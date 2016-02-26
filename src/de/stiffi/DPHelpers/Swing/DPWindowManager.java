package de.stiffi.DPHelpers.Swing;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.MouseInputAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.stiffi.DPHelpers.SoftwareSettings;

public class DPWindowManager {

	/**
	 * Die JDesktopPane, in der die Fenster liegen
	 */
	private JDesktopPane desktopPane;

	private DPDesktopPaneApplication parentApplication;

	/**
	 * Alle Fenster werden mit ihrem Bezeichner hier gespeichert
	 */
	private Hashtable<String, DPInternalFrame> windows;

	/**
	 * Wenn Fensterpositionen etc. gespeichert werden sollen, können hier SoftwareSettings
	 * festgelegt werden, in die gespeichert wird.
	 */
	private SoftwareSettings settings = null;

	/**
	 * SLF4J Logger Dieser wird für den WindowManager verwendet. Für den Logger der Implementierung
	 * ist imlLog da
	 */
	private Logger log = LoggerFactory.getLogger( DPWindowManager.class );

	/**
	 * Dieser Logger wird von der konkreten Implementierung verwendet. Ich weiß zwar nicht mehr
	 * warum aber irgendeinen Sinn hatte es, dass zwischen main und impl Logger unterschieden wird.
	 */
	private Logger implLog;

	/**
	 * Konstruktor
	 * 
	 * @param desktopPane Muss die JDesktopPane übergeben kriegen, auf der die Windows platziert
	 *            werden
	 */
	public DPWindowManager( JDesktopPane desktopPane ) {
		this.desktopPane = desktopPane;
		initWindowManager();
	}

	public DPWindowManager( DPDesktopPaneApplication parentApplication ) {
		this.desktopPane = parentApplication.getDesktopPane();
		this.parentApplication = parentApplication;
		initWindowManager();
	}

	/**
	 * Weist dem WindowManager ein SoftwareSettingsobjekt zu, in den Fensterpositionen etc.
	 * gespeichert werden.
	 * 
	 * @param settings
	 */
	public void setSettings( SoftwareSettings settings ) {
		this.settings = settings;
	}

	public SoftwareSettings getSettings() {
		return settings;
	}

	/**
	 * Initialisiert den WindowManager
	 */
	private void initWindowManager() {
		implLog = LoggerFactory.getLogger( getClass() );
		windows = new Hashtable<String, DPInternalFrame>();
	}

	/**
	 * Gibt den Logger für die Implementierung zurück
	 * 
	 * @return
	 */
	public Logger getLog() {
		return implLog;
	}

	/**
	 * Fügt dem WindowManager ein neues Fenster hinzu
	 * 
	 * @param windowIdentifier Eindeutiger Identifier des Fensters
	 * @param window Das Fenster an sich
	 */
	public void addWindow( String windowIdentifier, DPInternalFrame window ) {
		if ( windows.containsKey( windowIdentifier ) ) {
			log.error( "WARN: WindowManager.addWindow(): Window " + windowIdentifier + " already existing." );
		}
		window.setWindowManager( this );
		window.setWindowIdentifier( windowIdentifier );
		windows.put( windowIdentifier, window );

		desktopPane.add( window );

		WindowState initialState = loadState( window );
		initialState.applyToComponent( window );

		addWindowListeners( window );

		log.debug( "Window " + windowIdentifier + " added. Now calling implementations onWindowAdded()" );
		onWindowAdded( windowIdentifier, window );
		updateFensterMenu();
	}

	private void updateFensterMenu() {
		if ( parentApplication != null ) {
			parentApplication.updateFensterMenu();
		}
	}

	private void removeWindowListeners( final DPInternalFrame window ) {
	// TODO: Implementieren! Dazu dürfen keine anonymous inner classes als Listener benutzt werden!
	}

	private void addWindowListeners( final DPInternalFrame window ) {
		window.addInternalFrameListener( new InternalFrameListener() {

			@Override
			public void internalFrameActivated( InternalFrameEvent e ) {}

			@Override
			public void internalFrameClosed( InternalFrameEvent e ) {}

			@Override
			public void internalFrameClosing( InternalFrameEvent e ) {
				saveState( window );
			}

			@Override
			public void internalFrameDeactivated( InternalFrameEvent e ) {}

			@Override
			public void internalFrameDeiconified( InternalFrameEvent e ) {}

			@Override
			public void internalFrameIconified( InternalFrameEvent e ) {}

			@Override
			public void internalFrameOpened( InternalFrameEvent e ) {}
		} );

		window.addComponentListener( new ComponentListener() {

			@Override
			public void componentShown( ComponentEvent e ) {
				saveState( window );
			}

			@Override
			public void componentResized( ComponentEvent e ) {
				saveState( window );
			}

			@Override
			public void componentMoved( ComponentEvent e ) {
				saveState( window );
			}

			@Override
			public void componentHidden( ComponentEvent e ) {
				saveState( window );
			}
		} );
	}

	/**
	 * Speichert den aktuellen State des übergebenen Fensters in den zugewiesenen SoftwareSettings.
	 * 
	 * @param window
	 */
	private void saveState( DPInternalFrame window ) {

		if ( settings != null ) {
			String idString = "DPWindowManager." + window.getWindowIdentifier() + ".bounds";
			WindowState state = new WindowState( window );
			// log.info( "Saving Windowstate (" + window.getWindowIdentifier() + "): " +
			// state.toString() );
			settings.putFile( idString, state );
		}
	}

	/**
	 * Lädt den State zum übergebenen Fenster aus den zugewiesenen SoftwareSettings
	 * 
	 * @param window
	 * @return
	 */
	private WindowState loadState( DPInternalFrame window ) {
		log.info( "Loading Windowstate (" + window.getWindowIdentifier() + ")" );
		Rectangle bounds = new Rectangle( 0, 0, 400, 300 );
		WindowState state = new WindowState( window );
		state.setBounds( bounds );

		if ( settings != null ) {
			String idString = "DPWindowManager." + window.getWindowIdentifier() + ".bounds";
			try {
				WindowState tmp = (WindowState)settings.getObject( idString );
				if ( tmp != null ) {
					state = tmp;
					log.info( state.toString() );
				}
			} catch (Exception e) {
				log.debug( "Could not load Windowstate - using standardvalues " + state.toString() );
			}
		}
		return state;
	}

	/**
	 * Entfernt ein Fenster vom WindowManager und der DesktopPane
	 * 
	 * @param windowIdentifier
	 */
	public void removeWindow( String windowIdentifier ) {
		log.info( "Removing window " + windowIdentifier );
		DPInternalFrame f = windows.get( windowIdentifier );

		if ( f != null ) {
			desktopPane.remove( f );
			f.setWindowManager( null );
			f.setWindowIdentifier( "" );
			removeWindowListeners( f );
		}
		windows.remove( windowIdentifier );
		updateFensterMenu();
	}

	/**
	 * Entfernt ein Fenster vom WindowManager und der DesktopPane
	 * 
	 * @param window
	 */
	public void removeWindow( DPInternalFrame window ) {
		log.info( "Removing window " + window.getWindowIdentifier() );
		Enumeration<String> keys = windows.keys();

		while (keys.hasMoreElements()) {
			String windowIdentifier = keys.nextElement();
			DPInternalFrame f = windows.get( windowIdentifier );

			if ( f == window ) {
				removeWindow( windowIdentifier );
			}
		}
		updateFensterMenu();
	}

	/**
	 * Gibt alle Fenster zurück, die unter der Kontrolle des WindowManagers sind
	 * 
	 * @return
	 */
	public DPInternalFrame[] getWindows() {
		DPInternalFrame f[] = new DPInternalFrame[windows.size()];

		Enumeration<DPInternalFrame> e = windows.elements();
		int i = 0;
		while (e.hasMoreElements()) {
			f[i] = e.nextElement();
			i++;
		}
		return f;
	}

	/**
	 * Zeigt das Fenster mit dem übergebenen Identifier an. Wenn es schon sichtbar ist, bleibt es
	 * sichtbar.
	 * 
	 * @param windowIdentifier
	 */
	public void show( String windowIdentifier ) {
		log.info( "DPWindowManager.show( " + windowIdentifier + " )" );
		DPInternalFrame f = getWindow( windowIdentifier );
		if ( f != null ) {
			f.setVisible( true );
		}
		updateFensterMenu();
	}

	/**
	 * Versteckt das Fenster mit dem übergebenen Identifier.
	 * 
	 * @param windowIdentifier
	 */
	public void hide( String windowIdentifier ) {
		log.info( "DPWindowManager.hide( " + windowIdentifier + " )" );
		final DPInternalFrame f = getWindow( windowIdentifier );
		if ( f != null ) {
			f.setVisible( false );
		}
		updateFensterMenu();
	}

	/**
	 * Gibt das Fenster mit dem übergebenen Identifier zurück.<br />
	 * 
	 * @param windowIdentifier
	 * @return das Fenster, null wenn keines mit dem Identifier existiert.
	 */
	public DPInternalFrame getWindow( String windowIdentifier ) {
		DPInternalFrame f = null;
		if ( windowIdentifier != null ) {
			f = windows.get( windowIdentifier );
		}
		if ( f == null ) {
			log.error( "DPWindowManager.getWindow( " + windowIdentifier + " ) - Window not existing in my Window Registry" );
		}
		return f;
	}

	/**
	 * Setzt das übergebene Fenster ganz in den Vordergrund
	 * 
	 * @param windowIdentifier
	 */
	public void moveToFront( String windowIdentifier ) {
		log.info( "DPWindowManager.moveToFront( " + windowIdentifier + " )" );
		DPInternalFrame f = getWindow( windowIdentifier );
		if ( f != null ) {
			f.moveToFront();
		}
	}

	/**
	 * Verschiebt das übergebene Fenster ganz in den Hintergrund
	 * 
	 * @param windowIdentifier
	 */
	public void moveToBack( String windowIdentifier ) {
		log.info( "DPWindowManager.moveToBack( " + windowIdentifier + " )" );
		DPInternalFrame f = getWindow( windowIdentifier );
		if ( f != null ) {
			f.moveToBack();
		}
	}

	/**
	 * Klasse ist ein Workaround für den Tip von Sun, wie man modale JInternalFrames macht. Leider
	 * wird ein Fenster, das auf diese Weise modal gemacht wurde, unsichtbar sobald man es resized.<br />
	 * Das liegt daran, dass woher auch immer setVisible() auf die GlassPane aufgerufen wird. <br/>
	 * Um das zu unterbinden, wird setVisible() hier überschrieben und nur ausgeführt, wenn davor
	 * noch setWindowVisible(false) aufgerufen wurde. So wird verhindert, dass das Fenster
	 * verschwindet.
	 * 
	 * @author peez
	 * 
	 */
	private class ModalGlassPane extends JComponent {

		private boolean windowStillVisible = true;

		public ModalGlassPane() {
			super();
			setVisible( true );
		}

		@Override
		public void setVisible( boolean aFlag ) {
			if ( aFlag == false && !windowStillVisible ) {
				// Nur invisible setzen, wenn windowStillVisible auch auf false ist
				super.setVisible( aFlag );
			}
		}

		public void setWindowVisible( boolean b ) {
			windowStillVisible = b;
		}
	}

	/**
	 * Zeigt das übergebene Fenster modal an.
	 * 
	 * TODO: Evt. kann man noch das Übergeben von parentFrame unterbinden, z.B. indem von der
	 * glassPane irgendwie der zugehörige Frame rausgesucht wird.
	 * 
	 * @param window
	 * @param parentFrame Der Frame muss leider übergeben werden.
	 */
	public void showModal( final DPInternalFrame window ) {
		log.info( "DPWindowManager.showModal( " + window.getWindowIdentifier() + " )" );

		final JFrame parentFrame = (JFrame)SwingUtilities.getRoot( desktopPane );

		System.out.println( parentFrame.getClass().getName() );

		ModalGlassPane glass = new ModalGlassPane();

		glass.setOpaque( false );
		glass.add( window );

		// DPSwingHelpers.watchComponentDetails( window, "Window" );

		class ModalComponentListener implements ComponentListener {

			ModalGlassPane glass;

			public ModalComponentListener( ModalGlassPane glass ) {
				this.glass = glass;

				// Associate dummy mouse listeners
				// Otherwise mouse events pass through
				MouseInputAdapter adapter = new MouseInputAdapter() {};
				glass.addMouseListener( adapter );
				glass.addMouseMotionListener( adapter );
			}

			@Override
			public void componentHidden( ComponentEvent e ) {
				System.out.println( "internalFrameClosed" );
				glass.setWindowVisible( false );
				glass.setVisible( false );
				window.removeComponentListener( this );
				// window.removeInternalFrameListener( this );
				glass.setWindowVisible( false );
				glass.setVisible( false );
				glass = null;
			}

			@Override
			public void componentMoved( ComponentEvent e ) {
			// TODO Auto-generated method stub

			}

			@Override
			public void componentResized( ComponentEvent e ) {
			// TODO Auto-generated method stub

			}

			@Override
			public void componentShown( ComponentEvent e ) {
			// TODO Auto-generated method stub

			}

		}

		ModalComponentListener frameListener = new ModalComponentListener( glass );
		window.addComponentListener( frameListener );

		parentFrame.setGlassPane( glass );
		glass.setVisible( true );
		window.setVisible( true );
	}

	/**
	 * Zeigt das Fenster mit dem übergebenen Identifier modal an.
	 * 
	 * @param windowIdentifier
	 * @param parentFrame
	 */
	public void showModal( String windowIdentifier ) {
		final DPInternalFrame f = getWindow( windowIdentifier );
		if ( f == null ) {
			return;
		}

		showModal( f );
	}

	/**
	 * Wird aufgerufen, nachdem ein Fenster hinzugefügt wurde. <br />
	 * Diese Methode ist standardmäßig leer und kann von einer erbenden Klasse überschrieben werden
	 * 
	 * @param windowIdentifier
	 * @param window
	 */
	public void onWindowAdded( String windowIdentifier, DPInternalFrame window ) {

	}

	/**
	 * Zeigt einen Eingabedialog, in dem ein String eingegeben wird.
	 * 
	 * @param title
	 * @param message
	 * @param parentComponent
	 * @return den Wert, der eingegeben wurde oder null, wenn auf abbrechen geklickt wurde.
	 */
	public String showInputDialog( String title, String message, Component parentComponent ) {
		String s = JOptionPane.showInputDialog( parentComponent, message, title, JOptionPane.QUESTION_MESSAGE );
		return s;
	}
}
