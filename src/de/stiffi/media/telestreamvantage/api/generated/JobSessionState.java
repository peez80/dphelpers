
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobSessionState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JobSessionState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Ignored"/>
 *     &lt;enumeration value="Complete"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Idle"/>
 *     &lt;enumeration value="Paused"/>
 *     &lt;enumeration value="Interrupted"/>
 *     &lt;enumeration value="Suspended"/>
 *     &lt;enumeration value="StoppedByUser"/>
 *     &lt;enumeration value="WaitingToRetry"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JobSessionState")
@XmlEnum
public enum JobSessionState {

    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("Ignored")
    IGNORED("Ignored"),
    @XmlEnumValue("Complete")
    COMPLETE("Complete"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Idle")
    IDLE("Idle"),
    @XmlEnumValue("Paused")
    PAUSED("Paused"),
    @XmlEnumValue("Interrupted")
    INTERRUPTED("Interrupted"),
    @XmlEnumValue("Suspended")
    SUSPENDED("Suspended"),
    @XmlEnumValue("StoppedByUser")
    STOPPED_BY_USER("StoppedByUser"),
    @XmlEnumValue("WaitingToRetry")
    WAITING_TO_RETRY("WaitingToRetry");
    private final String value;

    JobSessionState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JobSessionState fromValue(String v) {
        for (JobSessionState c: JobSessionState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
