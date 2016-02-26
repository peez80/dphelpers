package de.stiffi.DPHelpers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Log {

	/**
	 * In diese Datei wird das Log geschrieben
	 */
	private File m_logFile = null;

	/**
	 * Sagt aus, ob vor jedem Eintrag der aktuelle Timestamp geschrieben werden soll.
	 */
	private boolean m_addTimeStamp = true;

	/**
	 * Wenn System.out zum Log umgeleitet wird, wird in dieser Variable die Referenz zum originalen System Out gespeichert.
	 */
	private PrintStream m_originalSysOut = null;

	/**
	 * Wenn System.err zum Log umgeleitet wird, wird in dieser Variable die Referenz zum originalen System.err gespeichert.
	 */
	private PrintStream m_originalSysErr = null;

	/**
	 * Wenn System.out umgeleitet wird, wird es in diese Variable umgeleitet
	 */
	private PrintStreamCapture m_replaceSysOut;

	/**
	 * Wenn System.err umgeleitet wird, wird es in diese Variable umgeleitet
	 */
	private PrintStreamCapture m_replaceSysErr;

	/**
	 * Dieses Objekt tut nichts. Es ist nur zur Synchronisierung einiger Methoden da.
	 */
	private static Object writeSynchronizer = new Object();

	/**
	 * Maximale Größe in Bytes der Log Datei. Wenn 0, dann ist die Log Datei in ihrer Größe unbegrenzt.
	 */
	private long m_maxLogFileSize = 0; // 0 --> Unbegrenzt

	/**
	 * In diesem Abstand (in Sekunden) wird überprüft, ob die Log Datei gekürzt werden muss. Es läuft allerdings kein Hintergrundthread. Die Prüfung findet nur bei Schreiboperationen statt und nur, wenn dieser Intervall bereits abgelaufen ist.
	 */
	private int m_logTrimInterval = 3600; // Jede Stunde

	/**
	 * Timestamp der letzten Log-Kürzungs Operation
	 */
	private long m_lastLogTrim = 0;

	/**
	 * Sagt aus, ob die Logdatei als HTML gespeichert werden soll.
	 * 
	 * TODO Ist glaube ich noch nicht richtig implementiert
	 */
	private boolean m_HTMLLog = false;

	/**
	 * Der kann zugewiesen werden, damit dann schnell mit statischer Methode in das Logfile geschrieben werden kann.
	 * 
	 * @see #w(String)
	 */
	private static Log staticLogger = null;

	/**
	 * Für den Fall, dass noch keine Log-Datei angelegt ist und trotzdem irgendwas geschrieben wird, werden diese Daten in diesem String zwischengespeichert. Wird dann irgendwann eine Log-Datei gesetzt, werden die Daten aus diesem Puffer da
	 * reingeschrieben.
	 */
	private String m_noLogFileBuffer = null;

	/**
	 * Wenn true, dann werden alle Messages, die mit doWrite (also alle) abgesetzt werden, auch an Std-Out weitergeleitet. Allerdings NUR, wenn Std-Out nicht umgeleitet wird, ansonsten würde das nämlich im Dauer-Loop enden
	 */
	private boolean m_forwardMsgToSysOut = false;

	/**
	 * Konstruktor
	 * 
	 * @param logFile Text-Datei für das Log
	 */
	public Log( String logFile ) {
		init( logFile );
	}

	/**
	 * Konstruktor Instantiiert das Log-Objekt. Da hier noch keine Datei angegeben ist, werden Log-Ausgaben einfach so lange gepuffert, bis eine Log-Datei angegeben wird und danach dann reingeschrieben.
	 * 
	 * Beim Ersten mal wird eine Fehlermeldung auf System.err ausgegeben, dass keine Logdatei gesetzt ist.
	 */
	public Log() {
		init( null );
	}

	/**
	 * Führt die Schreib-Operation aus
	 * 
	 * @param s
	 */
	private void doWrite( String s ) {

		// Bei Bedarf auf sysout ausgeben
		if ( m_forwardMsgToSysOut && m_replaceSysOut == null ) {
			System.out.println( s );
		}

		// Wenn kein Logfile angegeben ist, in Puffer schreiben!
		if ( m_logFile == null ) {
			if ( m_noLogFileBuffer == null ) {
				System.err.println( "Log:write() - no Logfile set - please use init() first!" );
				System.err.println( "      Output will be buffered until logfile is set." );

				m_noLogFileBuffer = "";
			}

			synchronized (writeSynchronizer) {
				// Daten in Buffer schreiben
				m_noLogFileBuffer += s;
			}
			return;
		}

		// TODO: HTML Logs müssen anders gekürzt werden

		if ( !m_HTMLLog ) {

			trimLogFile(); // Kürzt Log-File bei Bedarf
			synchronized (writeSynchronizer) {
				FileWriter w = null;
				try {
					w = new FileWriter( m_logFile, true );
					w.write( s );

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if ( w != null ) {
						try {
							w.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	private Document createHTMLFrame() {
		try {
			Document doc = XML.newDocument();

			Element eHtml = doc.createElement( "HTML" );
			doc.appendChild( eHtml );

			Element eHead = doc.createElement( "HEAD" );
			eHtml.appendChild( eHead );

			Element eBody = doc.createElement( "body" );
			eHtml.appendChild( eBody );

			eBody.setAttribute( "style", "font-family:Verdana,Arial,Helvetica;" );

			return doc;

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Setzt den Zeitabstand, in dem geprüft wird, ob die Log-Datei auf die angegebene Länge gekürzt werden muss.
	 * 
	 * @see Log#setMaxLogFileSize(long)
	 * 
	 * @param seconds
	 */
	public void setLogTrimInterval( int seconds ) {
		m_logTrimInterval = seconds;
	}

	/**
	 * Gibt das Intervall zurück, in dem geprüft wird, ob die Log-Datei gekürzt werden soll.
	 * 
	 * @return
	 */
	public int getLogTrimInterval() {
		return m_logTrimInterval;
	}

	/**
	 * Schreibt einen String in die Logdatei
	 * 
	 * @param s
	 */
	public void write( String s ) {

		if ( m_addTimeStamp ) {
			if ( !s.matches( "^\\s+\\z" ) ) { // Wenn nur whitespace, also z.B. nur
				// Zeilenumbruch etc. im String
				// vorkommt, dann kein Datum
				// voranstellen!
				s = Date.getDatetime() + ": \r\n" + s;
			}
		}

		doWrite( s );
	}

	/**
	 * Schreibt eine Integer Zahl in die Logdatei
	 * 
	 * @param i
	 */
	public void write( int i ) {
		write( "" + i );
	}

	/**
	 * Schreibt eine Integer Zahl in die Logdatei, incl. abschließendem Zeilenumbruch
	 * 
	 * @param i
	 */
	public void writeln( int i ) {
		writeln( "" + i );
	}

	/**
	 * Schreibt eine Zeile (mit anschließendem Zeilenumbruch) in eine Datei
	 * 
	 * @param s
	 */
	public void writeln( String s ) {
		write( s + "\r\n" );
	}

	/**
	 * Initialisiert den Logger
	 * 
	 * @param logFile Logfile, in das die Einträge gespeichert werden
	 * @return true, wenn alles in Ordnung ist, false wenn die Initialisierung fehltschlägt, wie z.B. die Datei nicht geöffnet werden kann.
	 */
	public boolean init( String logFile ) {

		// File f = new File( logFile );
		// if ( f.exists() && f.isDirectory() ) {
		// System.err.println( "Log::init() - target File is a directory!" );
		// return false;
		// }
		// m_logFile = f;
		setLogFile( logFile );

		String initString = "\r\n\r\n\r\n--------------\r\nLog Start " + Date.getDatetime() + "\r\n\r\n----------------------\r\n\r\n";

		doWrite( initString );

		trimLogFile();

		return true;
	}

	public boolean setLogFile( String logFile ) {
		File f = new File( logFile );
		if ( f.exists() && f.isDirectory() ) {
			System.err.println( "Log::setLogFile() - target File is a directory!" );
			m_logFile = null;
			return false;
		}

		m_logFile = f;

		if ( m_noLogFileBuffer != null ) { // Wenn schon was gepuffert wurde, den Puffer in die geöffnete Datei schreiben!
			synchronized (writeSynchronizer) {
				doWrite( m_noLogFileBuffer );
				m_noLogFileBuffer = null;
			}
		}

		return true;
	}

	/**
	 * aktiviert die automatische Vorstellung des aktuellen Timestamps vor Logeinträgen
	 */
	public void setAddTimestamp( boolean b ) {
		m_addTimeStamp = b;
	}

	/**
	 * Um statisch auf den Logger zugreifen zu können (also Log.w()), wird mit dieser Methode ein Verweis auf einen speziellen Logger statisch gespeichert.
	 * 
	 * @see #w(String)
	 * @param logger
	 */
	public static void setStaticLogger( Log logger ) {
		staticLogger = logger;
	}

	/**
	 * Wenn ein statischer Logger gesetzt ist, wird auf diesen geschrieben
	 * 
	 * @see #setStaticLogger(Log)
	 */
	public static void w( String s ) {
		if ( staticLogger != null ) {
			staticLogger.writeln( s );
		}
	}

	/**
	 * Liest den Standard System.out aus und schreibt diese Ausgaben in das Log-File
	 */
	public void setCaptureSysOut( boolean b ) {
		if ( b == true ) { // Einschalten
			m_originalSysOut = System.out;

			m_replaceSysOut = new PrintStreamCapture( this, System.out );
			System.setOut( new PrintStream( m_replaceSysOut ) );
		} else { // Ausschalten
			System.setOut( m_originalSysOut );
			m_replaceSysOut = null;
		}

	}

	/**
	 * Liest den Standard System.err aus und schreibt diese Ausgaben in das Log-File
	 * 
	 * @param b
	 */
	public void setCaptureSysErr( boolean b ) {
		if ( b == true ) { // Einschalten
			m_originalSysErr = System.err;

			m_replaceSysErr = new PrintStreamCapture( this, System.err );
			System.setErr( new PrintStream( m_replaceSysErr ) );
		} else { // Ausschalten
			System.setErr( m_originalSysErr );
			m_replaceSysErr = null;
		}
	}

	/**
	 * Stellt ein, ob Messages die mit doWrite() - also alle - abgesetzt werden, auch auf dem Standard-Output ausgegeben werden.
	 * 
	 * @param b
	 */
	public void setForwardMessagesToSysOut( boolean b ) {
		m_forwardMsgToSysOut = b;
	}

	/**
	 * kürzt bei Bedarf die Log-Datei
	 */
	private void trimLogFile() {

		if ( m_logFile == null ) {
			return;
		}

		if ( m_maxLogFileSize == 0 || m_logTrimInterval == 0 || System.currentTimeMillis() < m_lastLogTrim + ( m_logTrimInterval * 1000 ) ) {
			// Nicht trimmen, da die benötigte Zeit zwischen den Trim-Vorgängen
			// noch nicht erreicht ist
			return;
		}

		if ( m_logFile != null && m_maxLogFileSize != 0 ) {
			// LogFile einlesen

			long trim = m_logFile.length() - m_maxLogFileSize;
			if ( trim > 0 ) {
				File tmp;

				BufferedInputStream in = null;
				BufferedOutputStream out = null;
				try {
					synchronized (writeSynchronizer) {
						tmp = File.createTempFile( "DPLog", ".tmp", m_logFile.getParentFile() );

						in = new BufferedInputStream( new FileInputStream( m_logFile ) );
						out = new BufferedOutputStream( new FileOutputStream( tmp ) );

						in.skip( trim );
						byte b[] = new byte[2048];
						int len;
						while (( len = in.read( b ) ) != -1) {
							out.write( b, 0, len );
						}

						out.close();
						out = null;

						in.close();
						in = null;

						if ( m_logFile.delete() ) {
							tmp.renameTo( m_logFile );
						}
					}

					writeln( "Log Trimmed to " + m_logFile.length() + " bytes" );

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if ( in != null ) {
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if ( out != null ) {
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

			}
		}

		m_lastLogTrim = System.currentTimeMillis();
	}

	/**
	 * Setzt die maximale Größe der Log-Files
	 * 
	 * @param bytes 0, wenn unbegrenzt
	 */
	public void setMaxLogFileSize( long bytes ) {
		m_maxLogFileSize = bytes;
		trimLogFile();
	}

	/**
	 * Gibt die maximale Größe der Log-Datei zurück
	 * 
	 * @return
	 */
	public long getMaxLogFileSize() {
		return m_maxLogFileSize;
	}

	public void setHTML( boolean b ) {
		m_HTMLLog = b;
	}

	/**
	 * PrintStream, um Ausgaben umzuleiten
	 * 
	 * @author HD-Authoring
	 * 
	 */
	private class PrintStreamCapture extends OutputStream {

		private PrintStream passThru = null;

		Log m_logger = null;

		public PrintStreamCapture( Log logger, PrintStream passThru ) {
			this.passThru = passThru;
			m_logger = logger;
		}

		@Override
		public void write( int b ) throws IOException {

			m_logger.write( "" + (char)b );
			passThru.write( b );
		}

		public void write( byte[] b, int off, int len ) throws IOException {
			// Einfach bei Bedarf den Timestamp davorhängen und dann
			// super.write(b, off,len) aufrufen

			m_logger.write( new String( b, off, len ) );

			passThru.write( b, off, len );
		}
	}

	public File getLogFile() {
		return m_logFile;
	}
}
