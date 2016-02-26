
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TypeCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Empty"/>
 *     &lt;enumeration value="Boolean"/>
 *     &lt;enumeration value="Char"/>
 *     &lt;enumeration value="SByte"/>
 *     &lt;enumeration value="Byte"/>
 *     &lt;enumeration value="ByteArray"/>
 *     &lt;enumeration value="Int16"/>
 *     &lt;enumeration value="UInt16"/>
 *     &lt;enumeration value="Int32"/>
 *     &lt;enumeration value="UInt32"/>
 *     &lt;enumeration value="Int64"/>
 *     &lt;enumeration value="UInt64"/>
 *     &lt;enumeration value="Single"/>
 *     &lt;enumeration value="Double"/>
 *     &lt;enumeration value="Decimal"/>
 *     &lt;enumeration value="DateTime"/>
 *     &lt;enumeration value="Guid"/>
 *     &lt;enumeration value="String"/>
 *     &lt;enumeration value="Uri"/>
 *     &lt;enumeration value="Color"/>
 *     &lt;enumeration value="Image"/>
 *     &lt;enumeration value="TimeSpan"/>
 *     &lt;enumeration value="TimeCode"/>
 *     &lt;enumeration value="MailAddressCollection"/>
 *     &lt;enumeration value="Complex"/>
 *     &lt;enumeration value="Priority"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TypeCode")
@XmlEnum
public enum TypeCode {

    @XmlEnumValue("Empty")
    EMPTY("Empty"),
    @XmlEnumValue("Boolean")
    BOOLEAN("Boolean"),
    @XmlEnumValue("Char")
    CHAR("Char"),
    @XmlEnumValue("SByte")
    S_BYTE("SByte"),
    @XmlEnumValue("Byte")
    BYTE("Byte"),
    @XmlEnumValue("ByteArray")
    BYTE_ARRAY("ByteArray"),
    @XmlEnumValue("Int16")
    INT_16("Int16"),
    @XmlEnumValue("UInt16")
    U_INT_16("UInt16"),
    @XmlEnumValue("Int32")
    INT_32("Int32"),
    @XmlEnumValue("UInt32")
    U_INT_32("UInt32"),
    @XmlEnumValue("Int64")
    INT_64("Int64"),
    @XmlEnumValue("UInt64")
    U_INT_64("UInt64"),
    @XmlEnumValue("Single")
    SINGLE("Single"),
    @XmlEnumValue("Double")
    DOUBLE("Double"),
    @XmlEnumValue("Decimal")
    DECIMAL("Decimal"),
    @XmlEnumValue("DateTime")
    DATE_TIME("DateTime"),
    @XmlEnumValue("Guid")
    GUID("Guid"),
    @XmlEnumValue("String")
    STRING("String"),
    @XmlEnumValue("Uri")
    URI("Uri"),
    @XmlEnumValue("Color")
    COLOR("Color"),
    @XmlEnumValue("Image")
    IMAGE("Image"),
    @XmlEnumValue("TimeSpan")
    TIME_SPAN("TimeSpan"),
    @XmlEnumValue("TimeCode")
    TIME_CODE("TimeCode"),
    @XmlEnumValue("MailAddressCollection")
    MAIL_ADDRESS_COLLECTION("MailAddressCollection"),
    @XmlEnumValue("Complex")
    COMPLEX("Complex"),
    @XmlEnumValue("Priority")
    PRIORITY("Priority");
    private final String value;

    TypeCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeCode fromValue(String v) {
        for (TypeCode c: TypeCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
