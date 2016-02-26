package de.stiffi.DPHelpers.businessobject.interfaces;

import java.util.Date;

/**
 * Interface das markiert, dass ein Businessobjekt bei einer Änderung bzw. Erstellung mit einem
 * Timestamp markierbar ist.
 * <p>
 * Außerdem werden von diesem Interface die Methoden bereitgestellt, um die Timestamp-Felder zu
 * füllen bzw. auszulesen.
 * 
 * @author peez
 * 
 */
public interface TimestampMarkableCreate {

	/**
	 * Speichert den Timestamp des erstell-Datums des Businessobjekts
	 * 
	 * @param c
	 */
	public void setTimestampCreated( Date c );

	/**
	 * Gibt das Erstelldatum des Businessobjekts zurück
	 * 
	 * @return
	 */
	public Date getTimestampCreated();
}
