package de.stiffi.DPHelpers.Swing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.table.DefaultTableCellRenderer;

public class CalendarRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1774752212394519934L;

	private DateFormat dateFormat;

	public CalendarRenderer() {
		dateFormat = new SimpleDateFormat();
	}

	public CalendarRenderer( DateFormat df ) {
		dateFormat = df;
	}

	@Override
	protected void setValue( Object value ) {
		if ( value instanceof Calendar ) {
			setText( dateFormat.format( ( (Calendar)value ).getTime() ) );
		} else if ( value instanceof Date ) {
			setText( dateFormat.format( (Date)value ) );
		} else {
			super.setValue( value );
		}
	}
}
