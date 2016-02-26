
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
@WebService(name = "IItem", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IItem {


    /**
     * 
     * @param identifier
     * @return
     *     returns java.lang.String
     * @throws IItemGetItemLocationUnlicensedSdkExceptionFaultFaultMessage
     * @throws IItemGetItemLocationItemDoesNotExistExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "GetItemLocation", action = "http://Telestream.Vantage.Sdk/2010/07/IItem/GetItemLocation")
    @WebResult(name = "GetItemLocationResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "GetItemLocation", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetItemLocation")
    @ResponseWrapper(localName = "GetItemLocationResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetItemLocationResponse")
    public String getItemLocation(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier)
        throws IItemGetItemLocationItemDoesNotExistExceptionFaultFaultMessage, IItemGetItemLocationUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param newItemDefinition
     * @param identifier
     * @throws IItemUpdateItemItemDoesNotExistExceptionFaultFaultMessage
     * @throws IItemUpdateItemUnlicensedSdkExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "UpdateItem", action = "http://Telestream.Vantage.Sdk/2010/07/IItem/UpdateItem")
    @RequestWrapper(localName = "UpdateItem", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.UpdateItem")
    @ResponseWrapper(localName = "UpdateItemResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.UpdateItemResponse")
    public void updateItem(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier,
        @WebParam(name = "newItemDefinition", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        Item newItemDefinition)
        throws IItemUpdateItemItemDoesNotExistExceptionFaultFaultMessage, IItemUpdateItemUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param identifier
     * @return
     *     returns de.stiffi.media.telestreamvantage.api.generated.ArrayOfstring
     * @throws IItemGetItemFilePathsUnlicensedSdkExceptionFaultFaultMessage
     * @throws IItemGetItemFilePathsItemDoesNotExistExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "GetItemFilePaths", action = "http://Telestream.Vantage.Sdk/2010/07/IItem/GetItemFilePaths")
    @WebResult(name = "GetItemFilePathsResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "GetItemFilePaths", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetItemFilePaths")
    @ResponseWrapper(localName = "GetItemFilePathsResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetItemFilePathsResponse")
    public ArrayOfstring getItemFilePaths(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier)
        throws IItemGetItemFilePathsItemDoesNotExistExceptionFaultFaultMessage, IItemGetItemFilePathsUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param identifier
     * @return
     *     returns java.lang.String
     * @throws IItemGetRootItemFileUnlicensedSdkExceptionFaultFaultMessage
     * @throws IItemGetRootItemFileItemDoesNotExistExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "GetRootItemFile", action = "http://Telestream.Vantage.Sdk/2010/07/IItem/GetRootItemFile")
    @WebResult(name = "GetRootItemFileResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "GetRootItemFile", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetRootItemFile")
    @ResponseWrapper(localName = "GetRootItemFileResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetRootItemFileResponse")
    public String getRootItemFile(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier)
        throws IItemGetRootItemFileItemDoesNotExistExceptionFaultFaultMessage, IItemGetRootItemFileUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param identifier
     * @return
     *     returns de.stiffi.media.telestreamvantage.api.generated.ArrayOfguid
     * @throws IItemGetItemFilesUnlicensedSdkExceptionFaultFaultMessage
     * @throws IItemGetItemFilesItemDoesNotExistExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "GetItemFiles", action = "http://Telestream.Vantage.Sdk/2010/07/IItem/GetItemFiles")
    @WebResult(name = "GetItemFilesResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "GetItemFiles", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetItemFiles")
    @ResponseWrapper(localName = "GetItemFilesResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetItemFilesResponse")
    public ArrayOfguid getItemFiles(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier)
        throws IItemGetItemFilesItemDoesNotExistExceptionFaultFaultMessage, IItemGetItemFilesUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param identifier
     * @return
     *     returns de.stiffi.media.telestreamvantage.api.generated.Summary
     * @throws IItemGetSummaryItemDoesNotExistExceptionFaultFaultMessage
     * @throws IItemGetSummaryUnlicensedSdkExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "GetSummary", action = "http://Telestream.Vantage.Sdk/2010/07/IItem/GetSummary")
    @WebResult(name = "GetSummaryResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "GetSummary", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetSummary")
    @ResponseWrapper(localName = "GetSummaryResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetSummaryResponse")
    public Summary getSummary(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier)
        throws IItemGetSummaryItemDoesNotExistExceptionFaultFaultMessage, IItemGetSummaryUnlicensedSdkExceptionFaultFaultMessage
    ;

}