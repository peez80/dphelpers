package de.stiffi.DPHelpers.Swing;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public abstract class DPObjectListCellRenderer<T> extends JLabel implements ListCellRenderer {

	public abstract String getRenderedText( T value, int index, boolean isSelected, boolean cellHasFocus );

	@Override
	public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
		setText( "" );

		setText( getRenderedText( (T)value, index, isSelected, cellHasFocus ) );

		if ( isSelected ) {
			setBackground( list.getSelectionBackground() );
			setForeground( list.getSelectionForeground() );
		} else {
			setBackground( list.getBackground() );
			setForeground( list.getForeground() );
		}

		return this;
	}

}
