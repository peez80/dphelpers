package de.stiffi.DPHelpers;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class DPImageHelpers {

	public static BufferedImage flipHorizontal( BufferedImage img ) {

		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage flippedImage = new BufferedImage( w, h, img.getType() );
		Graphics2D g = flippedImage.createGraphics();
		g.drawImage( img, 0, 0, w, h, w, 0, 0, h, null );
		g.dispose();
		return flippedImage;
	}

	public static BufferedImage flipVertical( BufferedImage img ) {
		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage flippedImage = new BufferedImage( w, h, img.getType() );
		Graphics2D g = flippedImage.createGraphics();
		g.drawImage( img, 0, 0, w, h, 0, h, w, 0, null );
		g.dispose();
		return flippedImage;
	}
}
