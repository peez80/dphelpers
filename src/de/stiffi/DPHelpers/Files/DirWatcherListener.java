package de.stiffi.DPHelpers.Files;

import java.io.File;

public interface DirWatcherListener {

	/**
	 * Wird aufgerufen, wenn eine neue Datei als komplett erkannt wird.
	 * 
	 * @param file
	 */
	public void newFileAdded( File file );

	/**
	 * Wird aufgerufen, wenn eine vorher existierende Datei entfernt wurde.
	 * 
	 * @param file
	 */
	public void existingFileRemoved( File file );

	/**
	 * Wird aufgerufen, wenn eine Datei das erste mal als neu erkannt wird. Wenn sie sich die
	 * festgelegte Zeit nicht ändert, wird danach {@link #newFileAdded(File)} aufgerufen und die
	 * Datei kann als fertig existent angesehen werden.
	 * 
	 * @param file
	 */
	public void newFileChanging( File file );

	/**
	 * Wird aufgerufen, wenn eine bereits als komplett erkannte Datei anfängt sich zu ändern. Ist
	 * die Änderung fertig, wird {@link #existingFileFinished(File)} aufgerufen.
	 * 
	 * @param file
	 */
	public void existingFileChanging( File file );

	/**
	 * Wird aufgerufen, nachdem eine bereits zuvor als komplett erkannte Datei sich wieder geändert
	 * hat und das jetzt die eingestellte Zeit nicht mehr tut. jetzt kann die Datei wieder als komplett angesehen werden.
	 * 
	 * @param file
	 */
	public void existingFileFinished( File file );
	
	/**
	 * Wird vor jeder relevanten Aktion aufgerufen, um einen Heartbeat zu realisieren und damit zu bestätigen, dass das System noch aktiv ist und sich nicht aufgehängt hat
	 */
	public void heartBeat();
}
