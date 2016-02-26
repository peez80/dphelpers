
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TextEncoderFallback.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TextEncoderFallback">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fail"/>
 *     &lt;enumeration value="Replacement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TextEncoderFallback", namespace = "http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary")
@XmlEnum
public enum TextEncoderFallback {

    @XmlEnumValue("Fail")
    FAIL("Fail"),
    @XmlEnumValue("Replacement")
    REPLACEMENT("Replacement");
    private final String value;

    TextEncoderFallback(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TextEncoderFallback fromValue(String v) {
        for (TextEncoderFallback c: TextEncoderFallback.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
