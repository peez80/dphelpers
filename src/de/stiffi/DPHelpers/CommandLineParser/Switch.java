package de.stiffi.DPHelpers.CommandLineParser;

/**
 * Eine Switch (Schalter) hat nur einen An oder aus wert, d.h. er erscheint in der Kommandozeile (--> AN) oder
 * er erscheint eben nicht (--> AUS). Ein Switch ist immer optional, d.h. er kann weggelassen werden, wodurch er dann AUS
 * ist.
 * Ein Switch beginnt in der Kommandozeile mit /
 * 
 * @author HD-Authoring
 *
 */
public class Switch extends CommandLineElement {
	
	private boolean m_value = false;

	public Switch( String name, String description ) {
		super( name, description );
		// TODO Auto-generated constructor stub
	}
	
	public void setValue(boolean b) {
		m_value = b;
	}
	public boolean getValue() {
		return m_value;
	}
	
}
