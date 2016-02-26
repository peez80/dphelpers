package de.stiffi.DPHelpers.CharsetDetector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Diese Klasse dient dazu, aus einem Dateiinhalt ein Charset zu erraten. Leider gibt es keine wirklich sicheren Anzeichen, um eine Codierung hundertprozentig zu bestimmen. Diese Klasse funktioniert allerdings relativ gut. Je länger die Datei ist, desto
 * zuverlässiger wird die Bestimmung.
 * 
 * @author HD-Authoring
 * 
 */
public class CharsetDetector {

	/**
	 * Errät die Kodierung der übergebenen Datei. Merke: Je länger die Datei, desto zuverlässiger die Bestimmung.
	 * 
	 * @param f Datei, die bestimmt werden soll
	 * @return Charset Objekt passend zur gefundenen Codierung oder null bei einem Fehler
	 */
	public static Charset detect( File f ) {
		int bufferLength = (int)f.length();
		if ( bufferLength > 2097152 ) {
			bufferLength = 2097152;
		}

		try {
			Charset charset = CharsetToolkit.guessEncoding( f, bufferLength );

			return charset;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
