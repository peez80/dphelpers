package de.stiffi.DPHelpers;

import java.util.StringTokenizer;

/**
 * Diese Klasse stellt einige statische Methoden zur Verf�gung, die �fters bei Netzwerkoperationen ben�tigt werden.
 * @author HD-Authoring
 *
 */
public class NetworkHelpers {

	/**
	 * Pr�ft, ob der �bergebene String von der Struktur her eine IPv4 Adresse sein kann
	 * 
	 * @param ip
	 * @return
	 */
	public static boolean isIPAddress( String ip ) {
		StringTokenizer t = new StringTokenizer( ip, ".", false );

		try {
			if ( t.countTokens() != 4 ) {
				return false;
			}

			while (t.hasMoreTokens()) {
				int zahl = Integer.parseInt( t.nextToken() );
				if (zahl > 255) { //Jedes Token der IP Adresse kann max. 255 sein
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
