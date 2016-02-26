package de.stiffi.DPHelpers.Swing;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;

public class DPTimePicker extends JFormattedTextField {

	public DPTimePicker() {
		super( new SimpleDateFormat( "HH:mm" ) );
		setValue( new Date() );
	}

	public Date getDate() {
		return (Date)getValue();
	}

	public void setDate( Date date ) {
		setValue( date );
	}
}
