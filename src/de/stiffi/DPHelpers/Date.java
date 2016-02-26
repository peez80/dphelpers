package de.stiffi.DPHelpers;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Diese Klasse stellt einige static Methoden für oft verwendete Be- und Verarbeitungen von Datums- und Zeitangaben bereit.
 * 
 * @author HD-Authoring
 * 
 */
public class Date {

	/**
	 * Gibt einen Datetime String (YYYY-MM-DD HH:MM:SS) zurück
	 * 
	 * @param timeInMillis Systemzeit in Millisekunden
	 * @return
	 */
	public static String getDatetime( long timeInMillis ) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTimeInMillis( timeInMillis );

		return getDatetime( c );
	}

	/**
	 * Gibt den aktuellen Datetime String (YYYY-MM-DD HH:MM:SS) zurück
	 * 
	 * @return
	 */
	public static String getDatetime() {
		return getDatetime( new GregorianCalendar() );
	}

	/**
	 * Gibt einen Datetime String (YYYY-MM-DD HH:MM:SS) für das übergebene GregorianCalendar Objekt zurück
	 * 
	 * @param cal
	 * @return
	 */
	public static String getDatetime( GregorianCalendar cal ) {
		return getDate( cal ) + " " + getTime( cal );
	}

	/**
	 * Gibt nur das Datum (YYYY-MM-DD) für den übergebenen GregorianCalendar zurück
	 * 
	 * @param cal
	 * @return
	 */
	public static String getDate( GregorianCalendar cal ) {
		int year = cal.get( Calendar.YEAR );
		int month = cal.get( Calendar.MONTH );
		int day = cal.get( Calendar.DAY_OF_MONTH );

		String y = "" + year;
		String m = ( month < 10 ? "0" : "" ) + month;
		String d = ( day < 10 ? "0" : "" ) + day;

		String date = y + "-" + m + "-" + d;

		return date;
	}

	/**
	 * Gibt nur die Zeit (HH:MM:SS) für den übergebenen GregorianCalendar zurück.
	 * 
	 * @param cal
	 * @return
	 */
	public static String getTime( GregorianCalendar cal ) {
		int hour = cal.get( Calendar.HOUR_OF_DAY );
		int minute = cal.get( Calendar.MINUTE );
		int second = cal.get( Calendar.SECOND );

		String h = ( hour < 10 ? "0" : "" ) + hour;
		String min = ( minute < 10 ? "0" : "" ) + minute;
		String s = ( second < 10 ? "0" : "" ) + second;

		String time = h + ":" + min + ":" + s;
		return time;
	}

	/**
	 * Gibt das aktuelle Datum (YYYY-MM-DD) als String zurück
	 * 
	 * @return
	 */
	public static String getDate() {
		return getDate( new GregorianCalendar() );
	}

	public static String getDate( java.util.Date d ) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime( d );

		return getDate( cal );
	}

	/**
	 * Gibt die aktuelle Uhrzeit (HH:MM:SS) als String zurück
	 * 
	 * @return
	 */
	public static String getTime() {
		return getTime( new GregorianCalendar() );
	}
	
	public static boolean isValidDate(int year, int month, int day) {
		
		if (year < 0 || month < 1 || day < 1) {
			return false;
		}
		
		if (month > 12) {
			return false;
		}
		
		//Jetzt prüfen, ob der Tag zum Monat passt
		PCalendar cal = new PCalendar(year, month, 1, 0, 0, 0);
		int last_day_of_month = cal.getActualMaximum( Calendar.DAY_OF_MONTH );
		if (day > last_day_of_month) {
			return false;
		}
		
		
		return true;
	}

}
