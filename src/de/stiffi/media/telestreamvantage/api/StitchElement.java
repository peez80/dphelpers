package de.stiffi.media.telestreamvantage.api;

import java.net.URI;

import de.stiffi.DPHelpers.Timecode.Timecode;
import de.stiffi.DPHelpers.Timecode.WrongTimecodeException;

public class StitchElement {

	private String sourceFile = null;

	private Timecode tcIn = null;

	private Timecode tcOut = null;

	public StitchElement() {}

	public StitchElement( String sourceFile, Timecode tcIn, Timecode tcOut ) {
		this.sourceFile = sourceFile;
		this.tcIn = tcIn;
		this.tcOut = tcOut;
	}

	public String getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile( String sourceFile ) {
		this.sourceFile = sourceFile;
	}

	public Timecode getTcIn() {
		return tcIn;
	}

	public void setTcIn( Timecode tcIn ) {
		this.tcIn = tcIn;
	}

	public Timecode getTcOut() {
		return tcOut;
	}

	public void setTcOut( Timecode tcOut ) {
		this.tcOut = tcOut;
	}

	public void setTcIn( String timecode ) throws WrongTimecodeException {
		this.tcIn.setTC( timecode );
	}

	public void setTcOut( String timecode ) throws WrongTimecodeException {
		this.tcOut.setTC( timecode );
	}

}
