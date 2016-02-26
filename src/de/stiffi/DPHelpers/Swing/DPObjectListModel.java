package de.stiffi.DPHelpers.Swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

public class DPObjectListModel<T> extends AbstractListModel {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8570567703041308713L;

	private List<T>				elements			= new ArrayList<T>();

	public DPObjectListModel() {}

	public DPObjectListModel( List<T> contents ) {
		elements.addAll( contents );
	}

	@Override
	public Object getElementAt( int index ) {
		return elements.get( index );
	}

	@Override
	public int getSize() {
		return elements.size();
	}

	public void addElement( T element ) {
		elements.add( element );
		fireIntervalAdded( this, getSize(), getSize() );
	}

	public void removeElement( T element ) {
		for ( int i = 0; i < elements.size(); i++ ) {
			if ( elements.get( i ).equals( element ) ) {
				elements.remove( i );
				fireIntervalRemoved( this, i, i );
			}
		}
	}

	public void removeAll() {
		int selectionEndIndex = elements.size() - 1;
		if ( selectionEndIndex < 0 ) {
			selectionEndIndex = 0;
		}

		elements.clear();

		fireIntervalRemoved( this, 0, selectionEndIndex );
	}

	public List<T> getElements() {
		List<T> elems = new ArrayList<T>( elements );
		return elems;
	}

}
