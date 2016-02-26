package de.stiffi.DPHelpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CacheMap<K, V> implements Map<K, V> {

	/**
	 * Elemente dieser Klasse werden in der Hashtable {@link CacheMap#data} gespeichert u. geben die
	 * Daten zurück
	 * 
	 * 
	 * @author peez
	 * 
	 */
	private class CacheEntry {

		/**
		 * Dieser Timestamp (+{@link #cacheExpirationTime})wird zur Prüfung auf "alt" verwendet
		 */
		public long timestamp;

		/**
		 * Zeit in Millisekunden bis ein Eintrag als alt angesehen wird. Wenn 0 dann ist der Cache
		 * unendlich gültig
		 */
		public long cacheExpirationTime;

		/**
		 * Key des Eintrags. Ist der selbe wie der Key in {@link CacheMap#data}
		 */
		public K key;

		/**
		 * Wert des Cache Eintrags
		 */
		public V value;

		/**
		 * Gibt zurück, ob dieser Cache-Eintrag noch gültig ist oder die
		 * Cache-Zeit bereits abgelaufen ist.<br>
		 * ACHTUNG! Eine ms danach kann dieser Wert bereits false sein!
		 * 
		 * @return true wenn der Eintrag gültig ist, false falls nicht.
		 */
		public boolean isValid() {
			return ( cacheExpirationTime == 0 || System.currentTimeMillis() < timestamp + cacheExpirationTime );
		}
	}

	/**
	 * Hier werden die Daten gehalten.
	 */
	private Hashtable<K, CacheEntry> data;

	/**
	 * Standard Cache Dauer wenn bei put keine mitgegeben wurde.
	 */
	private long defaultCacheTime = 1000l;

	/**
	 * Wenn true, dann wird der Timestamp eines Eintrags bei jeder Anfrage auf den aktuellen Wert
	 * gesetzt.
	 * Dadurch kann z.B. ein Objekt über längere Zeit (länger als die eingestellte Cache-Time)
	 * valide bleiben, wenn es mehrmals kurz hintereinander angefragt wird.
	 */
	private boolean updateTimestampOnTouch = false;

	/**
	 * In diesem Abstand (Millisekunden) wird der komplette Cache-Speicher komplett aufgeräumt.
	 * Wenn der Wert 0 ist, wird nie aufgeräumt.<br />
	 * Hierfür wird kein eigener Thread gestartet. Das Aufräumen passiert dann nur bei einer
	 * aufgerufenen
	 * Methode.
	 */
	private long forceClearInterval = 0;

	/**
	 * Zeitpunkt wann der Cache das letzte mal komplett geleert wurde
	 */
	private long lastCacheClearTimestamp = 0;

	/**
	 * Wenn true, wird das Caching generell abgeschalten, d.h. bei put-Operationen werden keine
	 * Elemente gespeichert und bei get immer null zurückgegeben.
	 * Auf diese Weise lässt sich der Cache ausschalten.
	 */
	private boolean cacheDisabled = false;

	public CacheMap() {
		__initCacheMap();
	}

	private void __initCacheMap() {
		data = new Hashtable<K, CacheEntry>();
	}

	@Override
	public int size() {
		clearCacheIfExpired();
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		clearCacheIfExpired();
		return data.isEmpty();
	}

	@Override
	public boolean containsKey( Object key ) {
		clearCacheIfExpired( key );

		if ( isCacheDisabled() ) {
			// Kein Caching, keine Elemente
			return false;
		}

		return data.containsKey( key );
	}

	/**
	 * Leert für den übergebenen Key den Cache falls dieser abgelaufen ist.
	 * Muss üblicherweise nicht manuell aufgerufen werden, da die Klasse sich selbst verwaltet.
	 * 
	 * @param key
	 */
	public void clearCacheIfExpired( Object key ) {
		CacheEntry entry = data.get( key );
		if ( entry != null ) {
			if ( !entry.isValid() ) {
				// Cache expired!
				data.remove( key );
			}
		}
	}

	/**
	 * Leert für die komplette Map die Einträge falls die Cache-Zeit abgelaufen ist.
	 * Muss üblicherweise nicht manuell aufgerufen werden, da die Klasse sich selbst verwaltet.
	 */
	public void clearCacheIfExpired() {
		Enumeration<K> keys = data.keys();
		while (keys.hasMoreElements()) {
			clearCacheIfExpired( keys.nextElement() );
		}
		lastCacheClearTimestamp = System.currentTimeMillis();
	}

	/**
	 * Gibt zurück ob das Element mit dem übergebenen Key im Cache liegt bzw. ob die Cache-Zeit noch
	 * gültig ist.
	 * <p>
	 * ACHTUNG! Dies sollte nicht im Programmablauf genutzt werden wenn sicher sein muss, dass
	 * dieser Wert auch nach dem Aufruf korrekt ist. Eine Millisekunde danach kann der Wert z.B.
	 * schon nicht mehr im Cache sein u. ein {@link #get(Object)} null zurückliefern.<br>
	 * Für diese kritische überprüfung sollte immer get() verwendet werden und dann auf dem
	 * zurückgelieferten Wert gearbeitet werden.
	 * 
	 * @param key
	 * @return
	 */
	public boolean isInCache( Object key ) {
		clearCacheIfExpired( key );

		if ( isCacheDisabled() ) {
			// Kein Cache, keine Elemente
			return false;
		}

		CacheEntry entry = data.get( key );
		if ( entry == null ) {
			// Kein Element, also bin ich nicht im Cache
			return false;
		} else {
			return ( entry.isValid() );
		}
	}

	@Override
	public boolean containsValue( Object value ) {

		if ( isCacheDisabled() ) {
			// Kein Cache, keine Elemente
			return false;
		}

		Enumeration<CacheEntry> values = data.elements();
		while (values.hasMoreElements()) {
			CacheEntry entry = values.nextElement();
			if ( entry.value.equals( value ) && entry.isValid() ) {
				// Value gefunden
				return true;
			}
		}

		// Value nicht gefunden
		return false;
	}

	@Override
	public V get( Object key ) {

		if ( isCacheDisabled() ) {
			// Kein Cache, keine Elemente
			return null;
		}

		if ( isForceClearIntervalReached() ) {
			clearCacheIfExpired();
		} else {
			clearCacheIfExpired( key );
		}

		if ( !data.containsKey( key ) ) {
			return null;
		} else {
			CacheEntry entry = data.get( key );

			if ( updateTimestampOnTouch ) {
				entry.timestamp = System.currentTimeMillis();
			}
			return entry.value;
		}
	}

	@Override
	public V put( K key, V value ) {

		if ( isCacheDisabled() ) {
			// Kein Cache, keine Elemente
			return null;
		}
		return put( key, value, defaultCacheTime );
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @param cacheExpirationTime Cache-Gültigkeit. Wenn null, dann unendlich
	 * @return
	 */
	public V put( K key, V value, long cacheExpirationTime ) {

		if ( isForceClearIntervalReached() ) {
			clearCacheIfExpired();
		}

		if ( isCacheDisabled() ) {
			// Kein Cache, keine Elemente
			return null;
		}

		CacheEntry entry = new CacheEntry();
		entry.key = key;
		entry.value = value;
		entry.cacheExpirationTime = cacheExpirationTime;
		entry.timestamp = System.currentTimeMillis();

		// Zuerst Alte Value raussuchen, um das lt. Spezi erwartete alte Element zurückzugeben
		V oldValue = null;
		CacheEntry oldEntry = data.get( key );
		if ( oldEntry != null ) {
			oldValue = oldEntry.value;
		}

		// Und jetzt den neuen Wert setzen
		data.put( key, entry );

		return oldValue;
	}

	@Override
	public V remove( Object key ) {
		if ( isForceClearIntervalReached() ) {
			clearCacheIfExpired();
		}

		V oldValue = null;
		CacheEntry oldEntry = data.get( key );
		if ( oldEntry != null ) {
			oldValue = oldEntry.value;
		}
		data.remove( key );
		return oldValue;
	}

	@Override
	public void putAll( Map<? extends K, ? extends V> m ) {
		if ( isCacheDisabled() ) {
			// Kein Cache, keine Elemente
			return;
		}
		putAll( m, defaultCacheTime );
	}

	public void putAll( Map<? extends K, ? extends V> m, long cacheExpirationTime ) {
		if ( isCacheDisabled() ) {
			// Kein Cache, keine Elemente
			return;
		}

		Set<? extends K> keySet = m.keySet();
		Iterator<? extends K> keyIterator = keySet.iterator();

		while (keyIterator.hasNext()) {
			K key = keyIterator.next();
			V value = m.get( key );

			put( key, value, cacheExpirationTime );
		}
	}

	@Override
	public void clear() {
		data.clear();
	}

	@Override
	public Set<K> keySet() {
		if ( isForceClearIntervalReached() ) {
			clearCacheIfExpired();
		}
		if ( isCacheDisabled() ) {
			// Kein Cache, leeres KeySet
			return new HashSet<K>();
		}
		return data.keySet();
	}

	@Override
	public Collection<V> values() {
		if ( isForceClearIntervalReached() ) {
			clearCacheIfExpired();
		}

		Collection<V> values = new ArrayList<V>();

		if ( isCacheDisabled() ) {
			// Kein Cache, leere Collection
			return values;
		}

		Enumeration<CacheEntry> entries = data.elements();
		while (entries.hasMoreElements()) {
			CacheEntry entry = entries.nextElement();
			if ( updateTimestampOnTouch ) {
				entry.timestamp = System.currentTimeMillis();
			}
			values.add( entry.value );
		}
		return values;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO: IMPLEMENT
		throw new UnsupportedOperationException( "Not yet implemented" );
	}

	/**
	 * Gibt zurück, ob das Interval erreicht ist, in dem ein komplettes Aufräumen des Caches
	 * vorgenommen werden soll.
	 * 
	 * @return
	 */
	private boolean isForceClearIntervalReached() {
		return ( lastCacheClearTimestamp > 0 ) && ( System.currentTimeMillis() > lastCacheClearTimestamp + forceClearInterval );
	}

	/**
	 * Gibt die Standarddauer in Millisekunden zurück, nachder ein Cache-Element ungültig wird wenn
	 * bei {@link #put(Object, Object)} keine Zeit angegeben wird.
	 * 
	 * @return Standard Cache Dauer. Wenn null, dann ist der Cache unendlich gültig
	 */
	public long getDefaultCacheTime() {
		return defaultCacheTime;
	}

	/**
	 * Legt die Standarddauer fest, nachdem ein Cache-Element ungültig wird, wenn bei
	 * {@link #put(Object, Object)} keine Zeit angegeben wird.
	 * 
	 * @param defaultCacheTime in Millisekunden - wenn 0 dann bleibt Element unendlich gültig
	 */
	public CacheMap<K, V> setDefaultCacheTime( long defaultCacheTime ) {
		this.defaultCacheTime = defaultCacheTime;
		return this;
	}

	/**
	 * Gibt zurück, ob die Cache-Timeout Zeit weitergesetzt wird, wenn ein Element aus der Map
	 * ausgelesen wird. D.h. es wird der Timestamp des Eintrags beim Auslesen auf den aktuellen Wert
	 * gesetzt.
	 * 
	 * @return
	 */
	public boolean getUpdateTimestampOnTouch() {
		return updateTimestampOnTouch;
	}

	/**
	 * Legt fest ob beim Lesen eines Elements z.B. mit {@link #get(Object)} der Timestamp dieses
	 * Objekts auf die aktuelle Uhrzeit gesetzt wird und somit die Cache-Dauer neu gestartet wird. <br>
	 * Auf diese Weise kann ein Element z.B. längere Zeit (auch länger als die Cache-Dauer) gültig
	 * bleiben, wenn es öfters in kurzen Abständen abgefragt wird.
	 * 
	 * @param updateTimeStampOnTouch
	 */
	public void setUpdateTimestampOnTouch( boolean updateTimeStampOnTouch ) {
		this.updateTimestampOnTouch = updateTimeStampOnTouch;
	}

	/**
	 * In diesem Abstand (Millisekunden) wird der komplette Cache-Speicher komplett aufgeräumt.
	 * Wenn der Wert 0 ist, wird nie aufgeräumt.<br />
	 * Hierfür wird kein eigener Thread gestartet. Das Aufräumen passiert dann nur bei einer
	 * aufgerufenen
	 * Methode.
	 * 
	 * @return Interval in Millisekunden
	 */
	public long getForceClearInterval() {
		return forceClearInterval;
	}

	/**
	 * In diesem Abstand (Millisekunden) wird der komplette Cache-Speicher komplett aufgeräumt.
	 * Wenn der Wert 0 ist, wird nie aufgeräumt.<br />
	 * Hierfür wird kein eigener Thread gestartet. Das Aufräumen passiert dann nur bei einer
	 * aufgerufenen
	 * Methode.
	 * 
	 * @param forceClearInterval Intervall in Millisekunden
	 */
	public void setForceClearInterval( long forceClearInterval ) {
		this.forceClearInterval = forceClearInterval;
	}

	public boolean isCacheDisabled() {
		return cacheDisabled;
	}

	public void setCacheDisabled( boolean cacheDisabled ) {
		this.cacheDisabled = cacheDisabled;
	}
}
