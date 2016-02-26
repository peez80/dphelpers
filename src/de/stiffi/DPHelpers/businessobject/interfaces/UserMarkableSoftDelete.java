package de.stiffi.DPHelpers.businessobject.interfaces;

public interface UserMarkableSoftDelete<V> {

	/**
	 * Speichert den Benutzer, der das Businessobjekt ändert
	 * 
	 * @param userId
	 */
	public void setUserDeleted( V userId );

	/**
	 * Gibt den Benutzer zurück, der das Businessobjekt das letzte mal geändert hat.
	 * 
	 * @return
	 */
	public V getUserDeleted();
}
