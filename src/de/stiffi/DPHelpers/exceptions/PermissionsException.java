package de.stiffi.DPHelpers.exceptions;


/**
 * Diese Exception wird geworfen, wenn für eine Operation die Benutzerrechte nicht ausreichen
 * 
 * @author peez
 * 
 */
public class PermissionsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4040262499151595233L;

	public enum Operation {
		SELECT, INSERT, UPDATE, DELETE, UNDEFINED
	}

	private Operation operation = Operation.UNDEFINED;

	public PermissionsException( Operation operation ) {
		super();
		this.operation = operation;
	}

	public PermissionsException( Exception ex, Operation operation ) {
		super( ex );
		this.operation = operation;
	}

	public PermissionsException( String message, Exception ex, Operation operation ) {
		super( message, ex );
		this.operation = operation;
	}

	public PermissionsException( String message, Operation operation ) {
		super( message );
		this.operation = operation;
	}

	public Operation getOperation() {
		return operation;
	}

}
