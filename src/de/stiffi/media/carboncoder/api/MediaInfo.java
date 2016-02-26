package de.stiffi.media.carboncoder.api;

import org.w3c.dom.Element;

public class MediaInfo {

	private MediaInfoAudio audio;

	private MediaInfoVideo video;

	protected MediaInfo( Element eVideo, Element eAudio ) {
		audio = new MediaInfoAudio( eAudio );
		video = new MediaInfoVideo( eVideo );
	}

	public MediaInfoAudio getAudio() {
		return audio;
	}

	public MediaInfoVideo getVideo() {
		return video;
	}

	@Override
	public String toString() {
		return super.toString() + getAudio().getXml() + "\r\n" + getVideo().getXml();
	}
}
