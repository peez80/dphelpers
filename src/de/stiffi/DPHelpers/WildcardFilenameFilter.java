package de.stiffi.DPHelpers;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Filename Filter with DOS Wildcards.
 * <p>
 * 
 * 
 * @author Philipp Lamp
 * @version 2.5 2009-02-28 - CommandLine split off in its own package.
 * @since 2009-04-08
 */
public final class WildcardFilenameFilter implements FilenameFilter {

	/**
	 * Wildcard Regex
	 */
	private final Pattern pattern;

	private boolean acceptDirectories = true;

	/**
	 * Constructor
	 * <p>
	 * Also accepts Directories in Standard
	 * 
	 * @param wildcard pattern of files you want e.g. some*.txt debug?.c*
	 */
	public WildcardFilenameFilter( String wildcard ) {
		pattern = Pattern.compile( wildcardAsRegex( wildcard ) );
		setAcceptDirectories( true );
	}

	/**
	 * 
	 * @param wildcard
	 * @param acceptDirectories
	 */
	public WildcardFilenameFilter( String wildcard, boolean acceptDirectories ) {
		pattern = Pattern.compile( wildcardAsRegex( wildcard ) );
		setAcceptDirectories( acceptDirectories );
	}

	/**
	 * 
	 */
	public boolean accept( File dir, String name ) {
		File f = new File( dir, name );
		if ( acceptDirectories && f.isDirectory() ) {
			return true;
		} else {
			return pattern.matcher( name ).matches();
		}
	}

	/**
	 * convert a wild card containing * and ? to the equivalent regex Code duplicated in com.mindprod.example.TestWildcard
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

	public boolean isAcceptDirectories() {
		return acceptDirectories;
	}

	public void setAcceptDirectories( boolean acceptDirectories ) {
		this.acceptDirectories = acceptDirectories;
	}
}
