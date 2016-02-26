package de.stiffi.DPHelpers.businessobject.interfaces;

import java.util.Date;

public interface TimestampMarkableChange {

	/**
	 * Speichert den Timestamp der letzten �nderung des Businessobjekts
	 * 
	 * @param c
	 */
	public void setTimestampChanged( Date c );

	/**
	 * Gibt das Datum der letzten �nderung des Businessobjekts zur�ck
	 * 
	 * @return
	 */
	public Date getTimestampChanged();

}
