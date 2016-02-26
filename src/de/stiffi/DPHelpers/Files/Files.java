package de.stiffi.DPHelpers.Files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.stiffi.DPHelpers.DPHelpers;
import de.stiffi.DPHelpers.Files.SourceToTargetFileVisitor.Mode;

/**
 * Diese Klasse stellt einige static Funktionen zur Be- und Verarbeitung von Dateien zur Verfügung.
 * 
 * @author HD-Authoring
 * 
 */
public class Files {

	private final static Logger log = LoggerFactory.getLogger( Files.class );

	/**
	 * Standard-Retry Anzahl bei Dateioperationen
	 */
	public static int DEFAULT_RETRIES = 5;

	/**
	 * Standard-Wartezeiten zwischen Wiederholungsversuchen bei Dateioperationen
	 */
	public static int DEFAULT_RETRY_WAIT_SECONDS = 10;

	/**
	 * Standard-Buffersize für Dateioperationen wie kopieren etc.
	 */
	public static int DEFAULT_BUFFER_SIZE = 2097152; // Mit 2MB rel. groß, aber auch schnell

	public static void copyRecursive( Path sourceDir, Path targetDir ) throws IOException {

		SourceToTargetFileVisitor visitor = new SourceToTargetFileVisitor( sourceDir, targetDir, false, Mode.COPY );

		java.nio.file.Files.walkFileTree( sourceDir, visitor );
	}

	/**
	 * Copies file src to file dst with default buffer- and retry settings.
	 * 
	 * @see #DEFAULT_RETRIES
	 * @see #DEFAULT_RETRY_WAIT_SECONDS
	 * @see #DEFAULT_BUFFER_SIZE
	 * @param src Source file to copy
	 * @param dst Destination file to copy to
	 * @param listeners Listeners, that get informed of progress and succes or fail
	 * @return true if copy was successful, false otherwise
	 */
	public static boolean copyFile( File src, File dst, ProgressListener[] listeners ) {
		return copyFile( src, dst, DEFAULT_RETRIES, DEFAULT_RETRY_WAIT_SECONDS, DEFAULT_BUFFER_SIZE, listeners );
	}

	/**
	 * Copies file src to file dst
	 * 
	 * 
	 * TODO Testen!
	 * 
	 * 
	 * @param src Source file to copy
	 * @param dst Destination file to copy to
	 * @param retries Amount of retries if something goes wrong while copying
	 * @param retryWaitSeconds Time to waint before retry
	 * @param bufferSize Buffer-size to use for the copy process.
	 * @param listeners Listeners, that get informed of progress and success or fail
	 * @return true if copy was successful, false otherwise
	 */
	public static boolean copyFile( File src, File dst, int retries, int retryWaitSeconds, int bufferSize, ProgressListener[] listeners ) {

		BufferedInputStream in = null;
		BufferedOutputStream out = null;

		long filesize = src.length();
		long bytes_copied = 0;

		boolean copyComplete = false;

		// so lange wiederholen bis retries erreicht oder copycomplete ist.
		for ( int i = 0; i < retries && !copyComplete; i++ ) {

			if ( i > 0 ) { // Ab dem zweiten Versuch erst mal die retry-Zeit abwarten...
				try {
					System.err.println( "Some Error occurred. Waiting " + retryWaitSeconds + " until retry." );
					Thread.sleep( retryWaitSeconds * 1000 );
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// Kopieren
			try {
				in = new BufferedInputStream( new FileInputStream( src ) );
				out = new BufferedOutputStream( new FileOutputStream( dst ) );

				byte buf[] = new byte[bufferSize];
				int len;

				while (( len = in.read( buf ) ) != -1) {
					out.write( buf, 0, len );

					bytes_copied += len;

					float progress = (float)bytes_copied / (float)filesize;
					informListenersProgress( listeners, progress );
				}

				in.close();
				in = null;

				out.flush();
				out.close();
				out = null;

				copyComplete = true;

			} catch (FileNotFoundException e) {
				e.printStackTrace();
				if ( i == retries - 1 ) {
					informListenersFailed( listeners, "File not Found" );
					return false;
				}
			} catch (IOException e) {
				e.printStackTrace();

				if ( i == retries - 1 ) {
					informListenersFailed( listeners, "IOException" );
					return false;
				}
			} finally {
				if ( out != null ) {
					try {
						out.flush();
						out.close();
						out = null;
					} catch (IOException e) {
						e.printStackTrace();

						if ( i == retries - 1 ) {
							informListenersFailed( listeners, "IOException during closing outputstream" );
							return false;
						}
					}

				}
				if ( in != null ) {
					try {
						in.close();
						in = null;
					} catch (IOException e) {
						e.printStackTrace();
						if ( i == retries - 1 ) {
							informListenersFailed( listeners, "IOException during closing InputStream" );
							return false;
						}
					}
				}
			}
		} // end for

		informListenersSuccess( listeners );
		return true;
	}

	/**
	 * Informiert die Listener über den Fortschritt einer Aktion
	 * 
	 * @param listeners Array mit den Listenern, die informiert werden sollen.
	 * @param progress Fortschritt. Wertebereich: 0...1
	 */
	private static void informListenersProgress( ProgressListener[] listeners, float progress ) {
		if ( listeners != null ) {
			for ( int i = 0; i < listeners.length; i++ ) {
				listeners[i].progressUpdated( progress );
			}
		}
	}

	/**
	 * Informiert die Listener über eine erfolgreiche Beendigung einer Aktion.
	 * 
	 * @param listeners
	 */
	private static void informListenersSuccess( ProgressListener[] listeners ) {
		if ( listeners != null ) {
			for ( int i = 0; i < listeners.length; i++ ) {
				listeners[i].completedSuccessful();
			}
		}
	}

	/**
	 * Informiert die Listener über die fehlerhafte Beendigung einer Aktion.
	 * 
	 * @param listeners
	 * @param msg Textuelle Fehlerbeschreibung
	 */
	private static void informListenersFailed( ProgressListener[] listeners, String msg ) {
		if ( listeners != null ) {
			for ( int i = 0; i < listeners.length; i++ ) {
				listeners[i].failed( msg );
			}
		}
	}

	/**
	 * Gibt die md5 Prüfsumme der übergebenen Datei zurück
	 * 
	 * @param f Datei, deren MD5 Prüfsumme errechnet werden soll.
	 * @return MD5 Summe als String, null wenn ein Fehler autrat
	 */
	public static String md5( File f ) {
		return md5( f, null );
	}

	/**
	 * Gibt die MD5 Prüfsumme des übergebenen Strings zurück.
	 * 
	 * @param s String, aus dem die MD5 Prüfsumme berechnet wird
	 * @return MD5 Summe als String, null wenn ein Fehler autrat
	 */
	public static String md5( String s ) {
		MessageDigest md5;

		try {
			md5 = MessageDigest.getInstance( "MD5" );
			md5.reset();

			md5.update( s.getBytes() );

			byte[] result = md5.digest();

			return DPHelpers.hexStringFromBytes( result );

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String md5( InputStream inputStream ) throws NoSuchAlgorithmException, IOException {
		return md5( inputStream, 4096 );
	}

	public static String md5( InputStream inputStream, int bufferSize ) throws NoSuchAlgorithmException, IOException {
		MessageDigest md5 = MessageDigest.getInstance( "MD5" );
		BufferedInputStream in = new BufferedInputStream( inputStream );

		byte[] buf = new byte[bufferSize];
		int len;

		try {
			while (( len = in.read( buf ) ) != -1) {
				md5.update( buf, 0, len );
			}

			byte[] result = md5.digest();
			return DPHelpers.hexStringFromBytes( result );

		} catch (IOException e) {
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
			try {
				inputStream.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * Gibt die MD5 Prüfsumme der übergebenen Datei als String zurück.
	 * 
	 * 
	 * TODO: UNTESTED
	 * 
	 * @param f Datei, über deren Inhalt die MD5 Prüfsumme errechnet werden soll.
	 * @param listeners Listener, die über den Verlauf benachrichtig werden
	 * @return MD5 Prüfsumme als String, null wenn ein Fehler auftrat
	 */
	public static String md5( File f, ProgressListener[] listeners ) {

		long filesize = f.length();
		long bytes_processed = 0;

		BufferedInputStream in = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance( "MD5" );
			md5.reset();

			in = new BufferedInputStream( new FileInputStream( f ) );

			byte[] buf = new byte[4096];
			int len;
			while (( len = in.read( buf ) ) != -1) {
				md5.update( buf, 0, len );
				bytes_processed += len;

				float progress = bytes_processed / filesize;
				informListenersProgress( listeners, progress );
			}
			in.close();
			in = null;

			byte[] result = md5.digest();

			informListenersSuccess( listeners );
			return DPHelpers.hexStringFromBytes( result );

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			informListenersFailed( listeners, "No MD5 implementation on this System" );
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			informListenersFailed( listeners, "File not found" );
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			informListenersFailed( listeners, "IOException while reading file" );
			return null;
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

	/**
	 * Liest alle Dateien im angegebenen Verzeichnis aus und gibt diese als String-Array mit
	 * absoluten Pfaden zurück.
	 * 
	 * 
	 * @param dir
	 * @return
	 */
	public static String[] listFilesRecursive( String dir ) {
		return listFilesRecursive( dir, null );
	}

	/**
	 * Liest alle Dateien im angegebenen Verzeichnis aus und gibt diese als String-Array mit
	 * absoluten Pfaden zurück.
	 * 
	 * 
	 * @param dir
	 * @param filter Filer, um nur bestimmte Files zu übernehmen. Wenn null, dann werden alle Files
	 *            übernommen
	 * @return
	 */
	public static String[] listFilesRecursive( String dir, FilenameFilter filter ) {

		class ListSpider extends DirSpider {

			private Vector<String> m_files;

			private FilenameFilter m_filenameFilter = null;

			public ListSpider( File rootDirectory, FilenameFilter filter ) {
				super( rootDirectory );
				m_files = new Vector<String>();
				m_filenameFilter = filter;
			}

			@Override
			public void enterDir( File dir ) {}

			@Override
			public void handleDir( File dir ) {}

			@Override
			public void handleFile( File file ) {
				if ( m_filenameFilter == null ) {
					m_files.add( file.getAbsolutePath() );
				} else if ( m_filenameFilter.accept( file.getParentFile(), file.getName() ) ) {
					m_files.add( file.getAbsolutePath() );
				}
			}

			@Override
			public void leaveDir( File dir ) {}

			@Override
			public void postRun() {}

			@Override
			public void preRun() {
				m_files = new Vector<String>();
			}

			public String[] getFiles() {
				String files[] = new String[0];

				if ( m_files.size() > 0 ) {
					files = m_files.toArray( new String[0] );
				}

				return files;
			}
		}

		ListSpider s = new ListSpider( new File( dir ), filter );
		s.go();
		return s.getFiles();

	}

	/**
	 * Listener-Interface, das bei Methoden aus der Klasse Files z.B. den Fortschritt oder die
	 * Beendigung einer Aktion gesagt bekommt.
	 * 
	 * @author peez
	 * 
	 */
	public interface ProgressListener {

		public void progressUpdated( float progress );

		public void completedSuccessful();

		public void failed( String errmsg );
	}

	/**
	 * Hängt der übergebenen Datei einen Text an.
	 * 
	 * @param file Datei, wo der Text angehängt wird
	 * @param string Text der angehängt wird
	 * @throws IOException
	 */
	public static void append( File file, String string ) throws IOException {
		append( file, string.getBytes() );
	}

	/**
	 * Hängt der übergebenen Datei ein Byte-Array an.
	 * 
	 * @param file Datei, wo das Byte-Array angehängt wird
	 * @param b Byte-Array, das an die Datei angehängt wird.
	 * @throws IOException
	 */
	public static void append( File file, byte[] b ) throws IOException {
		FileOutputStream out = null;

		try {
			out = new FileOutputStream( file, true );
			out.write( b );
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if ( out != null ) {
				try {
					out.close();
				} catch (IOException e) {
					throw e;
				}
			}
		}
	}

	/**
	 * Methode, um einfach Dateien zu backuppen.<br>
	 * Dabei wird dem Dateinamen automatisch ein Timestamp angehängt und falls eine Datei mit selbem
	 * Namen bereits existiert, zusätzlich ein Zähler.
	 * 
	 * @param file
	 * @param backupDirectory
	 * @throws IOException
	 */
	public static void backupFile( File file, File backupDirectory ) throws IOException {
		if ( !file.exists() ) {
			throw new IOException( "File " + file.getAbsolutePath() + " does not exist!" );
		}
		if ( !file.isFile() ) {
			throw new IOException( "File " + file.getAbsolutePath() + " is not a File!" );
		}

		if ( !backupDirectory.exists() ) {
			throw new IOException( "Directory " + backupDirectory.getAbsolutePath() + " does not exist!" );
		}
		if ( !backupDirectory.isDirectory() ) {
			throw new IOException( "Directory " + backupDirectory.getAbsolutePath() + " is not a directory!" );
		}

		String filenamePreOriginal = file.getName();
		String extension = "";

		SimpleDateFormat df = new SimpleDateFormat( "yyyyMMdd-HHmmss" );
		String timestamp = df.format( new Date( System.currentTimeMillis() ) );

		if ( filenamePreOriginal.contains( "." ) ) {
			filenamePreOriginal = filenamePreOriginal.substring( 0, filenamePreOriginal.lastIndexOf( "." ) );
			extension = file.getName().substring( file.getName().lastIndexOf( "." ) );
		}

		int counter = 0;
		File targetFile = null;
		while (targetFile == null) {
			targetFile = new File( backupDirectory.getAbsolutePath() + File.separator + filenamePreOriginal + "_" + timestamp + "_" + counter + extension );
			if ( targetFile.exists() ) {
				targetFile = null;
				counter++;
			}
		}

		// Jetzt kopieren
		copyFile( file, targetFile, null );
	}

	/**
	 * Prüft, ob es die übergebene Datei bereits gibt und falls ja, wird dieser ein Zähler
	 * hinzugefügt so lange, bis es keine Datei mehr mit dem Namen gibt. Diese wird dann
	 * zurückgegeben.<br>
	 * Außerdem wird gleichzeitig eine neue, leere Datei mit diesem Namen angelegt, um den Namen zu
	 * reservieren. Aufrufende Klassen müssen daran denken, bei Nicht-Überschreibenden Methoden die
	 * Datei dann kurz vor der Schreiboperation zu löschen.
	 * 
	 * @param f
	 * @return
	 * @throws IOException
	 */
	public static File assertFreeFile( File file ) throws IOException {
		if ( !file.exists() ) {
			file.createNewFile();
			return file;
		}

		String filenamePreOriginal = file.getName();
		String extension = "";

		if ( filenamePreOriginal.contains( "." ) ) {
			filenamePreOriginal = filenamePreOriginal.substring( 0, filenamePreOriginal.lastIndexOf( "." ) );
			extension = file.getName().substring( file.getName().lastIndexOf( "." ) );
		}

		int counter = 0;
		File targetFile = null;
		while (targetFile == null) {
			// TODO: appendToFilename benutzen!
			targetFile = new File( file.getParent() + File.separator + filenamePreOriginal + "_" + counter + extension );
			if ( targetFile.exists() ) {
				targetFile = null;
				counter++;
			}
		}

		targetFile.createNewFile();

		return targetFile;
	}

	/**
	 * Hängt an den Dateinamen den übergebenen String an - VOR der Extension.
	 * 
	 * @param filename
	 * @param append
	 * @return
	 */
	public static String appendToFilename( String filename, String append ) {
		String filenamePreOriginal = "" + filename;
		String extension = "";

		if ( filenamePreOriginal.contains( "." ) ) {
			filenamePreOriginal = filenamePreOriginal.substring( 0, filenamePreOriginal.lastIndexOf( "." ) );
			extension = filename.substring( filename.lastIndexOf( "." ) );
		}

		return filenamePreOriginal + append + extension;
	}

	/**
	 * Führt eine Bereinigung des angegebenen Verzeichnisses durch. Dabei werden alle Files
	 * gelöscht, die nach dem LastModified Datum älter sind als das angegebene Datei-Alter.<br>
	 * filenameFilter kann null sein. Wenn nicht, werden nur die Dateien ins Housekeeping mit
	 * einbezogen, die durch die Kriterien des Filters gefunden werden.
	 * 
	 * @param directory Verzeichnis, das bereinigt werden soll
	 * @param fileAge Alter der Dateien, ab dem sie gelöscht werden (in Millisekunden)
	 * @param backupDir Wenn != null, werden Dateien nicht direkt gelöscht, sondern in dieses
	 *            Verzeichnis verschoben.
	 * @param filenameFilter Wenn != null, dann werden nur Dateien einbezogen, die dem
	 *            FilenameFilter entsprechen
	 * @param recursive wenn true, werden auch alle Unterverzeichnisse bearbeitet
	 * @throws IOException
	 */
	public static void doHousekeeping( File directory, long fileAge, File backupDir, FilenameFilter filenameFilter, boolean recursive ) throws IOException {
		if ( !directory.isDirectory() ) {
			throw new IOException( directory.getAbsolutePath() + " is not a directory!" );
		}
		if ( backupDir != null && !backupDir.isDirectory() ) {
			throw new IOException( "Backup Dir " + backupDir.getAbsolutePath() + " is not a directory!" );
		}

		log.info( "Housekeeping " + directory.getAbsolutePath() + " maxAge: " + fileAge + "ms" );

		File[] files = null;
		if ( filenameFilter == null ) {
			files = directory.listFiles();
		} else {
			files = directory.listFiles( filenameFilter );
		}

		// Alles was älter als dieser Timestamp ist, wird gelöscht
		long thresholdTimestamp = System.currentTimeMillis() - fileAge;

		for ( File f : files ) {
			if ( recursive && f.isDirectory() ) {
				doHousekeeping( f, fileAge, backupDir, filenameFilter, recursive );
			} else if ( f.isFile() && f.lastModified() < thresholdTimestamp ) {
				// Löschen
				log.info( "Removing file " + f.getAbsolutePath() );
				if ( backupDir != null ) {
					// Backup machen
					backupFile( f, backupDir );
				}
				if ( !f.delete() ) {
					throw new IOException( "Could not delete " + f.getAbsolutePath() );
				}
			}
		}
	}

	/**
	 * Gibt den Basename des übergebenen Dateinamens (also Dateinamen ohne Extension) zurück
	 */
	public static String getBasename( String completeFilename ) {
		// Falls ein Pfadname dabei ist, diesen rausfiltern
		if ( completeFilename.contains( "\\" ) ) {
			completeFilename = completeFilename.replace( "\\", "/" );
		}
		while (completeFilename.contains( "//" )) {
			completeFilename = completeFilename.replace( "//", "/" );
		}

		if ( completeFilename.contains( "/" ) ) {
			completeFilename = completeFilename.substring( completeFilename.lastIndexOf( "/" ) + 1 );
		}

		// Jetzt kann ich sicher sein, dass ich nur den Dateinamen habe
		if ( !completeFilename.contains( "." ) ) {
			// Keine Extension, also kompletten Dateinamen zurückgeben
			return completeFilename;
		} else {
			return completeFilename.substring( 0, completeFilename.lastIndexOf( "." ) );
		}
	}

	/**
	 * Gibt die Dateiextension einer Datei zurpck
	 * 
	 * @param completeFilename
	 * @return Dateiextension ohne Punkt, null falls der übergebene Dateinamen keine Extension hat
	 */
	public static String getExtension( String completeFilename ) {
		// Falls ein Pfadname dabei ist, diesen rausfiltern
		if ( completeFilename.contains( "\\" ) ) {
			completeFilename = completeFilename.replace( "\\", "/" );
		}
		while (completeFilename.contains( "//" )) {
			completeFilename = completeFilename.replace( "//", "/" );
		}

		if ( completeFilename.contains( "/" ) ) {
			completeFilename = completeFilename.substring( completeFilename.lastIndexOf( "/" ) + 1 );
		}

		// Jetzt kann ich sicher sein, dass ich nur den Dateinamen habe
		if ( !completeFilename.contains( "." ) ) {
			// Keine Extension, also kompletten Dateinamen zurückgeben
			return null;
		} else {
			return completeFilename.substring( completeFilename.lastIndexOf( "." ) + 1 );
		}
	}
}
