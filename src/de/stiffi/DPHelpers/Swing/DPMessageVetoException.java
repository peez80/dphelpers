package de.stiffi.DPHelpers.Swing;


public class DPMessageVetoException extends Exception {
	
	private Object source;
	private DPMessageBusMessage message;
	
	public DPMessageVetoException(DPMessageBusMessage message, Object src) {
		super("MessageVeto: " + message.toString() + "      -    Source: " + src.toString());
		source= src;
		this.message = message;
	}
	
	public Object getSource() {
		return source;
	}
	
	public DPMessageBusMessage getVetoedMessage() {
		return message;
	}
}
