package de.stiffi.DPHelpers.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Der DatabaseManager ist für die Verbindung zur Datenbank zuständig. Er hält eine Verbindung, die möglichst immer aufrechterhalten wird und mit getConnection() zurückgegeben wird. So werden so wenig wie möglich neue Verbindungsinitiierungen nötig.
 * 
 * TODO: Irgendwas implementieren, dass die Verbindung im Hintergrund geprüft wird und bei Bedarf wiederhergestellt.
 * 
 * 
 * @author lamp, last mod: $Author: lamp $
 * @version $Revision: 0000 $ $Date: Jul 21, 2009 $
 * 
 */
public class DatabaseManager {

	/**
	 * JDBC Treibername
	 */
	private String m_sqlDriverName;

	/**
	 * Datenbankserver Host
	 */
	private String m_sqlServer;

	/**
	 * Benutzername zur Datenbank
	 */
	private String m_sqlUsername;

	/**
	 * Password des Datenbankbenutzers
	 */
	private String m_sqlPassword;

	/**
	 * Port, auf dem der Datenbankserver läuft
	 */
	private int m_sqlPort;

	/**
	 * Name der Datenbank auf die zugegriffen werden soll
	 */
	private String m_sqlDatabase;

	/**
	 * In diesem Objekt werden die Verbindungsdaten gespeichert.
	 */
	private Connection m_dbConnection = null;

	private static DatabaseManager onlyInstance = null;

	/**
	 * Gibt die Instanz des Managers zurück
	 * 
	 * @return
	 * @throws NotInitializedException
	 */
	public static DatabaseManager getInstance() {
		if ( onlyInstance != null ) {
			return onlyInstance;
		} else {
			throw new NotInitializedException( "DatabaseManager is not yet initialized. Please run static method _init()_ first!" );
		}
	}

	/**
	 * Konstruktor
	 * 
	 * @param sqlDriverName
	 * @param sqlServer
	 * @param sqlUsername
	 * @param sqlPassword
	 * @param sqlPort
	 * @param sqlDatabase
	 */
	private DatabaseManager( String sqlDriverName, String sqlServer, String sqlUsername, String sqlPassword, int sqlPort, String sqlDatabase ) {
		m_sqlDriverName = sqlDriverName;
		m_sqlServer = sqlServer;
		m_sqlUsername = sqlUsername;
		m_sqlPassword = sqlPassword;
		m_sqlPort = sqlPort;
		m_sqlDatabase = sqlDatabase;
	}

	/**
	 * Initialisiert den Datenbankmanager mit den angegebenen Daten
	 * 
	 * @param sqlDriverName
	 * @param sqlServer
	 * @param sqlUsername
	 * @param sqlPassword
	 * @param sqlPort
	 * @param sqlDatabase
	 */
	public static void init( String sqlDriverName, String sqlServer, String sqlUsername, String sqlPassword, int sqlPort, String sqlDatabase ) {
		try {
			try {
				Class.forName( sqlDriverName ).newInstance();
				onlyInstance = new DatabaseManager( sqlDriverName, sqlServer, sqlUsername, sqlPassword, sqlPort, sqlDatabase );
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gibt die Verbindung zur Datenbank zurück. Bei Bedarf wird diese auch automatisch aufgebaut
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		if ( m_dbConnection != null && !m_dbConnection.isClosed() ) {
			return m_dbConnection;
		} else {
			String url = "jdbc:" + getSubProtocolName() + "://" + m_sqlServer + ":" + m_sqlPort + "/" + m_sqlDatabase;
			m_dbConnection = DriverManager.getConnection( url, m_sqlUsername, m_sqlPassword );
			return m_dbConnection;
		}
	}

	/**
	 * Gibt ein Standard-Statement zurück.
	 * <p>
	 * Diese Methode ersetzt einfach folgenden code:
	 * 
	 * <pre>
	 * 
	 * Connection conn = DatabaseManager.getConnection();
	 * 
	 * Statement stmt = conn.createStatement();
	 * </pre>
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Statement createStatement() throws SQLException {
		Connection conn = getConnection();
		return conn.createStatement();
	}

	/**
	 * Schließt die Verbindung explizit. Der Aufruf dieser Methode sollte im Normalfall nicht nötig sein.
	 */
	public void closeConnection() {
		try {
			if ( !m_dbConnection.isClosed() ) {
				m_dbConnection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Analysiert den in der init Methode übergebenen Datenbanktreiber Namen und gibt entsprechend das Subprotokoll (z.B. mysql) als String zurück
	 * 
	 * @return
	 */
	private String getSubProtocolName() {
		if ( m_sqlDriverName.contains( "mysql" ) ) {
			return "mysql";
		}

		return null;
	}

	/**
	 * Beim Finalisieren wird die Datenbankverbindung geschlossen.
	 */
	@Override
	public void finalize() throws Throwable {
		m_dbConnection.close();
		m_dbConnection = null;
		super.finalize();
	}

	/**
	 * Wenn das statement ein INSERT Statement war, kann mit dieser Funktion direkt die neu generierte Auto-Increment ID herausbekommen werden.
	 * 
	 * @param stmt
	 * @return -1 bei einem Fehler.
	 */
	public int getGeneratedId( Statement stmt ) {
		int id = -1;
		ResultSet rs;
		try {
			rs = stmt.getGeneratedKeys();
			if ( rs.next() ) {
				id = rs.getInt( 1 );
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}