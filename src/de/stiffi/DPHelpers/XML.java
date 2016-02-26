package de.stiffi.DPHelpers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import de.stiffi.DPHelpers.exceptions.ElementNotFoundException;

/**
 * Klasse für wiederkehrende XML Operationen.
 * 
 * @author peez
 * 
 */
public class XML {

	/**
	 * Gibt das erste Child-Element mit dem übergebenen Namen zurück
	 * 
	 * @param e Element, dessen Kinder durchsucht werden
	 * @param childName Name des gesuchten Child-Elements. Groß-/Kleinschreibung wird ignoriert
	 * @return gefundenes Element
	 * @throws ElementNotFoundException Wenn kein Element mit dem angegebenen Namen gefunden wurde
	 */
	public static Element getChild( Element e, String childName ) throws ElementNotFoundException {
		NodeList nl = e.getChildNodes();

		for ( int i = 0; i < nl.getLength(); i++ ) {
			if ( nl.item( i ).getNodeType() == Node.ELEMENT_NODE ) {
				Element elem = (Element)nl.item( i );
				if ( elem.getNodeName().equalsIgnoreCase( childName ) ) {
					return elem;
				}
			}
		}

		throw new ElementNotFoundException( "Element with name " + childName + " not found as Child of " + e.getNodeName() );
	}

	/**
	 * Gibt das erste gefundene Child-Element zurück, das als Wert den übergebenen value besitzt.
	 * 
	 * @param e
	 * @param childName
	 * @param value
	 * @return
	 * @throws ElementNotFoundException
	 */
	public static Element getChildWithValue( Element e, String childName, String value ) throws ElementNotFoundException {
		Element[] children = getChildren( e, childName );

		for ( Element eChild : children ) {
			if ( value.equals( eChild.getTextContent() ) ) {
				return eChild;
			}
		}

		// Kein Kind mit dieser Value gefundne
		throw new ElementNotFoundException( "No child with Name " + childName + " and Value " + value + " found." );
	}

	/**
	 * Gibt zurück, ob das übergebene Element ein Child-Element mit dem übergebenen Namen hat
	 * 
	 * @param e Element, dessen Kinder durchsucht werden
	 * @param childName Name des gesuchten Child-Elements
	 * @return true wenn gefunden, false wenn nicht
	 */
	public static boolean hasChild( Element e, String childName ) {
		try {
			getChild( e, childName );
			return true;
		} catch (ElementNotFoundException e1) {
			return false;
		}
	}

	/**
	 * Gibt alle Kind-Elemente mit dem Übergebenen Namen zurück
	 * 
	 * @param e Element, dessen Kinder durchsucht werden.
	 * @param childName Name der gesuchten Kinder. Groß-/Kleinschreibung wird ignoriert
	 * @return Array der gefundenen Elemente, leeres wenn keine gefunden wurden.
	 */
	public static Element[] getChildren( Element e, String childName ) {

		Vector<Element> children = new Vector<Element>();

		NodeList nl = e.getChildNodes();
		for ( int i = 0; i < nl.getLength(); i++ ) {
			if ( nl.item( i ).getNodeType() == Node.ELEMENT_NODE ) {
				Element elem = (Element)nl.item( i );
				if ( elem.getNodeName().equalsIgnoreCase( childName ) ) {
					children.add( elem );
				}
			}
		}

		return children.toArray( new Element[0] );
	}

	/**
	 * Gibt alle Child-Elemente des übergebenen Elements zurück.
	 * 
	 * @param e
	 * @return
	 */
	public static Element[] getChildren( Element e ) {
		ArrayList<Element> children = new ArrayList<Element>();

		NodeList nl = e.getChildNodes();
		for ( int i = 0; i < nl.getLength(); i++ ) {
			if ( nl.item( i ).getNodeType() == Node.ELEMENT_NODE ) {
				Element elem = (Element)nl.item( i );
				children.add( elem );
			}
		}

		return children.toArray( new Element[0] );

	}

	/**
	 * Gibt das nächste Sibling-Element des übergebenen Elements zurück.
	 * 
	 * @param e
	 * @return
	 */
	public static Element getNextSiblingElement( Element e ) {
		Node currentNode = e;
		while (( currentNode = currentNode.getNextSibling() ) != null) {
			if ( currentNode.getNodeType() == Node.ELEMENT_NODE ) {
				return (Element)currentNode;
			}
		}
		return null;
	}

	/**
	 * Gibt den Sibling zum übergebenen Element mit dem angegebenen Namen zurück.
	 * 
	 * @param e
	 * @param siblingName
	 * @return
	 * @throws ElementNotFoundException
	 */
	public static Element getSibling( Element e, String siblingName ) throws ElementNotFoundException {

		Node currentNode = e;
		while (( currentNode = currentNode.getNextSibling() ) != null) {
			currentNode = currentNode.getNextSibling();
			if ( currentNode.getNodeType() == Node.ELEMENT_NODE && currentNode.getNodeName().equals( siblingName ) ) {
				return (Element)currentNode;
			}
		}

		throw new ElementNotFoundException( "No Sibling with Name " + siblingName + " found." );
	}

	/**
	 * Speichert das XML Document in schöner Formatierung
	 * 
	 * @param xml zu speicherndes XML Document
	 * @param file hier wird gespeichert. Achtung! Datei wird automatisch überschrieben!
	 * @throws TransformerConfigurationException
	 * @throws FileNotFoundException
	 * @throws TransformerException
	 * @throws IOException
	 */
	public static void saveDocument( Node xml, Path file, InputStream xslFile, boolean prettyprint, String encoding ) throws TransformerConfigurationException,
			FileNotFoundException, TransformerException, IOException {

		// URL url= new XML().getClass().getClassLoader().getResource( "strip-space.xsl" );
		// InputStream xslFile = new XML().getClass().getClassLoader().getResourceAsStream(
		// "strip-space.xsl" );

		Transformer transformer = null;
		if ( xslFile == null ) {
			transformer = TransformerFactory.newInstance().newTransformer();
		} else {
			transformer = TransformerFactory.newInstance().newTransformer( new StreamSource( xslFile ) );
		}

		if ( prettyprint ) {
			transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
			transformer.setOutputProperty( "{http://xml.apache.org/xslt}indent-amount", "2" );
		}

		if ( encoding == null ) {
			encoding = "UTF-8";
		}
		transformer.setOutputProperty( OutputKeys.ENCODING, encoding );

		try (OutputStream os = Files.newOutputStream( file, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING )) {
			DOMSource source = new DOMSource( xml );

			StreamResult result = new StreamResult( os );
			transformer.transform( source, result );
		}

	}

	/**
	 * Gibt das XML Dokument als String zurück
	 * 
	 * @param xml
	 * @param encoding Encoding des zurückgegebenen Strings
	 * @param formatted wenn true, wird das Dokument schön formatiert, ansonsten in einer Zeile
	 *            zurückggeben
	 * @return
	 * @throws TransformerException
	 * @throws IOException
	 */
	public static String getAsString( Node xml, String encoding, boolean formatted ) throws TransformerException, IOException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();

		if ( formatted ) {
			transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
			transformer.setOutputProperty( "{http://xml.apache.org/xslt}indent-amount", "2" );
		}

		DOMSource source = new DOMSource( xml );
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		StreamResult result = new StreamResult( baos );
		transformer.transform( source, result );
		baos.close();

		return baos.toString( encoding );
	}

	public static String getAsString( Node xml, boolean formatted ) throws TransformerException, IOException {
		return getAsString( xml, "UTF-8", formatted );
	}

	/**
	 * Lädt die angegebene XML Datei und gibt das Document zurück
	 * 
	 * @param xmlFile
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public static Document loadDocument( File xmlFile ) throws SAXException, IOException, ParserConfigurationException {
		return loadDocument( Paths.get( xmlFile.getAbsolutePath() ) );
	}

	/**
	 * Lädt die angegebene XML Datei und gibt das Document zurück
	 * 
	 * @param xmlFile
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public static Document loadDocument( Path xmlFile ) throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xmlDoc = null;
		InputStream in = null;
		try {
			in = Files.newInputStream( xmlFile, StandardOpenOption.READ );
			// in = new FileInputStream( xmlFile );
			xmlDoc = builder.parse( in );
			return xmlDoc;
		} catch (IOException e) {
			throw e;
		} finally {
			if ( in != null ) {
				in.close();
			}
		}
	}

	/**
	 * Generiert ein neues, leeres XML Document
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 */
	public static Document newDocument() throws ParserConfigurationException {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document xmlDoc = builder.newDocument();
		return xmlDoc;
	}
}
