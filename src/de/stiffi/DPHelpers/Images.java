package de.stiffi.DPHelpers;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

public class Images {

	public static BufferedImage resizeImage( BufferedImage srcImg, int width, int height ) {
		// BufferedImage srcImg = ImageIO.read( src );

		// Jetzt die neue Größe berechnen
		Dimension targetSize = new Dimension( -1, -1 );
		if ( srcImg.getWidth() > width ) {
			// Verhaeltnis rausbekommen u. in target speichern
			targetSize.width = width;

			double factor = (double)width / srcImg.getWidth();
			targetSize.height = (int)Math.round( srcImg.getHeight() * factor );
		}
		if ( targetSize.height > height ) {
			// Wenn die höhe immer noch mehr ist als vorgesehen, das gleiche jetzt für die Höhe
			// machen
			targetSize.height = height;

			double factor = (double)height / srcImg.getHeight();
			targetSize.width = (int)Math.round( srcImg.getWidth() * factor );
		}

		BufferedImage outImage = null;
		if ( targetSize.width != -1 || targetSize.height != -1 ) {
			// Dann skalieren, ansonsten direkt das Bild weiterverwenden
			Image scaledImage = srcImg.getScaledInstance( targetSize.width, targetSize.height, Image.SCALE_SMOOTH );
			outImage = new BufferedImage( targetSize.width, targetSize.height, BufferedImage.TYPE_INT_RGB );
			Graphics g = outImage.getGraphics();
			g.drawImage( scaledImage, 0, 0, null );
			g.dispose();

			scaledImage.flush();

		} else {
			outImage = srcImg;
		}

		return outImage;

	}

	public static void resizeImage( File source, File dest, int width, int height ) throws IOException {
		resizeImage( source, dest, width, height, "jpg" );
	}

	public static void resizeImage( File source, File dest, int width, int height, String fileExtension ) throws IOException {
		BufferedImage srcImg = ImageIO.read( source );
		BufferedImage resizedImage = resizeImage( srcImg, width, height );

		// Wegschreiben
		// JPEG Writer holen u. mittlere Quali einstellen
		Iterator iterator = ImageIO.getImageWritersBySuffix( fileExtension );
		if ( !iterator.hasNext() ) {
			throw new IllegalArgumentException( "Could not find Image Writer for File Extension " + fileExtension );
		}
		ImageWriter imageWriter = (ImageWriter)iterator.next();
		JPEGImageWriteParam imageWriteParam = new JPEGImageWriteParam( Locale.getDefault() );
		imageWriteParam.setCompressionMode( JPEGImageWriteParam.MODE_EXPLICIT );
		imageWriteParam.setCompressionQuality( 0.3f );
		IIOImage iioImage = new IIOImage( resizedImage, null, null );
		ImageOutputStream ios = ImageIO.createImageOutputStream( dest );
		imageWriter.setOutput( ios );
		imageWriter.write( null, iioImage, imageWriteParam );
		ios.flush();
		ios.close();
		ios = null;

		srcImg.getGraphics().dispose();
		srcImg.flush();
		srcImg = null;
		resizedImage.getGraphics().dispose();
		resizedImage.flush();
		resizedImage = null;
	}
}
