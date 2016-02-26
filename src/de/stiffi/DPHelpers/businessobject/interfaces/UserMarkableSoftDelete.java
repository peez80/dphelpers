package de.stiffi.DPHelpers.businessobject.interfaces;

public interface UserMarkableSoftDelete<V> {

	/**
	 * Speichert den Benutzer, der das Businessobjekt �ndert
	 * 
	 * @param userId
	 */
	public void setUserDeleted( V userId );

	/**
	 * Gibt den Benutzer zur�ck, der das Businessobjekt das letzte mal ge�ndert hat.
	 * 
	 * @return
	 */
	public V getUserDeleted();
}
