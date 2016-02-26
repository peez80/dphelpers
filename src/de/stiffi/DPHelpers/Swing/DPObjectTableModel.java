package de.stiffi.DPHelpers.Swing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DPObjectTableModel<T> extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4985173133208185634L;

	/**
	 * Diese Objekte werden angezeigt
	 */
	private List<T> objects = new ArrayList<T>();

	/**
	 * Anzeigenamen für die Spalten
	 */
	private Hashtable<Integer, String> columnNames = new Hashtable<Integer, String>();

	/**
	 * Entsprechend der Anzeigenamen der Spalten die jeweiligen Get-Methoden.
	 */
	private Hashtable<Integer, String> columnGetters = new Hashtable<Integer, String>();

	/**
	 * Zell-Renderer (falls gesetzt) für die einzelnen Spalten
	 */
	private Hashtable<Integer, DPObjectRenderer> cellRenderers = new Hashtable<Integer, DPObjectRenderer>();

	/**
	 * Leerer Konstruktor
	 */
	public DPObjectTableModel() {

	}

	/**
	 * 
	 * @param columnNames Namen der Spalten
	 * @param columnGetters getter-Methoden des BOs zu den spaltnenamen (incl. "get")
	 */
	public DPObjectTableModel( String columnNames[], String columnGetters[] ) {
		setColumns( columnNames, columnGetters );
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		return objects.size();
	}

	@Override
	public String getColumnName( int column ) {
		return columnNames.get( column );
	}

	@Override
	public Object getValueAt( int rowIndex, int columnIndex ) {
		T o = objects.get( rowIndex );
		if ( o == null ) {
			return null;
		}

		// Wenn ich einen Renderer habe, dann den benutzen
		if ( this.cellRenderers.get( new Integer( columnIndex ) ) != null ) {
			DPObjectRenderer r = this.cellRenderers.get( new Integer( columnIndex ) );
			return r.render( o );

		} else {

			// Anonsten Java Reflection API benutzen, um den entsprechenden Wert rauszuholen
			String getterName = columnGetters.get( columnIndex );
			if ( getterName == null ) {
				return null;
			}

			Class<?> c = o.getClass();

			try {
				Method getter = c.getMethod( getterName, (Class<?>[])null );

				Object result = getter.invoke( o, (Object[])null );

				return result;

			} catch (SecurityException e) {
				e.printStackTrace();
				return null;
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				return null;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	/**
	 * 
	 * @param columnNames Spaltennamen
	 * @param columnGetters getter zu den Spaltennamen (incl. "get")
	 */
	public void setColumns( String[] columnNames, String[] columnGetters ) {
		this.columnNames.clear();
		this.columnGetters.clear();

		for ( int i = 0; i < columnNames.length; i++ ) {
			if ( columnNames[i] != null ) {
				this.columnNames.put( new Integer( i ), columnNames[i] );
			}
		}

		for ( int i = 0; i < columnGetters.length; i++ ) {
			if ( columnGetters[i] != null ) {
				this.columnGetters.put( new Integer( i ), columnGetters[i] );
			}
		}

		fireTableDataChanged();
	}

	/**
	 * Leert die das Model und damit die darüberliegende Tabelle
	 */
	public void clearData() {
		this.objects.clear();
		fireTableDataChanged();
	}

	/**
	 * Weist der übergebenen Spalte einen Zell-Renderer zu
	 * 
	 * @param columnIndex Spaltenindex
	 * @param renderer Renderer
	 */
	public void setCellRenderer( int columnIndex, DPObjectRenderer renderer ) {
		this.cellRenderers.put( columnIndex, renderer );
	}

	public void addColumn( String columnName, String getMethod ) {
		int i = getColumnCount();

		this.columnNames.put( new Integer( i ), columnName );
		this.columnGetters.put( new Integer( 1 ), getMethod );

		fireTableDataChanged();
	}

	/**
	 * Gibt das BusinessObject an der übergebenen Zeile zurück
	 * 
	 * @param row
	 * @return BusinessObject oder null, wenn es die Zeile nicht gibt
	 */
	public T getObjectAtRow( int row ) {
		return objects.get( row );
	}
	
	public void removeObject(T o) {
		int index = objects.indexOf( o );
		if (index != -1) {
			objects.remove( index );
//			fireTableRowsDeleted( index, index );
			fireTableDataChanged();
		}else{
			//TODO fehler schmeißen?
			
		}		
	}

	/**
	 * Legt eine neue Liste an BusinessObjekten fest. Die alten werden dabei entfernt
	 * 
	 * @param objects
	 */
	public void setValues( List<T> objects ) {
		this.objects = objects;
		fireTableDataChanged();
	}
	
	public void addElement(T elem)  {
		objects.add( elem );
		fireTableDataChanged();
	}

}
