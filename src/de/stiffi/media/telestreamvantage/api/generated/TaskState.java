
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaskState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Created"/>
 *     &lt;enumeration value="WaitingInput"/>
 *     &lt;enumeration value="InProcess"/>
 *     &lt;enumeration value="Paused"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="Succeeded"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaskState")
@XmlEnum
public enum TaskState {

    @XmlEnumValue("Created")
    CREATED("Created"),
    @XmlEnumValue("WaitingInput")
    WAITING_INPUT("WaitingInput"),
    @XmlEnumValue("InProcess")
    IN_PROCESS("InProcess"),
    @XmlEnumValue("Paused")
    PAUSED("Paused"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("Succeeded")
    SUCCEEDED("Succeeded");
    private final String value;

    TaskState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskState fromValue(String v) {
        for (TaskState c: TaskState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
