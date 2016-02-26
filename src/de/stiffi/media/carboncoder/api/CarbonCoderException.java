package de.stiffi.media.carboncoder.api;

/**
 * Wird geworfen, wenn beim Absetzen deines Befehls eine Fehlermeldung vom CarbonCoder zurückkommt.
 * In der Message steht der Wert des Tags "Error" der CarbonCoder Antwort.
 * 
 * @author peez
 * 
 */
public class CarbonCoderException extends Exception {

	public CarbonCoderException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarbonCoderException( String message, Throwable cause ) {
		super( message, cause );
		// TODO Auto-generated constructor stub
	}

	public CarbonCoderException( String message ) {
		super( message );
		// TODO Auto-generated constructor stub
	}

	public CarbonCoderException( Throwable cause ) {
		super( cause );
		// TODO Auto-generated constructor stub
	}

}
