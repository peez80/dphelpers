
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkflowJobState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WorkflowJobState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Stopping"/>
 *     &lt;enumeration value="Pausing"/>
 *     &lt;enumeration value="Paused"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="Complete"/>
 *     &lt;enumeration value="Waiting"/>
 *     &lt;enumeration value="StoppedByUser"/>
 *     &lt;enumeration value="WaitingToRetry"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WorkflowJobState")
@XmlEnum
public enum WorkflowJobState {

    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("Stopping")
    STOPPING("Stopping"),
    @XmlEnumValue("Pausing")
    PAUSING("Pausing"),
    @XmlEnumValue("Paused")
    PAUSED("Paused"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("Complete")
    COMPLETE("Complete"),
    @XmlEnumValue("Waiting")
    WAITING("Waiting"),
    @XmlEnumValue("StoppedByUser")
    STOPPED_BY_USER("StoppedByUser"),
    @XmlEnumValue("WaitingToRetry")
    WAITING_TO_RETRY("WaitingToRetry");
    private final String value;

    WorkflowJobState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkflowJobState fromValue(String v) {
        for (WorkflowJobState c: WorkflowJobState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
