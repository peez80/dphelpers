package de.stiffi.media.carboncoder.api;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Element;

import de.stiffi.DPHelpers.XML;

public class MediaInfoVideo {

	private String codec;

	private long framesCount = -1;

	private String interlacing;

	private int width;

	private int height;

	private int aspectX;

	private int aspectY;

	private String xmlData;

	protected MediaInfoVideo( Element eVideo ) {
		codec = eVideo.getAttribute( "Codec" );

		if ( eVideo.hasAttribute( "FrameDuration.QWD" ) ) {
			framesCount = Long.parseLong( eVideo.getAttribute( "FrameDuration.QWD" ) );
		}
		interlacing = eVideo.getAttribute( "Interlacing" );
		width = Integer.parseInt( eVideo.getAttribute( "Size_X.DWD" ) );
		height = Integer.parseInt( eVideo.getAttribute( "Size_Y.DWD" ) );
		aspectX = Integer.parseInt( eVideo.getAttribute( "Video_Aspect_X.DWD" ) );
		aspectY = Integer.parseInt( eVideo.getAttribute( "Video_Aspect_Y.DWD" ) );

		try {
			xmlData = XML.getAsString( eVideo, true );
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCodec() {
		return codec;
	}

	public long getFramesCount() {
		return framesCount;
	}

	public String getInterlacing() {
		return interlacing;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getAspectX() {
		return aspectX;
	}

	public int getAspectY() {
		return aspectY;
	}

	public String getXml() {
		return xmlData;
	}

	@Override
	public String toString() {
		return super.toString() + getXml();
	}
}
