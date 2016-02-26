
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TextEncoding.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TextEncoding">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ascii"/>
 *     &lt;enumeration value="Utf8"/>
 *     &lt;enumeration value="Utf8NoBom"/>
 *     &lt;enumeration value="Utf16LittleEndian"/>
 *     &lt;enumeration value="Utf16BigEndian"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TextEncoding", namespace = "http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary")
@XmlEnum
public enum TextEncoding {

    @XmlEnumValue("Ascii")
    ASCII("Ascii"),
    @XmlEnumValue("Utf8")
    UTF_8("Utf8"),
    @XmlEnumValue("Utf8NoBom")
    UTF_8_NO_BOM("Utf8NoBom"),
    @XmlEnumValue("Utf16LittleEndian")
    UTF_16_LITTLE_ENDIAN("Utf16LittleEndian"),
    @XmlEnumValue("Utf16BigEndian")
    UTF_16_BIG_ENDIAN("Utf16BigEndian");
    private final String value;

    TextEncoding(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TextEncoding fromValue(String v) {
        for (TextEncoding c: TextEncoding.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
