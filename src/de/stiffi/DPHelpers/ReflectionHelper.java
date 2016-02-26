package de.stiffi.DPHelpers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse bietet einige Hilfs-Methoden an um auf relativ einfache Weise die Reflection API zu
 * nutzen.
 * 
 * @author peez
 * 
 * @param <T> Klasse, die reflektiert wird.
 */
public class ReflectionHelper<T> {

	/**
	 * Das Objekt auf dem die Methoden aufgerufen werden
	 */
	private T object;

	/**
	 * Die Klasse, die das Objekt {@link #object} besitzt
	 */
	private Class clazz;

	/**
	 * Konstruktor.<br>
	 * Erstellt den ReflectionHelper
	 * 
	 * @param object Objekt, das reflektiert wird
	 */
	public ReflectionHelper( T object ) {
		setObject( object );
	}

	/**
	 * Gibt diene Liste mit allen verfügbaren Methoden mit dem übergebenen Namen zurück.
	 * 
	 * @param name Name der Methoden die gefunden werden sollen
	 * @return
	 */
	public List<Method> getMethodsByName( String name ) {
		List<Method> methodList = new ArrayList<Method>();
		Method[] methods = object.getClass().getMethods();

		for ( Method m : methods ) {
			if ( m.getName().equalsIgnoreCase( name ) ) {
				methodList.add( m );
			}
		}
		return methodList;
	}

	/**
	 * Erstellt eine neue Instanz der übergebenen Klasse mit einem leeren Konstruktor
	 * 
	 * @param <T>
	 * @param clazz Klasse die Instantiiert wird
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static <T> T newObject( Class<T> clazz ) throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException,
			InvocationTargetException {
		return newObject( clazz, new Object[0] );
	}

	/**
	 * Erstellt eine neue Instanz der übergebenen Klasse, indem der zu den initargs passende
	 * Konstruktor aufgerufen wird.
	 * 
	 * @param <T>
	 * @param clazz Klasse die Instantiiert wird
	 * @param initargs Argumente, die dem Konstruktor übergeben werden
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static <T> T newObject( Class<T> clazz, Object... initargs ) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException,
			IllegalAccessException, InvocationTargetException {

		if ( initargs == null ) {
			initargs = new Object[0];
		}

		Class[] parameterTypes = new Class[initargs.length];
		for ( int i = 0; i < initargs.length; i++ ) {
			parameterTypes[i] = initargs[i].getClass();
		}
		Constructor<T> constructor = clazz.getConstructor( parameterTypes );
		T newInstance = constructor.newInstance( initargs );
		return newInstance;
	}

	/**
	 * Gibt den Getter der übergebenen Klassenvariable zurück.
	 * <p>
	 * Beispiel: <code>
	 * class EineKlasse {
	 * 	private String memberVariable;
	 * 
	 * 	public String getMemberVariable() {
	 * 		return memberVariable;
	 * 	}
	 * }
	 * </code>
	 * <p>
	 * jetzt muss getGetter("memberVariable"); aufgerufen werden, um den Getter zu bekommen.
	 * 
	 * @param memberName
	 * @return
	 * @throws NoSuchMethodException
	 */
	public Method getGetter( String memberName ) throws NoSuchMethodException {
		// Achtung! Beim getter könnts auch "is" heißen
		String getter = "get" + memberName.substring( 0, 1 ).toUpperCase() + memberName.substring( 1 );
		Method method = null;
		try {
			method = clazz.getMethod( getter );
		} catch (SecurityException e) {
			throw e;
		} catch (NoSuchMethodException e) {
			// "get" gibts nicht, schauen obs ein "is" gibt...
			String getterIs = "is" + memberName.substring( 0, 1 ).toUpperCase() + memberName.substring( 1 );
			try {
				method = clazz.getMethod( getterIs );
			} catch (SecurityException e1) {
				throw e;
			} catch (NoSuchMethodException e1) {
				throw new NoSuchMethodException( "Neither Method " + getter + "() nor " + getterIs + "() available on Object " + clazz.getName() );
			}
		}

		return method;
	}

	/**
	 * Ruft den Getter fr die übergebene Membervariable auf.<br>
	 * Details siehe Beschreibung von {@link #getGetter(String)}
	 */
	public Object invokeGetter( String memberName ) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		Method method = getGetter( memberName );
		Object value = method.invoke( object );
		return value;
	}

	/**
	 * Gibt alle verfügbaren Setter für die übergebene Membervariable zurück
	 * 
	 * @param memberName
	 * @return
	 */
	public List<Method> getSetters( String memberName ) {
		List<Method> methodList = new ArrayList<Method>();

		String setter = "set" + memberName.substring( 0, 1 ).toUpperCase() + memberName.substring( 1 );

		Method[] methods = clazz.getMethods();
		for ( Method method : methods ) {
			if ( method.getName().equals( setter ) ) {
				methodList.add( method );
			}
		}
		return methodList;
	}

	/**
	 * Gibt alle (public, protected und private) Fields dieser Klasse zurück
	 * 
	 * @return
	 */
	public Field[] getDeclaredFields() {
		return clazz.getDeclaredFields();
	}
	
	/**
	 * Gibt alle erreichbaren Fields dieser Klasse zurück. D.h. meistens public
	 * @return
	 */
	public Field[] getFields() {
		return clazz.getFields();
	}

	/**
	 * Gibt das Feld mit dem übergebenen Namen zurück.
	 * 
	 * @param name
	 * @return Feld mit dem übergebenen Namen, null wenn das Feld nciht existiert
	 */
	public Field getField( String name ) {
		Field[] fields = getDeclaredFields();
		for ( Field f : fields ) {
			if ( f.getName().equals( name ) ) {
				return f;
			}
		}
		return null;
	}

	public Object getFieldValue( String fieldName ) throws IllegalArgumentException, IllegalAccessException {
		Field f = getField( fieldName );
		if ( f == null ) {
			throw new IllegalArgumentException( "Field not found" );
		}
		return f.get( object );
	}

	public Class<?> getFieldType( String fieldName ) throws IllegalArgumentException {
		Field f = getField( fieldName );
		if ( f == null ) {
			throw new IllegalArgumentException( "Field not found" );
		}
		return f.getType();
	}

	public void setFieldValue( String fieldName, Object value ) throws IllegalArgumentException, IllegalAccessException {
		Field f = getField( fieldName );
		if ( f == null ) {
			throw new IllegalArgumentException( "Field not found" );
		}
		f.set( object, value );
	}

	/**
	 * Gibt den Setter für die übergebene Membervariable zruück, der als Parameter den übergebenen
	 * ParameterTyp hat.
	 * 
	 * @param memberName
	 * @param parameterType
	 * @return
	 */
	public Method getSetter( String memberName, Class parameterType ) {
		List<Method> methods = getSetters( memberName );
		for ( Method method : methods ) {
			if ( method.getParameterTypes().length == 1 ) {
				if ( method.getParameterTypes()[0].isAssignableFrom( parameterType ) ) {
					return method;
				}
			}
		}
		return null;
	}

	public boolean hasSetter( String memberName, Class parameterType ) {
		return getSetter( memberName, parameterType ) != null;
	}

	/**
	 * ACHTUNG! NOCH NICHT GETESTET! Gibt die Methode mit dem übergebenen Namen und Parametertypen
	 * zurück.
	 * 
	 * 
	 * @param methodName Name der Methode
	 * @param parameterTypes Klassen der Parameter
	 * @return Gefundene Methode oder null, wenn die Methode nicht existiert
	 */
	public Method getMethod( String methodName, Class... parameterTypes ) {
		Method[] methods = clazz.getMethods();

		for ( Method method : methods ) {
			// Name gleich?
			if ( !method.getName().equals( methodName ) ) {
				continue;
			}

			// Anzahl parameter gleich?
			if ( method.getParameterTypes().length != parameterTypes.length ) {
				continue;
			}

			// Parameter gleich?
			for ( int i = 0; i < parameterTypes.length; i++ ) {
				if ( !parameterTypes[i].equals( method.getParameterTypes()[i] ) ) {
					continue;
				}
			}

			// Wenn ich bis hier hin gekommen bin, gibts die Methode!
			return method;
		}
		return null;
	}

	/**
	 * Führt den Setter aus
	 * 
	 * @param memberName
	 * @param value
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public void invokeSetter( String memberName, Object value ) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method setter = getSetter( memberName, value.getClass() );
		if ( setter == null ) {
			throw new NoSuchMethodException( "No Setter for Member " + memberName + " and Parameter-Type " + value.getClass().getName() + " found." );
		}

		setter.invoke( object, value );
	}

	/**
	 * Gibt das Objekt zurück, das reflektiert wird.
	 * 
	 * @return
	 */
	public T getObject() {
		return object;
	}

	/**
	 * Legt das Objekt fest, das reflektiert wird.
	 * 
	 * @param object
	 */
	public void setObject( T object ) {
		this.object = object;
		this.clazz = object.getClass();
	}
}
