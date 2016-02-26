
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "PauseResumeNotSupportedException", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
public class IJobSessionPauseSessionPauseResumeNotSupportedExceptionFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private PauseResumeNotSupportedException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public IJobSessionPauseSessionPauseResumeNotSupportedExceptionFaultFaultMessage(String message, PauseResumeNotSupportedException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public IJobSessionPauseSessionPauseResumeNotSupportedExceptionFaultFaultMessage(String message, PauseResumeNotSupportedException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: de.stiffi.media.telestreamvantage.api.generated.PauseResumeNotSupportedException
     */
    public PauseResumeNotSupportedException getFaultInfo() {
        return faultInfo;
    }

}
