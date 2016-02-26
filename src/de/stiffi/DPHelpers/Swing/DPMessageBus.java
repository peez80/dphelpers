package de.stiffi.DPHelpers.Swing;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Der MessageBus ist ein einfacher Weg, um Nachrichten beliebiger Art zwischen voneinander unabhängigen Objekten auszutauschen.
 * 
 * 
 * @author peez
 * 
 */
public class DPMessageBus {

	/**
	 * Singleton
	 */
	private static DPMessageBus onlyInstance = null;

	/**
	 * Alle Listeners, sortiert nach Channelname
	 */
	private Hashtable<String, Vector<DPMessageBusListener>> listeners;

	/**
	 * SLF4J Logger
	 */
	private Logger log;

	/**
	 * Konstruktor
	 */
	private DPMessageBus() {
		listeners = new Hashtable<String, Vector<DPMessageBusListener>>();
		log = LoggerFactory.getLogger( getClass() );
	}

	/**
	 * Gibt die Singleton-Instance des MessageBus zurück
	 * 
	 * @return
	 */
	public static DPMessageBus getInstance() {
		if ( onlyInstance == null ) {
			onlyInstance = new DPMessageBus();
		}
		return onlyInstance;
	}

	/**
	 * Registriert den übergebenen Listener für den angegebenen messageBusName
	 * 
	 * @param messageBusName
	 * @param listener
	 */
	public void register( String messageBusName, DPMessageBusListener listener ) {
		log.info( "DPMessageBus.register( " + messageBusName + ", " + listener.toString() + " )" );

		Vector<DPMessageBusListener> v = listeners.get( messageBusName );
		if ( v == null ) {
			v = new Vector<DPMessageBusListener>();
			listeners.put( messageBusName, v );
		}

		if ( !v.contains( listener ) ) {
			v.add( listener );
		}
	}

	/**
	 * Entfernt den übergebenen Listener aus allen Channels
	 * 
	 * @param listener
	 */
	public void removeListener( DPMessageBusListener listener ) {
		log.info( "DPMessageBus.removeListener( " + listener.toString() + " )" );

		Enumeration<String> keys = listeners.keys();

		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			removeListener( key, listener );
		}
	}

	/**
	 * Entfernt den übergebenen Listener aus dem übergebenen Channel
	 * 
	 * @param messageBusName
	 * @param listener
	 */
	public void removeListener( String messageBusName, DPMessageBusListener listener ) {

		log.info( "DPMessageBus.removeListener( " + messageBusName + ", " + listener.toString() + " )" );

		Vector<DPMessageBusListener> v = listeners.get( messageBusName );
		v.remove( listener );
	}

	/**
	 * Sendet eine Message in einen Channel
	 * 
	 * @param messageBusName Channel, in den die Nachricht gesendet wird
	 * @param message Message-Objekt, das durchgesendet wird.
	 */
	public void send( String messageBusName, DPMessageBusMessage message ) {

		log.debug( "DPMessageBus.send( " + messageBusName + ", " + message.toString() + " )" );

		Vector<DPMessageBusListener> v = listeners.get( messageBusName );
		if ( v == null ) {
			return;
		}

		for ( DPMessageBusListener l : v ) {
			try {
				l.messageReceived( messageBusName, message );
			} catch (DPMessageVetoException e) {
				// Ignore Veto
			}
		}
	}

	/**
	 * Sendet eine NULL-Message in den übergebenen Channel.
	 * <p>
	 * Die Listener bekommen dann eine Nachricht mit null als Data
	 * 
	 * @param messageBusName
	 */
	public void send( String messageBusName ) {
		log.debug( "DPMessageBus.send( " + messageBusName + " ) - sending Null-Message to Channel" );
		send( messageBusName, new DPMessageBusMessage( null ) );
	}

	public void sendBroadCastMessage( String messageBusName ) {
		log.debug( "DPMessageBus.send( " + messageBusName + ") - sending Null-Broadcast Message" );
		sendBroadcastMessage( messageBusName, new DPMessageBusMessage() );
	}

	public void sendBroadcastMessage( String messageBusName, DPMessageBusMessage message ) {
		Enumeration<String> channels = listeners.keys();
		while (channels.hasMoreElements()) {
			String ch = channels.nextElement();
			send( ch, message );
		}
	}

	public void sendVetoableMessage( String messageBusName, DPMessageBusMessage message ) throws DPMessageVetoException {
		Vector<DPMessageBusListener> v = listeners.get( messageBusName );
		if ( v == null ) {
			return;
		}

		for ( DPMessageBusListener l : v ) {
			l.messageReceived( messageBusName, message );
		}
	}

}
