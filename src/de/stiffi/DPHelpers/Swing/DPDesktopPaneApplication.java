package de.stiffi.DPHelpers.Swing;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import de.stiffi.DPHelpers.DPHelpers;
import de.stiffi.DPHelpers.SoftwareSettings;

/**
 * Hauptklasse für Anwendungen, die mehrere Fenster haben.
 * <p>
 * Um ein Fenster zu adden braucht man {@link #getWindowManager()}. Hier wird dann
 * {@link DPWindowManager#addWindow(String, DPInternalFrame)} aufgerufen.
 * 
 * @author peez
 * 
 */
public abstract class DPDesktopPaneApplication extends JFrame {

	private static final long		serialVersionUID	= -8665984157065964244L;

	/**
	 * Die Desktop Pane auf der sich alles abspielt
	 */
	private JDesktopPane			desktopPane;

	/**
	 * Interner Name der Anwendung. Steht z.B. auch im Title
	 */
	private String					applicationName;

	/**
	 * Window-Manager ist für alles zuständig, das mit den Fenstern passieren soll
	 */
	private DPWindowManager			windowManager;

	/**
	 * In diese Settings werden alle Stati etc. geschrieben
	 */
	private SoftwareSettings		settings;

	/**
	 * Die Menubar der Anwendung
	 */
	private JMenuBar				menuBar;

	/**
	 * Das Datei-Menu der Anwendung
	 */
	private JMenu					fileMenu;

	/**
	 * Das Fenster-Menu der Anweudung
	 */
	private JMenu					fensterMenu;

	/**
	 * Innerhalb des Fenster-Menüs gibt es ein "Alle Fenster" menü
	 */
	private JMenu					allWindowsMenu;

	/**
	 * Action, um den Workspaces-Manager aufzurufen
	 */
	private ManageWorkspacesAction	manageWorkspacesAction;

	/**
	 * Exit-Action
	 */
	private ExitAction				exitAction;

	/**
	 * Konstruktor
	 * 
	 * 
	 * @param applicationName
	 */
	public DPDesktopPaneApplication( String applicationName ) {
		initDPDesktopApplication( applicationName, new SoftwareSettings( applicationName + "_win" ) );
	}

	/**
	 * Konstruktor
	 * 
	 * @param applicationName
	 * @param settings
	 */
	public DPDesktopPaneApplication( String applicationName, SoftwareSettings settings ) {
		initDPDesktopApplication( applicationName, settings );
	}

	/**
	 * Wird VOR aller internen Initialisation aufgerufen
	 */
	public abstract void preInit();

	/**
	 * Wird NACH der internen Initialisation aufgerufen, direkt bevor die Fenster durch
	 * {@link #initWindows()} generiert werden wiederhergestellt werden.
	 */
	public abstract void postInit();

	/**
	 * Hier werden alle verfügbaren Fenster definiert
	 */
	protected abstract void initWindows();

	/**
	 * Innerhalb dieser Methode kann die Menübar erweitert werden
	 * 
	 * @param menuBar
	 * @param fileMenu
	 */
	protected abstract void extendMenuBar( JMenuBar menuBar, JMenu fileMenu );
	
	/**
	 * Wird aufgerufen, wenn alle Initialisierungsvorgänge fertig sind.
	 */
	protected abstract void onStart();

	/**
	 * Initialisierungs-Methode, wird vom Konstruktor aufgerufen
	 * 
	 * @param applicationName
	 * @param settings
	 */
	private void initDPDesktopApplication( String applicationName, SoftwareSettings settings ) {
		setName( applicationName );
		setTitle( applicationName );
		setSettings( settings );

		preInit();

		desktopPane = new JDesktopPane();
		setLayout( new BorderLayout() );
		add( desktopPane, BorderLayout.CENTER );
		setWindowManager( new DPWindowManager( this ) );
		getWindowManager().setSettings( getSettings() );

		try {
			WindowState windowState = (WindowState)getSettings().getObject( getApplicationName() + ".windowState" );
			windowState.applyToComponent( this );
		} catch (Exception e) {
			setBounds( new Rectangle( 100, 100, 600, 400 ) );
		}

		addWindowListener( new WindowAdapter() {

			@Override
			public void windowClosed( WindowEvent e ) {
				exit();
			}

		} );

		setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		initMenuBar();
		setVisible( true );
		postInit();
		initWindows();
		updateFensterMenu();
		onStart();
	}

	/**
	 * Initialisiert die Menubar
	 */
	private void initMenuBar() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu( "File" );
		menuBar.add( fileMenu );
		extendMenuBar( menuBar, fileMenu );

		fileMenu.addSeparator();
		exitAction = new ExitAction();
		JMenuItem btExit = new JMenuItem( exitAction );
		fileMenu.add( btExit );

		fensterMenu = new JMenu( "Fenster" );
		menuBar.add( fensterMenu );

		allWindowsMenu = new JMenu( "All Windows" );
		fensterMenu.add( allWindowsMenu );
		fensterMenu.addSeparator();

		manageWorkspacesAction = new ManageWorkspacesAction();

		this.setJMenuBar( menuBar );
	}

	/**
	 * Wenn ein Fenster hinzugefügt wurde oder visible / invisible gesetzt wird, wird immer diese
	 * Methode aufgerufen. Sie ordnet das Fenster Menü neu, sodass die Fenster immer an der
	 * richtigen Position (Alle Fenster oder offene Fenster) erscheinen
	 */
	protected void updateFensterMenu() {
		// Zuerst Menu leeren
		fensterMenu.removeAll();

		allWindowsMenu.removeAll();

		fensterMenu.add( allWindowsMenu );
		fensterMenu.add( new JMenuItem( manageWorkspacesAction ) );
		fensterMenu.addSeparator();

		final DPWindowManager wm = getWindowManager();

		DPInternalFrame windows[] = wm.getWindows();

		for ( final DPInternalFrame window : windows ) {
			JMenuItem item = new JMenuItem( window.getTitle() );
			item.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed( ActionEvent e ) {
					if ( !window.isVisible() ) {
						wm.show( window.getWindowIdentifier() );
					}
					wm.moveToFront( window.getWindowIdentifier() );
					window.requestFocus();
				}
			} );

			if ( window.isVisible() ) {
				fensterMenu.add( item );
			} else {
				allWindowsMenu.add( item );
			}
		}
	}

	/**
	 * Gibt den Applikationsnamen zurück
	 * 
	 * @return
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * Gibt die {@link JDesktopPane} der Anwendung zurück
	 * 
	 * @return
	 */
	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	/**
	 * Gibt den {@link DPWindowManager} der Anwendung zurück
	 * 
	 * @return
	 */
	public DPWindowManager getWindowManager() {
		return windowManager;
	}

	/**
	 * Legt einen {@link DPWindowManager} für diese Anwendung fest
	 * 
	 * @param windowManager
	 */
	public void setWindowManager( DPWindowManager windowManager ) {
		this.windowManager = windowManager;
	}

	/**
	 * Gibt die {@link SoftwareSettings} zurück
	 * 
	 * @return
	 */
	public SoftwareSettings getSettings() {
		return settings;
	}

	public void setSettings( SoftwareSettings settings ) {
		this.settings = settings;
	}

	/**
	 * Beendet die Anwendung
	 */
	public void exit() {

		// Bounds speichern
		WindowState state = new WindowState( this );
		getSettings().put( getApplicationName() + ".windowState", state );
		System.exit( 0 );
	}

	/**
	 * Gibt das File-Menü der Anwendung zurück
	 * 
	 * @return
	 */
	public JMenu getFileMenu() {
		return fileMenu;
	}

	/**
	 * Gibt das Fenster-Menü der Anwendung zurück
	 * 
	 * @return
	 */
	public JMenu getWindowMenu() {
		return fensterMenu;
	}

	/**
	 * Zeigt eine Info-Messagebox an
	 * 
	 * @param message
	 */
	public void showMessageBox( String message ) {
		showMessageBox( message, MessageType.INFO );
	}

	/**
	 * Zeigt eine MessageBox an
	 * 
	 * @param message
	 * @param messageType
	 */
	public void showMessageBox( String message, MessageType messageType ) {
		message = DPHelpers.wordWrap( message, 100 );

		int type = JOptionPane.INFORMATION_MESSAGE;
		String title = "Info";

		switch (messageType) {
		case INFO:
			type = JOptionPane.INFORMATION_MESSAGE;
			title = "Info";
			break;
		case WARNING:
			type = JOptionPane.WARNING_MESSAGE;
			title = "Warnung";
			break;
		case ERROR:
			type = JOptionPane.ERROR_MESSAGE;
			title = "Fehler";
			break;
		}

		JOptionPane.showMessageDialog( this, message, title, type );
	}

	private class ManageWorkspacesAction extends AbstractAction {

		private static final long	serialVersionUID	= -8307841320316542314L;

		public ManageWorkspacesAction() {
			super( "Arbeitsbereiche verwalten..." );
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			DPWorkspaceDialog d = new DPWorkspaceDialog( getWindowManager() );
			d.setVisible( true );
		}
	}

	private class ExitAction extends AbstractAction {

		public ExitAction() {
			super( "Beenden" );
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			exit();
		}
	}

	public enum MessageType {
		INFO, WARNING, ERROR
	}
	
	
	public void setWaitCursor() {
		this.setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
	}
	
	public void setDefaultCursor() {
		this.setCursor( Cursor.getDefaultCursor() );
	}
}
