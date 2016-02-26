package de.stiffi.DPHelpers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.stiffi.DPHelpers.DB.DatabaseManager;

/**
 * Um relativ schnell Einstellungen etc. speichern und verwalten zu können, wurde diese Klasse angelegt. Sie
 * erstellt automatisch im Userprofil unter ./DPProductions/<settings_name> eine Einstellungsdatei und
 * schreibt sowie liest von dort.
 * 
 * @author HD-Authoring
 * 
 */
public class SoftwareSettings {
	
	private final static Logger log = LoggerFactory.getLogger( SoftwareSettings.class );

	/**
	 * Hier werden die einzelnen Settings gespeichert
	 */
	private Hashtable<String, SettingsItem> m_settings = null;

	/**
	 * In dieser Datei werden die Einstellungen gespeichert und gelesen.
	 */
	private File m_propsFile = null;

	/**
	 * Wenn die Werte in einer Datenbank gespeichert werden sollen, wird die Verbindung über diesen
	 * Datenbankmanager hergestellt.
	 */
	private DatabaseManager m_dbManager = null;

	/**
	 * Name der Datenbanktabelle, in der die Settings gespeichert werden.
	 */
	private String m_dbTable;

	/**
	 * Wenn nichts angegeben wird, wird standardmäßig in dieser Location gespeichert. Je nachdem, ob ein
	 * DAtenbankkonstruktor oder ein File Konstruktor beim Instanziieren verwendet wird, wird dieses Feld
	 * entsprechend eingestellt.
	 */
	private StorageLocation m_standardLocation = StorageLocation.FILE;

	/**
	 * Wenn über setCollectKeys aktiviert, werden hier sämtliche Keys reingeschrieben, die genutzt werden.
	 * Sowohl zum Laden als auch zum Speichern. Die Funktion ist nützlich, wenn man alle in einem Programm
	 * möglichen Settings aufzeigen möchte.
	 * 
	 * Die Funktion gilt als eingeschalten, wenn diese Variable nicht null ist.
	 */
	private Vector<String> m_keyCollector = null;

	/**
	 * Konstruktor
	 * 
	 * @param settings_name
	 *            Eindeitiger Identifier für diese Software. Mit diesem Namen wird die Einstellungsdatei
	 *            angelegt.
	 */
	public SoftwareSettings( String settings_name ) {
		// Wenn nur ein Name angegeben wird, wird ein Settingsfile unter dem
		// Benutzerkonto/DPProductions angelegt.
		File dir = new File( System.getProperty( "user.home" ) + File.separator + "DPProductions" );
		m_propsFile = new File( dir + File.separator + settings_name + ".conf" );

		m_standardLocation = StorageLocation.FILE;

		init();
	}

	/**
	 * Konstruktor
	 * 
	 * @param settingsFile
	 *            In dieser Datei werden die Einstellungen gespeichert und gelesen
	 */
	public SoftwareSettings( File settingsFile ) {
		m_propsFile = new File( settingsFile.getAbsolutePath() );
		m_standardLocation = StorageLocation.FILE;
		init();
	}

	public String getStorageInfo() {
		if ( m_standardLocation.equals( StorageLocation.FILE ) ) {
			return m_propsFile.getAbsolutePath();
		}else if (m_standardLocation.equals(StorageLocation.DB)) {
			return "Database: " + m_dbTable;
		}
		return "<null>";
	}

	/**
	 * Wird ein Objekt über diesen Konstruktor generiert, werden Einstellungen in der Datenbank des
	 * dbConnection Objekts gespeichert und geladen.
	 * 
	 * 
	 * 
	 * @parma jdbcDriverName
	 * @param connectionString
	 *            muss komplett incl. Anmeldeinfo und Datenbankname übergeben werden.
	 * @param dbTable
	 */
	public SoftwareSettings( DatabaseManager dbManager, String dbTable ) {
		m_standardLocation = StorageLocation.DB;
		m_dbManager = dbManager;
		m_dbTable = dbTable;
		init();
	}

	/**
	 * Speichert Datenbank Einstellungen.
	 * <p>
	 * 
	 * @param dbManager
	 * @param dbTable
	 */
	public void setDBData( DatabaseManager dbManager, String dbTable ) {
		m_dbManager = dbManager;
		m_dbTable = dbTable;
		initDB();
	}

	/**
	 * Legt die Datei fest, in die Settings gespeichert werden.
	 * 
	 * @param settingsFile
	 */
	public void setFileData( File settingsFile ) {
		m_propsFile = new File( settingsFile.getAbsolutePath() );
		initFile();
	}

	/**
	 * Legt den Namen fest, anhand dessen die Datendatei ausgewählt wird, in die die Daten gespeichert werden.
	 * 
	 * @param settings_name
	 */
	public void setFileData( String settings_name ) {
		File dir = new File( System.getProperty( "user.home" ) + File.separator + "DPProductions" );
		m_propsFile = new File( dir + File.separator + settings_name + ".conf" );
		initFile();
	}

	/**
	 * Sagt aus, ob dieses Objekt seine Einstellungen in eine Datenbank speichert oder nicht
	 * 
	 * @return
	 */
	public boolean isDB() {
		return m_dbManager != null;
	}

	/**
	 * Sagt aus, ob dieses Objekt seine Einstellungen in eine lokale Datei speichert oder nicht
	 * 
	 * @return
	 */
	public boolean isFile() {
		return m_propsFile != null;
	}

	/**
	 * Initialisiert das Settings-Objekt
	 */
	private void init() {
		m_settings = new Hashtable<String, SettingsItem>();

		if ( isFile() ) {
			initFile();
		}
		if ( isDB() ) {
			initDB();
		}
	}

	/**
	 * Initialisiert den Dateipart
	 */
	private void initFile() {
		log.debug( "Initializing Settings with Settings File: " + m_propsFile.getAbsolutePath() );
		if ( !m_propsFile.exists() ) {
			File dir = m_propsFile.getParentFile();
			if ( !dir.exists() ) {
				dir.mkdirs();
			}
		}
		loadFromFile();
	}

	/**
	 * Initialisiert den Datenbankpart
	 */
	private void initDB() {
		// Prüfen, ob die Settings-Tabelle bereits existiert und wenn nicht, erstellen
		try {
			Connection conn = m_dbManager.getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( "SHOW TABLES LIKE '" + m_dbTable + "'" );
			String tablename = "";
			while (rs.next()) {
				tablename = rs.getString( 1 );
				if ( tablename.equals( m_dbTable ) ) {
					break;
				}
			}

			if ( !tablename.equals( m_dbTable ) ) {
				// Settingstabelle erstellen
				System.err.println( "No Settings table '" + m_dbTable + "' existing. Trying to create it." );
				createSettingsTable();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		loadFromDB();
	}

	/**
	 * Erstellt die Settings-Tabelle auf der Datenbank
	 */
	private void createSettingsTable() {
		try {
			Statement stmt = m_dbManager.createStatement();

			String sql = "CREATE TABLE `" + m_dbTable + "` (`settings_key` varchar(255) NOT NULL,`settings_value` text,PRIMARY KEY (`settings_key`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;";
			stmt.execute( sql );
			System.err.println( "Creating Table successful." );
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Da die Settings nur beim ersten Initialisieren des Objekts tatsächlich aus dem Speicherort gelesen
	 * werden und ab dem Zeitpunkt nur noch dort gespeichert, aber aus dem lokalen Speicher gelesen werden,
	 * kann es unte bestimmten Umständen sinnvoll sein,
	 * Settings neu aus dem Speicherort zu laden, um sicherzustellen, dass man die aktuellen Einstellungen
	 * besitzt. Das tut diese Funktion.
	 */
	public void reloadSettings() {
		if ( isDB() ) {
			loadFromDB();
		} else if ( isFile() ) {
			loadFromFile();
		}
	}

	/**
	 * Lädt alle Settings von der Datenbank. Diese Funktion kann auch genutzt werden, um sicherzustellen, dass
	 * die intern gespeicherten Settings denen aus der Datenbank entsprechen.
	 */
	private void loadFromDB() {
		if ( !isDB() ) {
			return;
		}

		try {
			Connection conn = m_dbManager.getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT settings_key, settings_value FROM " + m_dbTable );

			if ( rs != null ) {
				rs.beforeFirst();

				while (rs.next()) {
					String key = rs.getString( "settings_key" );
					String value = rs.getString( "settings_value" );

					// m_props.setProperty( key, value );
					SettingsItem item = new SettingsItem( key, value, StorageLocation.DB, false );

					m_settings.put( key, item );
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Lädt die Settings aus der Settingsdatei. Diese Funktion kann auch genutzt werden, um sicherzustellen,
	 * dass die intern gespeicherten Settings denen aus der Datei entsprechen.
	 */
	private void loadFromFile() {

		if ( !isFile() ) {
			return;
		}

		if ( m_propsFile.exists() ) {
			BufferedInputStream in = null;

			try {
				in = new BufferedInputStream( new FileInputStream( m_propsFile ) );

				Properties props = new Properties();
				props.load( in );

				Enumeration<?> keys = props.keys();
				while (keys.hasMoreElements()) {
					String key = (String)keys.nextElement();
					String value = props.getProperty( key );

					SettingsItem item = new SettingsItem( key, value, StorageLocation.FILE, false );
					m_settings.put( key, item );
				}

				// m_props.load( in );

			} catch (FileNotFoundException e) {
				e.printStackTrace();
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
			}
		}
	}

	/**
	 * Gibt den Wert zum übergebenen Key zurück
	 * 
	 * @param key
	 *            eindeutiger Bezeichner für einen bestimmten Wert
	 * @return Wert zum key, oder einen leeren String, wenn der Key nicht gefunden wurde.
	 */
	public String get( String key ) {
		if ( m_keyCollector != null ) {
			m_keyCollector.add( key );
		}

		SettingsItem item = m_settings.get( key );
		if ( item == null ) {
			return null;
		}

		return item.getValue();

		// return m_props.getProperty( key, "" );
	}

	public boolean contains( String key ) {
		return ( get( key ) != null );

	}

	public String get( String key, String defaultValue ) {
		String value = get( key );
		if ( value == null ) {
			return defaultValue;
		}
		return value;
	}

	/**
	 * Gibt einen INT-Wert zum übergebenen key zurück
	 * 
	 * @param key
	 * @return null, wenn kein Int-Wert auswertbar ist.
	 */
	public Integer getInt( String key ) {
		if ( m_keyCollector != null ) {
			m_keyCollector.add( key );
		}

		SettingsItem item = m_settings.get( key );
		if ( item == null ) {
			return null;
		}

		Integer valueInt = null;
		try {
			valueInt = Integer.parseInt( item.getValue().trim() );
		} catch (NumberFormatException e) {
			e.printStackTrace();
			valueInt = null;
		}
		return valueInt;
	}

	public Integer getInt( String key, int defaultValue ) {
		Integer i = getInt( key );
		if ( i == null ) {
			return new Integer( defaultValue );
		}
		return i;
	}

	/**
	 * Wenn zuvor ein Objekt (Serializable) über den assoziierten Key gespeichert wurde, kann dieses über
	 * diese Methode wieder ausgelesen werden. Wird kein Element mit dem key gefunden oder das gespeicherte
	 * Element wurde direkt als String oder Int
	 * gespeichert, gibt diese Methode null zurück
	 * 
	 * @param key
	 * @return null, wenn der Key nicht gefunden wurde, oder das gespeicherte Element kein Objekt ist.
	 */
	public Object getObject( String key ) {
		if ( m_keyCollector != null ) {
			m_keyCollector.add( key );
		}

		SettingsItem item = m_settings.get( key );

		if ( item == null ) {
			return null;
		}

		String valueString = item.getValue();

		Object obj = restoreObjectFromString( valueString );

		return obj;

	}

	/**
	 * Speichert ein Objekt
	 * 
	 * @param key
	 *            Eindeutiger Identifizierer für dieses Element
	 * @param value
	 *            Das Objekt, das gespeichert werden soll. Muss von Serializable abgeleitet sein.
	 * @param location
	 *            Ort, an dem das Element gespeichert werden soll (Datenbank oder File)
	 * @param temporary
	 *            Wenn true, wird nur temporär gespeichert, d.h. es wird nicht im Festspeicher abgelegt.
	 */
	public void put( String key, Serializable value, StorageLocation location, boolean temporary ) {

		String valueString = readObjectToString( value );

		put( key, valueString, location, temporary );

	}

	/**
	 * Speichert eine Einstellung
	 * 
	 * @param key
	 *            Eindeutiges Schlüsselwort
	 * @param value
	 *            Wert der Einstellung
	 * @param location
	 *            Ort - Datenbank oder Datei
	 * @param temporary
	 *            wenn true, dann wird die Einstellung nur temporär gespeichert, d.h. sie kommt nicht in die
	 *            Datenbank oder Datei
	 */
	public void put( String key, String value, StorageLocation location, boolean temporary ) {
		SettingsItem item = new SettingsItem( key, value, location, temporary );

		put( item );
	}

	public void putAll( Properties properties ) {
		Enumeration<?> keys = properties.keys();

		while (keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			String value = properties.getProperty( key );

			put( key, value );
		}
	}

	/**
	 * Speichert den übergebenen SettingsItem
	 * 
	 * 
	 * @param item
	 */
	private void put( SettingsItem item ) {
		if ( m_keyCollector != null ) {
			m_keyCollector.add( item.getKey() );
		}
		m_settings.put( item.getKey(), item );

		if ( !item.isTemporary() ) {
			if ( item.getLocation() == StorageLocation.DB ) {
				saveToDB( item.getKey() );
			} else {
				saveToFile();
			}
		}
	}

	public void remove( String key ) {
		if ( m_keyCollector != null ) {
			m_keyCollector.add( key );
		}

		SettingsItem item = m_settings.get( key );
		if ( item != null ) {
			m_settings.remove( key );

			if ( !item.isTemporary() ) {
				if ( item.getLocation() == StorageLocation.DB ) {
					saveToDB( item.getKey() );
				} else {
					saveToFile();
				}
			}
		}
	}

	/**
	 * Speichert entweder auf den Ort, den ein Elemtn schon hat und wenn es nicht existiert, wird das Element
	 * auf die Standardlocation gespeichert
	 * 
	 * @param key
	 *            eindeutiger Bezeichner für den Wert
	 * @param value
	 *            Wert zum Key
	 */
	public void put( String key, String value ) {

		// Prüfen, ob es den Wert schon gibt
		SettingsItem item = m_settings.get( key );
		if ( item == null ) {
			// Neu anlegen
			item = new SettingsItem( key, value, m_standardLocation, false );
		} else {
			item.setValue( value );
		}

		put( item );
	}

	/**
	 * Speichert das Objekt. Genaue Beschreibung siehe {@link #put(String, String)}
	 * 
	 * @see #put(String, String)
	 * @param key
	 * @param value
	 */
	public void put( String key, Serializable value ) {
		String valueString = readObjectToString( value );
		put( key, valueString );
	}

	/**
	 * Nimmt ein serialisierbares Objekt an und konvertiert es in einen Base64 encodeten String, um es in
	 * Textform speichern zu können.
	 * 
	 * @param object
	 * @return
	 */
	private String readObjectToString( Serializable object ) {
		String returnString = null;

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream( baos );
			os.writeObject( object );

			Base64 base64 = new Base64();
			returnString = base64.encodeToString( baos.toByteArray() );
			// BASE64Encoder enc = new BASE64Encoder();
			// returnString = enc.encode( baos.toByteArray() );

			os.close();
			baos.close();

			os = null;
			baos = null;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return returnString;
	}

	/**
	 * Nimmt einen Base64 Encodeten String und stellt das zuvor darin serialisierte Objekt wieder her. Stimmt
	 * irgendwas am String nicht, wird null zurückgegeben.
	 * 
	 * @param base64String
	 * @return
	 */
	private Object restoreObjectFromString( String base64String ) {
		Base64 base64 = new Base64();
		// BASE64Decoder dec = new BASE64Decoder();
		Object returnObj = null;

		try {
			ByteArrayInputStream bain = new ByteArrayInputStream( base64.decode( base64String ) );
			ObjectInputStream in = new ObjectInputStream( bain );
			returnObj = in.readObject();

			bain.close();
			in.close();

			bain = null;
			in = null;

		} catch (IOException e) {
			log.warn( e.getMessage(), e );
		} catch (ClassNotFoundException e) {
			log.warn( e.getMessage(), e );
		}catch (Exception e) {
			log.warn( e.getMessage(), e );
		}

		return returnObj;
	}

	/**
	 * Speichert den übergebenen Int-Wert
	 * 
	 * @param key
	 * @param value
	 */
	public void put( String key, int value ) {
		put( key, "" + value );
	}

	/**
	 * Speichert eine Einstellung temporär
	 * 
	 * @param key
	 * @param value
	 */
	public void putTemporary( String key, String value ) {
		SettingsItem item = new SettingsItem( key, value, StorageLocation.FILE, true );
		put( item );
	}

	/**
	 * Speichert eine Einstellung temporär
	 * 
	 * @param key
	 * @param value
	 */
	public void putTemporary( String key, Serializable value ) {
		String valueString = readObjectToString( value );
		putTemporary( key, valueString );
	}

	/**
	 * Speichert eine Einstellung in die Datenbank
	 * 
	 * @param key
	 * @param value
	 */
	public void putDB( String key, String value ) {
		SettingsItem item = new SettingsItem( key, value, StorageLocation.DB, false );
		put( item );
	}

	/**
	 * Speichert ein Objekt in die Datenbank
	 * 
	 * @param key
	 * @param value
	 */
	public void putDB( String key, Serializable value ) {
		String valueString = readObjectToString( value );
		putDB( key, valueString );
	}

	/**
	 * Speichert eine Einstellung in die Datei
	 * 
	 * @param key
	 * @param value
	 */
	public void putFile( String key, String value ) {
		SettingsItem item = new SettingsItem( key, value, StorageLocation.FILE, false );
		put( item );
	}

	/**
	 * Speichert ein Objekt in die Datei
	 * 
	 * @param key
	 * @param value
	 */
	public void putFile( String key, Serializable value ) {
		String valueString = readObjectToString( value );
		putFile( key, valueString );
	}

	/**
	 * Speichert die Einstellungen
	 */
	public void save() {
		if ( isFile() ) {
			saveToFile();
		} else if ( isDB() ) {
			saveToDB();
		} else {
			throw new RuntimeException( "WARNUNG: Settings konnten nicht gespeichert werden!" );
		}
	}

	/**
	 * Speichert alles in die Datenbank
	 */
	private void saveToDB() {
		try {
			Connection conn = m_dbManager.getConnection();

			PreparedStatement stmt = conn.prepareStatement( "REPLACE INTO " + m_dbTable + " SET settings_key=?, settings_value=?" );

			Enumeration<String> keys = m_settings.keys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();

				SettingsItem item = m_settings.get( key );
				if ( !item.isTemporary() && item.getLocation() == StorageLocation.DB ) {
					String value = item.getValue();

					stmt.setString( 1, key );
					stmt.setString( 2, value );

					stmt.execute();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Speichert nur den übergebenen Key in der Datenbank
	 * 
	 * @param key
	 */
	private void saveToDB( String key ) {
		try {
			Connection conn = m_dbManager.getConnection();

			PreparedStatement stmt = conn.prepareStatement( "REPLACE INTO " + m_dbTable + " SET settings_key=?, settings_value=?" );
			String value = "";

			SettingsItem item = m_settings.get( key );
			if ( item != null ) {
				if ( !item.isTemporary() ) {
					value = item.getValue();

					stmt.setString( 1, key );
					stmt.setString( 2, value );

					stmt.execute();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Speichert alle Settings in die lokale Datendatei
	 */
	private void saveToFile() {
		BufferedOutputStream out = null;

		try {
			out = new BufferedOutputStream( new FileOutputStream( m_propsFile ) );

			Properties props = new Properties();

			Enumeration<String> keys = m_settings.keys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();

				SettingsItem item = m_settings.get( key );

				if ( !item.isTemporary() && item.getLocation() == StorageLocation.FILE ) {
					props.setProperty( key, item.getValue() );
				}
			}
			props.store( out, null );

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if ( out != null ) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setCollectKeys( boolean collect ) {
		if ( collect = false ) {
			m_keyCollector = null;
		} else {
			if ( m_keyCollector == null ) {
				m_keyCollector = new Vector<String>();
			}
		}
	}

	public Vector<String> getCollectedKeys() {
		Vector<String> v = new Vector<String>();
		if ( m_keyCollector != null ) {
			v = m_keyCollector;
		}
		return v;
	}

	public enum StorageLocation {
		DB, FILE
	}

	private class SettingsItem {

		private String key = "";

		private String value = "";

		private StorageLocation location = StorageLocation.FILE;

		private boolean temporary = false;

		public SettingsItem( String key, String value, StorageLocation location, boolean temporary ) {
			this.key = key;
			this.value = value;
			this.location = location;
			this.temporary = temporary;
		}

		public String getValue() {
			return this.value;
		}

		public void setValue( String value ) {
			this.value = value;
		}

		public StorageLocation getLocation() {
			return this.location;
		}

		@SuppressWarnings("unused")
		public void setLocation( StorageLocation location ) {
			this.location = location;
		}

		public boolean isTemporary() {
			return this.temporary;
		}

		@SuppressWarnings("unused")
		public void setTemporary( boolean b ) {
			this.temporary = b;
		}

		public String getKey() {
			return this.key;
		}
	}
}
