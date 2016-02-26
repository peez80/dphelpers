package de.stiffi.media.carboncoder.api;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Element;

import de.stiffi.DPHelpers.XML;

public class MediaInfoAudio {

	private int sampleRate;

	private int sampleSize;

	private int channels;

	private String codec;

	private String xmlData;

	protected MediaInfoAudio( Element eAudio ) {
		sampleRate = Integer.parseInt( eAudio.getAttribute( "SampleRate.DWD" ) );
		sampleSize = Integer.parseInt( eAudio.getAttribute( "SampleSize.DWD" ) );
		channels = Integer.parseInt( eAudio.getAttribute( "Channels.DWD" ) );
		codec = eAudio.getAttribute( "Codec" );

		try {
			xmlData = XML.getAsString( eAudio, true );
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getSampleRate() {
		return sampleRate;
	}

	public int getSampleSize() {
		return sampleSize;
	}

	public int getChannels() {
		return channels;
	}

	public String getCodec() {
		return codec;
	}

	public String getXml() {
		return xmlData;
	}

	@Override
	public String toString() {
		return super.toString() + getXml();
	}
}
