package de.stiffi.DPHelpers.Swing;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.table.DefaultTableCellRenderer;

/**
 * Dieser Renderer kann dafür verwendet werden, um Byte-Werte anzuzeigen.<br />
 * Hierbei wird automatisch zwischen Byte, kB, MB, GB, TB, PB unterschieden.
 * 
 * @author peez
 * 
 */
public class BytesRenderer extends DefaultTableCellRenderer {

	/**
	 * Konstante für Bytes
	 */
	public final static int		UNIT_BYTES			= 0;

	/**
	 * Konstante für KiloBytes
	 */
	public final static int		UNIT_KILOBYTES		= 1;

	/**
	 * Konstante für MegaBytes
	 */
	public final static int		UNIT_MEGABYTES		= 2;

	/**
	 * Konstante für GigaBytes
	 */
	public final static int		UNIT_GIGABYTES		= 3;

	/**
	 * Konstante für TeraBytes
	 */
	public final static int		UNIT_TERABYTES		= 4;

	/**
	 * Konstante für PetaBytes
	 */
	public final static int		UNIT_PETABYTES		= 5;

	/**
	 * Abkürzung für Bytes
	 */
	private String				byteUnit			= "Bytes";

	/**
	 * Abkürzung für KiloBytes
	 */
	private String				kiloByteUnit		= "kB";

	/**
	 * Abkürzung für MegaBytes
	 */
	private String				megaByteUnit		= "MB";

	/**
	 * Abkürzung für GigaBytes
	 */
	private String				gigaByteUnit		= "GB";

	/**
	 * Abkürzung für TeraBytes
	 */
	private String				teraByteUnit		= "TB";

	/**
	 * Abkürzung für PetaBytes
	 */
	private String				petaByteUnit		= "PB";

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 4696043869093797702L;

	/**
	 * Damit werden die Bytes umgerechnet. Kann alles sein, sinnvoll ist aber 1000 oder 1024
	 */
	private int					divisor				= 1024;

	/**
	 * Auch wenn der Wert größer ist, wird maximal bis auf diese Einheit runtergerechnet.
	 */
	private int					maxUnit				= UNIT_PETABYTES;

	/**
	 * Damit wird die berechnete Zahl formatiert.
	 */
	private NumberFormat		numberFormat		= new DecimalFormat();

	public BytesRenderer() {}

	@Override
	protected void setValue( Object value ) {
		if ( value instanceof Number ) {
			Number n = (Number)value;
			double val = n.doubleValue();
			int currentUnit = UNIT_BYTES;

			// Runterrechnen bis auf den gewünschten Wert
			while (currentUnit < maxUnit && val > divisor) {
				val /= divisor;
				currentUnit++;
			}

			String text = numberFormat.format( val ) + " ";
			switch (currentUnit) {
			case UNIT_BYTES:
				text += byteUnit;
				break;
			case UNIT_KILOBYTES:
				text += kiloByteUnit;
				break;
			case UNIT_MEGABYTES:
				text += megaByteUnit;
				break;
			case UNIT_GIGABYTES:
				text += gigaByteUnit;
				break;
			case UNIT_TERABYTES:
				text += teraByteUnit;
				break;
			case UNIT_PETABYTES:
				text += petaByteUnit;
				break;
			}

			setText( text );

		} else {
			super.setValue( value );
		}
	}

	public String getByteUnit() {
		return byteUnit;
	}

	public void setByteUnit( String byteUnit ) {
		this.byteUnit = byteUnit;
	}

	public String getKiloByteUnit() {
		return kiloByteUnit;
	}

	public void setKiloByteUnit( String kiloByteUnit ) {
		this.kiloByteUnit = kiloByteUnit;
	}

	public String getMegaByteUnit() {
		return megaByteUnit;
	}

	public void setMegaByteUnit( String megaByteUnit ) {
		this.megaByteUnit = megaByteUnit;
	}

	public String getGigaByteUnit() {
		return gigaByteUnit;
	}

	public void setGigaByteUnit( String gigaByteUnit ) {
		this.gigaByteUnit = gigaByteUnit;
	}

	public String getTeraByteUnit() {
		return teraByteUnit;
	}

	public void setTeraByteUnit( String teraByteUnit ) {
		this.teraByteUnit = teraByteUnit;
	}

	public String getPetaByteUnit() {
		return petaByteUnit;
	}

	public void setPetaByteUnit( String petaByteUnit ) {
		this.petaByteUnit = petaByteUnit;
	}

	public int getDivisor() {
		return divisor;
	}

	public void setDivisor( int divisor ) {
		this.divisor = divisor;
	}

	public int getMaxUnit() {
		return maxUnit;
	}

	public void setMaxUnit( int maxUnit ) {
		if ( maxUnit < UNIT_BYTES || maxUnit > UNIT_PETABYTES ) {
			throw new IllegalArgumentException( "maxUnit can only be between UNIT_BYTES(0) and UNIT_PETABYTES (5)" );
		}
		this.maxUnit = maxUnit;
	}

	public NumberFormat getNumberFormat() {
		return numberFormat;
	}

	public void setNumberFormat( NumberFormat numberFormat ) {
		this.numberFormat = numberFormat;
	}

}
