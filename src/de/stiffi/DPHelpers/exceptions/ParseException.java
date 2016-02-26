package de.stiffi.DPHelpers.exceptions;

/**
 * Generelle Fehlerklasse, falls ein Parse-Vorgang fehlschlägt.
 * 
 * @author peez
 * 
 */
public class ParseException extends Exception {

	private Object data;

	/**
	 * 
	 */
	private static final long serialVersionUID = -4547069338772523202L;

	public ParseException() {
		super();
	}

	public ParseException( String message, Throwable cause ) {
		super( message, cause );
	}

	public ParseException( String message ) {
		super( message );
	}

	public ParseException( Throwable cause ) {
		super( cause );
	}

	public ParseException( Object data ) {
		super();
		this.data = data;
	}

	public ParseException( String message, Throwable cause, Object data ) {
		super( message, cause );
		this.data = data;
	}

	public ParseException( String message, Object data ) {
		super( message );
		this.data = data;
	}

	public ParseException( Throwable cause, Object data ) {
		super( cause );
		this.data = data;
	}

	public Object getData() {
		return data;
	}

}
