package de.stiffi.DPHelpers.exceptions;

import java.util.Hashtable;

/**
 * Diese Exception kann geworfen werden, wenn z.B. ein Login aufgrund falscher Benutzerdaten nicht
 * durchgeführt werden kann.
 * 
 * @author peez
 * 
 */
public class WrongUserDataException extends Exception {

	private Hashtable<String, Object> properties = new Hashtable<String, Object>();

	public WrongUserDataException() {
		super();
	}

	public WrongUserDataException( String message, Throwable cause ) {
		super( message, cause );
	}

	public WrongUserDataException( String message ) {
		super( message );
	}

	public WrongUserDataException( Throwable cause ) {
		super( cause );
	}

	public Hashtable<String, Object> getProperties() {
		return properties;
	}

	public Object getProperty( String key ) {
		return properties.get( key );
	}

	public void setProperty( String key, Object value ) {
		properties.put( key, value );
	}

}
