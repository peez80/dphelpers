package de.stiffi.DPHelpers.exceptions;

public class SaveException extends Exception {

	private Object	businessObject;

	public SaveException( Object boToSave ) {
		super();
		this.businessObject = boToSave;
	}

	public SaveException( String message, Throwable cause, Object boToSave ) {
		super( message, cause );
		this.businessObject = boToSave;
	}

	public SaveException( String message, Object boToSave ) {
		super( message );
		this.businessObject = boToSave;
	}

	public SaveException( Throwable cause, Object boToSave ) {
		super( cause );
		this.businessObject = boToSave;
	}

	public Object getBusinessObject() {
		return businessObject;
	}

}
