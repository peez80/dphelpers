package de.stiffi.DPHelpers.CommandLineParser;

import java.io.File;
import java.util.Vector;

import de.stiffi.DPHelpers.CommandLineParser.CommandLineElement.ValueType;

public class CommandLineParser {

	/**
	 * Hier kommen alle rein
	 */
	private Vector<CommandLineElement> m_elements;

	/**
	 * Konstruktor
	 */
	public CommandLineParser() {
		init();
	}

	/**
	 * Führt einige Initialisierungen durch
	 */
	private void init() {
		m_elements = new Vector<CommandLineElement>();
	}

	/**
	 * Gibt alle im Objekt definierten Argumente (NICHT die der Kommandozeile) zurück.
	 * 
	 * @return
	 */
	public Argument[] getArguments() {

		Vector<Argument> arguments = new Vector<Argument>();

		for ( int i = 0; i < m_elements.size(); i++ ) {
			if ( m_elements.get( i ) instanceof Argument ) {
				arguments.add( (Argument)m_elements.get( i ) );
			}
		}

		return arguments.toArray( new Argument[0] );
	}

	/**
	 * Gibt alle im Objekt definierten Switches (NICHT die der Kommandozeile) zurück.
	 * 
	 * @return
	 */
	public Switch[] getSwitches() {

		Vector<Switch> switches = new Vector<Switch>();

		for ( int i = 0; i < m_elements.size(); i++ ) {
			if ( m_elements.get( i ) instanceof Switch ) {
				switches.add( (Switch)m_elements.get( i ) );
			}
		}

		return switches.toArray( new Switch[0] );
	}

	/**
	 * Gibt alle im Objekt definierten Options (NICHT die der Kommandozeile) zurück.
	 * 
	 * @return
	 */
	public Option[] getOptions() {

		Vector<Option> options = new Vector<Option>();

		for ( int i = 0; i < m_elements.size(); i++ ) {
			if ( m_elements.get( i ) instanceof Option ) {
				options.add( (Option)m_elements.get( i ) );
			}
		}

		return options.toArray( new Option[0] );
	}

	/**
	 * Gibt die Option mit dem übergebenen Namen zurück ACHTUNG - sie muss nicht zwangsläufig mit
	 * dem Wert aus der Kommandozeile belegt sein. Die Belegung wird erst durch
	 * {@link #validate(String[])} vorgenommen.
	 * 
	 * @param name
	 * @return Die Option mit dem übergebenen Namen oder null, wenn es keine entspr. gibt
	 */
	public Option getOption( String name ) {

		for ( int i = 0; i < m_elements.size(); i++ ) {
			if ( m_elements.get( i ) instanceof Option ) {
				if ( m_elements.get( i ).getName().equalsIgnoreCase( name ) ) {
					return (Option)m_elements.get( i );
				}
			}
		}
		return null;
	}

	/**
	 * Gibt das Argument mit dem übergebenen Name zurück. ACHTUNG - Es muss nicht zwangsläufig mit
	 * dem Wert aus der Kommandozeile belegt sein. Die Belegung wird erst durch
	 * {@link #validate(String[])} vorgenommen.
	 * 
	 * @param name
	 * @return Das Argument mit dem übergebenen Namen oder null, wenn keines gefunden werden konnte.
	 */
	public Argument getArgument( String name ) {

		for ( int i = 0; i < m_elements.size(); i++ ) {
			if ( m_elements.get( i ) instanceof Argument ) {
				if ( m_elements.get( i ).getName().equals( name ) ) {
					return (Argument)m_elements.get( i );
				}
			}
		}
		return null;
	}

	/**
	 * Gibt die Switch mit dem übergebenen Name zurück. ACHTUNG - Es muss nicht zwangsläufig mit dem
	 * Wert aus der Kommandozeile belegt sein. Die Belegung wird erst durch
	 * {@link #validate(String[])} vorgenommen.
	 * 
	 * @param name
	 * @return Die Switch mit dem übergebenen Namen oder null, wenn keines gefunden werden konnte.
	 */
	public Switch getSwitch( String name ) {

		for ( int i = 0; i < m_elements.size(); i++ ) {
			if ( m_elements.get( i ) instanceof Switch ) {
				if ( m_elements.get( i ).getName().equalsIgnoreCase( name ) ) {
					return (Switch)m_elements.get( i );
				}
			}
		}
		return null;
	}

	/**
	 * Baut anhand der zuvor hinzugefügten Elemente einen String auf, der die Benutzung der
	 * Kommandozeile erläutert.
	 * 
	 * @return
	 */
	public String getUsage() {
		String line = "";
		String desc = "";

		// Zuerst Arguments
		Argument[] arguments = getArguments();

		for ( int i = 0; i < arguments.length; i++ ) {
			line += "<" + arguments[i].getName() + "> ";

			desc += arguments[i].getName() + "\r\n\t" + arguments[i].getDescription() + "\r\n\r\n";
		}

		// Jetzt der Rest
		for ( int i = 0; i < m_elements.size(); i++ ) {
			if ( m_elements.get( i ) instanceof Argument ) { // Arguments haben wir ja schon
				continue;
			}

			if ( m_elements.get( i ) instanceof Switch ) {
				Switch s = (Switch)m_elements.get( i );

				line += "[/" + s.getName() + "] ";
				desc += s.getName() + "\r\n\t" + s.getDescription();

				if ( s.getDependings() != null ) {
					desc += "\r\n\tDEPENDINGS: ";

					for ( int j = 0; j < s.getDependings().length; j++ ) {
						if ( j > 0 )
							desc += ", ";
						desc += s.getDependings()[j].getName();
					}
				}

				desc += "\r\n\r\n";
			} else if ( m_elements.get( i ) instanceof Option ) {
				Option o = (Option)m_elements.get( i );

				line += o.isMandatory() ? "<" : "[";

				line += "-" + o.getName() + " <" + o.getDescription() + ">";

				line += o.isMandatory() ? ">" : "]";

				desc += o.getName() + "\r\n\t" + o.getLongDescription() + "\r\n";
				if ( o.getPossibleValues() != null ) {
					desc += "\r\n\tPOSSIBLE VALUES: <";
					for ( int j = 0; j < o.getPossibleValues().length; j++ ) {
						if ( j > 0 )
							desc += ",";
						desc += o.getPossibleValues()[j];
					}
					desc += ">\r\n";
				}

				if ( o.getDependings() != null ) {
					desc += "\r\n\tDEPENDINGS: ";

					for ( int j = 0; j < o.getDependings().length; j++ ) {
						if ( j > 0 )
							desc += ", ";
						desc += o.getDependings()[j].getName();
					}
				}

				desc += "\r\n";
			}
		}

		// Jetzt noch Line und Details zusammenfügen
		String all = line + "\r\n\r\n" + desc;

		return all.trim();
	}

	/**
	 * Fügt ein Element hinzu
	 * 
	 * @param e
	 */
	public void add( CommandLineElement e ) {
		m_elements.add( e );
	}

	/**
	 * Validiert das Args-Array. Wenn es nicht passt, dann wird false zurückgegeben. Außerdem werden
	 * die internen Objekte mit den entsprechenden Werten aus args[] belegt.
	 * 
	 * @param args
	 * @return true, wenn das übergebene Array von der Form gut ist, false wenn nicht.
	 */
	public boolean validate( String args[] ) {
		// Erst prüfen, ob alle Arguments da sind.
		Argument arguments[] = getArguments();
		if ( args.length < arguments.length ) {
			return false;
		}
		for ( int i = 0; i < arguments.length; i++ ) {

			if ( args[i].startsWith( "-" ) || args[i].startsWith( "/" ) ) {
				return false;
			}

			Argument arg = arguments[i];
			boolean ok = false;
			if ( arg.getPossibleValues() != null ) {
				for ( int j = 0; j < arg.getPossibleValues().length; j++ ) {

					if ( arg.getPossibleValues()[j].equalsIgnoreCase( args[i] ) ) {
						ok = true;
						arg.setValue( args[i] ); // Wert setzen
						break;
					}
				}
				if ( !ok ) {
					return false;
				}
			} else {
				// Direkt den Wert setzen
				arg.setValue( args[i] );
			}

			// Hab ich nen speziellen Typ gesetzt? Dann das prüfen
			if ( arg.getValueType() != ValueType.UNDEFINED ) {
				switch (arg.getValueType()) {
				case EXISTING_FILE:
					File f = new File( args[i] );
					if ( !f.exists() || !f.isFile() ) {
						return false;
					}
					break;
				}
			}
		}

		// Argumente sind schonmal da. Jetzt prüfen, ob mandatory Options da sind und ob vorgegebene
		// Werte eingehalten wurden.
		Option options[] = getOptions();
		for ( int i = 0; i < options.length; i++ ) {
			// Option o = findOption( options[i].getName(), args );
			String value = findOption( options[i].getName(), args );

			// Auf Mandatory prüfen
			if ( options[i].isMandatory() && value == null ) {
				return false;

			} else if ( value != null ) {
				// vorgegebene Werte prüfen
				if ( options[i].getPossibleValues() != null ) {
					String[] possibleValues = options[i].getPossibleValues();

					// Option o = findOption( options[i].getName(), args );
					boolean ok = false;
					for ( int j = 0; j < possibleValues.length && value != null; j++ ) {
						if ( possibleValues[j].equalsIgnoreCase( value ) ) {
							options[i].setValue( value );
							ok = true;
							break;
						}
					}

					if ( !ok )
						return false;
				} else {
					options[i].setValue( value );
				}

				// Hab ich nen speziellen Typ gesetzt? Dann das prüfen
				if ( options[i].getValueType() != ValueType.UNDEFINED ) {
					switch (options[i].getValueType()) {
					case EXISTING_FILE:
						File f = new File( args[i] );
						if ( !f.exists() || !f.isFile() ) {
							return false;
						}
						break;
					}
				}
			} else {
				// Value == null also standardValue setzen
				options[i].setValue( options[i].getStandardValue() );
			}
		}

		// Jetzt von jedem Element die Dependings checken
		for ( int i = 0; i < m_elements.size(); i++ ) {
			CommandLineElement e = m_elements.get( i );

			if ( e instanceof Argument ) { // Argumente können sowieso keine Dependings haben, also
											// direkt weiter in der Schleife
				continue;
			}

			// Jetzt prüfen, ob das Element überhaupt in args vorkommt
			if ( !containsElement( e.getName(), args ) ) {
				// Wenns nicht vorkommt, dann muss auch nicht auf Dependings geprüft werden
				continue;
			}

			CommandLineElement[] dependings = e.getDependings();

			if ( dependings != null ) {
				for ( int j = 0; j < dependings.length; j++ ) {
					// Für jedes Depending prüfen, ob es eine Option oder Switch mit dem Namen in
					// args gibt
					boolean b = containsElement( dependings[j].getName(), args );

					if ( !b ) {
						// Wenn check jetzt noch null ist, dann fehlt ein Depending
						return false;
					}
				}
			}

		}

		// Switches sind immer optional, können also beim Validieren ignoriert werden, müssen aber
		// im Objekt gesetzt werden
		// der Kommandozeile entsprechend
		Switch switches[] = getSwitches();
		for ( int i = 0; i < switches.length; i++ ) {
			switches[i].setValue( findSwitch( switches[i].getName(), args ) );
		}

		return true;
	}

	/**
	 * Sucht die Option mit dem übergebenen Namen im args Array und gibt deren Wert (falls
	 * vorhanden) zurück.
	 * 
	 * @param name Name der Option - wie sie auch im Objekt verankert wurde
	 * @param args args Array
	 * @return Wert der Option, null wenn sie nicht gefunden wurde oder keinen Wert hat
	 */
	public String findOption( String name, String args[] ) {
		for ( int i = 0; i < args.length; i++ ) {
			if ( args[i].equalsIgnoreCase( "-" + name ) ) {
				// Option Key gefunden
				if ( i + 1 >= args.length ) { // Letztes Element
					return null;
				} else {
					String value = args[i + 1];
					if ( !value.startsWith( "-" ) && !value.startsWith( "/" ) ) {
						return value;
					}
				}
			}
		}
		return null; // Wenn ich hier her komme, dann wurde die Option nicht gefunden
	}

	/**
	 * Sucht die Switch mit dem übergebenen Nanmen im args Array und gibt zurück, ob sie da ist oder
	 * nicht. (Switch bsp: /n)
	 * 
	 * @param name Name der gesuchten Swuitch - wie sie auch im Objekt varnkert wurde
	 * @param args args Array
	 * @return true, wenn die Switch vorhanden ist, false wenn nicht
	 */
	public boolean findSwitch( String name, String args[] ) {
		for ( int i = 0; i < args.length; i++ ) {
			if ( args[i].equalsIgnoreCase( "/" + name ) ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Diese Funktion sucht das Argument mit dem übergebenen Namen (aus m_elements) aus dem args
	 * Array und gibt dessen Wert zurück. Da ein Argument innerhalb der Kommandozeile keinen Namen
	 * trägt sondern nur eine Reihenfolge hat, muss bei dieser Methode
	 * zuerst ausgelesen werden, an welcher Stelle das Argument steht und dann der entsprechende
	 * Wert zurückgegeben.
	 * 
	 * @param name Name des Arguments - wie es auch im Objekt verankert wurde
	 * @param args args Array
	 * @return Wert des Arguments oder null, wenn es nicht gefunden wurde
	 */
	public String findArgument( String name, String args[] ) {
		Argument arguments[] = getArguments();
		for ( int i = 0; i < arguments.length; i++ ) {
			if ( arguments[i].getName().equalsIgnoreCase( name ) ) {
				return findArgument( i, args );
			}
		}
		return null;
	}

	/**
	 * Findet das Argument mit dem angegebenen Index im args Array. Bei dieser Funktion ist es egal,
	 * welcher Typ von CommandlineElement an dieser Stelle steht. Es wird einfach diese Eintrag
	 * zurückgegeben
	 * 
	 * @param index Index des gesuchten Arguments im args Array
	 * @param args args Array
	 * @return
	 */
	public String findArgument( int index, String args[] ) {
		if ( index < args.length ) {
			return args[index];
		}
		return null;
	}

	/**
	 * Sucht im args Array nach dem Element mit dem übergebenen Namen
	 * 
	 * @param name
	 * @param args
	 * @return
	 */
	public boolean containsElement( String name, String args[] ) {
		// Prüfen, ob es ein Argument mit diesem Namen gibt
		String s = findArgument( name, args );
		if ( s != null ) {
			return true;
		}

		s = findOption( name, args );
		if ( s != null ) {
			return true;
		}

		boolean b = findSwitch( name, args );

		return b;
	}

}
