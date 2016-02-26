package de.stiffi.DPHelpers.Swing;

import java.awt.Cursor;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Klassen, die diese Klasse erweitern repräsentieren ein Fenster in einer DPDesktopPaneApplication
 * Anwendung
 * 
 * @author peez
 * 
 */
public class DPInternalFrame extends JInternalFrame {

	/**
	 * Referenz auf den {@link DPWindowManager}
	 */
	private DPWindowManager	myWindowManager		= null;

	/**
	 * jedes Fenster hat einen eindeutigen Identifier.
	 */
	private String			myWindowIdentifier	= "";

	/**
	 * SLF4J Logger
	 */
	private Logger			log;

	/**
	 * Konstruktor
	 */
	public DPInternalFrame() {
		super();
		initDPInternalFrame();
	}

	/**
	 * Konstruktor
	 * 
	 * @param title
	 * @param resizable
	 * @param closable
	 * @param maximizable
	 * @param iconifiable
	 */
	public DPInternalFrame( String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable ) {
		super( title, resizable, closable, maximizable, iconifiable );
		initDPInternalFrame();
	}

	/**
	 * 
	 * @param title
	 * @param resizable
	 * @param closable
	 * @param maximizable
	 */
	public DPInternalFrame( String title, boolean resizable, boolean closable, boolean maximizable ) {
		super( title, resizable, closable, maximizable );
		initDPInternalFrame();
	}

	/**
	 * 
	 * @param title
	 * @param resizable
	 * @param closable
	 */
	public DPInternalFrame( String title, boolean resizable, boolean closable ) {
		super( title, resizable, closable );
		initDPInternalFrame();
	}

	/**
	 * 
	 * @param title
	 * @param resizable
	 */
	public DPInternalFrame( String title, boolean resizable ) {
		super( title, resizable );
		initDPInternalFrame();
	}

	/**
	 * 
	 * @param title
	 */
	public DPInternalFrame( String title ) {
		super( title );
		initDPInternalFrame();
	}

	/**
	 * Initialisiert das Fenster. Methode wird vom Konstruktor aufgerufen
	 */
	private void initDPInternalFrame() {
		log = LoggerFactory.getLogger( getClass() );

		setDefaultCloseOperation( DO_NOTHING_ON_CLOSE );

		final DPMessageBusMessage msg = new DPMessageBusMessage();
		msg.setData( this );

		final DPMessageBus bus = DPMessageBus.getInstance();

		final String pre = "(" + getClass().getName() + ") " + getWindowIdentifier() + " ";

		addInternalFrameListener( new InternalFrameListener() {

			@Override
			public void internalFrameOpened( InternalFrameEvent e ) {
				log.info( pre + ": InternalFrameOpened" );
				msg.setCommand( DPMessageBusMessage.MSG_DPINTERNALFRAME_OPENED );

				bus.send( DPMessageBusMessage.CHANNEL_DPINTERNALFRAME, msg );
			}

			@Override
			public void internalFrameIconified( InternalFrameEvent e ) {
				log.info( pre + ": internalFrameIconified" );

				msg.setCommand( DPMessageBusMessage.MSG_DPINTERNALFRAME_ICONIFIED );
				bus.send( DPMessageBusMessage.CHANNEL_DPINTERNALFRAME, msg );

			}

			@Override
			public void internalFrameDeiconified( InternalFrameEvent e ) {
				log.info( pre + ": internalFrameDeiconified" );

				msg.setCommand( DPMessageBusMessage.MSG_DPINTERNALFRAME_DEICONIFIED );
				bus.send( DPMessageBusMessage.CHANNEL_DPINTERNALFRAME, msg );

			}

			@Override
			public void internalFrameDeactivated( InternalFrameEvent e ) {
				// log.info( pre + ": internalFrameDeactivated" );
				msg.setCommand( DPMessageBusMessage.MSG_DPINTERNALFRAME_DEACTIVATED );
				bus.send( DPMessageBusMessage.CHANNEL_DPINTERNALFRAME, msg );

			}

			@Override
			public void internalFrameClosing( InternalFrameEvent e ) {
				log.info( pre + ": internalFrameClosing" );
				msg.setCommand( DPMessageBusMessage.MSG_DPINTERNALFRAME_CLOSING );
				bus.send( DPMessageBusMessage.CHANNEL_DPINTERNALFRAME, msg );
				if ( getWindowManager() != null ) {
					getWindowManager().hide( getWindowIdentifier() );
				}
			}

			@Override
			public void internalFrameClosed( InternalFrameEvent e ) {
				log.info( pre + ": internalFrameClosed" );
				msg.setCommand( DPMessageBusMessage.MSG_DPINTERNALFRAME_CLOSED );
				bus.send( DPMessageBusMessage.CHANNEL_DPINTERNALFRAME, msg );

			}

			@Override
			public void internalFrameActivated( InternalFrameEvent e ) {
				// log.info( pre + ": internalFrameActivated" );
				msg.setCommand( DPMessageBusMessage.MSG_DPINTERNALFRAME_ACTIVATED );
				bus.send( DPMessageBusMessage.CHANNEL_DPINTERNALFRAME, msg );
			}
		} );
	}

	protected void setWindowManager( DPWindowManager windowManager ) {
		this.myWindowManager = windowManager;
	}

	public DPWindowManager getWindowManager() {
		return myWindowManager;
	}

	protected void setWindowIdentifier( String windowIdentifier ) {
		myWindowIdentifier = windowIdentifier;
	}

	public String getWindowIdentifier() {
		return myWindowIdentifier;
	}

	public void close() {
		getWindowManager().hide( getWindowIdentifier() );
	}

	public Logger getLog() {
		return log;
	}

	/**
	 * Kann von der ableitenden Klasse überschrieben werden und wird automatisch aufgerufen direkt
	 * VOR setVisible(true)
	 */
	public void onShow() {}

	/**
	 * Kann von der ableitenden Klasse überschrieben werden und wird automatisch aufgerufen direkt
	 * VOR setVisible(false)
	 */
	public void onHide() {}

	@Override
	public void setVisible( boolean aFlag ) {
		if ( aFlag == true ) {
			onShow();
		} else {
			onHide();
		}
		super.setVisible( aFlag );
	}
	
	public void setWaitCursor() {
		this.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
	}
	
	public void setDefaultCursor() {
		this.setCursor( Cursor.getDefaultCursor() );
	}

}
