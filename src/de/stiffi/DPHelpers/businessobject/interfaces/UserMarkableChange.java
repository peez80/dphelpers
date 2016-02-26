package de.stiffi.DPHelpers.businessobject.interfaces;

/**
 * Interface das markiert, dass bei Änderung / Erstellung der jeweilige Benutzername gespeichert
 * wird.
 * 
 * @author peez
 * 
 * @param <T> Da hier in manchen Umgebungen Strings als Username oder Integers als Benutzer-IDs
 *            gespeichert werden müssen, kann das hier definiert werden.
 */
public interface UserMarkableChange<T> {

	/**
	 * Speichert den Benutzer, der das Businessobjekt ändert
	 * 
	 * @param userId
	 */
	public void setUserChanged( T userId );

	/**
	 * Gibt den Benutzer zurück, der das Businessobjekt das letzte mal geändert hat.
	 * 
	 * @return
	 */
	public T getUserChanged();

}
