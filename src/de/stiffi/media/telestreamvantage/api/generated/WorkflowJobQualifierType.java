
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkflowJobQualifierType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WorkflowJobQualifierType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="Paused"/>
 *     &lt;enumeration value="Complete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WorkflowJobQualifierType")
@XmlEnum
public enum WorkflowJobQualifierType {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("Paused")
    PAUSED("Paused"),
    @XmlEnumValue("Complete")
    COMPLETE("Complete");
    private final String value;

    WorkflowJobQualifierType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkflowJobQualifierType fromValue(String v) {
        for (WorkflowJobQualifierType c: WorkflowJobQualifierType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
