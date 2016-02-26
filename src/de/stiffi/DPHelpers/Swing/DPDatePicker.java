package de.stiffi.DPHelpers.Swing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFormattedTextField;

public class DPDatePicker extends JFormattedTextField {

	public DPDatePicker() {
		super( new SimpleDateFormat( "dd.MM.yyyy" ) );
		setValue( new Date() );
	}

	public Date getDate() {
		return (Date)getValue();
	}

	public void setDate( Date date ) {
		if ( date != null ) {
			setValue( date );
		}
	}

	public void setDate( Calendar cal ) {
		if ( cal != null ) {
			setValue( cal.getTime() );
		}
	}
}
