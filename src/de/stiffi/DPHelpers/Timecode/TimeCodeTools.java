package de.stiffi.DPHelpers.Timecode;

public class TimeCodeTools {

	public static final int CALCMODE_ADD = 0x01;

	public static final int CALCMODE_SUB = 0x02;

	/**
	 * Achtung! Die Methode stimmt so nicht ganz!
	 * 
	 * @param tc1
	 * @param tc2
	 * @param calc_mode
	 * @return
	 * @throws WrongTimecodeException
	 */
	public static String calcTC( String tc1, String tc2, int calc_mode ) throws WrongTimecodeException {
		if ( !Timecode.isTC( tc1 ) || !Timecode.isTC( tc2 ) || ( calc_mode != CALCMODE_ADD ) ) {
			return null;
		}

		Timecode tc_1 = new Timecode( tc1 );
		Timecode tc_2 = new Timecode( tc2 );

		return tc_1.add( tc_2 ).toString();
	}
}
