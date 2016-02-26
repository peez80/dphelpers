package de.stiffi.DPHelpers.exceptions;

import de.stiffi.DPHelpers.XML;

/**
 * Wird geworfen, wenn von {@link XML} z.B. ein Element nicht gefunden wurde
 * 
 * @author peez
 * 
 */
public class ElementNotFoundException extends Exception {

	public ElementNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElementNotFoundException( String message, Throwable cause ) {
		super( message, cause );
		// TODO Auto-generated constructor stub
	}

	public ElementNotFoundException( String message ) {
		super( message );
		// TODO Auto-generated constructor stub
	}

	public ElementNotFoundException( Throwable cause ) {
		super( cause );
		// TODO Auto-generated constructor stub
	}

}
