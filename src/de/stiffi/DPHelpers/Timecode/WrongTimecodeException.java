package de.stiffi.DPHelpers.Timecode;

/**
 * Wird von den Timecode-Klassen geworfen, wenn übergebene Timecodes oder Timecode-Strings nicht
 * stimmen bzw. eine falsche Struktur haben.
 * 
 * @author peez
 * 
 */
public class WrongTimecodeException extends Exception {

	public WrongTimecodeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WrongTimecodeException( String message, Throwable cause ) {
		super( message, cause );
		// TODO Auto-generated constructor stub
	}

	public WrongTimecodeException( String message ) {
		super( message );
		// TODO Auto-generated constructor stub
	}

	public WrongTimecodeException( Throwable cause ) {
		super( cause );
		// TODO Auto-generated constructor stub
	}

}
