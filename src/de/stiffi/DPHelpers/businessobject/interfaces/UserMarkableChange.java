package de.stiffi.DPHelpers.businessobject.interfaces;

/**
 * Interface das markiert, dass bei �nderung / Erstellung der jeweilige Benutzername gespeichert
 * wird.
 * 
 * @author peez
 * 
 * @param <T> Da hier in manchen Umgebungen Strings als Username oder Integers als Benutzer-IDs
 *            gespeichert werden m�ssen, kann das hier definiert werden.
 */
public interface UserMarkableChange<T> {

	/**
	 * Speichert den Benutzer, der das Businessobjekt �ndert
	 * 
	 * @param userId
	 */
	public void setUserChanged( T userId );

	/**
	 * Gibt den Benutzer zur�ck, der das Businessobjekt das letzte mal ge�ndert hat.
	 * 
	 * @return
	 */
	public T getUserChanged();

}
