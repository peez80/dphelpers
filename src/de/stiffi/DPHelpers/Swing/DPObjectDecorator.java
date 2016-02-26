package de.stiffi.DPHelpers.Swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.stiffi.DPHelpers.ReflectionHelper;

/**
 * Dieser Decorator kann auf alle JComponents angewandt werden. Er sorgt dafür, dass Components
 * automatisch anhand eines Objektes aktualisiert bzw. ein Objekt anhand der Inhalte der Components
 * aktualisiert wird. <br/>
 * Um den Comonent vorzubereiten muss zuvor der Component mit
 * {@link DPObjectDecorator#prepareComponent(JComponent, String)} vorbereitet werden und der Name
 * der Membervariable, auf die sich der Component bezieht angegeben werden.
 * 
 * Benutzung - ich habe bspw. ein JPanel:
 * <p>
 * JPanel panel = new JPanel();<br>
 * DPObjectDecorator<JPanel, BusinessObjectTyp> decorator = new DPObjectDecorator<JPanel,
 * BusinessObjectTyp>(panel);<br>
 * add(decorator);<br>
 * <p>
 * Components müssen dann entsprechend mit {@link #prepareComponent(JComponent, String)} oder {@link #prepareComponent(JComponent, String, Class)} vorbereitet werden.
 * 
 * Analog zur {@link JScrollPane}
 * 
 * @author peez
 * 
 * @param <T> Klasse des Components, der dekoriert wird.
 * @param <V> Klasse des BusinessObjects mit dessen Daten die Componenten innerhalb des Decorators
 *            arbeiten
 */
public class DPObjectDecorator<T extends JComponent, V> extends Container {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8168618506860786567L;

	/**
	 * Logger
	 */
	private Logger log;

	/**
	 * JComponent, der dekoriert wird
	 */
	private T container;

	/**
	 * Konstruktor
	 * 
	 * @param container Der zu dekorierende JComponent
	 */
	public DPObjectDecorator( T container ) {
		log = LoggerFactory.getLogger( getClass() );
		this.container = container;
		setLayout( new BorderLayout() );
		add( container, BorderLayout.CENTER );
	}

	/**
	 * Aktualisiert den Component und alle untergeordneten Components, die die entsprechende
	 * ClientProperty gesetzt haben mit den Daten des übergebenen Objekts.
	 * 
	 * @see #prepareComponent(JComponent, String)
	 * @param container
	 * @param o
	 */
	private void updateComponent( Container container, V o ) {
		// Zuerst bei Bedarf den Component an sich updaten, danach rekursiv alle untergeordneten
		if ( container instanceof JComponent ) {
			String propertyValue = (String)( (JComponent)container ).getClientProperty( "DPObjectDecorator.value.name" );
			if ( propertyValue != null ) {
				String valueName = propertyValue.substring( 0, 1 ).toUpperCase() + propertyValue.substring( 1 );
				Class clazz = o.getClass();
				Method getMethod = null;
				try {
					getMethod = clazz.getMethod( "get" + valueName );
				} catch (SecurityException e) {
					log.error( e.getMessage(), e );
				} catch (NoSuchMethodException e) {
					// Nüsch die richtige Methode, noch zur Sicherheit schauen ob ich "is" heiße...
					try {
						getMethod = clazz.getMethod( "is" + valueName );
					} catch (SecurityException e1) {
						log.error( e1.getMessage(), e1 );
					} catch (NoSuchMethodException e1) {
						log.error( e1.getMessage(), e1 );
					}
				}
				if ( getMethod != null ) {
					try {
						Object returnValue = getMethod.invoke( o );
						if ( container instanceof JTextField ) {
							if ( returnValue == null ) {
								returnValue = new String( "" );
							}
							( (JTextField)container ).setText( returnValue.toString() );
						} else if ( container instanceof JPasswordField ) {
							if ( returnValue == null ) {
								returnValue = new String( "" );
							}
							( (JPasswordField)container ).setText( returnValue.toString() );
						} else if ( container instanceof JTextArea ) {
							if ( returnValue == null ) {
								returnValue = new String( "" );
							}
							( (JTextArea)container ).setText( returnValue.toString() );
						} else if ( container instanceof JCheckBox ) {
							if ( returnValue instanceof Boolean ) {
								( (JCheckBox)container ).setSelected( (Boolean)returnValue );
							}
						}
					} catch (IllegalArgumentException e) {
						log.error( e.getMessage(), e );
					} catch (IllegalAccessException e) {
						log.error( e.getMessage(), e );
					} catch (InvocationTargetException e) {
						log.error( e.getMessage(), e );
					}
				}
			}
		}
		// Jetzt alle untergeordneten Components aktualisieren
		for ( Component comp : container.getComponents() ) {
			if ( comp instanceof Container ) {
				updateComponent( (Container)comp, o );
			}
		}
	}

	/**
	 * Aktualisiert alle Components, die im Container dieses Decorators liegen mit dem Objekt.<br>
	 * Allerdings nur in den Components, die die entsprechende Client-Property
	 * "DPObjectDecorator.value.name" gesetzt haben. <br>
	 * Ist diese Property gesetzt, wird per Reflection API der entsprechende Getter aufgerufen und
	 * die Value auf den Component gesetzt
	 * 
	 * @see DPObjectDecorator#prepareComponent(JComponent, String)
	 * @param o
	 */
	public void updateComponents( V o ) {
		clearComponents( true );
		if ( o != null ) {
			updateComponent( container, o );
		}
	}

	/**
	 * Aktualisiert das übergebene Objekt mit den Werten der Components im Container dieses
	 * Decorators.<br />
	 * Allerdings nur mit Daten aus den Components, die die Client-Property
	 * "DPObjectDecorator.value.name" gesetzt haben.
	 * 
	 * @see DPObjectDecorator#prepareComponent(JComponent, String)
	 * @param o
	 */
	public void updateObject( V o ) {
		updateObject( o, container );
	}

	/**
	 * Aktualisiert das übergebene Objekt rekursiv mit den Werten aus dem übergebenen Container.
	 * 
	 * @see DPObjectDecorator#prepareComponent(JComponent, String)
	 * @param o
	 * @param container
	 */
	private void updateObject( V o, Container container ) {
		// Zuerst bei Bedarf den Component an sich updaten, danach rekursiv alle untergeordneten
		if ( container instanceof JComponent ) {
			String propertyValue = (String)( (JComponent)container ).getClientProperty( "DPObjectDecorator.value.name" );
			Class propertyClass = (Class)( (JComponent)container ).getClientProperty( "DPObjectDecorator.value.class" );
			if ( propertyValue != null ) {
				String valueName = propertyValue.substring( 0, 1 ).toUpperCase() + propertyValue.substring( 1 );
				ReflectionHelper<V> refl = new ReflectionHelper<V>( o );
				// Class clazz = o.getClass();
				// Method setMethod = null;
				Object value = null;
				// Zuerst die Value und damit die Klasse der Value rausfinden
				if ( container instanceof JTextField ) {
					value = ( (JTextField)container ).getText();
					// setMethod.invoke( o, value );
				} else if ( container instanceof JPasswordField ) {
					value = new String( ( (JPasswordField)container ).getPassword() );
					// setMethod.invoke( o, value );
				} else if ( container instanceof JTextArea ) {
					value = ( (JTextArea)container ).getText();
					// setMethod.invoke( o, value );
				} else if ( container instanceof JCheckBox ) {
					value = ( (JCheckBox)container ).isSelected();
					// setMethod.invoke( o, value );
				}
				if ( value != null ) {
					Class valueClass = value.getClass();
					if ( propertyClass != null ) {
						// Ich habe explizit eine Klasse für die Property gesetzt, also diesen
						// Setter wählen. Vorausgesetzt ist kann eine derartige Klasse mit meiner
						// derzeitigen Value instantiieren
						try {
							value = (Object)ReflectionHelper.newObject( propertyClass, value );
						} catch (Exception e) {
							// Wenn ein Fehler passiert, dann eben value so lassen.
							log.warn( "Could not Instantiate a new Object for " + propertyValue + " with value " + value.toString() + ". Using value for Object setter." );
						}
					}

					try {
						// Setter aufrufen - je nach klasse wird automatisch der richtige aufgerufen
						refl.invokeSetter( valueName, value );
					} catch (Exception e) {
						log.warn( e.getMessage(), e );
					}

				}
			}
		}
		for ( Component comp : container.getComponents() ) {
			if ( comp instanceof Container ) {
				updateObject( o, (Container)comp );
			}
		}
	}

	/**
	 * Leert rekursiv alle enthaltenen JText-Komponenten und JCheckboxen.
	 */
	public void clearComponents() {
		clearComponents( true );
	}

	/**
	 * Leert rekursiv alle enthaltenen JText-Komponenten und JCheckboxen
	 * 
	 * @param cleanAllComponents wenn true, werden ALLE components geleert, wenn false nur die, die
	 *            die ClientProperty gesetzt haben
	 */
	public void clearComponents( boolean cleanAllComponents ) {
		clearComponent( this.container, cleanAllComponents );
	}

	/**
	 * Leert rekursiv den übergebenen Container
	 * 
	 * @param container
	 * @param cleanAllComponents wenn true, werden ALLE components geleert, wenn false nur die, die
	 *            die ClientProperty gesetzt haben
	 */
	private void clearComponent( Container container, boolean cleanAllComponents ) {
		if ( container instanceof JComponent ) {
			String propertyValue = (String)( (JComponent)container ).getClientProperty( "DPObjectDecorator.value.name" );
			if ( propertyValue != null || cleanAllComponents ) {
				// Component leer machen. Dazu einfach die üblichen setter ausprobieren.
				ReflectionHelper<Container> refl = new ReflectionHelper<Container>( container );
				// Nur vorgesehende Klassen cleanen
				try {
					if ( container instanceof JTextField || container instanceof JTextArea || container instanceof JPasswordField ) {
						refl.invokeSetter( "text", "" );
					} else if ( container instanceof JCheckBox ) {
						refl.invokeSetter( "selected", new Boolean( false ) );
					} else if ( container instanceof JComboBox ) {
						( (JComboBox)container ).setSelectedIndex( 0 );
					} else if ( container instanceof JList ) {
						( (JList)container ).getSelectionModel().clearSelection();
					} else if ( container instanceof JTable ) {
						( (JTable)container ).getSelectionModel().clearSelection();
					}
				} catch (IllegalArgumentException e) {
					log.error( e.getMessage(), e );
				} catch (NoSuchMethodException e) {
					log.error( e.getMessage(), e );
				} catch (IllegalAccessException e) {
					log.error( e.getMessage(), e );
				} catch (InvocationTargetException e) {
					log.error( e.getMessage(), e );
				}
			}
		}
		for ( Component c : container.getComponents() ) {
			if ( c instanceof Container ) {
				clearComponent( (Container)c, cleanAllComponents );
			}
		}
	}

	/**
	 * Gibt den dekorierten Container zurück
	 * 
	 * @return
	 */
	public T getContainer() {
		return container;
	}

	/**
	 * 
	 * @param component
	 * @param valueName
	 */
	public static void prepareComponent( JComponent component, String valueName ) {
		component.putClientProperty( "DPObjectDecorator.value.name", valueName );
	}

	public static void prepareComponent( JComponent component, String valueName, Class<?> valueClazz ) {
		prepareComponent( component, valueName );
		component.putClientProperty( "DPObjectDecorator.value.class", valueClazz );
	}

	public void setEnabled( boolean componentsEnabled, boolean allComponents ) {
		setComponentEnabled( container, componentsEnabled, allComponents );
	}

	/**
	 * Aktiviert / Deaktiviert alle Components rekursiv
	 * 
	 * @param container
	 * @param componentsEnabled
	 * @param allComponents
	 */
	private void setComponentEnabled( Component component, boolean componentsEnabled, boolean allComponents ) {
		// Prüfen ob ich den übergebenen Component bearbeiten darf
		boolean setMe = allComponents;
		if ( component instanceof JComponent ) {
			String propertyValue = (String)( (JComponent)container ).getClientProperty( "DPObjectDecorator.value.name" );
			if ( propertyValue != null ) {
				setMe = true;
			}
		}

		if ( setMe ) {
			component.setEnabled( componentsEnabled );
		}

		// Jetzt rekursiv alle enthaltenen
		if ( component instanceof Container ) {
			Component[] components = ( (Container)component ).getComponents();

			for ( Component comp : components ) {
				setComponentEnabled( comp, componentsEnabled, allComponents );
			}
		}
	}

	@Override
	public void setEnabled( boolean b ) {
		setEnabled( b, true );
	}
}
