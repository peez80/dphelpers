package de.stiffi.DPHelpers.Files;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class ThreadedDirWatcher extends DirWatcher {

	/**
	 * WatcherThread, der die Arbeit macht und im Hintergrund aktiv ist.
	 */
	private WatcherThread watcherThread = null;

	/**
	 * Intervall in Seknden, die Pause gemacht werden zwischen zwei Index-Vorgängen. D.h. egal wie
	 * lange ein Index Vorgang dauert, am Ende wird die eingestellte Zeit gewartet und dann der
	 * Vorgang erneut begeonnen.
	 */
	private int indexInterval;

	/**
	 * Konstruktor. Danach bitte {@link #start()} aufrufen, um den Watcher zu starten.
	 * 
	 * 
	 * @param directory Root-Verzeichnis, das überwacht wird.
	 * @param indexInterval Pause in Sekunden zwischen Index-Vorgängen
	 * @param completeThreshold Zeit, die eine Datei sich nicht mehr ändern darf, bevor sie als
	 *            komplett angesehen wird.
	 * @throws IOException Wenn das angegebene Verzeichnis nicht existiert oder kein Verzeichnis
	 *             ist.
	 */
	public ThreadedDirWatcher( File directory, int indexInterval, int completeThreshold ) throws IOException {
		super( directory, completeThreshold );

		this.indexInterval = indexInterval;

	}

	/**
	 * Konstruktor. Danach bitte {@link #start()} aufrufen, um den Watcher zu starten.
	 * 
	 * @param directory Root-Verzeichnis, das überwacht wird.
	 * @param indexInterval Pause in Sekunden zwischen Index-Vorgängen
	 * @param completeThreshold Zeit, die eine Datei sich nicht mehr ändern darf, bevor sie als
	 *            komplett angesehen wird.
	 * @param fileFilter Es werden nur Dateien überwacht, die diesem Filter entsprechen
	 * @throws IOException Wenn das angegebene Verzeichnis nicht existiert oder kein Verzeichnis
	 *             ist.
	 */
	public ThreadedDirWatcher( File directory, int indexInterval, int completeThreshold, FileFilter fileFilter ) throws IOException {
		super( directory, completeThreshold, fileFilter );

		this.indexInterval = indexInterval;
	}

	/**
	 * Startet den DirWatcher. zwischen dem Konstruktor und dieser Methode können verschiedene
	 * Einstellungen vorgenommen werden wie Listener adden etc.
	 */
	public void start() {
		startWatcher();
	}

	public void stop() {
		stopWatcher();
	}

	/**
	 * Startet den internen Thread
	 */
	private void startWatcher() {
		if ( watcherThread == null || !watcherThread.isAlive() ) {
			watcherThread = new WatcherThread();
			watcherThread.start();
		}
	}

	/**
	 * Stoppt den internen Thread
	 */
	private void stopWatcher() {
		if ( watcherThread != null ) {
			watcherThread.stopThread();
			watcherThread = null;
		}
	}

	public int getIndexInterval() {
		return indexInterval;
	}

	public void setIndexInterval( int indexInterval ) {
		this.indexInterval = indexInterval;
	}

	/**
	 * Dieser Thread macht die eigentliche Arbeit
	 * 
	 * @author peez
	 * 
	 */
	private class WatcherThread extends Thread {

		/**
		 * Wenn der WatchThread aktiv ist, ist diese Variable true ansonsten false
		 */
		private boolean threadRunning = false;

		@Override
		public void run() {
			threadRunning = true;
			while (threadRunning) {

				watch();

				try {
					Thread.sleep( indexInterval * 1000 );
				} catch (InterruptedException e) {
				}
			}
		}

		public void stopThread() {
			threadRunning = false;
			interrupt();
		}

		public boolean isRunning() {
			return threadRunning;
		}
	}
}
