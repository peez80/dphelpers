package de.stiffi.DPHelpers.Swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 * Erweiterung von JTable um ein paar Funktionen, für die normalerweise mehr Tipparbeit nötig wäre
 * 
 * @author peez
 * 
 */
public class DPTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3623464789529732254L;

	/**
	 * Spezielle Renderer, die in der Table verwendet werden.
	 */
	private Hashtable<Integer, TableCellRenderer> renderers = new Hashtable<Integer, TableCellRenderer>();

	public DPTable() {
		super();
		init();
	}

	public DPTable( int numRows, int numColumns ) {
		super( numRows, numColumns );
		init();
	}

	public DPTable( Object[][] rowData, Object[] columnNames ) {
		super( rowData, columnNames );
		init();
	}

	public DPTable( TableModel dm, TableColumnModel cm, ListSelectionModel sm ) {
		super( dm, cm, sm );
		init();
	}

	public DPTable( TableModel dm, TableColumnModel cm ) {
		super( dm, cm );
		init();
	}

	public DPTable( TableModel dm ) {
		super( dm );
		init();
	}

	public DPTable( Vector rowData, Vector columnNames ) {
		super( rowData, columnNames );
		init();
	}

	private void init() {
		// --- Auch mit Rechtsklick Selektion zulassen
		addMouseListener( new MouseAdapter() {

			@Override
			public void mousePressed( MouseEvent e ) {
				int row = rowAtPoint( e.getPoint() );

				if ( row != -1 ) {
					getSelectionModel().setSelectionInterval( row, row );
				}
			}
		} );
	}

	/**
	 * Legt einen {@link TableCellRenderer} für die übergebene Spalte fest
	 * 
	 * @param column
	 * @param renderer
	 */
	public void setTableCellRenderer( int column, TableCellRenderer renderer ) {
		renderers.put( new Integer( column ), renderer );
	}

	@Override
	public TableCellRenderer getCellRenderer( int row, int column ) {
		TableCellRenderer renderer = renderers.get( new Integer( column ) );
		return renderer != null ? renderer : super.getCellRenderer( row, column );
	}

	/**
	 * Legt die Namen der Spalten dieser Tabelle fest
	 * 
	 * @param names
	 */
	public void setColumnNames( String... names ) {
		for ( int i = 0; i < names.length; i++ ) {
			setColumnName( i, names[i] );
		}
	}

	/**
	 * Legt den Namen der Spalte mit dem übergebenen Index fest
	 * 
	 * @param columnIndex
	 * @param name
	 */
	public void setColumnName( int columnIndex, String name ) {
		getColumnModel().getColumn( columnIndex ).setHeaderValue( name );
	}
}
