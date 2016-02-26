package de.stiffi.DPHelpers.Swing;

public class DPMessageBusMessage {

	public final static String CHANNEL_DPINTERNALFRAME = "CHANNEL_DPINTERNALFRAME";

	public final static String MSG_DPINTERNALFRAME_OPENED = "DPINTERNALFRAME_OPENED";

	public final static String MSG_DPINTERNALFRAME_CLOSED = "DPINTERNALFRAME_CLOSED";

	public final static String MSG_DPINTERNALFRAME_ICONIFIED = "DPINTERNALFRAME_ICONIFIED";

	public final static String MSG_DPINTERNALFRAME_DEICONIFIED = "DPINTERNALFRAME_DEICONIFIED";

	public final static String MSG_DPINTERNALFRAME_DEACTIVATED = "DPINTERNALFRAME_DEACTIVATED";

	public final static String MSG_DPINTERNALFRAME_CLOSING = "DPINTERNALFRAME_CLOSING";

	public final static String MSG_DPINTERNALFRAME_ACTIVATED = "DPINTERNALFRAME_ACTIVATED";

	/**
	 * Vorgefertigte Konstante, wenn ein neues BusinessObjekt gewählt wurde
	 */
	public final static String BO_SELECTION_CHANGED = "BO_SELECTION_CHANGED";

	/**
	 * Wurde eine Selection aufgehoben, kann eine Message von diesem Typ gesendet werden.
	 */
	public final static String CLEAR_SELECTION = "CLEAR_SELECTION";

	private Object data = new Object();

	private String command = "";

	public DPMessageBusMessage( String command ) {
		setCommand( command );
	}

	public DPMessageBusMessage( String command, Object data ) {
		setData( data );
		setCommand( command );
	}

	public DPMessageBusMessage() {

	}

	public Object getData() {
		return data;
	}

	public void setData( Object data ) {
		this.data = data;
	}

	@Override
	public String toString() {

		String s = "";
		if ( getData() != null ) {
			s = "DPMessageBusMessage - " + getCommand() + " - " + getData().toString();
		} else {
			s = super.toString();
		}

		return s;
	}

	public String getCommand() {
		return command;
	}

	public boolean isCommand( String command ) {
		return ( this.command.equals( command ) );
	}

	public void setCommand( String command ) {
		this.command = command;
	}
}
