package de.stiffi.DPHelpers.businessobject.interfaces;

import java.util.Date;

public interface TimestampMarkableChange {

	/**
	 * Speichert den Timestamp der letzten Änderung des Businessobjekts
	 * 
	 * @param c
	 */
	public void setTimestampChanged( Date c );

	/**
	 * Gibt das Datum der letzten Änderung des Businessobjekts zurück
	 * 
	 * @return
	 */
	public Date getTimestampChanged();

}
