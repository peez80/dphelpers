package de.stiffi.DPHelpers.Files;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * �berpr�ft in regelm��igen Abst�nden ein Verzeichnis auf neue Dateien.<br>
 * 
 * Kommen neue Dateien hinzu, werden diese zuerst gesondert beobachtet bis sie eine best. Zeit nicht
 * mehr gewachsen sind. Erst dann gelten sie als komplett und werden an die entsprechenden Listener
 * * weitergegeben.
 * <p>
 * Vorerst wird der DirWatcher keine Unterverzeichnisse �berwachen.
 */
public class DirWatcher {

	/**
	 * Root-Verzeichnis, das �berwacht wird.
	 */
	private File directory;

	/**
	 * Zeit in Sekunden, die eine Datei sich nicht mehr �ndern darf (in Gr��e und LastModified
	 * Datum), dass sie als komplett angesehen wird.
	 */
	private int completeThreshold;

	/**
	 * Wenn gesetzt, wird dieser FileFilter auf den Indexer angewandt und dementsprechend nur die
	 * hier angegebenen Dateitypen �berwacht.
	 */
	private FileFilter fileFilter = null;

	/**
	 * Hier ind alle aktuell als komplett angesehenen Dateien gespeichert.
	 * <p>
	 * Struktur: Dateipfad - FileData Objekt
	 */
	private Hashtable<String, FileData> completeFiles = new Hashtable<String, FileData>();

	/**
	 * Hier sind alle aktuell als unkomplett, also noch wachsenden angesehenen Dateien gespeichert.
	 * 
	 */
	private List<FileData> incompleteFiles = new ArrayList<FileData>();

	/**
	 * Vorerst bleibt das false
	 */
	private boolean recursive = false;

	private List<DirWatcherListener> listeners = new ArrayList<DirWatcherListener>();

	/**
	 * Sagt aus, ob von einem anderen Thread aus ein Stop erbeten wird. Wenn true, wird bei der
	 * n�chsten sinnvollen Gelegenheit der Index-Vorgang abgebrochen
	 */
	private boolean stopRequest = false;

	/**
	 * Sagt aus, ob gerade ein Index-Vorgang l�uft.
	 */
	private boolean working = false;
	
	/**
	 * Wenn true, werden beim Starten vorhandene Files nicht als neue Datei gemeldet.
	 */
	private boolean ignoreInitialFiles = false;
	
	/**
	 * Anzahl an Watch-Durchl�ufen
	 */
	private long watchCount = 0;

	/**
	 * Konstruktor. Danach bitte {@link #start()} aufrufen, um den Watcher zu starten.
	 * 
	 * 
	 * @param directory Root-Verzeichnis, das �berwacht wird.
	 * @param indexInterval Pause in Sekunden zwischen Index-Vorg�ngen
	 * @param completeThreshold Zeit in Sekunden, die eine Datei sich nicht mehr �ndern darf, bevor sie als
	 *            komplett angesehen wird.
	 * @throws IOException Wenn das angegebene Verzeichnis nicht existiert oder kein Verzeichnis
	 *             ist.
	 */
	public DirWatcher( File directory, int completeThreshold ) throws IOException {
		if ( !directory.exists() || !directory.isDirectory() ) {
			throw new IOException( "Not existing or no directory" );
		}

		this.directory = new File( directory.getAbsolutePath() );
		this.completeThreshold = completeThreshold;
	}

	/**
	 * Konstruktor. Danach bitte {@link #start()} aufrufen, um den Watcher zu starten.
	 * 
	 * @param directory Root-Verzeichnis, das �berwacht wird.
	 * @param indexInterval Pause in Sekunden zwischen Index-Vorg�ngen
	 * @param completeThreshold Zeit, die eine Datei sich nicht mehr �ndern darf, bevor sie als
	 *            komplett angesehen wird.
	 * @param fileFilter Es werden nur Dateien �berwacht, die diesem Filter entsprechen
	 * @throws IOException Wenn das angegebene Verzeichnis nicht existiert oder kein Verzeichnis
	 *             ist.
	 */
	public DirWatcher( File directory, int completeThreshold, FileFilter fileFilter ) throws IOException {
		this( directory, completeThreshold );
		this.fileFilter = fileFilter;
	}

	/**
	 * Startet einen Index-Vorgang.
	 */
	public void watch() {
		if ( !working ) {
			// Nur ausf�hren, wenn nicht gerade schon geindexed wird.
			stopRequest = false;
			working = true;
			watchDir( getDirectory() );
			watchCount++;
			working = false;
		}
	}

	/**
	 * Obwohl vorerst keine Unterverzeichnisse, ist diese Methode mit ihrem Argument schonmal
	 * f�r rekursion vorbereitet.
	 * 
	 * @param directory
	 */
	protected void watchDir( File directory ) {
		working = true;

		File files[] = null;
		if ( fileFilter != null ) {
			files = directory.listFiles( fileFilter );
		} else {
			files = directory.listFiles();
		}

		// Alle Files durchgehen
		for ( File file : files ) {

			if ( stopRequested() ) { // Stop wenn n�tig!
				working = false;
				return;
			}

			if ( recursive && file.isDirectory() ) {
				// Wenn rekursiv, Unterverzeichnis handeln
				watchDir( file );
			} else if ( file.isFile() ) {
				/*
				 * Strategie: Dateien durchgehen. Wenn sie noch nicht vorhanden sind, zu den
				 * "wachsenden" Dateien hinzuf�gen. Sind sie vorhanden, Datum u. Gr��e pr�fen.
				 * Wenn unterschiedlich zu den "wachsenden" Dateien verschieben
				 */
				
				if (ignoreInitialFiles && watchCount == 0) {
					//Beim ersten Durchgang wenn ignoreInitialFiles einfach alle Files ins Complete werfen
					FileData fileData = new FileData( file );
					completeFiles.put( file.getAbsolutePath(), fileData );
				}

				FileData fileData = completeFiles.get( file.getAbsolutePath() );
				if ( fileData != null ) {
					// Datei gibts schon - also Daten kurz pr�fen und wenn alles gleich ist,
					// weiter in der Schleife!
					if ( fileData.equals( file ) ) {
						continue;
					} else {
						// Datei ist nicht mehr gleich, also wieder zu den nicht-kompletten
						// schieben
						completeFiles.remove( file.getAbsolutePath() );
						fileData.isNewFile = false;
						incompleteFiles.add( fileData );
						existingFileChanging( file );
					}
				} else {
					// Neue Datei - pr�fen ob ich in incomplete Files bin, ansonsten adden
					fileData = new FileData( file );

					if ( !incompleteFiles.contains( fileData ) ) {
						fileData.isNewFile = true;
						incompleteFiles.add( fileData );
						newFileChanging( file );
					}

				}
			}
		}

		// Jetzt die incomplete Files durchgehen und pr�fen ob sie jetzt als komplett angesehen
		// werden k�nnen.

		for ( int i = 0; i < incompleteFiles.size(); i++ ) {

			if ( stopRequested() ) { // Stop wenn n�tig!
				working = false;
				return;
			}

			FileData fileData = incompleteFiles.get( i );

			if ( !fileData.file.exists() ) {
				// Datei wurde zwischenzeitlich gel�scht. Entfernen und Event schmei�en
				incompleteFiles.remove( fileData );
				existingFileRemoved( fileData.file );

			} else if ( !fileData.isUpToDate() ) {
				// Datei hat sich seit letztem Durchlauf ge�ndert, also einfach wieder updaten
				fileData.update();
			} else {
				// Wenn Datei die eingestellte Zeit nicht mehr ge�ndert wurde, als komplett
				// ansehen!
				if ( System.currentTimeMillis() - fileData.lastUpdate > completeThreshold * 1000l ) {
					// Bin fertig!
					incompleteFiles.remove( i );
					completeFiles.put( fileData.file.getAbsolutePath(), fileData );

					if ( fileData.isNewFile ) {
						fileData.isNewFile = false;
						newFileAdded( fileData.file );
					} else {
						existingFileFinished( fileData.file );
					}

					// Mit Remove verschieben sich die indizes in der for-Schleife
					i--;
				}
			}
		}

		// Und ganz zum schluss nochmal die kompletten Files durchgehen ob eine davon gel�scht
		// wurde.
		Enumeration<String> paths = completeFiles.keys();
		while (paths.hasMoreElements()) {

			if ( stopRequested() ) { // Stop wenn n�tig!
				working = false;
				return;
			}

			String filePath = paths.nextElement();
			File file = new File( filePath );
			if ( !file.exists() ) {
				// Datei gel�scht, also aus Hashtable entfernen und Event schmei�en
				completeFiles.remove( filePath );
				existingFileRemoved( file );
			}
		}

		working = false;
	}

	/**
	 * Da das Indexen ein langwieriger Prozess sein kann, wird diese Methode zwischendrin immer
	 * wieder aufgerufen.
	 * <p>
	 * Abgeleitete Klassen k�nnen sie �berschreiben um zu pr�fen, ob der Index-Vorgang abgebrochen
	 * werden soll.
	 * 
	 * @return true, wenn abgebrochen werden soll
	 */
	protected boolean stopRequested() {
		return stopRequest;
	}

	/**
	 * Setzt {@link #stopRequest} auf true, damit der Index-Vorgang bei der n�chsten sinnvollen
	 * Gelegenheit abgebrochen wird.<br>
	 * Wenn auf das Abbrechen gewartet werden soll, muss dieser Thread danach dann wiederholt auf
	 * {@link #isWorking()} == false pr�fen
	 */
	public void setStopRequest() {
		stopRequest = true;
	}

	public void newFileAdded( File file ) {
		for ( DirWatcherListener listener : listeners ) {
			listener.newFileAdded( file );
		}
	}

	public void existingFileRemoved( File file ) {
		for ( DirWatcherListener listener : listeners ) {
			listener.existingFileRemoved( file );
		}
	}

	public void newFileChanging( File file ) {
		for ( DirWatcherListener listener : listeners ) {
			listener.newFileChanging( file );
		}
	}

	public void existingFileChanging( File file ) {
		for ( DirWatcherListener listener : listeners ) {
			listener.existingFileChanging( file );
		}
	}

	public void existingFileFinished( File file ) {
		for ( DirWatcherListener listener : listeners ) {
			listener.existingFileFinished( file );
		}
	}

	public void addListener( DirWatcherListener listener ) {
		if ( !listeners.contains( listener ) ) {
			listeners.add( listener );
		}
	}

	private class FileData {

		public File file;

		public long length;

		public long lastModified;

		public long lastUpdate;

		/*
		 * speichert zwischen ob ich eine bereits bekannte Datei oder eine neue bin, um zu
		 * entscheiden, welcher Event geworfen wird, wenn die Datei komplett ist.
		 */
		private boolean isNewFile = false;

		public FileData() {}

		public FileData( File f ) {
			file = new File( f.getAbsolutePath() );
			update();
		}

		public boolean equals( File file ) {
			return ( file.length() == length && file.lastModified() == lastModified );
		}

		/**
		 * Achtung! Damit ich bei {@link DirWatcher#incompleteFiles} contains() aufrufen kann, pr�ft
		 * diese Methode nur auf den Dateipfad!
		 * 
		 */
		@Override
		public boolean equals( Object obj ) {
			if ( !( obj instanceof FileData ) ) {
				return super.equals( obj );
			} else {
				FileData o = (FileData)obj;
				return ( o.file.getAbsolutePath().equals( file.getAbsolutePath() ) );
			}
		}

		public void update() {
			length = file.length();
			lastModified = file.lastModified();
			lastUpdate = System.currentTimeMillis();
		}

		/**
		 * Pr�ft, ob die im Objekt gespeicherten Informationen noch mit den tats�chlichen Daten der
		 * Datei �bereinstimmen
		 * 
		 * @return
		 */
		public boolean isUpToDate() {
			return ( equals( file ) );
		}
	}

	public FileFilter getFileFilter() {
		return fileFilter;
	}

	public void setFileFilter( FileFilter fileFilter ) {
		this.fileFilter = fileFilter;
	}

	public File getDirectory() {
		return directory;
	}

	public boolean isRecursive() {
		return recursive;
	}

	public List<DirWatcherListener> getListeners() {
		return listeners;
	}

	/**
	 * Sagt aus, ob gerade noch ein Index-Vorgang aktiv ist. Diese Methode muss wiederholend gepr�ft
	 * werden, nachdem z.B. #setStopRequest() aufgerufen wurde.
	 * 
	 * @return
	 */
	public boolean isWorking() {
		return working;
	}

	
	public boolean getIgnoreInitialFiles() {
		return ignoreInitialFiles;
	}

	
	public void setIgnoreInitialFiles( boolean ignoreInitialFiles ) {
		this.ignoreInitialFiles = ignoreInitialFiles;
	}
}
