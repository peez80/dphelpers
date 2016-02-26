package de.stiffi.DPHelpers.Files;

import java.io.IOException;
import java.io.InputStream;

public abstract class GrowingFileReader {

	/**
	 * Lesepuffer
	 */
	private int readBuffer = 10485760; // Initial 10MB Buffer

	/**
	 * Puffer an bytes, der immer mind. im Stream übrig gelassen wird, um nicht ans Ende des Streams
	 * zu gelangen
	 * und damit die Datenübertragung zu stoppen (z.B. problematisch bei FTP-Transfers)
	 */
	private int bufferBuffer = 100;

	/**
	 * Sagt aus, ob die Klasse gerade am Lesen einer Datei ist
	 */
	private boolean reading = false;

	/**
	 * Zeit, die eine Datei sich nicht mehr ändern darf, um als komplett
	 * angesehen zu werden
	 */
	private long fileCompleteTime = 10000l;

	/**
	 * Zeit in ms, die gewartet wird bevor der nächste Leseversuch gestartet
	 * wird, falls ein Lesevorgang keine Daten zurückgibt
	 */
	private long noDataWaitDuration = 1000l;

	/**
	 * Aus diesem Stream wird gelesen
	 */
	private InputStream inputStream = null;

	/**
	 * Gesamtanzahl an Bytes die gelesen wurden
	 */
	private long bytesRead = 0;

	private String name = "";

	private long readStopTimestamp = 0;

	public GrowingFileReader( InputStream inputStream ) {
		this.inputStream = inputStream;
	}

	/**
	 * Wird aufgerufen, wenn die Datei als beendet angesehen wird, d.h. wenn sie
	 * in {@link #fileCompleteTime} Millisekunden nicht mehr gewachsen ist
	 * 
	 * @param file
	 */
	public abstract void onFinish();

	/**
	 * Wird nach jedem Lese-Durchgang aufgerufen, um den Fortschritt zu
	 * dokumentieren und die Daten zu übergeben, mit denen die implementierende
	 * Klasse dann irgendwas machen kann
	 * 
	 * @param file
	 * @param bytesRead
	 */
	public abstract void onRead( byte b[], int off, int len );

	/**
	 * Wenn in der Datei nicht mehr gelesen werden kann, wird eine bestimmte
	 * Zeit gewartet und ein erneuter Lesevorgang probiert. Der Start dieser
	 * Wartezeit wird durch den Aufruf dieser Methode markiert.
	 * 
	 * @param file
	 * @param bytesRead
	 * @param waitTime
	 */
	public abstract void onWaitForData( long bytesRead, long waitTime );

	/**
	 * Zur Unterstützung des Lesevorgangs kann die implementierende Klasse diese Methode
	 * unterstützen und die aktuelle Dateigröße zurückgeben.<br>
	 * Die Methode kann auch nicht implementiert werden und null zurückgeben. Dann orientiert der
	 * Reader sich ausschließlich an den Rückgabewerten des InputStreams.
	 */
	public abstract Long getCurrentSize();

	/**
	 * Wird als allererstes VOR dem Start aufgerufen, damit z.B. die
	 * implementierende Klasse bestimmte Resourcen vorbereiten kann, die in den
	 * anderen Callbacks verwendet werden.
	 */
	public abstract void onStart();

	public long getFileCompleteTime() {
		return fileCompleteTime;
	}

	/**
	 * Startet den Datei Auslesevorgang. Diese Methode ist synchron! Soll
	 * nebenläufig gelesen werden, muss der Aufrufer einen eigenen Thread
	 * aufmachen.
	 */
	public void startReading() {
		reading = true;
		bytesRead = 0;
		readStopTimestamp = 0;
		long currentSize = -1;
		onStart();

		byte buf[] = new byte[getReadBuffer()];
		int len = 0;

		// Im aktuellen Durchlauf lesen?
		boolean readThisTime = true;
		boolean stopRequest = false;

		try {

			while (!stopRequest) {

				System.out.println( "\r\n--------------------------------" );

				readThisTime = true; // Zurücksetzen
				

				Long currentFilesize = getCurrentSize();
				if ( currentFilesize != null ) {
					// Wenn ich mich an der Dateigröße orientieren kann dann so machen
					long availableBytes = currentFilesize.longValue() - bytesRead;
					if ( availableBytes < bufferBuffer ) {
						System.out.println( "Waiting - filesize too small." );
						waitForData( false );
						readThisTime = false;
					}
				}

				if ( readThisTime && inputStream.available() <= bufferBuffer ) {
					// Diese Prüfung darf nur gemacht werden, wenn obige nicht gezogen hat oder
					// positiv war
					// Nicht genug bytes verfügbar - warten
					System.out.println( "Waiting... available():" + inputStream.available() );
					waitForData();
					readThisTime = false; // Nur Lesen aussetzen, wenn nicht letzte Runde
				}

				if ( readThisTime ) {
					int readLen = inputStream.available() - bufferBuffer;
					System.out.println( "ReadthisTime!" );
					System.out.println( "available(): " + ( readLen + bufferBuffer ) );
					System.out.println( "readLen    : " + readLen );
					len = inputStream.read( buf, 0, readLen );
					bytesRead += len;
					readStopTimestamp = 0;
					onRead( buf, 0, len );
					System.out.println( "-\r\nread: " + len );

					if ( len == -1 ) {
						waitForData();
					}

					// TODO: hier evt. mark() etc. benutzen
				}

				if ( readStopTimestamp != 0 && System.currentTimeMillis() > readStopTimestamp + fileCompleteTime ) {
					// Kam einige Zeit nichts mehr an Daten, also aussteigen!
					stopRequest = true;
				}

				System.out.println( "---------------------------------\r\n" );
			}

			// Daten "fertig", jetzt noch den Rest aus dem Strom lesen
			while (( len = inputStream.read( buf ) ) != -1) {
				System.out.println( "Rest Lesen: " + len );
				onRead( buf, 0, len );
			}

			Long filesize = getCurrentSize();
			if ( filesize != null ) {
				if ( filesize != currentSize ) {
					System.out.println( "File changing!" );
					currentSize = filesize.longValue();
					if ( readStopTimestamp != 0 ) {
						readStopTimestamp = 0;
					}
				}
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		reading = false;

		onFinish();
	}

	/**
	 * Aktualisiert bei bedarf {@link #readStopTimestamp} und wartet die eingestellte Zeit
	 */
	private void waitForData() {
		waitForData( true );
	}

	/**
	 * Wartet die eingestellte Zeit
	 * 
	 * @param setTimestamp wenn true, wird der Timestamp (bei bedarf) gesetzt, wenn false wird er
	 *            nicht angefasst
	 */
	private void waitForData( boolean setTimestamp ) {
		try {
			if ( setTimestamp && readStopTimestamp == 0 ) {
				readStopTimestamp = System.currentTimeMillis();
			}
			onWaitForData( bytesRead, noDataWaitDuration );
			Thread.sleep( noDataWaitDuration );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setFileCompleteTime( long fileCompleteTime ) {

		this.fileCompleteTime = fileCompleteTime;
	}

	public int getReadBuffer() {

		return readBuffer;
	}

	public void setReadBuffer( int readBuffer ) {
		// Mindestens so groß wie der Buffer-Puffer
		this.readBuffer = readBuffer >= bufferBuffer ? readBuffer : bufferBuffer;
	}

	public boolean isReading() {
		return reading;
	}

	protected InputStream getInputStream() {
		return inputStream;
	}

	public long getNoDataWaitDuration() {
		return noDataWaitDuration;
	}

	public void setNoDataWaitDuration( long noDataWaitDuration ) {
		this.noDataWaitDuration = noDataWaitDuration;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}
}
