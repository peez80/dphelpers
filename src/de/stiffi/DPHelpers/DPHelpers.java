package de.stiffi.DPHelpers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.UIManager;

public class DPHelpers {

	/**
	 * Die Methode {@link #getRandomString(int)} generiert einen Zufallsstring mit Zeichen, die hier
	 * drin vorkommen.
	 */
	private final static String RANDOM_STRING_CHAR_REPOSITORY = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!§%#";

	private final static String FILENAME_ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 _-#.";

	public static String add0( int zahl ) {
		return ( ( zahl < 10 ) ? "0" : "" ) + zahl;
	}

	public static String implode( Vector<String> tokens, String separator ) {
		StringBuffer sb = new StringBuffer();

		for ( int i = 0; i < tokens.size(); i++ ) {
			if ( i > 0 ) {
				sb.append( separator );
			}
			sb.append( tokens.get( i ).toString() );
		}

		return sb.toString();
	}

	public static String wordWrap( String s, int charCount ) {

		String sb = "";

		StringTokenizer tLines = new StringTokenizer( s, "\n" );

		while (tLines.hasMoreTokens()) {
			String line = tLines.nextToken().trim();

			if ( line.length() > 0 ) {
				if ( sb.length() > 0 ) {
					sb += "\r\n";
				}

				String currentLine = "";

				StringTokenizer t = new StringTokenizer( line, " " );

				while (t.hasMoreTokens()) {
					String token = t.nextToken();

					if ( currentLine.length() + token.length() > charCount ) {
						sb += currentLine + "\r\n";
						currentLine = "";
					}
					currentLine += token + " ";
				}
				sb += currentLine;
			}

		}

		return sb;
	}

	public static void dumpList( List<?> l ) {
		System.out.println( "------ Dump List ( " + l.size() + " ): " + l.toString() );
		for ( int i = 0; i < l.size(); i++ ) {
			System.out.println( "   " + l.get( i ).toString() );
		}
		System.out.println( "----------------------------------------" );
	}

	public static void dumpMap( Map<?, ?> m ) {
		Set<?> keys = m.keySet();

		System.out.println( "------ Dump Map ( " + keys.size() + " ): " + m.toString() );

		Iterator<?> i = keys.iterator();
		while (i.hasNext()) {
			Object key = i.next();
			Object value = m.get( key );
			System.out.println( "   " + key.toString() + "    --> " + value.toString() );
		}
		System.out.println( "---------------------------------------" );
	}

	/**
	 * Gibt die Details des übergebenen Objektes aus (dessen public Eigenschaften)
	 * 
	 * @param o
	 */
	public static <T> void dump( T object ) {
		System.out.println( "\r\n---------------------------------------" );
		System.out.println( "Dump Object " + object.toString() );
		dump( object, 0 );
		System.out.println( "-----------------------------------\r\n" );
	}

	private static <T> void dump( T object, int indent ) {
		StringBuffer indentString = new StringBuffer();
		for ( int i = 0; i < indent; i++ ) {
			indentString.append( " " );
		}

		ReflectionHelper<T> refl = new ReflectionHelper<T>( object );
		Field[] fields = refl.getFields();
		for ( Field f : fields ) {
			try {
				System.out.println( indentString.toString() + f.getName() + ":\t " + refl.getFieldValue( f.getName() ) );
				// if ( refl.getFieldValue( f.getName() ) != null &&
				// Serializable.class.isAssignableFrom( refl.getFieldValue( f.getName() ).getClass()
				// ) ) {
				// dump( refl.getFieldValue( f.getName() ), 3 );
				// }
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Entfernt / und \ vom Anfang und Ende des übergebenen Strings.
	 * 
	 * @return
	 */
	public static String trimSlashes( String s ) {
		while (s.startsWith( "/" ) || s.startsWith( "\\" )) {
			s = s.substring( 1 );
		}
		while (s.endsWith( "/" ) || s.endsWith( "\\" )) {
			s = s.substring( 0, s.length() - 1 );
		}
		return s;
	}

	/**
	 * Generiert aus einem Byte-Array einen hexstring. Wird benutzt von den md5 Methoden
	 * 
	 * @param b
	 * @return
	 */
	public static String hexStringFromBytes( byte[] b )

	{
		final char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		String hex = "";

		int msb;

		int lsb = 0;
		int i;

		// MSB maps to idx 0

		for ( i = 0; i < b.length; i++ )

		{

			msb = ( b[i] & 0x000000FF ) / 16;

			lsb = ( b[i] & 0x000000FF ) % 16;
			hex = hex + hexChars[msb] + hexChars[lsb];
		}
		return ( hex );
	}

	/**
	 * Formatiert die übergbene Anzahl an Bytes in einen String und rechnet automatisch die für die
	 * Anzeige passende Einheit (bytes, kB. MB, GB, TB, PB) aus.
	 * 
	 * @param bytes
	 * @return
	 */
	public static String formatBytes( double bytes ) {
		double b = bytes;
		String einheit = "Bytes";

		if ( b >= 1024 ) {
			b = b / 1024;
			einheit = "kB";
		}
		if ( b >= 1024 ) {
			b = b / 1024;
			einheit = "MB";
		}
		if ( b >= 1024 ) {
			b = b / 1024;
			einheit = "GB";
		}
		if ( b >= 1024 ) {
			b = b / 1024;
			einheit = "TB";
		}
		if ( b >= 1024 ) {
			b = b / 1024;
			einheit = "PB";
		}

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits( 2 );

		return nf.format( b ) + " " + einheit;
	}

	/**
	 * Formatiert die übergebenen Millisekunden in das format:
	 * 
	 * 01d 20h 19m 42s
	 * 
	 * @param milliseconds
	 * @return
	 */
	public static String formatDuration( long milliseconds, DurationFormat format ) {

		long remainingSec = Math.round( (double)milliseconds / (double)1000 );

		String s = "";

		if ( format == DurationFormat.dhms ) {
			long days = (long)Math.floor( remainingSec / 60 / 60 / 24 );

			if ( days != 0 ) {
				remainingSec -= days * 60 * 60 * 24;
				s += days + "d ";
			}

			long hours = (long)Math.floor( remainingSec / 60 / 60 );
			remainingSec -= hours * 60 * 60;

			if ( s.length() > 0 || hours != 0 ) {
				s += ( hours < 10 ? "0" : "" ) + hours + "h ";
			}

			long minutes = (long)Math.floor( remainingSec / 60 );
			remainingSec -= minutes * 60;

			if ( s.length() > 0 || minutes != 0 ) {
				s += ( minutes < 10 ? "0" : "" ) + minutes + "m ";
			}

			s += ( remainingSec < 10 ? "0" : "" ) + remainingSec + "s";

		} else if ( format == DurationFormat.HHMMSS ) {

			long hours = (long)Math.floor( remainingSec / 60 / 60 );
			remainingSec -= hours * 60 * 60;

			if ( s.length() > 0 || hours != 0 ) {
				s += ( hours < 10 ? "0" : "" ) + hours + ":";
			}

			long minutes = (long)Math.floor( remainingSec / 60 );
			remainingSec -= minutes * 60;

			if ( s.length() > 0 || minutes != 0 ) {
				s += ( minutes < 10 ? "0" : "" ) + minutes + ":";
			}

			s += ( remainingSec < 10 ? "0" : "" ) + remainingSec;
		}

		return s;
	}

	public static enum DurationFormat {
		HHMMSS, dhms
	}

	public static boolean equals( Object o1, Object o2 ) {
		if ( o1 == null && o2 == null ) {
			return true;
		} else if ( o1 == null && o2 != null ) {
			return false;
		} else if ( o1 != null && o2 == null ) {
			return false;
		} else {
			return o1.equals( o2 );
		}
	}

	public static enum LookAndFeel {
		WINDOWS, NIMBUS, NATIVE;
	}

	public static void setLookAndFeel( LookAndFeel laf ) {
		String lafString = null;

		switch (laf) {
		case NIMBUS:
			lafString = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
			break;
		case WINDOWS:
			lafString = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			break;
		case NATIVE:
			lafString = UIManager.getSystemLookAndFeelClassName();
			break;
		}

		if ( lafString != null ) {
			try {
				UIManager.setLookAndFeel( lafString );
			} catch (Exception e) {
			}
		}
	}

	public static void copyStream( InputStream is, OutputStream os ) throws IOException {
		copyStream( is, os, 4096 );
	}

	public static void copyStream( InputStream is, OutputStream os, int bufSize ) throws IOException {

		byte buf[] = new byte[bufSize];
		int len;

		while (( len = is.read( buf ) ) != -1) {
			os.write( buf, 0, len );
		}
	}

	public static String getCallers( int depth ) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		// Die letzten drei nehmen
		StringBuilder sb = new StringBuilder();
		int start = 2;
		int end = stackTraceElements.length >= start + depth ? start + depth : stackTraceElements.length;
		for ( int i = start; i < end; i++ ) {
			StackTraceElement se = stackTraceElements[i];
			for ( int j = 0; j < i; j++ ) {
				sb.append( "  " );
			}
			sb.append( se.toString() ).append( "\r\n" );
			// sb.append( se.getClassName() ).append( "." ).append( se.getMethodName() ).append( ":"
			// ).append( se.getLineNumber() ).append( "\r\n" );
		}	

		return sb.toString();
	}

	/**
	 * Generiert einen String mit zufälligen Inhalten.
	 * Der String kann folgende Zeichen enthalten:<br />
	 * {@value #RANDOM_STRING_CHAR_REPOSITORY}
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString( int length ) {
		return getRandomString( length, RANDOM_STRING_CHAR_REPOSITORY );
	}

	/**
	 * Generiert einen String mit zufälligen Inhalten (Buchstaben, Zahlen, Sonderzeichen) und gibt
	 * diesen zurück.
	 * 
	 * @param length Länge des zu generierenden Strings
	 * @param charRepository In diesem String müssen alle Zeichen übergeben werden, aus denen der
	 *            Zufallsstring generiert wird.
	 * @return
	 */
	public static String getRandomString( int length, String charRepository ) {
		Random rnd = new Random( System.currentTimeMillis() * System.currentTimeMillis() );
		StringBuilder sb = new StringBuilder( length );
		for ( int i = 0; i < length; i++ ) {
			int charIndex = rnd.nextInt( charRepository.length() );
			sb.append( charRepository.charAt( charIndex ) );
		}
		return sb.toString();
	}

	public static String filterFileName( String s ) {
		StringBuilder sb= new StringBuilder();
		for ( int i = 0; i < s.length(); i++ ) {
			if ( FILENAME_ALLOWED_CHARS.contains( String.valueOf( s.charAt( i ) ) ) ) {
				sb.append( s.charAt( i ) );
			}
		}
		return sb.toString();
	}

	public static void dumpToFile( String s, Path logfile ) throws IOException {
		System.out.println( s );

		try (BufferedWriter out = Files.newBufferedWriter( logfile, Charset.defaultCharset(), StandardOpenOption.APPEND, StandardOpenOption.CREATE )) {
			out.write( s );
			out.write( "\r\n" );
		}
	}

	public static <T> void removeBiggest( Collection<T> elements, Comparator<T> comparator ) {
		T biggest = null;
		Iterator<T> it = elements.iterator();
		while (it.hasNext()) {
			T element = it.next();
			if ( biggest == null || comparator.compare( element, biggest ) > 0 ) {
				biggest = element;
			}
		}

		if ( biggest != null ) {
			elements.remove( biggest );
		}
	}

	public static <T> void removeSmallest( Collection<T> elements, Comparator<T> comparator ) {
		T smallest = null;
		Iterator<T> it = elements.iterator();
		while (it.hasNext()) {
			T element = it.next();
			if ( smallest == null || comparator.compare( element, smallest ) < 0 ) {
				smallest = element;
			}
		}

		if ( smallest != null ) {
			elements.remove( smallest );
		}
	}

}
