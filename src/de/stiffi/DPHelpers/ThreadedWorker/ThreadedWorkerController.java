package de.stiffi.DPHelpers.ThreadedWorker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadedWorkerController<T extends Thread> {

	/**
	 * Wenn auf true gesetzt, wird der Controller beendet
	 */
	private boolean stopRequest = false;

	private boolean running = false;

	private int maxThreads = 1;

	private List<T> queuedWorkers;

	private List<T> runningWorkers;

	private Thread mainThread = null;

	/**
	 * Zeit die der Controller schläft bis zum nächsten Durchlauf
	 */
	private long sleepTime = 1000;
	
	private Object synchronizer = new Object();

	public ThreadedWorkerController() {
		__init();
	}

	public ThreadedWorkerController( int maxThreads ) {
		__init();
		this.maxThreads = maxThreads;
	}

	/**
	 * Initialisiert den Controller und setzt die Anzahl an parallelen Threads auf die Anzahl der
	 * Cores im Rechner
	 */
	private void __init() {
		maxThreads = Runtime.getRuntime().availableProcessors();
		queuedWorkers =  new LinkedList<T>();
		runningWorkers = new LinkedList<T>();
	}

	public void add( T worker ) {
		queuedWorkers.add( worker );
	}

	public void remove( T worker ) {
		queuedWorkers.remove( worker );
	}

	public void start() {
		synchronized (synchronizer) {
			if ( running ) {
				return;
			}

			mainThread = new Thread( new Runnable() {

				@Override
				public void run() {
					running = true;
					while (!stopRequest) {
						invokeQueue();
						try {
							Thread.sleep( sleepTime );
						} catch (InterruptedException e) {
						}
					}
					running = false;				
				}
			} );
			mainThread.start();
		}		
	}

	/**
	 * Wird regelmäßig von {@link #start()} aufgerufen u. startet neue Threads wenn ein Slot frei
	 * ist
	 */
	private void invokeQueue() {
		synchronized (synchronizer) {
			// queuedWorkers aufräumen, wenn einer fertig ist.
			for ( int i=0; i<runningWorkers.size(); i++ ) {				
				if ( !runningWorkers.get( i ).isAlive() ) {
					runningWorkers.remove( runningWorkers.get( i ));
					i--;
				}
			}

			if ( stopRequest ) {
				return;
			}

			// Wenn wieder ein Slot frei ist, den nächsten Thread einstellen

			if ( runningWorkers.size() < maxThreads && queuedWorkers.size() > 0 ) {
				T worker = queuedWorkers.get( 0 );
				queuedWorkers.remove( 0 );				
				runningWorkers.add( worker );
				worker.start();
			}
		}
	}

	/**
	 * Hält den Controller an - wenn er im Threaded Mode läuft.
	 */
	public void stop() {
		synchronized (synchronizer) {
			stopRequest = true;
			mainThread.interrupt();
			for ( T worker : runningWorkers ) {
				worker.interrupt();
			}
		}
	}

	public int getMaxThreads() {
		return maxThreads;
	}

	public void setMaxThreads( int maxThreads ) {
		this.maxThreads = maxThreads;
	}

	/**
	 * Gibt zurück, ob der Controller gerade läuft
	 * 
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}
	
	public final List<T> getQueuedWorkers() {
		return queuedWorkers;
	}
	
	public final List<T> getRunningWorkers() {
		return runningWorkers;
	}

}
