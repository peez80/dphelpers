
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorePosition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StorePosition">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Internal"/>
 *     &lt;enumeration value="External"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StorePosition")
@XmlEnum
public enum StorePosition {

    @XmlEnumValue("Internal")
    INTERNAL("Internal"),
    @XmlEnumValue("External")
    EXTERNAL("External");
    private final String value;

    StorePosition(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StorePosition fromValue(String v) {
        for (StorePosition c: StorePosition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
