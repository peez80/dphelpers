package de.stiffi.DPHelpers.Swing;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Baut ohne großes User-Zutun ein Formular auf mit Label - Feld in Spalten verteilt. <br>
 * Hierfür muss die Methode {@link #addFormElement(String, Component)} verwendet werden! Sobald die
 * standard add-Methoden verwendet werden, funktioniert dieser Panel nicht mehr!
 * Außerdem darf ihm kein neuer LayoutManager verpasst werden!
 */
public class DPFormularPanel extends JPanel {
	
	public static enum FormOptions {
		NO_HORIZONTAL_FILL
	}

	private static final long serialVersionUID = -3668683321275008535L;	

	/**
	 * Anzahl Spalten, die angezeigt werden. Eine Spalte besteht immer aus Label und Feld-Spalte
	 */
	private int formColumns = 1;

	/**
	 * Aktueller Cursor - an dieser Stelle wird das nächste Element eingefügt.<br>
	 * Der X-Wert benennt die aktuelle "Spalte". Eine "Spalte" in diesem Kontext bedeutet eine
	 * GridBagLayout-Spalte mit Label und eine mit Feld
	 */
	private Point currentCursor = new Point( 0, 0 );

	/**
	 * Gridbagconstraint, der für die Label-spalten verwendet wird
	 */
	private GridBagConstraints gbcLabels = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets( 0, 0, 0, 0 ), 0, 0 );

	/**
	 * GridBagConstraint, der für die Eingabefelder verwendet wird
	 */
	private GridBagConstraints gbcFields = new GridBagConstraints( 0, 0, 1, 1, 100, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets( 0, 0, 0, 0 ), 0, 0 );

	/**
	 * 
	 */
	public DPFormularPanel() {
		super();
		formColumns = 1;
		___initDPFormularPanel();
	}

	/**
	 * 
	 * @param formColumns Anzahl der Formular Spalten
	 */
	public DPFormularPanel( int formColumns ) {
		super();
		this.formColumns = formColumns;
		___initDPFormularPanel();
	}

	/**
	 * Initialisierung
	 */
	private void ___initDPFormularPanel() {
		setLayout( new GridBagLayout() );
	}

	/**
	 * Fügt ein Formularelement an die nächste freie Stelle ein
	 * 
	 * @param label Label-Text, der links von der Komponente angezeigt wird
	 * @param component Komponente, die eingefügt werden soll
	 */
	public void addFormElement( String label, Component component ) {
		JLabel l = new JLabel( label );
		addFormElement( l, component, new FormOptions[]{} );
	}

	/**
	 * Fügt ein Formularelement an die nächste freie Stelle ein
	 * 
	 * @param label Label, der links von der Komponente angezeigt wird
	 * @param component Komponente, die eingefügt werden soll
	 */
	public void addFormElement(JLabel label, Component component, FormOptions... options) {
		gbcLabels.gridx =(currentCursor.x*2)-1 + 1;
		gbcFields.gridx = currentCursor.x * 2 + 1;
		gbcLabels.gridy = currentCursor.y;
		gbcFields.gridy = currentCursor.y;
		
		GridBagConstraints cbcLabel = (GridBagConstraints)gbcLabels.clone();
		GridBagConstraints gbcField = (GridBagConstraints)gbcFields.clone();
		
		if (options != null) {
			for (FormOptions o : options) {
				if (o.equals( FormOptions.NO_HORIZONTAL_FILL )) {
					gbcField.fill = GridBagConstraints.NONE;
				}
			}
		}
		
		add(label, cbcLabel);
		add(component, gbcField);
		
		forwardCursor();
	}
	
	public void addFormElement(String label, Component component, FormOptions... options) {
		JLabel l = new JLabel( label );
		addFormElement( l, component, options );
	}
	
	/**
	 * Aktuelles Feld am Cursor überspringen u. Cursor eins weiter setzen
	 */
	public void addFormElementEmpty() {
		forwardCursor();
	}
	
	/**
	 * Setzt den Cursor ein Feld weiter. Immer von links nach Rechts,
	 * wenn die Maximalanzahl an Spalten erreicht ist, wird eine Zeile
	 * weitergeschalten
	 */
	private void forwardCursor() {
		//Cursor weiter setzen
		currentCursor.x++;
		if (currentCursor.x >= formColumns) {
			//Zu weit rechts, also Zeilenumbruch
			currentCursor.x=0;
			currentCursor.y++;
		}
	}
	
	/**
	 * Gibt eine Referenz auf die verwendeten GridBagConstraint für die Labels zurück.
	 * 
	 * @return
	 */
	public GridBagConstraints getLabelsConstraints() {
		return gbcLabels;
	}
	
	/**
	 * Gibt eine Referenz auf die verwendeten GridBagConstraint für die Eingabefelder zurück.
	 * 
	 * @return
	 */
	public GridBagConstraints getFieldsConstraints() {
		return gbcFields;
	}
}
