
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
@WebService(name = "IBinder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IBinder {


    /**
     * 
     * @param identifier
     * @throws IBinderRemoveBinderUnlicensedSdkExceptionFaultFaultMessage
     * @throws IBinderRemoveBinderCatalogAccessExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "RemoveBinder", action = "http://Telestream.Vantage.Sdk/2010/07/IBinder/RemoveBinder")
    @RequestWrapper(localName = "RemoveBinder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.RemoveBinder")
    @ResponseWrapper(localName = "RemoveBinderResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.RemoveBinderResponse")
    public void removeBinder(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier)
        throws IBinderRemoveBinderCatalogAccessExceptionFaultFaultMessage, IBinderRemoveBinderUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param identifierOfFolderToMoveTo
     * @param identifier
     * @throws IBinderMoveBinderCatalogAccessExceptionFaultFaultMessage
     * @throws IBinderMoveBinderUnlicensedSdkExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "MoveBinder", action = "http://Telestream.Vantage.Sdk/2010/07/IBinder/MoveBinder")
    @RequestWrapper(localName = "MoveBinder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.MoveBinder")
    @ResponseWrapper(localName = "MoveBinderResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.MoveBinderResponse")
    public void moveBinder(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier,
        @WebParam(name = "identifierOfFolderToMoveTo", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifierOfFolderToMoveTo)
        throws IBinderMoveBinderCatalogAccessExceptionFaultFaultMessage, IBinderMoveBinderUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param itemToAdd
     * @param identifier
     * @throws IBinderAddItemToBinderDuplicateItemExceptionFaultFaultMessage
     * @throws IBinderAddItemToBinderUnlicensedSdkExceptionFaultFaultMessage
     * @throws IBinderAddItemToBinderCatalogAccessExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "AddItemToBinder", action = "http://Telestream.Vantage.Sdk/2010/07/IBinder/AddItemToBinder")
    @RequestWrapper(localName = "AddItemToBinder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.AddItemToBinder")
    @ResponseWrapper(localName = "AddItemToBinderResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.AddItemToBinderResponse")
    public void addItemToBinder(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier,
        @WebParam(name = "itemToAdd", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        Item itemToAdd)
        throws IBinderAddItemToBinderCatalogAccessExceptionFaultFaultMessage, IBinderAddItemToBinderDuplicateItemExceptionFaultFaultMessage, IBinderAddItemToBinderUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param identifier
     * @param itemIdentifier
     * @throws IBinderRemoveItemFromBinderCatalogAccessExceptionFaultFaultMessage
     * @throws IBinderRemoveItemFromBinderUnlicensedSdkExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "RemoveItemFromBinder", action = "http://Telestream.Vantage.Sdk/2010/07/IBinder/RemoveItemFromBinder")
    @RequestWrapper(localName = "RemoveItemFromBinder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.RemoveItemFromBinder")
    @ResponseWrapper(localName = "RemoveItemFromBinderResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.RemoveItemFromBinderResponse")
    public void removeItemFromBinder(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier,
        @WebParam(name = "itemIdentifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String itemIdentifier)
        throws IBinderRemoveItemFromBinderCatalogAccessExceptionFaultFaultMessage, IBinderRemoveItemFromBinderUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param itemToUpdate
     * @param identifier
     * @throws IBinderUpdateItemInBinderCatalogAccessExceptionFaultFaultMessage
     * @throws IBinderUpdateItemInBinderUnlicensedSdkExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "UpdateItemInBinder", action = "http://Telestream.Vantage.Sdk/2010/07/IBinder/UpdateItemInBinder")
    @RequestWrapper(localName = "UpdateItemInBinder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.UpdateItemInBinder")
    @ResponseWrapper(localName = "UpdateItemInBinderResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.UpdateItemInBinderResponse")
    public void updateItemInBinder(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier,
        @WebParam(name = "itemToUpdate", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        Item itemToUpdate)
        throws IBinderUpdateItemInBinderCatalogAccessExceptionFaultFaultMessage, IBinderUpdateItemInBinderUnlicensedSdkExceptionFaultFaultMessage
    ;

    /**
     * 
     * @param identifier
     * @return
     *     returns de.stiffi.media.telestreamvantage.api.generated.ContentType
     * @throws IBinderGetContentFromBinderUnlicensedSdkExceptionFaultFaultMessage
     * @throws IBinderGetContentFromBinderCatalogAccessExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "GetContentFromBinder", action = "http://Telestream.Vantage.Sdk/2010/07/IBinder/GetContentFromBinder")
    @WebResult(name = "GetContentFromBinderResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "GetContentFromBinder", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetContentFromBinder")
    @ResponseWrapper(localName = "GetContentFromBinderResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetContentFromBinderResponse")
    public ContentType getContentFromBinder(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier)
        throws IBinderGetContentFromBinderCatalogAccessExceptionFaultFaultMessage, IBinderGetContentFromBinderUnlicensedSdkExceptionFaultFaultMessage
    ;

}
