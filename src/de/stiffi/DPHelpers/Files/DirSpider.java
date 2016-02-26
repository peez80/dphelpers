package de.stiffi.DPHelpers.Files;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Vector;

/**
 * Diese Klasse dient dazu, Verzeichnisbäume rekursiv durchzugehen und zu bearbeiten.
 * 
 * @see SimpleDirSpider SimpleDirSpider - Eine Standard-Spider, die nur angeschlossene Listener
 *      benachrichtigt
 * @author HD-Authoring
 * 
 */
public abstract class DirSpider {

	/**
	 * Hier gehts los mit durchsuchen
	 */
	private File m_root = null;

	/**
	 * Da sehr oft auch Ausgaben über Verzeichnisstrukturen gemacht werden müssen, wird hier
	 * automatisch für jedes Unterverzeichnis der Wert eins höher gezählt, während es wieder eins
	 * erniedrigt wird, wenn ein Verzeichnis verlassen wird. So lassen sich relativ einfach
	 * strukturierte Informationen ausgeben.
	 * 
	 * @see #getIndent()
	 */
	private int m_indent = 0;

	/**
	 * Neben den Methoden, die von einer ableitenden Klasse überschrieben werden müssen, besteht
	 * außerdem die Möglichkeit, die Dateien per Listener verarbeiten zu lassen. Diese Listener
	 * werden hier im Vector gespeichert.
	 */
	private Vector<DirSpiderListener> m_listeners = null;

	/**
	 * Im Normalfall soll eine Spider auch rekursiv alle Unterverzeichnisse durchgehen. Es gibt aber
	 * auch Fälle, wo nur das Root-Verzeichnis
	 */
	private boolean m_recursive = true;

	/**
	 * Wenn nur bestimmte Dateien genommen werden sollen, kann hier ein FilenameFilter gespeichert
	 * werden
	 */
	private FilenameFilter m_filenameFilter = null;

	/**
	 * Wenn true, wird das Abarbeiten der Verzeichnisse, das vorher mit go() gestartet wurde,
	 * beendet
	 */
	private boolean stopRequest = false;

	/**
	 * Konstruktor.
	 * 
	 * @param rootDirectory Start-Verzeichnis für die Spider
	 */
	public DirSpider( File rootDirectory ) {
		setRootDirectory( rootDirectory );
		m_listeners = new Vector<DirSpiderListener>();
	}

	/**
	 * Setzt das Start-Verzeichnis für die Spider
	 * 
	 * @param rootDirectory
	 */
	public void setRootDirectory( File rootDirectory ) {
		m_root = rootDirectory;
	}

	/**
	 * Beginnt mit der Abarbeitung
	 */
	public void go() {
		stopRequest = false;
		preRun();
		spider( m_root );
		postRun();
		stopRequest = false;
	}

	/**
	 * Bricht das Abarbeiten der Verzeichnisse ab postRun() etc. wird danach noch ausgeführt
	 */
	public void stop() {
		stopRequest = true;
	}

	/**
	 * Rekursive Funktion, führt das "durchgehen" aus. Jedes verzeichnis wird durchlaufen. Wenn ein
	 * Verzeichnis durchlaufen wird, werden folgende Methoden in dieser Reihenfolge aufgerufen:
	 * 
	 * enterDir() handleDir() spider() leaveDir()
	 * 
	 * Das heißt, enterDir() und leaveDir() sind eigentlich mehr zur Information da. Eigentliche
	 * Operationen sollten in handleDir() ausgeführt werden.
	 * 
	 * @param dir
	 */
	private void spider( File dir ) {
		if ( stopRequest ) {
			return;
		}

		if ( !dir.isDirectory() ) {
			return;
		}

		File files[] = dir.listFiles( m_filenameFilter );

		if ( files == null ) {
			return;
		}

		for ( int i = 0; i < files.length; i++ ) {

			if ( stopRequest ) {
				return;
			}

			if ( files[i].isDirectory() && m_recursive ) {

				m_indent++;
				enterDir( files[i] );
				informListeners_enterDir( files[i] );
				m_indent++;
				handleDir( files[i] );
				informListeners_handleDir( files[i] );
				spider( files[i] );
				m_indent--;
				leaveDir( files[i] );
				informListeners_leaveDir( files[i] );
				m_indent--;

			} else if ( files[i].isFile() ) {
				handleFile( files[i] );
				informListeners_handleFile( files[i] );
			}
		}
	}

	/**
	 * Diese Methode wird von go() vor dem eigentlichen Spider-Vorgang aufgerufen
	 */
	public abstract void preRun();

	/**
	 * Diese Methode wird von go() nach dem Spidern aufgerufen
	 */
	public abstract void postRun();

	/**
	 * Diese Funktion wird aufgerufen, wenn eine Datei gefunden wird. Gewünschte Funktionen sollten
	 * hier implementiert werden.
	 * 
	 * @param file
	 */
	public abstract void handleFile( File file );

	/**
	 * Informiert die Listener, dass eine Datei gefunden wurde.
	 * 
	 * @param file
	 */
	private void informListeners_handleFile( File file ) {
		for ( int i = 0; i < m_listeners.size(); i++ ) {
			m_listeners.get( i ).handleFile( file, this );
		}
	}

	/**
	 * Diese Funktion wird aufgerufen, wenn ein Verzeichnis gefunden wird. Sie wird aufgerufen, wenn
	 * das Verzeichnis "betreten" wird, also VOR den enthaltenen Dateien.
	 * 
	 * @param dir
	 */
	public abstract void handleDir( File dir );

	/**
	 * Informiert die Listener, dass ein Verzeichnis gefunden wurde
	 * 
	 * @param dir
	 */
	private void informListeners_handleDir( File dir ) {
		for ( int i = 0; i < m_listeners.size(); i++ ) {
			m_listeners.get( i ).handleDir( dir, this );
		}
	}

	/**
	 * Informiert die Listener, dass gerade ein Verzeichnis "betreten" wurde.
	 * 
	 * @param dir
	 */
	private void informListeners_enterDir( File dir ) {
		for ( int i = 0; i < m_listeners.size(); i++ ) {
			m_listeners.get( i ).enterDir( dir, this );
		}
	}

	/**
	 * Diese Funktion wird aufgerufen, wenn ein Verzeichnis "betreten" wird, d.h. bevor handleDir()
	 * aufgerufen wird und die beinhalteten Dateien abgearbeitet werden.
	 * 
	 * @param dir
	 */
	public abstract void enterDir( File dir );

	/**
	 * Diese Funktion wird aufgerufen, wenn ein Verzeichnis wieder "verlassen" wird, d.h. nachdem
	 * alle Unterdateien- und Verzeichnisse abgearbeitet sind.
	 * 
	 * @param dir
	 */
	public abstract void leaveDir( File dir );

	/**
	 * Informiert die Listener, dass gerade ein Verzeichnis "verlassen" wurde.
	 * 
	 * @param dir
	 */
	private void informListeners_leaveDir( File dir ) {
		for ( int i = 0; i < m_listeners.size(); i++ ) {
			m_listeners.get( i ).leaveDir( dir, this );
		}
	}

	/**
	 * Gibt das Start-Verzeichnis der Spider zurück
	 * 
	 * @return
	 */
	public File getRootDirectory() {
		return m_root;
	}

	/**
	 * Da öfters Verzeichnisstrukturen abgebildet werden müssen, wird hier mit jedem
	 * Unterverzeichnis schon eine Leerstelle hinzugefügt. diese Funktion gibt also immer einen
	 * String mit einer bestimmten Anzahl Leerzeichen zurück, damit Verzeichnis bäume schnell
	 * dargestellt werden können.
	 * 
	 * @return
	 */
	public String getIndent() {
		String s = "";
		for ( int i = 0; i < m_indent; i++ ) {
			s += " ";
		}
		return s;
	}

	/**
	 * Fügt einen Listener hinzu
	 * 
	 * @param l
	 */
	public void addDirSpiderListener( DirSpiderListener l ) {
		if ( !m_listeners.contains( l ) ) {
			m_listeners.add( l );
		}
	}

	/**
	 * Entfernt den übergebenen Listener
	 * 
	 * @param l
	 */
	public void removeDirSpiderListener( DirSpiderListener l ) {
		m_listeners.remove( l );
	}

	/**
	 * Stellt ein, ob die Spider rekursiv den Verzeichnisbaum durchgehen soll, oder nur auf der
	 * oberen angegebenen Ebene arbeitet.
	 * 
	 * @param recursive
	 */
	public void setRecursive( boolean recursive ) {
		m_recursive = recursive;
	}

	/**
	 * Sagt aus, ob die Spider rekursiv den Verzeichnisbaum durchgeht, oder nur auf der oberen
	 * angegebenen Ebene arbeitet.
	 * 
	 * @return
	 */
	public boolean isRecursive() {
		return m_recursive;
	}

	/**
	 * Wenn nur bestimmte Dateien berücksichtigt werden sollen, kann mit dieser Funktion ein
	 * FilenameFilter regisrtiert werden, der dann beim "Spidern" benutzt wird.
	 * 
	 * @param filter FilenameFilter der genutzt werden soll. Wenn null, werden alle gefundenen Files
	 *            berücksichtigt
	 */
	public void setFilenameFilter( FilenameFilter filter ) {
		m_filenameFilter = filter;
	}

	/**
	 * Gibt den FilenameFilter zurück, der beim Spidern genutzt wird.
	 * 
	 * @return
	 */
	public FilenameFilter getFilenameFilter() {
		return m_filenameFilter;
	}
}
