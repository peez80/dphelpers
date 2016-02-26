
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "JobDoesNotExistException", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
public class IWorkflowJobRestartJobJobDoesNotExistExceptionFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private JobDoesNotExistException faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public IWorkflowJobRestartJobJobDoesNotExistExceptionFaultFaultMessage(String message, JobDoesNotExistException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public IWorkflowJobRestartJobJobDoesNotExistExceptionFaultFaultMessage(String message, JobDoesNotExistException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: de.stiffi.media.telestreamvantage.api.generated.JobDoesNotExistException
     */
    public JobDoesNotExistException getFaultInfo() {
        return faultInfo;
    }

}
