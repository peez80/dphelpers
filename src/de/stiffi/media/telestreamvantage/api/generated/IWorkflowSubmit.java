
package de.stiffi.media.telestreamvantage.api.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "IWorkflowSubmit", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IWorkflowSubmit {


    /**
     * 
     * @param sourceFilename
     * @param workflowIdentifier
     * @param context
     * @param jobName
     * @return
     *     returns java.lang.String
     * @throws IWorkflowSubmitSubmitFileWorkflowInvalidStateExceptionFaultFaultMessage
     * @throws IWorkflowSubmitSubmitFileUnlicensedSdkExceptionFaultFaultMessage
     * @throws IWorkflowSubmitSubmitFileWorkflowDoesNotExistExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "SubmitFile", action = "http://Telestream.Vantage.Sdk/2010/07/IWorkflowSubmit/SubmitFile")
    @WebResult(name = "SubmitFileResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "SubmitFile", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.SubmitFile")
    @ResponseWrapper(localName = "SubmitFileResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.SubmitFileResponse")
    public String submitFile(
        @WebParam(name = "workflowIdentifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String workflowIdentifier,
        @WebParam(name = "sourceFilename", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String sourceFilename,
        @WebParam(name = "context", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        Context context,
        @WebParam(name = "jobName", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String jobName)
        throws IWorkflowSubmitSubmitFileUnlicensedSdkExceptionFaultFaultMessage, IWorkflowSubmitSubmitFileWorkflowDoesNotExistExceptionFaultFaultMessage, IWorkflowSubmitSubmitFileWorkflowInvalidStateExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param sourceFilename
     * @param workflowIdentifier
     * @param context
     * @param jobName
     * @param requiredItems
     * @return
     *     returns java.lang.String
     * @throws IWorkflowSubmitSubmitFileAndItemsWorkflowInvalidStateExceptionFaultFaultMessage
     * @throws IWorkflowSubmitSubmitFileAndItemsUnlicensedSdkExceptionFaultFaultMessage
     * @throws IWorkflowSubmitSubmitFileAndItemsWorkflowDoesNotExistExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "SubmitFileAndItems", action = "http://Telestream.Vantage.Sdk/2010/07/IWorkflowSubmit/SubmitFileAndItems")
    @WebResult(name = "SubmitFileAndItemsResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "SubmitFileAndItems", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.SubmitFileAndItems")
    @ResponseWrapper(localName = "SubmitFileAndItemsResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.SubmitFileAndItemsResponse")
    public String submitFileAndItems(
        @WebParam(name = "workflowIdentifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String workflowIdentifier,
        @WebParam(name = "sourceFilename", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String sourceFilename,
        @WebParam(name = "context", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        Context context,
        @WebParam(name = "requiredItems", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        ArrayOfItem requiredItems,
        @WebParam(name = "jobName", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String jobName)
        throws IWorkflowSubmitSubmitFileAndItemsUnlicensedSdkExceptionFaultFaultMessage, IWorkflowSubmitSubmitFileAndItemsWorkflowDoesNotExistExceptionFaultFaultMessage, IWorkflowSubmitSubmitFileAndItemsWorkflowInvalidStateExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param workflowIdentifier
     * @param context
     * @param sourceBinderIdentifier
     * @param jobName
     * @return
     *     returns java.lang.String
     * @throws IWorkflowSubmitSubmitBinderWorkflowDoesNotExistExceptionFaultFaultMessage
     * @throws IWorkflowSubmitSubmitBinderUnlicensedSdkExceptionFaultFaultMessage
     * @throws IWorkflowSubmitSubmitBinderWorkflowInvalidStateExceptionFaultFaultMessage
     * @throws IWorkflowSubmitSubmitBinderCatalogAccessExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "SubmitBinder", action = "http://Telestream.Vantage.Sdk/2010/07/IWorkflowSubmit/SubmitBinder")
    @WebResult(name = "SubmitBinderResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "SubmitBinder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.SubmitBinder")
    @ResponseWrapper(localName = "SubmitBinderResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.SubmitBinderResponse")
    public String submitBinder(
        @WebParam(name = "workflowIdentifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String workflowIdentifier,
        @WebParam(name = "sourceBinderIdentifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String sourceBinderIdentifier,
        @WebParam(name = "context", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        Context context,
        @WebParam(name = "jobName", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String jobName)
        throws IWorkflowSubmitSubmitBinderCatalogAccessExceptionFaultFaultMessage, IWorkflowSubmitSubmitBinderUnlicensedSdkExceptionFaultFaultMessage, IWorkflowSubmitSubmitBinderWorkflowDoesNotExistExceptionFaultFaultMessage, IWorkflowSubmitSubmitBinderWorkflowInvalidStateExceptionFaultFaultMessage
    ;

}
