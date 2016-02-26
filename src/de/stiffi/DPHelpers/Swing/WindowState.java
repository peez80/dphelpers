package de.stiffi.DPHelpers.Swing;

import java.awt.Component;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;

public class WindowState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Rectangle bounds = new Rectangle( 0, 0, 0, 0 );

	private boolean visible = false;

	private boolean enabled = false;

	private boolean maximized = false;

	private boolean iconified = false;

	private int dividerlocation = -1;

	public WindowState() {

	}

	public WindowState( Component c ) {
		readFromComponent( c );
	}

	public void readFromComponent( Component c ) {
		bounds = (Rectangle)c.getBounds().clone();
		visible = c.isVisible();
		enabled = c.isEnabled();

		if ( c instanceof JInternalFrame ) {
			JInternalFrame f = (JInternalFrame)c;

			bounds = f.getNormalBounds();
			this.maximized = f.isMaximum();
			this.iconified = f.isIcon();
		}

		if ( c instanceof JFrame ) {
			JFrame f = (JFrame)c;
			if ( f.getExtendedState() == JFrame.MAXIMIZED_BOTH ) {
				maximized = true;
			}
		}

		if ( c instanceof JSplitPane ) {
			JSplitPane p = (JSplitPane)c;
			dividerlocation = p.getDividerLocation();
		}
	}

	public void applyToComponent( Component c ) {
		c.setBounds( bounds );
		c.setEnabled( enabled );
		c.setVisible( visible );

		if ( c instanceof JInternalFrame ) {
			JInternalFrame f = (JInternalFrame)c;

			try {
				f.setMaximum( isMaximized() );
			} catch (PropertyVetoException e) {
			}

			try {
				f.setIcon( isIconified() );
			} catch (PropertyVetoException e) {
			}
		}
		if ( ( c instanceof JFrame ) ) {
			JFrame f = (JFrame)c;

			if ( isMaximized() ) {
				f.setExtendedState( JFrame.MAXIMIZED_BOTH );
			}
		}

		if ( c instanceof JSplitPane ) {
			JSplitPane p = (JSplitPane)c;
			p.setDividerLocation( dividerlocation );
		}
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds( Rectangle bounds ) {
		this.bounds = bounds;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible( boolean visible ) {
		this.visible = visible;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled( boolean enabled ) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		String s = getClass().getName() + "[ " + bounds.x + "," + bounds.y + "," + bounds.width + "," + bounds.height + "  ;  " + isVisible() + "  ; " + isEnabled() + "  ]";
		return s;
	}

	public boolean isMaximized() {
		return maximized;
	}

	public void setMaximized( boolean maximized ) {
		this.maximized = maximized;
	}

	public boolean isIconified() {
		return iconified;
	}

	public void setIconified( boolean iconified ) {
		this.iconified = iconified;
	}
}
