package de.stiffi.DPHelpers;

import java.util.Vector;

/**
 * Diese Klasse verknüpft Key - Value Paare. Im Unterschid zu den Klassen aus java.util kann diese
 * Klasse mehrere gleiche Keys besitzen.
 * 
 * 
 * ACHTUNG!! Noch nicht getestet!
 * 
 * @version 14.04.2009
 * 
 * @author HD-Authoring
 *
 * @param <K>
 * @param <V>
 */
public class MultipleMap<K, V> {

	/**
	 * Hier werden die Einträge gespeichert
	 */
	private Vector<Entry<K, V>> m_entries;

	/**
	 * Konstruktor
	 */
	public MultipleMap() {
		init();
	}

	/**
	 * Führt erste Initialisierungen durch
	 */
	private void init() {
		m_entries = new Vector<Entry<K, V>>();
	}

	/**
	 * Objekte dieser Klasse repräsentieren je einen Eintrag der MultipleMap. sie haben einen Key und einen Value
	 * 
	 * @author HD-Authoring
	 *
	 * @param <K>
	 * @param <V>
	 */
	private class Entry<K, V> {

		private K key;

		private V value;

		public Entry( K key, V value ) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}

	/**
	 * Speichert ein key - value Paar in der MultipleMap.
	 * 
	 * 
	 * @param key
	 * @param value
	 */
	public void put( K key, V value ) {
		Entry<K, V> e = new Entry<K, V>( key, value );
		m_entries.add( e );
	}

	/**
	 * Gibt alle Values zum übergebenen Key in einem Vector zurück
	 * @param key
	 * @return Vector mit allen gefundenen Values, null wenn der Key nicht existiert
	 */
	public Vector<V> getValues( K key ) {

		Vector<V> values = new Vector<V>();

		for ( int i = 0; i < m_entries.size(); i++ ) {
			if ( m_entries.get( i ).getKey().equals( key ) ) {
				values.add( m_entries.get( i ).getValue() );
			}
		}

		if ( values.size() == 0 ) {
			return null;
		} else {
			return values;
		}
	}

	/**
	 * Gibt den ersten Value der zum übergebenen Key gefunden wird, zurück
	 * 
	 * @param key
	 * @return Erster Value zum übergebenen Key, null wenn der Key nicht in der MultipleMap existiert
	 */
	public V getValue( K key ) {

		for ( int i = 0; i < m_entries.size(); i++ ) {
			if ( m_entries.get( i ).getKey().equals( key ) ) {
				return (V)m_entries.get( i );
			}
		}

		return null;
	}

	/**
	 * Entfernt alle vorhandenen Wertepaare mit dem übergebenen Key und Value aus der MultipleMap
	 * 
	 * @param key
	 * @param value
	 */
	public void remove( K key, V value ) {
		for ( int i = 0; i < m_entries.size(); i++ ) {
			if ( m_entries.get( i ).getKey().equals( key ) && m_entries.get( i ).getValue().equals( value ) ) {
				m_entries.remove( i );
				i--;
			}
		}
	}

	/**
	 * Entfernt alle Einträge mit dem übergebenen Key aus der MultipleMap
	 * @param key
	 */
	public void remove( K key ) {
		while (containsKey( key )) {
			for ( int i = 0; i < m_entries.size(); i++ ) {
				if (m_entries.get(i).getKey().equals(key)) {
					m_entries.remove( i );
					break;
				}
			}
		}
	}

	/**
	 * Sagt aus, ob ein Wertepaar mit dem übergebenen Key in der MultipleMap existiert
	 * 
	 * @param key
	 * @return
	 */
	public boolean containsKey( K key ) {
		for ( int i = 0; i < m_entries.size(); i++ ) {
			if ( m_entries.get( i ).getKey().equals( key ) ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sagt aus, ob ein Wertepaar mit dem übergebenen Value in der MultipleMap existiert
	 * @param value
	 * @return
	 */
	public boolean containsValue( V value ) {
		for ( int i = 0; i < m_entries.size(); i++ ) {
			if ( m_entries.get( i ).getValue().equals( value ) ) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sagt aus ob ein Wertepaar mit dem übergebenen Key und Value bereits in der MultipleMap existiert.
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean contains(K key, V value) {
		for (int i=0; i<m_entries.size(); i++) {
			if (m_entries.get(i).getValue().equals(value) && m_entries.get(i).getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}
}
