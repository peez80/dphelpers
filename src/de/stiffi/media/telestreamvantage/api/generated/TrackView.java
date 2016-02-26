
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrackView.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackView">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="Table"/>
 *     &lt;enumeration value="Image"/>
 *     &lt;enumeration value="Graph"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackView")
@XmlEnum
public enum TrackView {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("Table")
    TABLE("Table"),
    @XmlEnumValue("Image")
    IMAGE("Image"),
    @XmlEnumValue("Graph")
    GRAPH("Graph");
    private final String value;

    TrackView(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TrackView fromValue(String v) {
        for (TrackView c: TrackView.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
