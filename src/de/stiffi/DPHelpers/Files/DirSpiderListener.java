package de.stiffi.DPHelpers.Files;

import java.io.File;

/**
 * Es gibt zwei Methoden, eine DirSpider mit Leben zu füllen. Nr. 1 ist, ein eigenständiges Objekt zu erstellen, das dann
 * die entsprechenden Aktionen ausführt.
 * Nr. 2 ist, einer DirSpider einen oder mehrere Listener anzuhängen, welche dann die Aktionen durchführen.
 * 
 * @author HD-Authoring
 *
 */
public interface DirSpiderListener {
	/**
	 * Wird aufgerufen, wenn die Spider ein Verzeichnis "betritt".
	 * 
	 * @param directory Verzeichnis, das betreten wurde
	 * @param source betroffene DirSpider
	 */
	public void enterDir(File directory, DirSpider source);
	/**
	 * Wird aufgerufen, wenn die Spider ein Verzeichnis "verlässt".
	 * 
	 * @param directory Verzeichnis, das verlassen wurde
	 * @param source betroffene DirSpider
	 */
	public void leaveDir(File directory, DirSpider source);
	
	/**
	 * Wird aufgerufen, wenn die DirSpider ein Verzeichnis gefunden hat.
	 * 
	 * @param directory Verzeichnis, das gefunden wurde
	 * @param source betroffene DirSpider
	 */
	public void handleDir(File directory, DirSpider source);
	
	/**
	 * Wird aufgerufen, wenn die DirSpider eine Datei gefunden hat.
	 * 
	 * @param file Datei, die gefunden wurde
	 * @param source betroffene DirSpider
	 */
	public void handleFile(File file, DirSpider source);	
}
