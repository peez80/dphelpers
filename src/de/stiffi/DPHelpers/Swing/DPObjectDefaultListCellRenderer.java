package de.stiffi.DPHelpers.Swing;

import java.awt.Component;
import java.lang.reflect.InvocationTargetException;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import de.stiffi.DPHelpers.ReflectionHelper;

/**
 * Ein {@link ListCellRenderer}, der im Konstruktor einen Membenamen mitgegeben bekommt und dann
 * beim Rendern den entsprechenden Getter zum übergebenen Membernamen aufruft.
 * 
 * <br>
 * Es wird davon ausgegangen, dass dieser Member ein String oder ein Objekt mit passendem
 * .toString() ist.
 * 
 * @author peez
 * 
 */
public class DPObjectDefaultListCellRenderer extends DefaultListCellRenderer {

	/**
	 * Getter für diesen Member wird aufgerufen
	 */
	private String	memberName;

	/**
	 * Konstruktor
	 * 
	 * @param memberName Name des Members, der zum Anzeigen des gerenderten Texts verwendet wird.
	 *            Der Member muss ein String oder ein Objekt mit passender .toString() Methode sein.
	 */
	public DPObjectDefaultListCellRenderer( String memberName ) {
		this.memberName = memberName;
	}

	@Override
	public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
		// TODO Auto-generated method stub
		Component comp = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );

		if ( value != null && comp != null ) {
			ReflectionHelper<Object> reflObject = new ReflectionHelper<Object>( value );
			ReflectionHelper<Component> reflComponent = new ReflectionHelper<Component>( comp );

			try {
				Object text = reflObject.invokeGetter( memberName );
				if ( text != null ) {
					reflComponent.invokeSetter( "text", text.toString() );
				}

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return comp;

	}

}
