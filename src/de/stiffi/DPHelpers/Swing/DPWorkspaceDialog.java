package de.stiffi.DPHelpers.Swing;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class DPWorkspaceDialog extends JDialog {

	private DPWindowManager windowManager;

	private JLabel workspacesTitle;

	private JList workspacesList;

	private Vector<WorkspaceDefinition> workspaces;

	private JButton btLoad;

	private JButton btSave;

	private JButton btDelete;

	private JButton btClose;

	public DPWorkspaceDialog( DPWindowManager windowManager ) {
		this.windowManager = windowManager;
		workspaces = new Vector<WorkspaceDefinition>();
		createGUI();
		reloadWorkspaces();
		setModal( true );
		pack();
	}

	public void reloadWorkspaces() {
		workspaces = loadWorkspaces();
		if ( workspaces == null ) {
			workspaces = new Vector<WorkspaceDefinition>();
		}

		String s[] = new String[workspaces.size()];
		for ( int i = 0; i < s.length; i++ ) {
			s[i] = workspaces.get( i ).getTitle();
		}

		workspacesList.setListData( s );

	}

	private void createGUI() {
		setLayout( new BorderLayout() );
		setTitle( "Arbeitsbereiche" );

		workspacesTitle = new JLabel( "Arbeitsbereiche wählen oder speichern: " );
		add( workspacesTitle, BorderLayout.NORTH );

		workspacesList = new JList();
		String a[] = { "", "", "", "", "", "", "", "", "" };
		workspacesList.setListData( a );
		add( workspacesList, BorderLayout.CENTER );

		JPanel pButtons = new JPanel( new GridBagLayout() );
		GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 100, 100, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets( 1, 1, 1, 1 ), 0, 0 );

		btLoad = new JButton( " Laden " );
		btSave = new JButton( " Akt. Zustand speichern " );
		btDelete = new JButton( " Löschen" );
		btClose = new JButton( " Schließen " );

		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {
				btPressed( e );
			}
		};

		btLoad.addActionListener( al );
		btSave.addActionListener( al );
		btDelete.addActionListener( al );
		btClose.addActionListener( al );

		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		pButtons.add( btLoad, gbc );

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		pButtons.add( btSave, gbc );

		gbc.gridx = 2;
		pButtons.add( btDelete, gbc );

		gbc.gridx = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		pButtons.add( btClose, gbc );

		add( pButtons, BorderLayout.SOUTH );

	}

	private void btPressed( ActionEvent e ) {
		if ( e.getSource() == btClose ) {
			setVisible( false );
			this.dispose();
		} else if ( e.getSource() == btSave ) {
			saveCurrentWorkspaceData();
		} else if ( e.getSource() == btDelete ) {
			deleteCurrentWorkspaceData();
		} else if ( e.getSource() == btLoad ) {
			applyWorkspaceData();
		}
	}

	private void applyWorkspaceData() {
		String id = (String)workspacesList.getSelectedValue();

		if ( id == null ) {
			return;
		}

		Enumeration<WorkspaceDefinition> e = workspaces.elements();
		while (e.hasMoreElements()) {
			WorkspaceDefinition wd = e.nextElement();
			if ( wd.getTitle().equals( id ) ) {
				wd.apply( windowManager );
				onWorkspaceApplied();
				break;
			}
		}

	}

	private void deleteCurrentWorkspaceData() {
		String id = (String)workspacesList.getSelectedValue();
		if ( id == null ) {
			return;
		}

		for ( WorkspaceDefinition wd : workspaces ) {
			if ( wd.getTitle().equals( id ) ) {
				workspaces.remove( wd );
				break;
			}
		}

		saveWorkspaces();
		reloadWorkspaces();
	}

	private void saveCurrentWorkspaceData() {

		String name = windowManager.showInputDialog( "Titel", "Bitte Titel für den Arbeitsbereich eingeben", this );
		if ( name == null || name.trim().length() == 0 ) {
			return;
		}

		WorkspaceDefinition w = new WorkspaceDefinition();
		w.readFromWindowManager( windowManager );
		w.setTitle( name );

		workspaces.add( w );
		saveWorkspaces();
		reloadWorkspaces();
	}

	public DPWindowManager getWindowManager() {
		return windowManager;
	}

	protected Vector<WorkspaceDefinition> loadWorkspaces() {
		if ( getWindowManager() == null ) {
			return null;
		}

		Object o = getWindowManager().getSettings().getObject( "WorkspaceManager.Dialog.workspaces" );

		if ( o instanceof Vector<?> ) {
			Vector v = (Vector<?>)o;

			if ( v.size() > 0 ) {
				Object oTest = v.get( 0 );
				if ( oTest instanceof WorkspaceDefinition ) {
					// Dann passts
					Vector<WorkspaceDefinition> returnVector = (Vector<WorkspaceDefinition>)o;
					return returnVector;
				}
			}
		}
		return null;
	}

	protected void saveWorkspaces() {
		getWindowManager().getSettings().put( "WorkspaceManager.Dialog.workspaces", getWorkspaceDefinitions() );
	}

	protected void onWorkspaceApplied() {
	}

	public void setWorkspaceTitleText( String s ) {
		workspacesTitle.setText( s );
		pack();
	}

	public Vector<WorkspaceDefinition> getWorkspaceDefinitions() {
		return workspaces;
	}

}
