package de.stiffi.DPHelpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PCalendar extends GregorianCalendar {

	public PCalendar() {
		super();
	}

	public PCalendar( int year, int month, int dayOfMonth, int hourOfDay, int minute, int second ) {
		super( year, month, dayOfMonth, hourOfDay, minute, second );
	}

	/**
	 * Neuer Kalender am aktuellen Tag mit der übergebenen Uhrzeit
	 * 
	 * @param hour
	 * @param minute
	 * @param second
	 */
	public PCalendar( int hour, int minute, int second ) {
		super();
		set( Calendar.HOUR_OF_DAY, hour );
		set( Calendar.MINUTE, minute );
		set( Calendar.SECOND, second );
		set( Calendar.MILLISECOND, 0 );
	}

	public PCalendar( long timeInMillis ) {
		super();
		setTimeInMillis( timeInMillis );
	}

	public PCalendar( Calendar cal ) {
		super();
		setTimeInMillis( cal.getTimeInMillis() );
	}

	public PCalendar( java.util.Date date ) {
		super();
		setTimeInMillis( date.getTime() );
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		return df.format( getTime() );
	}

	public void setTimeData( Calendar c ) {
		set( Calendar.HOUR_OF_DAY, c.get( Calendar.HOUR_OF_DAY ) );
		set( Calendar.MINUTE, c.get( Calendar.MINUTE ) );
		set( Calendar.SECOND, c.get( Calendar.SECOND ) );
		set( Calendar.MILLISECOND, c.get( Calendar.MILLISECOND ) );
	}

	public void setDateData( Calendar c ) {
		set( Calendar.DAY_OF_YEAR, c.get( Calendar.DAY_OF_YEAR ) );
		set( Calendar.YEAR, c.get( Calendar.YEAR ) );
	}

	public boolean equalsDate( PCalendar cal ) {
		boolean equals = true;
		if ( cal.get( Calendar.YEAR ) != get( Calendar.YEAR ) ) {
			equals = false;
		}
		if ( cal.get( Calendar.DAY_OF_YEAR ) != get( Calendar.DAY_OF_YEAR ) ) {
			equals = false;
		}
		return equals;
	}

	public boolean equalsTime( PCalendar cal ) {
		boolean equals = true;
		if ( cal.get( Calendar.HOUR_OF_DAY ) != get( Calendar.HOUR_OF_DAY ) ) {
			equals = false;
		}
		if ( cal.get( Calendar.MINUTE ) != get( Calendar.MINUTE ) ) {
			equals = false;
		}
		if ( cal.get( Calendar.SECOND ) != get( Calendar.SECOND ) ) {
			equals = false;
		}
		if ( cal.get( Calendar.MILLISECOND ) != get( Calendar.MILLISECOND ) ) {
			equals = false;
		}
		return equals;
	}
	
	/**
	 * Entfernt die Zeit-Informationen, sodass exakt Mitternacht referenziert wird und gibt sich selbst zurück
	 */
	public PCalendar clearTimeData() {
		
		set( Calendar.HOUR_OF_DAY, 0 );
		set(Calendar.MINUTE, 0);
		set(Calendar.SECOND, 0);
		set(Calendar.MILLISECOND,0);
		
		return this;
	}

}
