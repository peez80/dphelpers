package de.stiffi.DPHelpers.Timecode;

import java.util.StringTokenizer;

/**
 * Diese Klasse repräsentiert einen Timecode. Mit ihr kann man Berechnungen etc. anstellen.
 * 
 * @author HD-Authoring
 * 
 */
public class Timecode {

	/**
	 * Standardwert für neu erstellte Timecode-Objekte. Kann von einer verwendeten Applikation als
	 * Standard vorbelegt werden.
	 */
	public static float STANDARD_FPS = 30f;

	private long m_frames = 0;

	/**
	 * Framerate. Basierend auf dieser Framerate werden alle Berechnungen durchgeführt
	 */
	protected float fps = STANDARD_FPS;

	/**
	 * Standardkonstruktor
	 */
	public Timecode() {

	}

	/**
	 * Erstellt ein neues Timecode Objekt mit dem übergebenen Timecode (HH:MM:SS:FF) als
	 * Voreinstellung
	 * 
	 * @param tc
	 */
	public Timecode( String tc ) throws WrongTimecodeException {
		this.setTC( tc );
	}

	/**
	 * Erstellt ein neues Timecode Objekt mit dem übergebenen Timecode (HH:MM:SS:FF) und Framerate
	 * als Voreinstellung
	 * 
	 * @param tc
	 * @param fps
	 */
	public Timecode( String tc, float fps ) throws WrongTimecodeException {
		setFPS( fps );
		setTC( tc );
	}

	public Timecode( long frames, float fps ) {
		setFPS( fps );
		setTC( frames );

	}

	public void setTC( long frames ) {
		m_frames = frames;
	}

	/**
	 * Setzt den TC (Format HH:MM:SS:FF) für dieses Objekt
	 * 
	 * @param tc
	 * @return
	 */
	public boolean setTC( String tc ) throws WrongTimecodeException {
		// Jetzt den TC in seine Bestandteile aufteilen
		StringTokenizer t = new StringTokenizer( tc, ":", false );

		if ( t.countTokens() != 4 ) {
			throw new WrongTimecodeException( "TC has not exactly four Tokens separated by \":\"" );
		}

		try {

			int h = Integer.parseInt( t.nextToken() );
			int m = Integer.parseInt( t.nextToken() );
			int s = Integer.parseInt( t.nextToken() );
			int f = Integer.parseInt( t.nextToken() );

			long frames = (long)( f + fps * s + fps * m * 60f + fps * h * 60f * 60f );

			m_frames = frames;
		} catch (Exception e) {
			throw new WrongTimecodeException( "One of the Timecode Tokens is not Integer" );
		}

		return true;
	}

	/**
	 * Addiert einen Timecode zu diesem und gibt das Ergebnis zurück
	 * 
	 * @param tc Dieser Timecode wird addiert
	 * @return Neues Timecode Objekt mit dem Ergebnis der Addition
	 */
	public Timecode add( Timecode tc ) {
		Timecode tc_calc = null;

		tc_calc = this.clone();

		tc_calc = tc_calc.addFrames( tc.getFrames() );
		//
		//
		// tc_calc.h += tc.h;
		// tc_calc.m += tc.m;
		// tc_calc.s += tc.s;
		// tc_calc.f += tc.f;
		// tc_calc.normalize();

		return tc_calc;
	}

	/**
	 * Addiert die übergebenen Millisekunden zu diesem und gibt das Ergebnis in einem neuen Timecode
	 * zurück
	 * 
	 * @param ms
	 * @return
	 */
	public Timecode addMilliseconds( long ms ) {
		Timecode tc_calc = this.clone();

		// Millisekunden zu frames umrechnen
		double ms_per_frame = 1000 / fps;
		long frames = (long)( ms / ms_per_frame );

		tc_calc = tc_calc.addFrames( frames );

		return tc_calc;
	}

	/**
	 * Subtrahiert einen Timecode zu diesem und gibt das Ergebnis zurück
	 * 
	 * @param tc Dieser Timecode wird subtrahiert
	 * @return Neues Timecode Objekt mit dem Ergebnis der Subtraktion
	 */
	public Timecode sub( Timecode tc ) {

		Timecode tcNew = new Timecode( getFrames() - tc.getFrames(), fps );

		return tcNew;
	}

	/**
	 * Addiert einen Timecode zu diesem und gibt das Ergebnis zurück
	 * 
	 * @param timecode Dieser Timecode wird addiert
	 * @return Ergebnis der Addition
	 * @throws WrongTimecodeException
	 */
	public Timecode add( String timecode ) throws WrongTimecodeException {
		Timecode tc;
		try {
			tc = new Timecode( timecode );
			return this.add( tc );
		} catch (WrongTimecodeException e) {
			WrongTimecodeException e1 = new WrongTimecodeException( "Passed Timecode is wrong", e );
			throw e1;
		}

	}

	/**
	 * Subtrahiert einen Timecode zu diesem und gibt das Ergebnis zurück
	 * 
	 * @param timecode Dieser Timecode wird Subtrahiert
	 * @return Ergebnis der Subtraktion
	 * @throws WrongTimecodeException
	 */
	public Timecode sub( String timecode ) throws WrongTimecodeException {
		Timecode tc = new Timecode( timecode );
		return this.sub( tc );
	}

	/**
	 * Addiert die übergebene Anzahl an Frames zu diesem Timecode und gibt das Ergebnis zurück
	 * 
	 * @param frames
	 * @return Ergebnis der Addition
	 */
	public Timecode addFrames( long frames ) {
		Timecode tc_calc = new Timecode( getFrames() + frames, fps );

		// tc_calc.f += frames;
		// tc_calc.normalize();

		return tc_calc;
	}

	/**
	 * Gibt die String-Repräsentation des aktuellen Timecodes zurück
	 */
	@Override
	public String toString() {

		// normalize();

		double frames = m_frames;

		double factor = fps * 60f * 60f;
		int h = (int)Math.floor( frames / factor );
		frames = frames - h * factor;

		factor = fps * 60f;
		int m = (int)Math.floor( frames / factor );
		frames = frames - m * factor;

		factor = fps;
		int s = (int)Math.floor( frames / factor );
		frames = frames - s * factor;

		int f = (int)frames;

		String hour = ( h < 10 ? "0" : "" ) + h;
		String minute = ( m < 10 ? "0" : "" ) + m;
		String second = ( s < 10 ? "0" : "" ) + s;
		String frame = ( f < 10 ? "0" : "" ) + f;

		return ( hour + ":" + minute + ":" + second + ":" + frame );
	}

	/**
	 * Gibt die Gesamtzahl Frames für diesen TC zurück, basierend auf der eingestellten Framerate
	 * für diesen TC
	 * 
	 * @return
	 */
	public long getFrames() {
		return m_frames;
	}

	/**
	 * Gibt zurück, ob der übergebene Timecode von seiner Struktur her auch wirklich ein Timecode
	 * ist.
	 * 
	 * @param tc
	 * @return
	 */
	public static boolean isTC( String tc ) {
		StringTokenizer t = new StringTokenizer( tc, ":", false );

		if ( t.countTokens() != 4 ) {
			return false;
		}

		try {
			Integer.parseInt( t.nextToken() );
			Integer.parseInt( t.nextToken() );
			Integer.parseInt( t.nextToken() );
			Integer.parseInt( t.nextToken() );
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * Gibt zurück, ob der übergebene String eine Int-Zahl ist.
	 * 
	 * @param s String, der getestet wird
	 * @return true, wenn der übergebene String eine Int-Zahl ist, false wenn nicht
	 */
	private static boolean isNumber( String s ) {
		try {
			Integer.parseInt( s );
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Gibt eine exakte (Deep-)Kopie dieses Objekts zurück
	 */
	@Override
	public Timecode clone() {
		return new Timecode( m_frames, fps );
	}

	/**
	 * Setzt eine neue Framerate. Der resultierende Timecode (HH:MM:SS:FF) wird durch diese Funktion
	 * geändert, da durch diese Funktion eine andere Laufzeit angenommen wird.
	 * 
	 * @param k_fps
	 */
	public void changeFPS( float k_fps ) {
		this.fps = k_fps;
	}

	/**
	 * Mit dieser Funktion wird die Framerate (incl. der der Berechnung zugrundeliegenden Frames) so
	 * angepasst, dass der resultierende Timecode (HH:MM:SS:FF) gleich bleibt. also ergibt sich
	 * keine Laufzeitänderung.
	 * 
	 * @param newFPS
	 */
	public void setFPS( float newFPS ) {

		String tc = toString();
		fps = newFPS;
		try {
			setTC( tc );
		} catch (WrongTimecodeException e) {
			// Einfach fangen - der bestehende Timecode MUSS ja in einem richtigen Format sein, da
			// das im Voraus schon abgefangen worden wäre
			e.printStackTrace();
		}

		// long frames = getFrames();
		// Timecode tmp = new Timecode( frames, newFPS );
		// setFPS( newFPS );
		// setTC( tmp.toString() );
	}

	/**
	 * Gibt die Framerate zurück, die diesem Objekt zugrunde liegt.
	 * 
	 * @return
	 */
	public float getFPS() {
		return fps;
	}

}
