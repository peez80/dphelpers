package de.stiffi.DPHelpers.CommandLineParser;

import java.util.Vector;

/**
 * Oberklasse f�r Argument, Option und Switch
 * 
 * @author HD-Authoring
 * 
 */
public class CommandLineElement {

	/**
	 * Name des Elements. Hier�ber wird es auch intern angesprochen
	 */
	private String m_name;

	/**
	 * Kurze Beschreibung des Elements
	 */
	private String m_shortDescription;

	/**
	 * Wenn ein Element Abh�ngigkeiten hat, d.h. wenn also zwingend f�r ein element noch andere
	 * Elemente in der Kommandozeile existieren m�ssen, k�nnen in diesem Vektor Verweise auf diese
	 * gespeichert werden.
	 */
	private Vector<CommandLineElement> m_dependings;

	/**
	 * Wenn ein Element nur festgelegte Werte haben kann, k�nnen diese in diesem Array geseichert
	 * werden.
	 */
	private String[] m_possibleValues = null;

	public enum ValueType {
		UNDEFINED, EXISTING_FILE
	}

	/**
	 * Was f�r eine Art von Inhalt muss in diesem Argument stehen. Wird zur automatischen
	 * validierung verwendet
	 */
	private ValueType valueType = ValueType.UNDEFINED;

	/**
	 * Konstruktor
	 * 
	 * @param name Name des Elements
	 * @param shortDescription Kurzbeschreibung des ELements
	 */
	public CommandLineElement( String name, String shortDescription ) {
		m_name = name;
		m_shortDescription = shortDescription;

		m_dependings = new Vector<CommandLineElement>();
	}

	/**
	 * Gibt den Namen dieses Elements zur�ck
	 * 
	 * @return
	 */
	public String getName() {
		return m_name;
	}

	/**
	 * Gibt die Kurzbeschreibung dieses Elements zur�ck
	 * 
	 * @return
	 */
	public String getDescription() {
		return m_shortDescription;
	}

	/**
	 * Gibt alle Elemente, von denen dieses Element abh�ngt, zur�ck
	 * 
	 * @return Depending Elemente, oder null wenn es keine Abh�ngigkeiten gibt
	 */
	CommandLineElement[] getDependings() {
		CommandLineElement elements[] = m_dependings.toArray( new CommandLineElement[0] );

		return elements.length == 0 ? null : elements;
	}

	/**
	 * F�gt ein Element hinzu, von dem dieses Element abh�ngig ist.
	 * 
	 * @param e
	 */
	public void addDepending( CommandLineElement e ) {
		if ( e instanceof Switch || e instanceof Option ) { // Nur Switches und options hier
															// reinnehmen, Arguments m�ssen ja eh
															// immer da sein
			m_dependings.add( e );
		}
	}

	/**
	 * Gibt alle m�glichen Werte f�r dieses Element zur�ck.
	 * 
	 * @return Alle Werte, die f�r dieses Element m�glich sind, null wenn alles m�glich ist.
	 */
	public String[] getPossibleValues() {
		return m_possibleValues;
	}

	/**
	 * Wenn dieses Element im Wertebereich beschr�nkt ist, k�nnen alle m�glichen Werte hier
	 * gespeichert werden.
	 * 
	 * @param possibleValues
	 */
	public void setPossibleValues( String[] possibleValues ) {
		m_possibleValues = possibleValues;
	}

	/**
	 * Gibt die Art des Inhalts dieses Elements (wenn es einen Wert hat) zur�ck. Wird zur
	 * Validierung verwendet
	 * 
	 * @return
	 */
	public ValueType getValueType() {
		return valueType;
	}

	/**
	 * Legt die Art des Inhalts dieses Elements (wenn es einen Wert hat) fest. Wird zur Validierung
	 * verwendet
	 * 
	 * @param valueType
	 */
	public void setValueType( ValueType valueType ) {
		this.valueType = valueType;
	}
}
