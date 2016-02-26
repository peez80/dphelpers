
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
@WebService(name = "ICatalog", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ICatalog {


    /**
     * 
     * @param currentFolder
     * @return
     *     returns de.stiffi.media.telestreamvantage.api.generated.ArrayOfFolderType
     * @throws ICatalogListFoldersUnlicensedSdkExceptionFaultFaultMessage
     * @throws ICatalogListFoldersCatalogAccessExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "ListFolders", action = "http://Telestream.Vantage.Sdk/2010/07/ICatalog/ListFolders")
    @WebResult(name = "ListFoldersResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "ListFolders", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.ListFolders")
    @ResponseWrapper(localName = "ListFoldersResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.ListFoldersResponse")
    public ArrayOfFolderType listFolders(
        @WebParam(name = "currentFolder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String currentFolder)
        throws ICatalogListFoldersCatalogAccessExceptionFaultFaultMessage, ICatalogListFoldersUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param currentFolder
     * @return
     *     returns de.stiffi.media.telestreamvantage.api.generated.ArrayOfBinderType
     * @throws ICatalogListBindersUnlicensedSdkExceptionFaultFaultMessage
     * @throws ICatalogListBindersCatalogAccessExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "ListBinders", action = "http://Telestream.Vantage.Sdk/2010/07/ICatalog/ListBinders")
    @WebResult(name = "ListBindersResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "ListBinders", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.ListBinders")
    @ResponseWrapper(localName = "ListBindersResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.ListBindersResponse")
    public ArrayOfBinderType listBinders(
        @WebParam(name = "currentFolder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String currentFolder)
        throws ICatalogListBindersCatalogAccessExceptionFaultFaultMessage, ICatalogListBindersUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param identifier
     * @return
     *     returns de.stiffi.media.telestreamvantage.api.generated.FolderType
     * @throws ICatalogGetFolderCatalogAccessExceptionFaultFaultMessage
     * @throws ICatalogGetFolderUnlicensedSdkExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "GetFolder", action = "http://Telestream.Vantage.Sdk/2010/07/ICatalog/GetFolder")
    @WebResult(name = "GetFolderResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "GetFolder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetFolder")
    @ResponseWrapper(localName = "GetFolderResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetFolderResponse")
    public FolderType getFolder(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier)
        throws ICatalogGetFolderCatalogAccessExceptionFaultFaultMessage, ICatalogGetFolderUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param identifier
     * @return
     *     returns de.stiffi.media.telestreamvantage.api.generated.BinderType
     * @throws ICatalogGetBinderCatalogAccessExceptionFaultFaultMessage
     * @throws ICatalogGetBinderUnlicensedSdkExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "GetBinder", action = "http://Telestream.Vantage.Sdk/2010/07/ICatalog/GetBinder")
    @WebResult(name = "GetBinderResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "GetBinder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetBinder")
    @ResponseWrapper(localName = "GetBinderResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetBinderResponse")
    public BinderType getBinder(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier)
        throws ICatalogGetBinderCatalogAccessExceptionFaultFaultMessage, ICatalogGetBinderUnlicensedSdkExceptionFaultFaultMessage
    ;

}
