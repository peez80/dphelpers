package de.stiffi.DPHelpers.Swing;

import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class DPSwingHelpers {

	/**
	 * Alignment links
	 */
	public static final int LEFT = 0x1;

	/**
	 * Zentriert (gilt für horizontal und vertikal)
	 */
	public static final int CENTER = 0x2;

	/**
	 * Alignment Rechts
	 */
	public static final int RIGHT = 0x3;

	/**
	 * Alignment oben
	 */
	public static final int TOP = 0x4;

	/**
	 * Alignment unten
	 */
	public static final int BOTTOM = 0x5;

	/**
	 * Blocksatz (kann für horizontal und vertikal verwendet werden)
	 */
	public static final int JUSTIFY = 0x6;

	/**
	 * Zeichnet einen ausgerichteten String auf der Zeichenfläche.
	 * <p>
	 * Der String wird sowohl horizontal als auch vertikal innerhalb der übergebenen area ausgerichtet.
	 * <p>
	 * Ist der String länger als der Platz, wird auch entsprechend außerhalb gezeichnet, damit die Alignments passen.
	 * 
	 * @see #LEFT
	 * @see #CENTER
	 * @see #RIGHT
	 * @see #TOP
	 * @see #BOTTOM
	 * @see #JUSTIFY
	 * 
	 * @param g Graphics Objekt, auf das gezeichnet wird
	 * @param area innerhalb dieser Area wird der Text angeordnet
	 * @param text Dieser Text wird gezeichnet
	 * @param horizontalAlignment Horizontale Ausrichtugn
	 * @param verticalAlignment
	 */
	public static void drawAlignedString( Graphics g, Rectangle area, String text, int horizontalAlignment, int verticalAlignment ) {
		FontMetrics fm = g.getFontMetrics();

		// Bounds des Textes auslesen
		String textLines[] = text.split( "\n" );

		int linesCount = textLines.length;
		int textHeight = fm.getHeight() * linesCount;
		int lineHeight = fm.getHeight();

		// Wenn vertikaler Blocksatz, dann die Zeilenhöhe entspr. anpassen
		if ( verticalAlignment == JUSTIFY ) {
			// Texthöhe ohne Zeilenabstand berechnen
			int rawTextHeight = textLines.length * ( fm.getAscent() + fm.getDescent() );

			int gesamtSpace = area.height - rawTextHeight;
			int lineSpacing = fm.getLeading();
			if ( textLines.length > 1 ) { // Division by 0 vermeiden
				lineSpacing = gesamtSpace / ( textLines.length - 1 );
			}

			lineHeight = fm.getAscent() + fm.getDescent() + lineSpacing;
			textHeight = area.height;
		}

		// Zuerst die vertikale Start-Position des Blocks raussuchen
		// Vertikale Position festlegen dazu im Switch die links-obere Ecke
		// raussuchen, danach einfach + getAscent()
		int yGesamt = area.y;
		switch (verticalAlignment) {
		case TOP:
		case JUSTIFY:
			yGesamt = area.y;
			break;
		case CENTER:
			yGesamt = area.y + ( ( area.height - textHeight ) / 2 );
			break;
		case BOTTOM:
			yGesamt = area.y + ( area.height - textHeight );
			break;
		}
		int yPos = yGesamt + fm.getAscent(); // Am Ende jetzt die Baseline (von wo aus gezeichnet wird) festlegen

		// X-Position muss für jede Zeile extra berechnet werden
		for ( String textLine : textLines ) {
			int stringWidth = fm.stringWidth( textLine );
			// Horizontale Position festlegen
			int xPos = area.x;
			switch (horizontalAlignment) {
			case LEFT:
			case JUSTIFY:
				xPos = area.x;
				break;
			case CENTER:
				xPos = area.x + ( ( area.width - stringWidth ) / 2 );
				break;
			case RIGHT:
				xPos = area.x + ( area.width - stringWidth );
				break;
			}

			// Und Zeile zeichnen
			if ( horizontalAlignment == JUSTIFY ) {
				// Bei Blocksatz muss der Abstand jedes Wortes manuell geregelt werden

				String words[] = textLine.split( " " );
				int allWordsLength = 0; // Gesamtlänge der Wörter ohne Leerzeichen
				for ( String word : words ) {
					allWordsLength += fm.stringWidth( word.trim() );
				}
				int gesamtSpace = area.width - allWordsLength;
				int wordSpacing = fm.stringWidth( " " );

				if ( words.length > 1 ) { // auf >1 abfragen um Division by 0 zu verhindern
					wordSpacing = gesamtSpace / ( words.length - 1 );
				}

				// Jetzt jedes Wort einzeln zeichnen
				for ( String word : words ) {
					g.drawString( word, xPos, yPos );
					xPos += ( fm.stringWidth( word ) + wordSpacing );
				}

			} else {
				g.drawString( textLine, xPos, yPos );
			}
			yPos += lineHeight;
		}
	}

	public static void watchComponentDetails( Component c, final String watchID ) {
		c.addPropertyChangeListener( new PropertyChangeListener() {

			@Override
			public void propertyChange( PropertyChangeEvent evt ) {
				System.err.println( "propertyChange[" + watchID + "]:  " + evt.getPropertyName() + ": " + evt.getOldValue() + " -> " + evt.getNewValue() );

			}

		} );
		c.addComponentListener( new ComponentListener() {

			@Override
			public void componentHidden( ComponentEvent e ) {
				System.err.println( "[" + watchID + "]:  " + "componentHidden " + e.getComponent() );

			}

			@Override
			public void componentMoved( ComponentEvent e ) {
				System.err.println( "[" + watchID + "]:  " + "componentMoved " + e.getComponent().getBounds() );

			}

			@Override
			public void componentResized( ComponentEvent e ) {
				System.err.println( "[" + watchID + "]:  " + "componentResized " + e.getComponent().getBounds() );
			}

			@Override
			public void componentShown( ComponentEvent e ) {
				System.err.println( "[" + watchID + "]:  " + "componentShown " + e.getComponent() );
			}
		} );

		if ( c instanceof JInternalFrame ) {
			( (JInternalFrame)c ).addInternalFrameListener( new InternalFrameListener() {

				@Override
				public void internalFrameOpened( InternalFrameEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "internalFrameOpened " + e.getInternalFrame().toString() );

				}

				@Override
				public void internalFrameIconified( InternalFrameEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "internalFrameIconified " + e.getInternalFrame().toString() );
				}

				@Override
				public void internalFrameDeiconified( InternalFrameEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "internalFrameDeiconified " + e.getInternalFrame().toString() );
				}

				@Override
				public void internalFrameDeactivated( InternalFrameEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "internalFrameDeactivated " + e.getInternalFrame().toString() );
				}

				@Override
				public void internalFrameClosing( InternalFrameEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "internalFrameClosing " + e.getInternalFrame().toString() );
				}

				@Override
				public void internalFrameClosed( InternalFrameEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "internalFrameClosed " + e.getInternalFrame().toString() );
				}

				@Override
				public void internalFrameActivated( InternalFrameEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "internalFrameActivated " + e.getInternalFrame().toString() );
				}
			} );

			c.addMouseListener( new MouseListener() {

				@Override
				public void mouseReleased( MouseEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "mouseReleased " + e.getComponent().toString() );
				}

				@Override
				public void mousePressed( MouseEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "mousePressed " + e.getComponent().toString() );
				}

				@Override
				public void mouseExited( MouseEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "mouseExited " + e.getComponent().toString() );
				}

				@Override
				public void mouseEntered( MouseEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "mouseEntered " + e.getComponent().toString() );
				}

				@Override
				public void mouseClicked( MouseEvent e ) {
					System.err.println( "[" + watchID + "]:  " + "mouseClicked " + e.getComponent().toString() );
				}
			} );

			if ( c instanceof Window ) {
				Window w = (Window)c;

				w.addWindowListener( new WindowListener() {

					@Override
					public void windowActivated( WindowEvent e ) {
						System.err.println( "[" + watchID + "]:  " + "windowActivated " + e.getWindow().toString() );

					}

					@Override
					public void windowClosed( WindowEvent e ) {
						System.err.println( "[" + watchID + "]:  " + "windowClosed " + e.getWindow().toString() );

					}

					@Override
					public void windowClosing( WindowEvent e ) {
						System.err.println( "[" + watchID + "]:  " + "windowClosing " + e.getWindow().toString() );

					}

					@Override
					public void windowDeactivated( WindowEvent e ) {
						System.err.println( "[" + watchID + "]:  " + "windowDeactivated " + e.getWindow().toString() );
					}

					@Override
					public void windowDeiconified( WindowEvent e ) {
						System.err.println( "[" + watchID + "]:  " + "windowDeiconified " + e.getWindow().toString() );

					}

					@Override
					public void windowIconified( WindowEvent e ) {
						System.err.println( "[" + watchID + "]:  " + "windowIconified " + e.getWindow().toString() );
					}

					@Override
					public void windowOpened( WindowEvent e ) {
						System.err.println( "[" + watchID + "]:  " + "windowOpened " + e.getWindow().toString() );
					}

				} );

				w.addWindowStateListener( new WindowStateListener() {

					@Override
					public void windowStateChanged( WindowEvent e ) {

						System.err.println( "[" + watchID + "]:  " + "windowStateChanged from " + getWindowStateText( e.getOldState() ) + " to " + getWindowStateText( e.getNewState() ) );

					}

				} );
			}

		}
	}

	private static String getWindowStateText( int windowState ) {

		/*
		 * WINDOW_ACTIVATED The window-activated event type. static int WINDOW_CLOSED The window closed event. static int WINDOW_CLOSING The "window is closing" event. static int WINDOW_DEACTIVATED The window-deactivated event type. static int
		 * WINDOW_DEICONIFIED The window deiconified event type. static int WINDOW_FIRST The first number in the range of ids used for window events. static int WINDOW_GAINED_FOCUS The window-gained-focus event type. static int WINDOW_ICONIFIED The window
		 * iconified event. static int WINDOW_LAST The last number in the range of ids used for window events. static int WINDOW_LOST_FOCUS The window-lost-focus event type. static int WINDOW_OPENED The window opened event. static int WINDOW_STATE_CHANGED
		 */

		String s = "Unknown";
		switch (windowState) {
		case WindowEvent.WINDOW_ACTIVATED:
			s = "WINDOW_ACTIVATED";
			break;
		case WindowEvent.WINDOW_CLOSED:
			s = "WINDOW_CLOSED";
			break;
		case WindowEvent.WINDOW_CLOSING:
			s = "WINDOW_CLOSING";
			break;
		case WindowEvent.WINDOW_DEACTIVATED:
			s = "WINDOW_DEACTIVATED";
			break;
		case WindowEvent.WINDOW_DEICONIFIED:
			s = "WINDOW_DEICONIFIED";
			break;

		case WindowEvent.WINDOW_GAINED_FOCUS:
			s = "WINDOW_GAINED_FOCUS";
			break;
		case WindowEvent.WINDOW_ICONIFIED:
			s = "WINDOW_ICONIFIED";
			break;
		case WindowEvent.WINDOW_LOST_FOCUS:
			s = "WINDOW_LOST_FOCUS";
			break;
		case WindowEvent.WINDOW_OPENED:
			s = "WINDOW_OPENED";
			break;
		case WindowEvent.WINDOW_STATE_CHANGED:
			s = "WINDOW_STATE_CHANGED";
			break;
		}

		return s;
	}
}
