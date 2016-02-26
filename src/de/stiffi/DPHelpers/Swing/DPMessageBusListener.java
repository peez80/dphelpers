package de.stiffi.DPHelpers.Swing;


public interface DPMessageBusListener {
	public void messageReceived(String messageBusName, DPMessageBusMessage msg) throws DPMessageVetoException; 
}
