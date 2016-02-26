package de.stiffi.DPHelpers.CommandLineParser;

/**
 * Ein Argument ist ein zwingender Bestandteil einer Kommandozeile. es hat keinen Key, sondern nur
 * einen Wert
 * und wird in der richtigen Reihenfolge (nämlich der Reihenfolge, in der die Arguments zu
 * CommandLineParser
 * hinzugefügt wurden) aufgerufen.
 * 
 * Argumente kommen in der Kommandozeile immer vor allen Options und Switches
 * 
 * @author HD-Authoring
 * 
 */
public class Argument extends CommandLineElement {

	/**
	 * Wert des Arguments
	 */
	private String m_value = "";

	public Argument( String name, String description ) {
		super( name, description );
	}

	public void setValue( String value ) {
		m_value = value;
	}

	public String getValue() {
		return m_value;
	}
}
