package de.stiffi.DPHelpers.Swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * ACHTUNG!!! Die Klasse hab ich mal kurz angefangen dann aber vorerst doch weider gesteckt!
 * 
 * Funktioniert als NICHT!!
 * 
 * 
 * @author peez
 * 
 */
public abstract class DPSearchDialog extends DPInternalFrame {

	/**
	 * Anzahl an Such-Zeilen
	 */
	private int rowsCount = 2;

	private SearchAction searchAction;

	private JButton btSearch;

	public DPSearchDialog() {
		super();
	}

	public DPSearchDialog( String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable ) {
		super( title, resizable, closable, maximizable, iconifiable );
	}

	public DPSearchDialog( String title, boolean resizable, boolean closable, boolean maximizable ) {
		super( title, resizable, closable, maximizable );
	}

	public DPSearchDialog( String title, boolean resizable, boolean closable ) {
		super( title, resizable, closable );
	}

	public DPSearchDialog( String title, boolean resizable ) {
		super( title, resizable );
	}

	public DPSearchDialog( String title ) {
		super( title );
	}

	private void createGUI() {
		setLayout( new BorderLayout() );

		// Buttons ----------------------------------------
		JPanel pButtons = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		add( pButtons, BorderLayout.SOUTH );
		searchAction = new SearchAction();
		btSearch = new JButton( searchAction );
		pButtons.add( btSearch );

	}

	private String getJpqlString( List<SearchCriteria> criterias ) {
		return null;
	}

	public int getRowsCount() {
		return rowsCount;
	}

	private class SearchAction extends AbstractAction {

		public SearchAction() {
			super( "Suchen..." );
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
		// TODO Auto-generated method stub

		}
	}

	/**
	 * Ein Suchkriterium definiert, wonach und wie gesucht werden soll.
	 * 
	 * @author peez
	 * 
	 */
	private static class SearchCriteria {

		/**
		 * Die klasse in der die Membervariable ist, die gesucht wird
		 */
		public Class entityClazz;

		/**
		 * Der Name der Membervariable auf der gesucht werden soll
		 */
		public String entityMemberName;

		/**
		 * Die Klasse der Membervariable auf der gesucht werden soll.
		 */
		public Class entityMemberClazz;

		/**
		 * Der Wert mit dem die Membervariable verglichen werden soll.
		 */
		public Object searchValue;

		/**
		 * Comparator, mit dem die Membervariable mit dem Wert verglichen werden soll.
		 */
		public int comparator;

		/**
		 * Wird immer hochgezählt, um Suchkriterien identifizieren zu können
		 */
		private static int criteriaIdGenerator = 0;

		private int criteriaId;

		private static Object synchronizer = new Object();

		public SearchCriteria() {
			synchronized (synchronizer) {
				criteriaId = criteriaIdGenerator++;
			}
		}

		public int getId() {
			return criteriaId;
		}

	}

	private static class Comparator {

		public final static int EQUALS = 1;

		public final static int LIKE = 2;

		public final static int BIGGER_THAN = 3;

		public final static int SMALLER_THAN = 4;

		public final static int BIGGER_OR_EQUALS = 5;

		public final static int SMALLER_OR_EQUALS = 6;

		public final static int IN = 7;

		/**
		 * Gibt alle Comparatoren zurück, die für die übergebene Klasse verwendet werden können.
		 * 
		 * @param clazz
		 * @return
		 */
		public static int[] getComparatorsForClass( Class<?> clazz ) {
			List<Integer> comparators = new ArrayList<Integer>();

			if ( clazz.isAssignableFrom( Number.class ) ) {
				comparators.add( EQUALS );
				comparators.add( BIGGER_THAN );
				comparators.add( SMALLER_THAN );
				comparators.add( BIGGER_OR_EQUALS );
				comparators.add( SMALLER_OR_EQUALS );
				comparators.add( IN );
			} else if ( clazz.isAssignableFrom( CharSequence.class ) ) {
				comparators.add( EQUALS );
				comparators.add( LIKE );
				comparators.add( IN );
			} else {
				comparators.add( EQUALS );
				comparators.add( IN );
			}

			int[] ret = new int[comparators.size()];
			for ( int i = 0; i < comparators.size(); i++ ) {
				ret[i] = comparators.get( i ).intValue();
			}
			return ret;
		}
	}

}
