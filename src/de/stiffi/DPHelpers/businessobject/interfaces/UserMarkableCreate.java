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
public interface UserMarkableCreate<T> {

	/**
	 * Speichert den Benutzer, der das Businessobjekt erstellt hat
	 * 
	 * @param userId
	 */
	public void setUserCreated( T userId );

	/**
	 * Gibt den Benutzer zur�ck, der das Businessobjekt erstellt hat.
	 * 
	 * @return
	 */
	public T getUserCreated();

}
