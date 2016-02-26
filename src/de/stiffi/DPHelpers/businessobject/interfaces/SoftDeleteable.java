package de.stiffi.DPHelpers.businessobject.interfaces;


/**
 * Interface, das zum einen markiert, dass die implementierende Businessobjekt-Klasse soft-deletable
 * ist.
 * <p>
 * Au�erdem wird die Methode bereitgestellt, um das Businessobjekt Soft zu l�schen
 * 
 * @param <T> Datentyp der verwendet wird, um die BenutzerId bei setDeletedUser zu speichern.
 *            Projektspezifisch kann das unterschiedlich (z.B. String als Benutzername oder Integer
 *            als Benutzer_ID) sein.
 * 
 * @author peez
 * 
 */
public interface SoftDeleteable {

	/**
	 * Legt fest, ob das BusinessObjekt gel�scht ist oder nicht.
	 * 
	 * @param deletedFlag
	 */
	public void setDeleted( boolean deletedFlag );

	/**
	 * Gibt zur�ck, ob das Businessobjekt gel�scht ist.
	 * 
	 * @return
	 */
	public boolean isDeleted();
}
