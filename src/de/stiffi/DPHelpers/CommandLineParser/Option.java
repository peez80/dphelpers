package de.stiffi.DPHelpers.CommandLineParser;


/**
 * Eine Option hat einen Key und einen Wert. Optionen können Pflicht oder Option sein.
 * Eine Option besteht immer aus -<key> <Wert> auf der Kommandozeile.
 * 
 * @author HD-Authoring
 *
 */
public class Option extends CommandLineElement {
	
	private String m_value = null;
	
	private boolean m_Mandatory = false;
	
	private String m_longDescription = "";
	
	private String m_standardValue = null;
	
	

	public Option( String name, String description, String longDescription, boolean mandatory ) {
		super( name, description );
		m_longDescription = longDescription;
		isMandatory( mandatory );
	}
	
	public Option(String name, String description, String longDescription) {
		super(name, description);
		m_longDescription = longDescription;
		isMandatory(false);
	}
	
	public Option(String name, String description, String longDescription, String standardValue) {
		super(name, description);
		m_longDescription = longDescription;
		isMandatory(false);
		setStandardValue( standardValue );
	}
	
	public String getValue() {
		return m_value;
		
	}
	public void setValue(String value) {
		m_value = value;
	}
	
	public boolean isMandatory() {
		return m_Mandatory;
	}
	
	public void isMandatory(boolean b) {
		m_Mandatory = b;
	}
	
	public String getLongDescription() {
		return m_longDescription;
	}
	
	public void setStandardValue(String v) {
		m_standardValue = v;
	}
	public String getStandardValue() {
		return m_standardValue;
	}
	
	
	

}
