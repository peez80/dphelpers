package de.stiffi.DPHelpers.SoftwareProtection;

public class InvalidSerialException extends Exception {

	public static final int REASON_TIME_EXPIRED = 0x1;

	public static final int REASON_WRONG_FORMAT = 0x2;

	public static final int REASON_WRONG_SERIAL = 0x3;

	private int reason;

	public InvalidSerialException( String message, int reason ) {
		super( message );
		this.reason = reason;
	}

	public int getReason() {
		return reason;
	}
}
