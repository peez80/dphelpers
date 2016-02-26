package de.stiffi.media.carboncoder.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import de.stiffi.DPHelpers.XML;
import de.stiffi.DPHelpers.exceptions.ElementNotFoundException;
import de.stiffi.media.carboncoder.api.JobInfo.JobStatus;
import de.stiffi.media.carboncoder.api.JobListCriteria.Operator;

/**
 * Aufruf-API für den Rhozet Carbon Coder.
 * <p>
 * Diese Klasse erleichtert es wesentlich, übliche Funktionen über die CarbonCoder
 * Socket-Schnittstelle auszuführen.<br>
 * Hierbei werden die üblicherweise per XML-Struktur übertragenen Befehle gekapselt und die
 * Kommunikation mit der Carbon Engine durchgeführt. Der Aufrufer muss nur noch die Methoden
 * Rückgabewerte verarbeiten.
 * <p>
 * Funktionen die mit einem _ beginnen, sind Funktionen, die relativ genau die Methoden der XML API
 * repräsentieren. Diese sind zwar public, werden aber i.d.R. von den anderen Methoden (ohne _)
 * verwendet.
 * 
 * @author peez
 * 
 */
public class CarbonCoderConnector {

	public final static String CARBON_API_VERSION = "1.2";

	public final static String TASK_TYPE_JOBLIST = "JobList";

	public final static String TASK_TYPE_JOBQUEUE = "JobQueue";

	public final static String TASK_TYPE_JOBSTATUSLIST = "JobStatusList";

	public final static String TASK_TYPE_JOBEVALUATE = "JobEvaluate";

	public final static String TASK_TYPE_JOBCOMMAND = "JobCommand";

	public final static String TASK_TYPE_VERSION = "Version";

	public final static String JOBCOMMAND_QUERYINFO = "QueryInfo";

	public final static String JOBCOMMAND_QUERYJOB = "Query";

	public final static String JOBCOMMAND_QUERY = "Query";

	public final static String JOBCOMMAND_STOP = "Stop";

	public final static String JOBCOMMAND_PAUSE = "Pause";

	public final static String JOBCOMMAND_RESUME = "Resume";

	public final static String JOBCOMMAND_SETPRIORITY = "SetPriority";

	public final static String JOBCOMMAND_REQUEUE = "Requeue";

	public final static String JOBCOMMAND_REMOVE = "Remove";

	private String carbonHost;

	private int carbonPort;

	private boolean printDebug = false;

	public final static SimpleDateFormat dateformat_CNLT = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

	/**
	 * Erstellt einen CarbonConnector, der mit den angegebenen Host und Port kommuniziert
	 * 
	 * @param host Host, auf dem der CarbonCoder angesprochen werden soll
	 * @param port Port des CarbonCoders. Wenn nicht anders konfiguriert: 1120
	 */
	public CarbonCoderConnector( String host, int port ) {
		this.carbonHost = host;
		this.carbonPort = port;
	}

	/**
	 * Wenn auf true gesetzt, werden die Befehle und Replies auf dem Standard-Out ausgegeben
	 * 
	 * @param b
	 */
	public void setPrintDebug( boolean b ) {
		printDebug = b;
	}

	/**
	 * Gibt ein leeres XML-Dokument zurück, das das Root-Element zum übergebenen TaskType
	 * beinhaltet.
	 * 
	 * @param taskType
	 * @return
	 * @throws ParserConfigurationException
	 */
	public Document getEmptyDocument( String taskType ) throws ParserConfigurationException {
		Document doc = XML.newDocument();

		Element eRoot = doc.createElement( "cnpsXML" );
		eRoot.setAttribute( "TaskType", taskType );
		eRoot.setAttribute( "CarbonAPIVer", CARBON_API_VERSION );

		doc.appendChild( eRoot );

		return doc;
	}

	/**
	 * Schickt das Kommando im übergebenen XML Dokument an den CarbonCoder.
	 * Bevor das Reply-Dokumkent zurückgegeben wird, wird dieses auf das Feld Success geprüft und
	 * falls dieser FALSE ist, wird direkt eine {@link CarbonCoderException} mit der Fehlermeldung
	 * aus dem Attribute Error geworfen.<br>
	 * Auf diese Weise kann der Aufrufer sicher gehen, dass das Kommando fehlerfrei angenommen wurde
	 * solange keine Exception fliegt.
	 * 
	 * 
	 * @param xmlCommand
	 * @return
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws CarbonCoderException
	 */
	public Document sendCommand( Document xmlCommand ) throws UnknownHostException, IOException, TransformerException, SAXException, ParserConfigurationException,
			CarbonCoderException {
		// XML String bauen
		String rawXmlString = XML.getAsString( xmlCommand, false );

		if ( printDebug ) {
			System.out.println( "\r\nCommand: \r\n" + XML.getAsString( xmlCommand, true ) + "\r\n" );
		}

		String commandString = "CarbonAPIXML1 " + rawXmlString.getBytes( "UTF-8" ).length + rawXmlString;

		// Jetzt verbinden und Befehl senden
		Socket socket = new Socket( carbonHost, carbonPort );
		InputStream inputStream = socket.getInputStream();
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write( commandString.getBytes( "UTF-8" ) );
		outputStream.flush();

		// InputStream auslesen und analysieren während dem Auslesen!
		// Komischerweise dauert es beim üblichen Prüfen auf -1 ewig, bis das Programm weiterläuft.

		// Prefix auslesen
		byte[] bPrefix = new byte["CarbonAPIXML1 ".length()];
		if ( inputStream.read( bPrefix ) == -1 ) {
			throw new IOException( "Streamende vorzeitig erreicht!" );
		}

		String sPrefix = new String( bPrefix );
		if ( !sPrefix.equals( "CarbonAPIXML1 " ) ) {
			throw new IllegalStateException( "Antwort von CarbonCoder beginnt nicht mit CarbonAPIXML1." );
		}

		// Message Länge auslesen bis ein Space gefunden wurde
		String sLength = "";
		char c;
		while (( c = (char)inputStream.read() ) != -1) {
			if ( c == ' ' ) {
				// Direkt raus
				break;
			} else {
				sLength += c;
			}
		}

		// Länge parsen
		int responseLength = -1;
		try {
			responseLength = Integer.parseInt( sLength.trim() );
		} catch (Exception e) {
			throw new IllegalStateException( "Konnte Längen-Token nicht aus CarbonCoder Antwort auslesen" );
		}

		// Jetzt den Rest des Streams auslesen (mit responseLength)
		byte[] bResponse = new byte[responseLength];

		for ( int i = 0; i < responseLength; i++ ) {
			int b = inputStream.read();
			if ( b == -1 ) {
				throw new IOException( "Response-Ende vorzeitig erreicht!" );
			}
			bResponse[i] = (byte)b;
		}

		inputStream.close();
		outputStream.close();

		String responseString = new String( bResponse, "UTF-8" );

		if ( printDebug ) {
			System.out.println( "Response: \r\n" + responseString + "\r\n\r\n" );
		}

		if ( responseString.getBytes().length != responseLength ) {
			throw new IOException( "Länge der Antwort stimmt nicht mit der angegebenen Länge überein. Angegeben: " + responseLength + " Tatsächlich: "
					+ responseString.getBytes().length + ". Evt. wurde die Antwort nur teilweise übertragen." );
		}

		// Response in ein XML einlesen
		Document responseDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( new ByteArrayInputStream( bResponse ) );

		// Wenn jetzt noch vom <Reply> Element das Attribut Success != "TRUE" ist, dann die
		// Fehlerbeschreibung zurückgeben
		Element eReply = responseDoc.getDocumentElement();
		if ( !eReply.getAttribute( "Success" ).equalsIgnoreCase( "TRUE" ) ) {
			// Fehler!
			String errorMessage = eReply.getAttribute( "Error" );
			throw new CarbonCoderException( errorMessage );
		}

		return responseDoc;
	}

	/**
	 * Gibt eine Liste mit den GUIDs aller(!) Jobs aus CarbonCoder zurück.<br>
	 * Achtung! Es werden auch alle kompletten, failed etc. Jobs zurückgegeben d.h. die Liste kann
	 * sehr lang sein.
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 * @throws ElementNotFoundException
	 */
	public List<String> _jobList() throws ParserConfigurationException, UnknownHostException, IOException, TransformerException, SAXException, CarbonCoderException,
			ElementNotFoundException {
		Document doc = getEmptyDocument( TASK_TYPE_JOBLIST );
		// JobList kann leer bleiben - ich bekomme als Antwort alle Jobs

		Document reply = sendCommand( doc );

		Element eReply = reply.getDocumentElement();
		Element eJobList = XML.getChild( eReply, "JobList" );
		Element[] jobs = XML.getChildren( eJobList );

		List<String> jobList = new ArrayList<String>();
		for ( Element eJob : jobs ) {
			String guid = eJob.getAttribute( "GUID" );
			if ( guid != "" ) {
				jobList.add( guid );
			}
		}
		return jobList;
	}

	/**
	 * Ruft JobEvaluate auf. JobEvaluate analysiert den Transcoding-Befehl und gibt detaillierte
	 * Infos über Quelle und Ziel zurück.<br>
	 * Da hier sehr viele und unterschiedliche Informationen zurückkommen können, wird hier direkt
	 * das Reply Document zurückgegeben, damit die aufrufende Klasse dieses parst.
	 * 
	 * @param uncSourceVideo
	 * @param uncSourceAudio
	 * @param transcodingPresetGUID
	 * @return Gibt das komplette Reply-Dokument zurück, da hier die Werte sehr unterschiedlich
	 *         ausfallen können.
	 * @throws ParserConfigurationException
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 */
	public Document _jobEvaluate( String uncSourceVideo, String uncSourceAudio, String transcodingPresetGUID ) throws ParserConfigurationException, UnknownHostException,
			IOException, TransformerException, SAXException, CarbonCoderException {
		Document doc = getEmptyDocument( TASK_TYPE_JOBEVALUATE );

		doc = addSourceAndTarget( doc, uncSourceVideo, uncSourceAudio, transcodingPresetGUID );
		Document reply = sendCommand( doc );

		return reply;
	}

	/**
	 * Liest ein paar Informationen aus der angegebenen Videodatei aus und gibt diese zurück
	 * 
	 * @param uncFilePath
	 * @return
	 * @throws UnknownHostException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 * @throws ElementNotFoundException
	 */
	public MediaInfo getMediaInfo( String uncFilePath ) throws UnknownHostException, ParserConfigurationException, IOException, TransformerException, SAXException,
			CarbonCoderException, ElementNotFoundException {
		Document reply = _jobEvaluate( uncFilePath, null, null );

		Element eRoot = reply.getDocumentElement();
		Element eJobEvaluateResult = XML.getChild( eRoot, "JobEvaluateResult" );
		Element eSources = XML.getChild( eJobEvaluateResult, "Sources" );
		Element eModule_0 = XML.getChild( eSources, "Module_0" );
		Element ePublicDescription = XML.getChild( eModule_0, "PublicDescription" );

		Element eVideo = XML.getChild( ePublicDescription, "Video" );
		Element eAudio = XML.getChild( ePublicDescription, "Audio" );

		return new MediaInfo( eVideo, eAudio );
	}

	/**
	 * Stellt einen Transcode-Job ein.
	 * 
	 * 
	 * @param jobName Name des Jobs wie er in der Queue auftaucht
	 * @param username Wenn gewünscht, kann dem Job ein Benutzername mitgegeben. Hat keinen Einfluss
	 *            aufs Encoding. Wenn null, wird ein Standard-Name verwendet
	 * @param uncSourceVideo UNC-Pfad zum Video Quell File
	 * @param uncSourceAudio UNC-Pfad zum Audio Quell File. Wenn null ist, wird Audio aus der
	 *            angegebenen Video-Quelle verwendet
	 * @param transcodingPresetGUID GUID des Transcode-Presets, der die Encodingeinstellungen
	 *            definiert. Beispiel: {A7264AEF-FF57-42E0-BBAD-CCF546CD515F}
	 * @param priority Priorität des Encoding Prozesses. Wertebereich von 0-255
	 * 
	 * @throws ParserConfigurationException
	 * @throws CarbonCoderException
	 * @throws SAXException
	 * @throws TransformerException
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public String _jobQueue( String jobName, String username, String uncSourceVideo, String uncSourceAudio, String transcodingPresetGUID, Integer priority )
			throws ParserConfigurationException, UnknownHostException, IOException, TransformerException, SAXException, CarbonCoderException {

		Document doc = getJobQueueDocument( jobName, username, uncSourceVideo, uncSourceAudio, transcodingPresetGUID, priority );

		// ---------- Und jetzt Command absetzen
		Document result = sendCommand( doc );
		// Job GUID aus result auslesen
		Element eReply = result.getDocumentElement();
		return eReply.getAttribute( "GUID" );
	}

	public String _jobQueueDetailled( String jobName, String username, String uncSourceVideo, String uncSourceAudio, String transcodingPresetGUID, Integer priority,
			Interlacing sourceInterlacing, Integer sourcePixelAspect_X, Integer sourcePixelAspect_Y, Integer targetVideoWidth, Integer targetVideoHeight,
			Interlacing targetInterlacing, Integer targetPixelAspect_X, Integer targetPixelAspect_Y, Float targetFps, String targetPath, String targetBaseFilename

	) throws ParserConfigurationException, UnknownHostException, IOException, TransformerException, SAXException, CarbonCoderException, ElementNotFoundException {

		Document doc = getJobQueueDocument( jobName, username, uncSourceVideo, uncSourceAudio, transcodingPresetGUID, priority );

		// --- Job-Dokument durch die zusätzlichen Werte erweitern.
		// Source: cnpsXML/Sources/Module_0/ModuleData Tag unter Module_0 holen und durch attrs
		// erweitern

		Element eRoot = doc.getDocumentElement(); // cnpsXML
		Element eSources = XML.getChild( eRoot, "Sources" );
		Element eModule0 = XML.getChild( eSources, "Module_0" );
		Element eModuleDataSource = XML.getChild( eModule0, "ModuleData" );

		if ( sourceInterlacing != null ) {
			switch (sourceInterlacing) {
			case PROGRESSIVE:
				eModuleDataSource.setAttribute( "FrameMode.DWD", "0" );
				break;
			case BOTTOM_FIELD_FIRST:
				eModuleDataSource.setAttribute( "FrameMode.DWD", "1" );
				break;
			case TOP_FIELD_FIRST:
				eModuleDataSource.setAttribute( "FrameMode.DWD", "2" );
				break;
			}
		}

		if ( sourcePixelAspect_X != null && sourcePixelAspect_Y != null ) {
			eModuleDataSource.setAttribute( "PixelAspect_X.DWD", sourcePixelAspect_X.toString() );
			eModuleDataSource.setAttribute( "PixelAspect_Y.DWD", sourcePixelAspect_Y.toString() );
		}

		// Target: cnpsXML/Destinations/Module_0/ModuleData --> ModuleData adden, falls es ned gibt
		Element eDestinations = XML.getChild( eRoot, "Destinations" );
		Element eDestModule0 = XML.getChild( eDestinations, "Module_0" );

		Element eDestModuleData = null;
		try {
			eDestModuleData = XML.getChild( eDestModule0, "ModuleData" );
		} catch (Exception e) {
			// Not found, also anlegen
			eDestModuleData = doc.createElement( "ModuleData" );
			eDestModule0.appendChild( eDestModuleData );
		}

		// Jetzt die Attribute setzen
		if ( targetVideoWidth != null && targetVideoHeight != null ) {
			eDestModuleData.setAttribute( "CML_V_SizeX.DWD", targetVideoWidth.toString() );
			eDestModuleData.setAttribute( "CML_V_SizeY.DWD", targetVideoHeight.toString() );
		}

		if ( targetInterlacing != null ) {

			switch (targetInterlacing) {
			case PROGRESSIVE:
				eDestModuleData.setAttribute( "interlace_mode.DWD", "2" );
				break;
			case BOTTOM_FIELD_FIRST:
				eDestModuleData.setAttribute( "interlace_mode.DWD", "1" );
				break;
			case TOP_FIELD_FIRST:
				eDestModuleData.setAttribute( "interlace_mode.DWD", "0" );
				break;
			}
		}

		if ( targetPixelAspect_X != null && targetPixelAspect_Y != null ) {
			eDestModuleData.setAttribute( "PixelAspect_X.DWD", targetPixelAspect_X.toString() );
			eDestModuleData.setAttribute( "PixelAspect_Y.DWD", targetPixelAspect_Y.toString() );
		}

		if ( targetFps != null ) {
			eDestModuleData.setAttribute( "FrameRate.DBL", targetFps.toString() );
		}

		if ( targetPath != null ) {
			eDestModuleData.setAttribute( "CML_P_Path", targetPath );
		}

		if ( targetBaseFilename != null ) {
			eDestModuleData.setAttribute( "CML_P_BaseFileName", targetBaseFilename );
		}

		// ---------- Und jetzt Command absetzen
		Document result = sendCommand( doc );
		// Job GUID aus result auslesen
		Element eReply = result.getDocumentElement();
		return eReply.getAttribute( "GUID" );
	}

	private Document getJobQueueDocument( String jobName, String username, String uncSourceVideo, String uncSourceAudio, String transcodingPresetGUID, Integer priority )
			throws ParserConfigurationException {
		// Start-Prüfungen und Anpassungen vornehmen
		if ( priority == null ) {
			priority = 100;
		} else if ( priority < 0 ) {
			priority = 0;
		} else if ( priority > 255 ) {
			priority = 255;
		}

		// Document aufbauen
		Document doc = getEmptyDocument( TASK_TYPE_JOBQUEUE );
		Element eRoot = doc.getDocumentElement();
		eRoot.setAttribute( "JobName", jobName );
		eRoot.setAttribute( "User", username == null ? "DPProdCarbonCoderConnector" : username );

		// --- Source und Target einfügen -------------
		doc = addSourceAndTarget( doc, uncSourceVideo, uncSourceAudio, transcodingPresetGUID );

		// --- ProjectSettings
		Element eProjectSettings = doc.createElement( "ProjectSettings" );
		eRoot.appendChild( eProjectSettings );
		eProjectSettings.setAttribute( "Priority.DWD", "" + priority );

		return doc;
	}

	/**
	 * Da diese Werte sowohl bei jobEvaluate als auch bei JobQueue verwendet werden, werden Source-
	 * und Destination Werte immer über diese Methode in ein XML Command Dokument eingefügt
	 * 
	 * @param doc
	 * @param uncSourceVideo
	 * @param uncSourceAudio
	 * @param transcodingPresetGUID
	 * @return
	 */
	private Document addSourceAndTarget( Document doc, String uncSourceVideo, String uncSourceAudio, String transcodingPresetGUID ) {
		// Wenn Audio nicht angegeben ist, VideoFile als Audio angeben!
		boolean separateAudio = uncSourceAudio != null;

		if ( transcodingPresetGUID != null ) {
			transcodingPresetGUID = transcodingPresetGUID.trim();
			if ( !transcodingPresetGUID.startsWith( "{" ) ) {
				transcodingPresetGUID = "{" + transcodingPresetGUID;
			}
			if ( !transcodingPresetGUID.endsWith( "}" ) ) {
				transcodingPresetGUID = transcodingPresetGUID + "}";
			}
		}

		Element eRoot = doc.getDocumentElement();

		// --- Sources ----------------------------------
		Element eSources = doc.createElement( "Sources" );
		eRoot.appendChild( eSources );

		Element eModule_0 = doc.createElement( "Module_0" );
		eSources.appendChild( eModule_0 );
		eModule_0.setAttribute( "MultiSource.DWD", "1" );

		Element eModuleData = doc.createElement( "ModuleData" );
		eModule_0.appendChild( eModuleData );

		Element eStreamTypeTable = doc.createElement( "StreamTypeTable" );
		eModuleData.appendChild( eStreamTypeTable );

		// Video
		eStreamTypeTable.setAttribute( "StreamType_0.DWD", "0" );
		eStreamTypeTable.setAttribute( "StreamPtr_0.DWD", "0" );

		// Audio
		eStreamTypeTable.setAttribute( "StreamType_1.DWD", separateAudio ? "2" : "0" ); // Wenn
		// Audio

		// separat, dann
		// 2 --> Benutze
		// aus
		// MultiSourceModule_1
		eStreamTypeTable.setAttribute( "StreamPtr_1.DWD", "1" );

		Element eSourceModules = doc.createElement( "SourceModules" );
		eModuleData.appendChild( eSourceModules );

		Element eMultiSrcModule_0 = doc.createElement( "MultiSrcModule_0" );
		eSourceModules.appendChild( eMultiSrcModule_0 );
		eMultiSrcModule_0.setAttribute( "Filename", uncSourceVideo );

		Element eMultiSrcModule_1 = doc.createElement( "MultiSrcModule_1" );
		eSourceModules.appendChild( eMultiSrcModule_1 );
		eMultiSrcModule_1.setAttribute( "Filename", separateAudio ? uncSourceAudio : uncSourceVideo );

		// // Test mit nur Video-File:
		// Element eModule_0 = doc.createElement( "Module_0" );
		// eSources.appendChild( eModule_0 );
		// eModule_0.setAttribute( "Filename", uncSourceVideo );

		// --- Destinations ---------------------------------------
		Element eDestinations = doc.createElement( "Destinations" );
		eRoot.appendChild( eDestinations );

		if ( transcodingPresetGUID != null ) {
			Element eDestinationModule_0 = doc.createElement( "Module_0" );
			eDestinations.appendChild( eDestinationModule_0 );
			eDestinationModule_0.setAttribute( "PresetGUID", transcodingPresetGUID );
			eDestinationModule_0.setAttribute( "DestinationName", transcodingPresetGUID );
		}
		// TODO: Bei Bedarf auch mit <ModuleData/> Ausgabefile- und Pfad festlegen

		return doc;
	}

	/**
	 * Führt den Befehl JobCommand aus.<br>
	 * JobCommand kann verschiedene Daten zurückgeben, deshalb wird einfach das komplette
	 * Reply-Document zurückgegeben. Der Aufrufer muss dieses dann auslesen. Für die einzelnen
	 * Funktionen werden hier in der Klasse Methoden angeboten, die diese Methode jeweils auf ihre
	 * eigene Art aufrufen.
	 * 
	 * 
	 * @param jobCommand
	 * @param jobGUID
	 * @param priority Optional - nur wenn Priorität gesetzt werden soll, kann ansonsten null
	 *            bleiben
	 * @throws ParserConfigurationException
	 * @throws CarbonCoderException
	 * @throws SAXException
	 * @throws TransformerException
	 * @throws IOException
	 * @throws UnknownHostException
	 * 
	 * @returns Da verschiedenartige Antworten möglich sind, wird hier das komplette Reply Dokument
	 *          zurückgegeben
	 */
	public Document _jobCommand( String jobCommand, String jobGUID, Integer priority ) throws ParserConfigurationException, UnknownHostException, IOException,
			TransformerException, SAXException, CarbonCoderException {
		Document doc = getEmptyDocument( TASK_TYPE_JOBCOMMAND );

		Element eRoot = doc.getDocumentElement();
		Element eJobCommand = doc.createElement( "JobCommand" );
		eRoot.appendChild( eJobCommand );

		eJobCommand.setAttribute( "GUID", jobGUID );
		eJobCommand.setAttribute( "Command", jobCommand );
		eJobCommand.setAttribute( "Priority.DWD", "" + ( priority != null ? priority : "120" ) );

		Document replyDoc = sendCommand( doc );
		return replyDoc;
	}

	/**
	 * Gibt detaillierte Infos über den Job mit der angegebenen GUID zurück.
	 * 
	 * @param jobGUID
	 * @return
	 * @throws UnknownHostException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 * @throws ElementNotFoundException
	 */
	public JobInfo queryJobInfo( String jobGUID ) throws UnknownHostException, ParserConfigurationException, IOException, TransformerException, SAXException, CarbonCoderException,
			ElementNotFoundException {
		Document reply = _jobCommand( JOBCOMMAND_QUERYINFO, jobGUID, null );

		Element eRoot = reply.getDocumentElement();
		Element eJobInfo = XML.getChild( eRoot, "JobInfo" );

		return new JobInfo( eJobInfo );
	}

	public Document queryJob( String jobGUID ) throws UnknownHostException, ParserConfigurationException, IOException, TransformerException, SAXException, CarbonCoderException {
		Document reply = _jobCommand( JOBCOMMAND_QUERYJOB, jobGUID, null );
		return reply;
	}

	/**
	 * Gibt alle JobInfos zurück, die im übergebenen status sind, und die letzte Änderungszeit
	 * innerhalb der angegebenen Zeitspanne liegt.<br>
	 * Je nach Status wird zur Auswahl der Zeit das entsprechende Feld als Filter verwendet.
	 * 
	 * @param status
	 * @param from
	 * @param to
	 * @return
	 * @throws CarbonCoderException
	 * @throws SAXException
	 * @throws TransformerException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws UnknownHostException
	 * @throws ElementNotFoundException
	 */
	public List<JobInfo> queryJobInfoList( JobStatus status, Calendar from, Calendar to ) throws UnknownHostException, ParserConfigurationException, IOException,
			TransformerException, SAXException, CarbonCoderException, ElementNotFoundException {
		List<JobListCriteria> crits = new ArrayList<JobListCriteria>();
		crits.add( new JobListCriteria( "Status", Operator.EQUAL, status.toString() ) );

		String timeParam = null;

		switch (status) {
		case PREPARING:
		case QUEUED:
		case STARTING:
			timeParam = "CheckInTime_CNLT";
			break;
		case STARTED:
		case STOPPING:
		case STOPPED:
		case PAUSING:
		case PAUSED:
		case RESUMING:
			timeParam = "StartTime_CNLT";
			break;
		case COMPLETED:
		case ERROR:
			timeParam = "CompletedTime_CNLT";
			break;

		case INVALID:
		default:
			timeParam = "CheckInTime_CNLT"; // Im Zweifel CheckInTime verwenden
			break;
		}

		crits.add( new JobListCriteria( timeParam, Operator.GREATERTHAN, dateformat_CNLT.format( from.getTime() ) ) );
		crits.add( new JobListCriteria( timeParam, Operator.LESSTHAN, dateformat_CNLT.format( to.getTime() ) ) );

		return _queryJobInfoList( crits );
	}

	/**
	 * Liest eine Liste mit Job-Details aus CarbonCoder aus. Die Criterias werden mit AND verknüpft.
	 * <p>
	 * 
	 * Folgende Felder können abgefragt werden:
	 * <ul>
	 * <li>Name String Name of the job</li>
	 * <li>GUID String GUID of the job</li>
	 * <li>State String Current state of the job</li>
	 * <li>Status String Current status of the job</li>
	 * <li>Progress.DWD Integer Current progress of the job</li>
	 * <li>Description String Description of the job</li>
	 * <li>User String Username of the user that created the job</li>
	 * <li>SourceDescription String Description of the source</li>
	 * <li>AgentIP String IP address of the agent or unassigned</li>
	 * <li>Guid String Guid of the job on agent</li>
	 * <li>Priority.DWD Integer Priority of the job</li>
	 * <li>DeleteProcessedSource.DWD Integer 0/1 whether the source le will be deleted on completion
	 * </li>
	 * <li>CheckInTime String Time the job was submitted (MM/DD/YY hh:mm:ss)</li>
	 * <li>CheckInTime CNLT String Time the job was submitted (YYYY-MM-DD hh:mm:ss)</li>
	 * <li>CheckInTime SCM String Time(GMT) the job was submitted (YYYY-MM-DD hh:mm:ss)</li>
	 * <li>StartTime String, optional Time the job was started (MM/DD/YY hh:mm:ss)</li>
	 * <li>StartTime CNLT String, optional Time the job was started (YYYY-MM-DD hh:mm:ss)</li>
	 * <li>StartTime SCM String, optional Time(GMT) the job was started (YYYY-MM-DD hh:mm:ss)</li>
	 * <li>CompletedTime String, optional Time the job was completed (MM/DD/YY hh:mm:ss)</li>
	 * <li>CompletedTime CNLT String, optional Time the job was completed (YYYY-MM-DD hh:mm:ss)</li>
	 * <li>CompletedTime SCM String, optional Time(GMT) the job was completed (YYYY-MM-DD hh:mm:ss)</li>
	 *</ul>
	 * 
	 * @param criterias Liste mit Kriterien, um die Jobs auszulesen
	 * @return
	 * @throws ParserConfigurationException
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 * @throws ElementNotFoundException
	 */
	public List<JobInfo> _queryJobInfoList( List<JobListCriteria> criterias ) throws ParserConfigurationException, UnknownHostException, IOException, TransformerException,
			SAXException, CarbonCoderException, ElementNotFoundException {
		Document doc = getEmptyDocument( TASK_TYPE_JOBSTATUSLIST );

		Element eRoot = doc.getDocumentElement();
		Element eFilter = doc.createElement( "Filter" );
		eRoot.appendChild( eFilter );

		Element eListSettings = doc.createElement( "ListSettings" );
		eRoot.appendChild( eListSettings );

		// Criterias aufbauen
		for ( int i = 0; i < criterias.size(); i++ ) {

			JobListCriteria c = criterias.get( i );

			Element eCrit = doc.createElement( "Criteria_" + i );
			eFilter.appendChild( eCrit );

			if ( c.getParameter() != null ) {
				eCrit.setAttribute( "Parameter", c.getParameter() );
				eCrit.setAttribute( "Operator", c.getOperator().toString() );
				eCrit.setAttribute( "Value", c.getValue() );
			}
		}

		// Sortierung gibts nicht, muss vom Client gemacht werden
		List<JobInfo> jobInfos = new ArrayList<JobInfo>();
		Document reply = sendCommand( doc );
		Element eJobStatusList = XML.getChild( reply.getDocumentElement(), "JobStatusList" );
		Element[] jobInfoElements = XML.getChildren( eJobStatusList );
		for ( Element eJobInfo : jobInfoElements ) {
			if ( eJobInfo.getNodeName().startsWith( "Job_" ) ) {
				jobInfos.add( new JobInfo( eJobInfo ) );
			}
		}

		return jobInfos;
	}

	/**
	 * Stoppt einen Job. Dieser taucht in CarbonCoder dann unter "Failed Jobs" auf.
	 * 
	 * @param jobGUID
	 * @throws UnknownHostException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 */
	public void stopJob( String jobGUID ) throws UnknownHostException, ParserConfigurationException, IOException, TransformerException, SAXException, CarbonCoderException {
		_jobCommand( JOBCOMMAND_STOP, jobGUID, null );
	}

	/**
	 * Pausiert einen Job. Achtung! Der pausierte Job verschwindet komplett aus der CarbonCoder
	 * Admin Anwendung. Per API kann er aber problemlos resumed werden, dann erscheint er wieder.
	 * 
	 * @param jobGUID
	 * @throws UnknownHostException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 */
	public void pauseJob( String jobGUID ) throws UnknownHostException, ParserConfigurationException, IOException, TransformerException, SAXException, CarbonCoderException {
		_jobCommand( JOBCOMMAND_PAUSE, jobGUID, null );
	}

	/**
	 * Nimmt einen pausierten Job wieder auf.
	 * 
	 * @param jobGUID
	 * @throws UnknownHostException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 */
	public void resumeJob( String jobGUID ) throws UnknownHostException, ParserConfigurationException, IOException, TransformerException, SAXException, CarbonCoderException {
		_jobCommand( JOBCOMMAND_RESUME, jobGUID, null );
	}

	/**
	 * Legt die Priorität für einen Job fest.
	 * 
	 * @param jobGUID
	 * @param priority 0-255 (255 -- Start immediately)
	 * @throws UnknownHostException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 */
	public void setJobPriority( String jobGUID, int priority ) throws UnknownHostException, ParserConfigurationException, IOException, TransformerException, SAXException,
			CarbonCoderException {
		if ( priority < 0 ) {
			priority = 0;
		} else if ( priority > 255 ) {
			priority = 120;
		}

		_jobCommand( JOBCOMMAND_SETPRIORITY, jobGUID, new Integer( priority ) );
	}

	/**
	 * Stellt einen fehlerhaften Job neu ein.
	 * 
	 * @param jobGUID
	 * @throws UnknownHostException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 */
	public void requeueJob( String jobGUID ) throws UnknownHostException, ParserConfigurationException, IOException, TransformerException, SAXException, CarbonCoderException {
		_jobCommand( JOBCOMMAND_REQUEUE, jobGUID, null );
	}

	/**
	 * Entfernt den übergebenen Job komplett aus allen Job-Listen (dieser Job ist dann nicht mehr
	 * über API oder CarbonCoder Admin zu sehen)
	 * 
	 * @param jobGUID
	 * @throws UnknownHostException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 */
	public void removeJob( String jobGUID ) throws UnknownHostException, ParserConfigurationException, IOException, TransformerException, SAXException, CarbonCoderException {
		_jobCommand( JOBCOMMAND_REMOVE, jobGUID, null );
	}

	/**
	 * Gibt die Version des CarbonCoders zurück.
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws CarbonCoderException
	 */
	public String _version() throws ParserConfigurationException, UnknownHostException, IOException, TransformerException, SAXException, CarbonCoderException {
		Document doc = getEmptyDocument( TASK_TYPE_VERSION );
		Document reply = sendCommand( doc );
		return reply.getDocumentElement().getAttribute( "Version" );
	}

	/**
	 * Gibt die Liste aller Ziel-Files (als UNC Pfad) eines Jobs zurück. Es können mehrere zu
	 * mehreren Destinations
	 * sein. Das ignoriert aber diese Methode. <br>
	 * Sie gibt einfach ALLE Files, die vom Target produziert werden, zurück. <br>
	 * Sollten detaillierte Informationsn gewünscht sein, muss queryJob() aufgerufen werden und das
	 * Document manuell geparsed.
	 * 
	 * @param jobGUID
	 * @return
	 * @throws CarbonCoderException
	 * @throws SAXException
	 * @throws TransformerException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws UnknownHostException
	 * @throws ElementNotFoundException
	 */
	public List<String> getTargetFilePaths( String jobGUID ) throws UnknownHostException, ParserConfigurationException, IOException, TransformerException, SAXException,
			CarbonCoderException, ElementNotFoundException {
		List<String> files = new ArrayList<String>();

		Document doc = queryJob( jobGUID );

		Element eRoot = doc.getDocumentElement();
		Element eJob = XML.getChild( eRoot, "Job" );
		Element eDestinations = XML.getChild( eJob, "Destinations" );

		Element[] modules = XML.getChildren( eDestinations );
		for ( Element eModule : modules ) {
			if ( eModule.getNodeName().startsWith( "Module_" ) ) {
				// Ein module-Tag, also hier <TargetFiles> auslesen mit den Attributen File_0 ...
				// File_x
				Element[] nlTargetFiles = XML.getChildren( eModule, "TargetFiles" );
				for ( Element eTargetFiles : nlTargetFiles ) {
					NamedNodeMap nmAttributes = eTargetFiles.getAttributes();
					for ( int i = 0; i < nmAttributes.getLength(); i++ ) {
						if ( nmAttributes.item( i ).getNodeType() == Node.ATTRIBUTE_NODE ) {
							Attr attr = (Attr)nmAttributes.item( i );
							if ( attr.getName().startsWith( "File_" ) ) {
								files.add( attr.getValue() );
							}
						}
					}
				}
			}
		}

		return files;
	}
}
