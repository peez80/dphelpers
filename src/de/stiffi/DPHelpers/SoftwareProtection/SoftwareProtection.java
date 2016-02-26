package de.stiffi.DPHelpers.SoftwareProtection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import de.stiffi.DPHelpers.Files.Files;

/**
 * Diese Klasse stellt einige Funktionen bereit, die im Zusammenhang mit dem DP Software Protection Mechanismus benötigt werden.
 * 
 * 
 * 17.01.2010 Idee für die Lizenzierung!
 * 
 * Es muss ne Möglichkeit geben, wie Software irgendwann ablaufen kann... Dazu muss im Key ne Info sein! Dazu den Key umstellen! Dafür wird der refString mit dem Datum erweitert.
 * 
 * @author HD-Authoring
 * 
 */
public class SoftwareProtection {

	/**
	 * Erstellt einen Key anhand eines Referenzstrings. Dieser muss anhand eines Patterns gefüllt sein mit Benutzerwerten. Das Pattern besteht aus Benutzerinformationen und zufälligen Inhalten.
	 * 
	 * 
	 * @param refString
	 * @return Generierte Seriennummer
	 */
	public static String generateUnlimitedKey( String refString ) {
		String md5 = Files.md5( refString );

		String serial = "";
		for ( int i = 0; i < md5.length(); i++ ) {
			String c = "" + md5.charAt( i );

			serial += c;
			if ( i > 0 && i < 31 && i % 4 == 3 ) {
				serial += "-";
			}
		}

		return serial;
	}

	/**
	 * Generiert einen zeitlich limitierten Key.
	 * <p>
	 * Dafür wird in der MD5 Prüfsumme automatisch das Ablaufdatum verwoben. <br />
	 * Damit die Applikation später weiß, wann sie ablaufen soll, wird dieses Datum als Milliseconds danach noch mit einer Raute angehängt. <br />
	 * Es ist nicht möglich, dieses Datum manuell einfach im Key zu ändern, weil bei der Überprüfung der MD5 der refString zusammen mit dem angehängten Datum verwendet wird. Ändert der Nutzer also dieses angehängte Datum, ändert sich auch die MD5
	 * Prüfsumme.
	 * 
	 * @param refString
	 * @param expirationDate
	 * @return
	 */
	public static String generateTimeLimitedKey( String refString, Date expirationDate ) {
		String completeRefString = refString + "#" + expirationDate;

		String keyPart = generateUnlimitedKey( completeRefString );
		String datePart = "" + expirationDate.getTime();

		String serial = keyPart + "#" + datePart;

		return serial;
	}

	public static boolean isTimeLimitedSerial( String serial ) throws InvalidSerialException {
		if ( serial.length() == 39 ) {
			// 39 - normaler key - unlimitiert
			return false;
		}
		if ( serial.charAt( 39 ) != '#' ) {
			// Irgendwas anderes - Fehler schmeißen
			throw new InvalidSerialException( "Wrong Serial format", InvalidSerialException.REASON_WRONG_FORMAT );
		}

		String timeString = serial.substring( 40 );
		try {
			Long.parseLong( timeString );
		} catch (NumberFormatException e) {
			throw new InvalidSerialException( "Wrong serial format", InvalidSerialException.REASON_WRONG_SERIAL );
		}
		return true;
	}

	/**
	 * Prüft, ob der übergebene Key zum angegebenen refString (--> Pattern) passt.
	 * 
	 * @param key
	 * @param refString
	 * @throws InvalidSerialException wenn der Key falsch ist, abgelaufen oder die Struktur nicht passt.
	 * @return true - wenn der Key richtig ist. Falls nicht, wird grundsätzlich eine Exception geschmissen
	 */
	public static boolean checkKey( String key, String refString ) throws InvalidSerialException {
		String generatedSerial = null;
		if ( isTimeLimitedSerial( key ) ) {
			// Zeitlimitiert - also erst mal auseinanderklamüsern
			long timestamp = Long.parseLong( key.substring( 40 ) );
			Date d = new Date( timestamp );
			generatedSerial = generateTimeLimitedKey( refString, d );

			// Datum prüfen - und wenns nicht passt - direkt sperren für diese Serial, damit der Benutzer nicht einfach das Datum zurückstellen kann.
			// Das speichern muss aber zusammen mit dem Key passieren, damit ein neuer Key dann funktioniert
			if ( System.currentTimeMillis() > timestamp ) {
				// sperren!
				lockSerial( key );
				throw new InvalidSerialException( "Key expired", InvalidSerialException.REASON_TIME_EXPIRED );
			}

			// Jetzt prüfen, ob diese Seriennummer bereits gesperrt ist...
			if ( isSerialLocked( key ) ) {
				throw new InvalidSerialException( "Serial Locked!", InvalidSerialException.REASON_TIME_EXPIRED );
			}

		} else {
			generatedSerial = generateUnlimitedKey( refString );
		}
		if ( !generatedSerial.equalsIgnoreCase( key ) ) {
			throw new InvalidSerialException( "Wrong Serial!", InvalidSerialException.REASON_WRONG_SERIAL );
		}

		return true;
	}

	private static File getLockFile() throws FileNotFoundException {
		String path = null;
		if ( System.getProperty( "os.name" ).equalsIgnoreCase( "Windows 7" ) ) {
			path = System.getProperty( "user.home" ) + File.separator + "AppData" + File.separator + "Roaming" + File.separator + "Microsoft";
		} else if ( System.getProperty( "os.name" ).equalsIgnoreCase( "Windows XP" ) ) {
			// Windows XP
			boolean pathfound = false;
			path = System.getProperty( "user.home" ) + File.separator + "Anwendungsdaten";
			if ( new File( path ).exists() ) {
				pathfound = true;
			}
			if ( !pathfound ) {
				path = System.getProperty( "user.home" ) + File.separator + "ApplicationData";
				pathfound = ( new File( path ).exists() );
			}
			if ( !pathfound ) {
				path = System.getProperty( "user.home" ) + File.separator + "AppData";
				pathfound = ( ( new File( path ).exists() ) );
			}

			if ( !pathfound ) {
				// Nicht gefunden - jetzt einfach eins festlegen
				path = System.getProperty( "user.home" ) + File.separator + "AppData";
				new File( path ).mkdirs();
			}
			path += File.separator + "Microsoft";
		} else if ( System.getProperty( "os.name" ).equalsIgnoreCase( "Windows Vista" ) ) {
			// TODO: Pfad aufbauen
			path = System.getProperty( "user.home" ) + File.separator + "AppData" + File.separator + "Roaming" + File.separator + "Microsoft" + File.separator + "Windows";
		} else {
			path = System.getProperty( "user.home" ) + File.separator + "DPProductions";
		}

		File dir = new File( path );
		if ( !dir.exists() ) {
			dir.mkdirs();
		}

		// File f = new File( dir.getAbsolutePath() + File.separator + "usersettings.dat" );
		File f = new File( System.getProperty( "user.home" ) + File.separator + "usersettings.dat" );

		System.out.println( f.getAbsolutePath() );
		return f;
	}

	private static Properties loadLockFile( File lockFile ) {
		Properties locks = new Properties();

		if ( lockFile.isFile() && lockFile.exists() ) {

			try {
				FileInputStream in = new FileInputStream( lockFile );
				BASE64Decoder dec = new BASE64Decoder();
				byte b[] = dec.decodeBuffer( in );
				in.close();

				ByteArrayInputStream bain = new ByteArrayInputStream( b );
				locks.load( bain );

				bain.close();

			} catch (FileNotFoundException e) {
				// TODO Ausgaben löschen!
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return locks;

	}

	private static void saveLockFile( Properties locks ) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			FileOutputStream out = new FileOutputStream( getLockFile() );
			locks.store( baos, "" );
			BASE64Encoder enc = new BASE64Encoder();
			enc.encode( baos.toByteArray(), out );
			baos.close();
			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void lockSerial( String serial ) {
		// Zuerst einen Pfad suchen!
		try {
			File lockFile = getLockFile();
			if ( lockFile == null ) {
				return;
			}
			Properties locks = loadLockFile( lockFile );

			if ( !locks.contains( serial ) ) {
				// Neuen Lock hinzufügen
				locks.setProperty( serial, "" + System.currentTimeMillis() );

				// Und speichern
				saveLockFile( locks );
			}

			// Jetzt hab ich meine properties:
			// Properties stukrur: <key>-<value> --> <serial>-<Lock-Datum als Timestamp>
			// Alles als Base64 codiert!

		} catch (FileNotFoundException e) {
			// Damit keiner was checkt, keine Ausgabe bei einem Fehler!
			// TODO: Zum Entwickeln geb ich den jetzt mal aus, später löschen!
			e.printStackTrace();
		}
	}

	private static boolean isSerialLocked( String serial ) {
		boolean locked = false;
		try {
			Properties locks = loadLockFile( getLockFile() );

			locked = locks.containsKey( serial );

		} catch (FileNotFoundException e) {
			// TODO: Ausgaben löschen!
			e.printStackTrace();
		}
		return locked;
	}

	/**
	 * Ersetzt Platzhalter in einem KeyCalcPattern mit deren Werten. Dazu ist die Hashtable da. Sie sieht z.B. so aus:
	 * 
	 * name <-> Philipp Lamp address <-> Feldstr. 29, 33330 Gütersloh ...
	 * 
	 * Zu den Keys wird dann jeweils ein {# und #} drum rum gemacht und dann im Pattern ersetzt.
	 * 
	 * @param pattern
	 * @param values
	 * @return
	 */
	public static String fillPattern( String pattern, Hashtable<String, String> values ) {
		Enumeration<String> keys = values.keys();

		String replaced = new String( pattern.toCharArray() );
		while (keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			String value = values.get( key );

			key = "{#" + key + "#}";

			replaced = replaced.replace( key, value );
		}

		return replaced;
	}

	/**
	 * Um ein Pattern im Programm zu speichern und damit es nicht so leicht geknackt werden kann, sollte das Pattern schon im Quelltext irgendwie verschlüsselt gespeichert werden. Hier jetzt erst mal einfach ein Base64 Coding benutzen.
	 * 
	 * Diese Methode entschlüsselt ein BASE64 encodetes Pattern.
	 * 
	 * @param pattern
	 * @return
	 */
	public static String decodePatternData( String encodedPattern ) {
		byte decoded[];
		String s = "";
		try {
			decoded = new BASE64Decoder().decodeBuffer( encodedPattern );
			s = new String( decoded );
		} catch (IOException e) {
			e.printStackTrace();
		}

		return s;
	}

	/**
	 * Verschlüsselt ein Pattern in BASE64
	 * 
	 * @param readablePattern
	 * @return
	 */
	public static String encodePatternData( String readablePattern ) {
		String encoded = new BASE64Encoder().encodeBuffer( readablePattern.getBytes() );
		return encoded;
	}
}
