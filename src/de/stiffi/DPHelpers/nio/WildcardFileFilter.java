package de.stiffi.DPHelpers.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * Java nio Dateifilter, der mit normalen DOS-Wildcards arbeitet.
 * 
 * @author peez
 * 
 */
public class WildcardFileFilter implements Filter<Path> {

	/**
	 * Wenn true, werden Verzeichnisse grundsätzlich akzeptiert, egal ob sie dem Pattern
	 * entsprechen. Wenn false, werden auch Verzeichnisse auf das Pattern geprüft.
	 */
	private boolean alwaysAcceptDirectories = true;

	/**
	 * Wenn dieser Wert != null ist, dann wurde ein exaktes Verzeichnis / Dateiangegeben, d.h. es
	 * muss bzw. darf nicht auf Wildcards gefiltert werden.
	 */
	private Path exactPath = null;

	/**
	 * Pattern, auf den bei {@link #accept(Path)} gematched wird, wenn ein * oder ? im Konstruktor
	 * übergeben wird.
	 */
	private Pattern regexPattern = null;

	/**
	 * Konstruktor, in dem einfach ein Wildcardstring übergeben wird. Verzeichnisse werden bei
	 * {@link #accept(Path)} immer akzeptiert.
	 * 
	 * 
	 * @param wildcardPattern DOS-Wildcard Pattern oder ein absoluter Pfad ohne Wildcards.
	 */
	public WildcardFileFilter( String wildcardPattern ) {
		alwaysAcceptDirectories = true;

		if ( !wildcardPattern.contains( "*" ) && !wildcardPattern.contains( "?" ) ) {
			// Keine Wildcards, also habe ich exakt eine Datei / Verzeichnis angegeben
			exactPath = Paths.get( wildcardPattern );
		} else {
			regexPattern = Pattern.compile( wildcardAsRegex( wildcardPattern ) );
		}
	}

	/**
	 * Konstruktor. Bekommt ein Windcard Pattern und die Info, ob Verzeichnisse grundsätzclich
	 * akzeptiert werden oder ebenfalls auf das Pattern geprüft werden
	 * 
	 * @param wildcardPattern DOS-Wildcard Pattern oder ein absoluter Pfad ohne Wildcards.
	 * @param alwaysAcceptDirectories Wenn true, werden Verzeichnisse immer mit ausgegeben,
	 *            wenn false nur, wenn diese dem Filter entsprechen.
	 */
	public WildcardFileFilter( String wildcardPattern, boolean alwaysAcceptDirectories ) {
		this( wildcardPattern );
		this.alwaysAcceptDirectories = alwaysAcceptDirectories;
	}

	/**
	 * Konstruktor der direkt eine Regex akzeptiert.
	 * Wenn erweiterte Dinge nötig sind, die nicht einfach über ein übliches DOS-Like Wildcard
	 * Pattern erledigt werden können, lässt sich hier direkt ein Regex Pattern übergeben, auf das
	 * gematched wird.
	 * 
	 * @param acceptPattern Regex-Pattern, auf das bei {@link #accept(Path)} gematched wird
	 * @param alwaysAcceptDirectories Wenn true, werden Verzeichnisse immer mit ausgegeben,
	 *            wenn false nur, wenn diese dem Filter entsprechen.
	 */
	public WildcardFileFilter( Pattern acceptPattern, boolean alwaysAcceptDirectories ) {
		this.alwaysAcceptDirectories = alwaysAcceptDirectories;
		regexPattern = acceptPattern;
	}

	/**
	 * Konstruktor der direkt eine Regex akzeptiert.
	 * Wenn erweiterte Dinge nötig sind, die nicht einfach über ein übliches DOS-Like Wildcard
	 * Pattern erledigt werden können, lässt sich hier direkt ein Regex Pattern übergeben, auf das
	 * gematched wird.
	 * 
	 * @param acceptPattern Regex-Pattern, auf das bei {@link #accept(Path)} gematched wird
	 * 
	 */
	public WildcardFileFilter( Pattern acceptPattern ) {
		alwaysAcceptDirectories = true;
		regexPattern = acceptPattern;
	}

	@Override
	public boolean accept( Path entry ) throws IOException {
		if ( alwaysAcceptDirectories && Files.isDirectory( entry ) ) {
			return true;
		}

		if ( exactPath != null ) {
			if ( exactPath.getNameCount() == 1 ) {
				// Nur ein Dateiname, kein kompletter Pfad..
				return ( entry.getFileName().equals( exactPath.getFileName() ) );
			} else {
				return entry.equals( exactPath );
			}

		} else {
			// Wildcard!
			return regexPattern.matcher( entry.toString() ).matches();
		}
	}

	/**
	 * Wenn true, werden bei {@link #accept(Path)} Verzeichnisse immer akzeptiert, wenn false dann
	 * werden sie genau wie Dateien auch gegen das Pattern gematched.
	 * 
	 * @return
	 */
	public boolean isAlwaysAcceptDirectories() {
		return alwaysAcceptDirectories;
	}

	/**
	 * convert a wild card containing * and ? to the equivalent regex Code duplicated in
	 * com.mindprod.example.TestWildcard
	 * 
	 * @param wildcard wildcard string describing a file.
	 * 
	 * @return regex string that could be fed to Pattern.comile
	 */
	private static String wildcardAsRegex( String wildcard ) {
		StringBuilder sb = new StringBuilder( wildcard.length() * 110 / 100 );
		for ( int i = 0; i < wildcard.length(); i++ ) {
			final char c = wildcard.charAt( i );
			switch (c) {
			case '*':
				sb.append( ".*?" );
				break;

			case '?':
				sb.append( "." );
				break;

			// chars that have magic regex meaning. They need quoting to be taken
			// literally
			case '$':
			case '(':
			case ')':
			case '+':
			case '-':
			case '.':
			case '[':
			case '\\':
			case ']':
			case '^':
			case '{':
			case '|':
			case '}':
				sb.append( '\\' );
				sb.append( c );
				break;

			default:
				sb.append( c );
				break;
			}
		}
		return sb.toString();
	}

}
