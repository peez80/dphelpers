package de.stiffi.DPHelpers.businessobject.interfaces;

import java.io.Serializable;

/**
 * Implementierende Klassen bedeuten, dass sie ein BusinessObjekt sind und demnach einen Wert "ID"
 * haben.
 * 
 * @author peez
 * 
 * @param <T> Datentyp des Prim�rschl�ssels
 */
public interface BusinessObject<T> extends Serializable {

	/**
	 * Gibt die Id des BusinessObjects zur�ck
	 * 
	 * @return
	 */
	public T getId();
}
