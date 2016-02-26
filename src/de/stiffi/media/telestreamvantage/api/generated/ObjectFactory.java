
package de.stiffi.media.telestreamvantage.api.generated;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.stiffi.media.telestreamvantage.api.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _FileProperties_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FileProperties");
    private final static QName _WorkflowInvalidStateException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "WorkflowInvalidStateException");
    private final static QName _ArrayOfEvent_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfEvent");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _StatusContext_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "StatusContext");
    private final static QName _ArrayOfMedia_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfMedia");
    private final static QName _ContentDoesNotExistException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ContentDoesNotExistException");
    private final static QName _GuidField_QNAME = new QName("http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", "GuidField");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _FieldOfdouble_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FieldOfdouble");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _Summary_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Summary");
    private final static QName _ArrayOfContentType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfContentType");
    private final static QName _UnlicensedSdkException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "UnlicensedSdkException");
    private final static QName _Media_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Media");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Value_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Value");
    private final static QName _InvalidJobStateException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "InvalidJobStateException");
    private final static QName _UriField_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "UriField");
    private final static QName _ItemDoesNotExistException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ItemDoesNotExistException");
    private final static QName _Event_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Event");
    private final static QName _FormatSummary_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FormatSummary");
    private final static QName _Component_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Component");
    private final static QName _Element_QNAME = new QName("http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", "Element");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _TaskState_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "TaskState");
    private final static QName _TypeCode_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "TypeCode");
    private final static QName _ArrayOfFolderType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfFolderType");
    private final static QName _Context_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Context");
    private final static QName _Session_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Session");
    private final static QName _ArrayOfProperty_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfProperty");
    private final static QName _ConditionValue_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ConditionValue");
    private final static QName _TextEncoderFallback_QNAME = new QName("http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", "TextEncoderFallback");
    private final static QName _TemplateDoesNotExistException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "TemplateDoesNotExistException");
    private final static QName _Operation_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Operation");
    private final static QName _Unique_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Unique");
    private final static QName _JobSessionState_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "JobSessionState");
    private final static QName _JobType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "JobType");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _ArrayOfItem_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfItem");
    private final static QName _Record_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Record");
    private final static QName _DuplicateItemException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "DuplicateItemException");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _ManifestList_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ManifestList");
    private final static QName _TextEncoding_QNAME = new QName("http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", "TextEncoding");
    private final static QName _ArrayOfItemType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfItemType");
    private final static QName _File_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "File");
    private final static QName _XmlSerializerNamespaces_QNAME = new QName("http://schemas.datacontract.org/2004/07/System.Xml.Serialization", "XmlSerializerNamespaces");
    private final static QName _Parameter_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Parameter");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _ArrayOfBinderType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfBinderType");
    private final static QName _MetaSummary_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "MetaSummary");
    private final static QName _History_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "History");
    private final static QName _BinderType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "BinderType");
    private final static QName _ArrayOfstring_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring");
    private final static QName _Procedure_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Procedure");
    private final static QName _FieldOfguid_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FieldOfguid");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _Complex_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Complex");
    private final static QName _UnitType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "UnitType");
    private final static QName _FieldOfanyURI_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FieldOfanyURI");
    private final static QName _Store_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Store");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _WorkflowJobQualifierType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "WorkflowJobQualifierType");
    private final static QName _FolderType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FolderType");
    private final static QName _BindableFieldOfanyURI_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "BindableFieldOfanyURI");
    private final static QName _ContentType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ContentType");
    private final static QName _AudioSummary_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "AudioSummary");
    private final static QName _TrackTrackValue_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Track.TrackValue");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _Task_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Task");
    private final static QName _PauseResumeInvalidStateException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "PauseResumeInvalidStateException");
    private final static QName _FieldOfboolean_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FieldOfboolean");
    private final static QName _FieldOfint_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FieldOfint");
    private final static QName _SessionType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "SessionType");
    private final static QName _ArrayOfTask_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfTask");
    private final static QName _ArrayOfOperation_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfOperation");
    private final static QName _MD5HashKey_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "MD5HashKey");
    private final static QName _SessionDoesNotExistException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "SessionDoesNotExistException");
    private final static QName _ArrayOfCondition_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfCondition");
    private final static QName _ArrayOfRecord_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfRecord");
    private final static QName _ArrayOfguid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfguid");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _ArrayOfParameter_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfParameter");
    private final static QName _ArrayOfTrackTrackValue_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfTrack.TrackValue");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Manifest_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Manifest");
    private final static QName _TrackView_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "TrackView");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Item_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Item");
    private final static QName _FileType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FileType");
    private final static QName _ArrayOfLabel_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfLabel");
    private final static QName _ConditionList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", "ConditionList");
    private final static QName _Property_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Property");
    private final static QName _WorkflowJobState_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "WorkflowJobState");
    private final static QName _ArrayOfStatusContext_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfStatusContext");
    private final static QName _UniqueListOfConditionuZpbrClh_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "UniqueListOfConditionuZpbrClh");
    private final static QName _Document_QNAME = new QName("http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", "Document");
    private final static QName _Condition_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Condition");
    private final static QName _FieldOflong_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FieldOflong");
    private final static QName _ArrayOfJobType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfJobType");
    private final static QName _Label_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Label");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _StorePosition_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "StorePosition");
    private final static QName _JobDoesNotExistException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "JobDoesNotExistException");
    private final static QName _ArrayOfAudioSummary_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfAudioSummary");
    private final static QName _UniqueType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "UniqueType");
    private final static QName _CatalogAccessException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "CatalogAccessException");
    private final static QName _Track_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Track");
    private final static QName _Collection_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Collection");
    private final static QName _WorkflowDoesNotExistException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "WorkflowDoesNotExistException");
    private final static QName _FieldOfstring_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FieldOfstring");
    private final static QName _UniqueListOfFileuZpbrClh_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "UniqueListOfFileuZpbrClh");
    private final static QName _ArrayOfSessionType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfSessionType");
    private final static QName _VideoSummary_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "VideoSummary");
    private final static QName _PauseResumeNotSupportedException_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "PauseResumeNotSupportedException");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _ItemType_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ItemType");
    private final static QName _ArrayOfProcedure_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfProcedure");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Constraint_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Constraint");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _WorkflowState_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "WorkflowState");
    private final static QName _ArrayOfSession_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ArrayOfSession");
    private final static QName _GetContentsForJobResponseGetContentsForJobResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetContentsForJobResult");
    private final static QName _VideoSummaryAspectWidth_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "AspectWidth");
    private final static QName _VideoSummaryFramerate_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Framerate");
    private final static QName _VideoSummaryAspectHeight_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "AspectHeight");
    private final static QName _VideoSummaryWidth_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Width");
    private final static QName _VideoSummaryVbr_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Vbr");
    private final static QName _VideoSummaryAncillary_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Ancillary");
    private final static QName _VideoSummaryBitrate_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Bitrate");
    private final static QName _VideoSummaryCodec_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Codec");
    private final static QName _VideoSummaryHeight_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Height");
    private final static QName _VideoSummaryOrder_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Order");
    private final static QName _VideoSummaryIFrame_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "IFrame");
    private final static QName _VideoSummaryChroma_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Chroma");
    private final static QName _VideoSummaryInterlaced_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Interlaced");
    private final static QName _JobTypeName_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Name");
    private final static QName _ItemDoesNotExistExceptionMessage_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Message");
    private final static QName _GetVariablesResponseGetVariablesResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetVariablesResult");
    private final static QName _SummaryMeta_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Meta");
    private final static QName _SummaryAudio_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Audio");
    private final static QName _SummaryVideo_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Video");
    private final static QName _SummaryFormat_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Format");
    private final static QName _UpdateItemNewItemDefinition_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "newItemDefinition");
    private final static QName _GetWorkflowResponseGetWorkflowResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetWorkflowResult");
    private final static QName _GetContentLabelsResponseGetContentLabelsResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetContentLabelsResult");
    private final static QName _ComponentDescription_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Description");
    private final static QName _SubmitFileContext_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "context");
    private final static QName _SubmitFileJobName_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "jobName");
    private final static QName _SubmitFileSourceFilename_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "sourceFilename");
    private final static QName _GetWorkflowVariableRequirementsResponseGetWorkflowVariableRequirementsResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetWorkflowVariableRequirementsResult");
    private final static QName _GetDomainVersionResponseGetDomainVersionResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetDomainVersionResult");
    private final static QName _ConditionValueDefault_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Default");
    private final static QName _GetSessionsForJobResponseGetSessionsForJobResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetSessionsForJobResult");
    private final static QName _GetJobsForWorkflowResponseGetJobsForWorkflowResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetJobsForWorkflowResult");
    private final static QName _UpdateItemInBinderItemToUpdate_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "itemToUpdate");
    private final static QName _MetaSummaryCopyright_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Copyright");
    private final static QName _MetaSummaryAuthor_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Author");
    private final static QName _MetaSummaryAbstract_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Abstract");
    private final static QName _MetaSummaryTitle_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Title");
    private final static QName _MetaSummaryRating_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Rating");
    private final static QName _ProcedureConditions_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Conditions");
    private final static QName _AddItemToBinderItemToAdd_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "itemToAdd");
    private final static QName _GetContentAttachmentsResponseGetContentAttachmentsResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetContentAttachmentsResult");
    private final static QName _StoreManifests_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Manifests");
    private final static QName _StoreData_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Data");
    private final static QName _GetCatalogsResponseGetCatalogsResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetCatalogsResult");
    private final static QName _HistoryContexts_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Contexts");
    private final static QName _HistoryOperations_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Operations");
    private final static QName _FilePropertiesFilePath_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FilePath");
    private final static QName _FilePropertiesFileSize_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FileSize");
    private final static QName _FilePropertiesFileName_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FileName");
    private final static QName _FilePropertiesFileExtension_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FileExtension");
    private final static QName _GetFileResponseGetFileResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetFileResult");
    private final static QName _ListBindersResponseListBindersResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ListBindersResult");
    private final static QName _ValueComplexValue_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ComplexValue");
    private final static QName _ValueText_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Text");
    private final static QName _RecordEntry_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Entry");
    private final static QName _GetItemFilesResponseGetItemFilesResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetItemFilesResult");
    private final static QName _EventDetail_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Detail");
    private final static QName _TaskEvents_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Events");
    private final static QName _GetWorkflowItemRequirementsResponseGetWorkflowItemRequirementsResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetWorkflowItemRequirementsResult");
    private final static QName _GetLabelsResponseGetLabelsResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetLabelsResult");
    private final static QName _ParameterCategoryValue_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "CategoryValue");
    private final static QName _ParameterUnit_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Unit");
    private final static QName _ParameterTag_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Tag");
    private final static QName _FormatSummaryDuration_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Duration");
    private final static QName _GetSessionDetailResponseGetSessionDetailResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetSessionDetailResult");
    private final static QName _ListFoldersResponseListFoldersResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ListFoldersResult");
    private final static QName _GetFolderResponseGetFolderResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetFolderResult");
    private final static QName _GetItemFilePathsResponseGetItemFilePathsResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetItemFilePathsResult");
    private final static QName _GetCatalogResponseGetCatalogResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetCatalogResult");
    private final static QName _AudioSummaryChannels_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Channels");
    private final static QName _AudioSummarySamplerate_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Samplerate");
    private final static QName _AudioSummaryBitsPerSample_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "BitsPerSample");
    private final static QName _GetItemLocationResponseGetItemLocationResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetItemLocationResult");
    private final static QName _GetContentFromBinderResponseGetContentFromBinderResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetContentFromBinderResult");
    private final static QName _GetSessionStatusResponseGetSessionStatusResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetSessionStatusResult");
    private final static QName _TrackValues_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Values");
    private final static QName _SessionTasks_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Tasks");
    private final static QName _SessionLog_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Log");
    private final static QName _GetWorkflowsResponseGetWorkflowsResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetWorkflowsResult");
    private final static QName _GetMediaVersionsResponseGetMediaVersionsResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetMediaVersionsResult");
    private final static QName _GetLabelResponseGetLabelResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetLabelResult");
    private final static QName _FileLocation_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Location");
    private final static QName _FilePath_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Path");
    private final static QName _FilePathRelevantEnabled_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "PathRelevantEnabled");
    private final static QName _SubmitFileAndItemsRequiredItems_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "requiredItems");
    private final static QName _CollectionParameters_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Parameters");
    private final static QName _ItemFiles_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Files");
    private final static QName _GetSessionResponseGetSessionResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetSessionResult");
    private final static QName _GetJobResponseGetJobResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetJobResult");
    private final static QName _GetMediaVersionResponseGetMediaVersionResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetMediaVersionResult");
    private final static QName _OperationLastError_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "LastError");
    private final static QName _OperationSessions_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Sessions");
    private final static QName _OperationExecutedOn_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "ExecutedOn");
    private final static QName _GetAgilityMediaVersionsResponseGetAgilityMediaVersionsResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetAgilityMediaVersionsResult");
    private final static QName _MD5HashKeyKey_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Key");
    private final static QName _ComplexProperties_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "Properties");
    private final static QName _GetSummaryResponseGetSummaryResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetSummaryResult");
    private final static QName _FileTypeFullPathName_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "FullPathName");
    private final static QName _GetBinderResponseGetBinderResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetBinderResult");
    private final static QName _GetContentMediaResponseGetContentMediaResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetContentMediaResult");
    private final static QName _GetVariableResponseGetVariableResult_QNAME = new QName("http://Telestream.Vantage.Sdk/2010/07", "GetVariableResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.stiffi.media.telestreamvantage.api.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWorkflowState }
     * 
     */
    public GetWorkflowState createGetWorkflowState() {
        return new GetWorkflowState();
    }

    /**
     * Create an instance of {@link UpdateItemInBinderResponse }
     * 
     */
    public UpdateItemInBinderResponse createUpdateItemInBinderResponse() {
        return new UpdateItemInBinderResponse();
    }

    /**
     * Create an instance of {@link VideoSummary }
     * 
     */
    public VideoSummary createVideoSummary() {
        return new VideoSummary();
    }

    /**
     * Create an instance of {@link JobType }
     * 
     */
    public JobType createJobType() {
        return new JobType();
    }

    /**
     * Create an instance of {@link Unique }
     * 
     */
    public Unique createUnique() {
        return new Unique();
    }

    /**
     * Create an instance of {@link GetVariablesResponse }
     * 
     */
    public GetVariablesResponse createGetVariablesResponse() {
        return new GetVariablesResponse();
    }

    /**
     * Create an instance of {@link Summary }
     * 
     */
    public Summary createSummary() {
        return new Summary();
    }

    /**
     * Create an instance of {@link ArrayOfTrackTrackValue }
     * 
     */
    public ArrayOfTrackTrackValue createArrayOfTrackTrackValue() {
        return new ArrayOfTrackTrackValue();
    }

    /**
     * Create an instance of {@link UpdateItem }
     * 
     */
    public UpdateItem createUpdateItem() {
        return new UpdateItem();
    }

    /**
     * Create an instance of {@link GetSessionsForJob }
     * 
     */
    public GetSessionsForJob createGetSessionsForJob() {
        return new GetSessionsForJob();
    }

    /**
     * Create an instance of {@link GetContentLabelsResponse }
     * 
     */
    public GetContentLabelsResponse createGetContentLabelsResponse() {
        return new GetContentLabelsResponse();
    }

    /**
     * Create an instance of {@link SubmitFile }
     * 
     */
    public SubmitFile createSubmitFile() {
        return new SubmitFile();
    }

    /**
     * Create an instance of {@link GetSessionProgressResponse }
     * 
     */
    public GetSessionProgressResponse createGetSessionProgressResponse() {
        return new GetSessionProgressResponse();
    }

    /**
     * Create an instance of {@link GetWorkflowVariableRequirementsResponse }
     * 
     */
    public GetWorkflowVariableRequirementsResponse createGetWorkflowVariableRequirementsResponse() {
        return new GetWorkflowVariableRequirementsResponse();
    }

    /**
     * Create an instance of {@link GetFolder }
     * 
     */
    public GetFolder createGetFolder() {
        return new GetFolder();
    }

    /**
     * Create an instance of {@link GetSessionsForJobResponse }
     * 
     */
    public GetSessionsForJobResponse createGetSessionsForJobResponse() {
        return new GetSessionsForJobResponse();
    }

    /**
     * Create an instance of {@link ConditionValue }
     * 
     */
    public ConditionValue createConditionValue() {
        return new ConditionValue();
    }

    /**
     * Create an instance of {@link GetVariable }
     * 
     */
    public GetVariable createGetVariable() {
        return new GetVariable();
    }

    /**
     * Create an instance of {@link GetLabels }
     * 
     */
    public GetLabels createGetLabels() {
        return new GetLabels();
    }

    /**
     * Create an instance of {@link GetContentLabels }
     * 
     */
    public GetContentLabels createGetContentLabels() {
        return new GetContentLabels();
    }

    /**
     * Create an instance of {@link GetContentAttachmentsResponse }
     * 
     */
    public GetContentAttachmentsResponse createGetContentAttachmentsResponse() {
        return new GetContentAttachmentsResponse();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link ActivateResponse }
     * 
     */
    public ActivateResponse createActivateResponse() {
        return new ActivateResponse();
    }

    /**
     * Create an instance of {@link SessionDoesNotExistException }
     * 
     */
    public SessionDoesNotExistException createSessionDoesNotExistException() {
        return new SessionDoesNotExistException();
    }

    /**
     * Create an instance of {@link GetFileResponse }
     * 
     */
    public GetFileResponse createGetFileResponse() {
        return new GetFileResponse();
    }

    /**
     * Create an instance of {@link GetWorkflowItemRequirementsResponse }
     * 
     */
    public GetWorkflowItemRequirementsResponse createGetWorkflowItemRequirementsResponse() {
        return new GetWorkflowItemRequirementsResponse();
    }

    /**
     * Create an instance of {@link Deactivate }
     * 
     */
    public Deactivate createDeactivate() {
        return new Deactivate();
    }

    /**
     * Create an instance of {@link GetLabelsResponse }
     * 
     */
    public GetLabelsResponse createGetLabelsResponse() {
        return new GetLabelsResponse();
    }

    /**
     * Create an instance of {@link StopJob }
     * 
     */
    public StopJob createStopJob() {
        return new StopJob();
    }

    /**
     * Create an instance of {@link GetWorkflows }
     * 
     */
    public GetWorkflows createGetWorkflows() {
        return new GetWorkflows();
    }

    /**
     * Create an instance of {@link ListFoldersResponse }
     * 
     */
    public ListFoldersResponse createListFoldersResponse() {
        return new ListFoldersResponse();
    }

    /**
     * Create an instance of {@link GetRootItemFileResponse }
     * 
     */
    public GetRootItemFileResponse createGetRootItemFileResponse() {
        return new GetRootItemFileResponse();
    }

    /**
     * Create an instance of {@link GetItemFilePathsResponse }
     * 
     */
    public GetItemFilePathsResponse createGetItemFilePathsResponse() {
        return new GetItemFilePathsResponse();
    }

    /**
     * Create an instance of {@link GetRootItemFile }
     * 
     */
    public GetRootItemFile createGetRootItemFile() {
        return new GetRootItemFile();
    }

    /**
     * Create an instance of {@link GetJobState }
     * 
     */
    public GetJobState createGetJobState() {
        return new GetJobState();
    }

    /**
     * Create an instance of {@link FieldOfanyURI }
     * 
     */
    public FieldOfanyURI createFieldOfanyURI() {
        return new FieldOfanyURI();
    }

    /**
     * Create an instance of {@link ResumeSession }
     * 
     */
    public ResumeSession createResumeSession() {
        return new ResumeSession();
    }

    /**
     * Create an instance of {@link GetContentMedia }
     * 
     */
    public GetContentMedia createGetContentMedia() {
        return new GetContentMedia();
    }

    /**
     * Create an instance of {@link RemoveBinderResponse }
     * 
     */
    public RemoveBinderResponse createRemoveBinderResponse() {
        return new RemoveBinderResponse();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link ArrayOfJobType }
     * 
     */
    public ArrayOfJobType createArrayOfJobType() {
        return new ArrayOfJobType();
    }

    /**
     * Create an instance of {@link GetMediaVersionResponse }
     * 
     */
    public GetMediaVersionResponse createGetMediaVersionResponse() {
        return new GetMediaVersionResponse();
    }

    /**
     * Create an instance of {@link RemoveJobResponse }
     * 
     */
    public RemoveJobResponse createRemoveJobResponse() {
        return new RemoveJobResponse();
    }

    /**
     * Create an instance of {@link BinderType }
     * 
     */
    public BinderType createBinderType() {
        return new BinderType();
    }

    /**
     * Create an instance of {@link RemoveItemFromBinderResponse }
     * 
     */
    public RemoveItemFromBinderResponse createRemoveItemFromBinderResponse() {
        return new RemoveItemFromBinderResponse();
    }

    /**
     * Create an instance of {@link AddItemToBinderResponse }
     * 
     */
    public AddItemToBinderResponse createAddItemToBinderResponse() {
        return new AddItemToBinderResponse();
    }

    /**
     * Create an instance of {@link FieldOfstring }
     * 
     */
    public FieldOfstring createFieldOfstring() {
        return new FieldOfstring();
    }

    /**
     * Create an instance of {@link GetPercentageJobCompletedResponse }
     * 
     */
    public GetPercentageJobCompletedResponse createGetPercentageJobCompletedResponse() {
        return new GetPercentageJobCompletedResponse();
    }

    /**
     * Create an instance of {@link ArrayOfAudioSummary }
     * 
     */
    public ArrayOfAudioSummary createArrayOfAudioSummary() {
        return new ArrayOfAudioSummary();
    }

    /**
     * Create an instance of {@link GetSummaryResponse }
     * 
     */
    public GetSummaryResponse createGetSummaryResponse() {
        return new GetSummaryResponse();
    }

    /**
     * Create an instance of {@link Condition }
     * 
     */
    public Condition createCondition() {
        return new Condition();
    }

    /**
     * Create an instance of {@link GetBinderResponse }
     * 
     */
    public GetBinderResponse createGetBinderResponse() {
        return new GetBinderResponse();
    }

    /**
     * Create an instance of {@link GetSessionProgress }
     * 
     */
    public GetSessionProgress createGetSessionProgress() {
        return new GetSessionProgress();
    }

    /**
     * Create an instance of {@link ArrayOfguid }
     * 
     */
    public ArrayOfguid createArrayOfguid() {
        return new ArrayOfguid();
    }

    /**
     * Create an instance of {@link ArrayOfFolderType }
     * 
     */
    public ArrayOfFolderType createArrayOfFolderType() {
        return new ArrayOfFolderType();
    }

    /**
     * Create an instance of {@link ArrayOfProcedure }
     * 
     */
    public ArrayOfProcedure createArrayOfProcedure() {
        return new ArrayOfProcedure();
    }

    /**
     * Create an instance of {@link GetContentsForJobResponse }
     * 
     */
    public GetContentsForJobResponse createGetContentsForJobResponse() {
        return new GetContentsForJobResponse();
    }

    /**
     * Create an instance of {@link GetDomainVersion }
     * 
     */
    public GetDomainVersion createGetDomainVersion() {
        return new GetDomainVersion();
    }

    /**
     * Create an instance of {@link ArrayOfstring }
     * 
     */
    public ArrayOfstring createArrayOfstring() {
        return new ArrayOfstring();
    }

    /**
     * Create an instance of {@link ArrayOfOperation }
     * 
     */
    public ArrayOfOperation createArrayOfOperation() {
        return new ArrayOfOperation();
    }

    /**
     * Create an instance of {@link GetContentFromBinder }
     * 
     */
    public GetContentFromBinder createGetContentFromBinder() {
        return new GetContentFromBinder();
    }

    /**
     * Create an instance of {@link ArrayOfCondition }
     * 
     */
    public ArrayOfCondition createArrayOfCondition() {
        return new ArrayOfCondition();
    }

    /**
     * Create an instance of {@link GetDomainVersionResponse }
     * 
     */
    public GetDomainVersionResponse createGetDomainVersionResponse() {
        return new GetDomainVersionResponse();
    }

    /**
     * Create an instance of {@link GetAgilityMediaVersions }
     * 
     */
    public GetAgilityMediaVersions createGetAgilityMediaVersions() {
        return new GetAgilityMediaVersions();
    }

    /**
     * Create an instance of {@link DeactivateResponse }
     * 
     */
    public DeactivateResponse createDeactivateResponse() {
        return new DeactivateResponse();
    }

    /**
     * Create an instance of {@link MoveFolder }
     * 
     */
    public MoveFolder createMoveFolder() {
        return new MoveFolder();
    }

    /**
     * Create an instance of {@link AddItemToBinder }
     * 
     */
    public AddItemToBinder createAddItemToBinder() {
        return new AddItemToBinder();
    }

    /**
     * Create an instance of {@link GetCatalogsResponse }
     * 
     */
    public GetCatalogsResponse createGetCatalogsResponse() {
        return new GetCatalogsResponse();
    }

    /**
     * Create an instance of {@link History }
     * 
     */
    public History createHistory() {
        return new History();
    }

    /**
     * Create an instance of {@link Value }
     * 
     */
    public Value createValue() {
        return new Value();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link RemoveJob }
     * 
     */
    public RemoveJob createRemoveJob() {
        return new RemoveJob();
    }

    /**
     * Create an instance of {@link Element }
     * 
     */
    public Element createElement() {
        return new Element();
    }

    /**
     * Create an instance of {@link GetSessionDetailResponse }
     * 
     */
    public GetSessionDetailResponse createGetSessionDetailResponse() {
        return new GetSessionDetailResponse();
    }

    /**
     * Create an instance of {@link GetFolderResponse }
     * 
     */
    public GetFolderResponse createGetFolderResponse() {
        return new GetFolderResponse();
    }

    /**
     * Create an instance of {@link GetCatalogResponse }
     * 
     */
    public GetCatalogResponse createGetCatalogResponse() {
        return new GetCatalogResponse();
    }

    /**
     * Create an instance of {@link GetContentFromBinderResponse }
     * 
     */
    public GetContentFromBinderResponse createGetContentFromBinderResponse() {
        return new GetContentFromBinderResponse();
    }

    /**
     * Create an instance of {@link InvalidJobStateException }
     * 
     */
    public InvalidJobStateException createInvalidJobStateException() {
        return new InvalidJobStateException();
    }

    /**
     * Create an instance of {@link ArrayOfContentType }
     * 
     */
    public ArrayOfContentType createArrayOfContentType() {
        return new ArrayOfContentType();
    }

    /**
     * Create an instance of {@link ListBinders }
     * 
     */
    public ListBinders createListBinders() {
        return new ListBinders();
    }

    /**
     * Create an instance of {@link PauseResumeNotSupportedException }
     * 
     */
    public PauseResumeNotSupportedException createPauseResumeNotSupportedException() {
        return new PauseResumeNotSupportedException();
    }

    /**
     * Create an instance of {@link GetWorkflow }
     * 
     */
    public GetWorkflow createGetWorkflow() {
        return new GetWorkflow();
    }

    /**
     * Create an instance of {@link ConditionList }
     * 
     */
    public ConditionList createConditionList() {
        return new ConditionList();
    }

    /**
     * Create an instance of {@link GetSessionDetail }
     * 
     */
    public GetSessionDetail createGetSessionDetail() {
        return new GetSessionDetail();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link GetFile }
     * 
     */
    public GetFile createGetFile() {
        return new GetFile();
    }

    /**
     * Create an instance of {@link RestartJob }
     * 
     */
    public RestartJob createRestartJob() {
        return new RestartJob();
    }

    /**
     * Create an instance of {@link GetSessionStateResponse }
     * 
     */
    public GetSessionStateResponse createGetSessionStateResponse() {
        return new GetSessionStateResponse();
    }

    /**
     * Create an instance of {@link ArrayOfRecord }
     * 
     */
    public ArrayOfRecord createArrayOfRecord() {
        return new ArrayOfRecord();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link UriField }
     * 
     */
    public UriField createUriField() {
        return new UriField();
    }

    /**
     * Create an instance of {@link GetVariableResponse }
     * 
     */
    public GetVariableResponse createGetVariableResponse() {
        return new GetVariableResponse();
    }

    /**
     * Create an instance of {@link GetContentAttachments }
     * 
     */
    public GetContentAttachments createGetContentAttachments() {
        return new GetContentAttachments();
    }

    /**
     * Create an instance of {@link PauseSessionResponse }
     * 
     */
    public PauseSessionResponse createPauseSessionResponse() {
        return new PauseSessionResponse();
    }

    /**
     * Create an instance of {@link GetWorkflowResponse }
     * 
     */
    public GetWorkflowResponse createGetWorkflowResponse() {
        return new GetWorkflowResponse();
    }

    /**
     * Create an instance of {@link MoveBinder }
     * 
     */
    public MoveBinder createMoveBinder() {
        return new MoveBinder();
    }

    /**
     * Create an instance of {@link SubmitFileResponse }
     * 
     */
    public SubmitFileResponse createSubmitFileResponse() {
        return new SubmitFileResponse();
    }

    /**
     * Create an instance of {@link ArrayOfSessionType }
     * 
     */
    public ArrayOfSessionType createArrayOfSessionType() {
        return new ArrayOfSessionType();
    }

    /**
     * Create an instance of {@link Component }
     * 
     */
    public Component createComponent() {
        return new Component();
    }

    /**
     * Create an instance of {@link ArrayOfMedia }
     * 
     */
    public ArrayOfMedia createArrayOfMedia() {
        return new ArrayOfMedia();
    }

    /**
     * Create an instance of {@link ArrayOfTask }
     * 
     */
    public ArrayOfTask createArrayOfTask() {
        return new ArrayOfTask();
    }

    /**
     * Create an instance of {@link StatusContext }
     * 
     */
    public StatusContext createStatusContext() {
        return new StatusContext();
    }

    /**
     * Create an instance of {@link GetJobsForWorkflowResponse }
     * 
     */
    public GetJobsForWorkflowResponse createGetJobsForWorkflowResponse() {
        return new GetJobsForWorkflowResponse();
    }

    /**
     * Create an instance of {@link MetaSummary }
     * 
     */
    public MetaSummary createMetaSummary() {
        return new MetaSummary();
    }

    /**
     * Create an instance of {@link GetJobsForWorkflow }
     * 
     */
    public GetJobsForWorkflow createGetJobsForWorkflow() {
        return new GetJobsForWorkflow();
    }

    /**
     * Create an instance of {@link FileProperties }
     * 
     */
    public FileProperties createFileProperties() {
        return new FileProperties();
    }

    /**
     * Create an instance of {@link PauseSession }
     * 
     */
    public PauseSession createPauseSession() {
        return new PauseSession();
    }

    /**
     * Create an instance of {@link GetItemFilesResponse }
     * 
     */
    public GetItemFilesResponse createGetItemFilesResponse() {
        return new GetItemFilesResponse();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link RemoveItemFromBinder }
     * 
     */
    public RemoveItemFromBinder createRemoveItemFromBinder() {
        return new RemoveItemFromBinder();
    }

    /**
     * Create an instance of {@link GetWorkflowVariableRequirements }
     * 
     */
    public GetWorkflowVariableRequirements createGetWorkflowVariableRequirements() {
        return new GetWorkflowVariableRequirements();
    }

    /**
     * Create an instance of {@link MoveBinderResponse }
     * 
     */
    public MoveBinderResponse createMoveBinderResponse() {
        return new MoveBinderResponse();
    }

    /**
     * Create an instance of {@link MoveFolderResponse }
     * 
     */
    public MoveFolderResponse createMoveFolderResponse() {
        return new MoveFolderResponse();
    }

    /**
     * Create an instance of {@link FolderType }
     * 
     */
    public FolderType createFolderType() {
        return new FolderType();
    }

    /**
     * Create an instance of {@link Parameter }
     * 
     */
    public Parameter createParameter() {
        return new Parameter();
    }

    /**
     * Create an instance of {@link ArrayOfBinderType }
     * 
     */
    public ArrayOfBinderType createArrayOfBinderType() {
        return new ArrayOfBinderType();
    }

    /**
     * Create an instance of {@link FormatSummary }
     * 
     */
    public FormatSummary createFormatSummary() {
        return new FormatSummary();
    }

    /**
     * Create an instance of {@link RemoveFolder }
     * 
     */
    public RemoveFolder createRemoveFolder() {
        return new RemoveFolder();
    }

    /**
     * Create an instance of {@link AudioSummary }
     * 
     */
    public AudioSummary createAudioSummary() {
        return new AudioSummary();
    }

    /**
     * Create an instance of {@link GetItemLocationResponse }
     * 
     */
    public GetItemLocationResponse createGetItemLocationResponse() {
        return new GetItemLocationResponse();
    }

    /**
     * Create an instance of {@link GetSessionStatusResponse }
     * 
     */
    public GetSessionStatusResponse createGetSessionStatusResponse() {
        return new GetSessionStatusResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link GetWorkflowsResponse }
     * 
     */
    public GetWorkflowsResponse createGetWorkflowsResponse() {
        return new GetWorkflowsResponse();
    }

    /**
     * Create an instance of {@link WorkflowDoesNotExistException }
     * 
     */
    public WorkflowDoesNotExistException createWorkflowDoesNotExistException() {
        return new WorkflowDoesNotExistException();
    }

    /**
     * Create an instance of {@link Constraint }
     * 
     */
    public Constraint createConstraint() {
        return new Constraint();
    }

    /**
     * Create an instance of {@link GetMediaVersionsResponse }
     * 
     */
    public GetMediaVersionsResponse createGetMediaVersionsResponse() {
        return new GetMediaVersionsResponse();
    }

    /**
     * Create an instance of {@link UniqueListOfFileuZpbrClh }
     * 
     */
    public UniqueListOfFileuZpbrClh createUniqueListOfFileuZpbrClh() {
        return new UniqueListOfFileuZpbrClh();
    }

    /**
     * Create an instance of {@link Media }
     * 
     */
    public Media createMedia() {
        return new Media();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link FieldOfboolean }
     * 
     */
    public FieldOfboolean createFieldOfboolean() {
        return new FieldOfboolean();
    }

    /**
     * Create an instance of {@link GetJob }
     * 
     */
    public GetJob createGetJob() {
        return new GetJob();
    }

    /**
     * Create an instance of {@link GetCatalogs }
     * 
     */
    public GetCatalogs createGetCatalogs() {
        return new GetCatalogs();
    }

    /**
     * Create an instance of {@link TemplateDoesNotExistException }
     * 
     */
    public TemplateDoesNotExistException createTemplateDoesNotExistException() {
        return new TemplateDoesNotExistException();
    }

    /**
     * Create an instance of {@link GetMediaVersion }
     * 
     */
    public GetMediaVersion createGetMediaVersion() {
        return new GetMediaVersion();
    }

    /**
     * Create an instance of {@link Collection }
     * 
     */
    public Collection createCollection() {
        return new Collection();
    }

    /**
     * Create an instance of {@link GetCatalog }
     * 
     */
    public GetCatalog createGetCatalog() {
        return new GetCatalog();
    }

    /**
     * Create an instance of {@link GetSessionResponse }
     * 
     */
    public GetSessionResponse createGetSessionResponse() {
        return new GetSessionResponse();
    }

    /**
     * Create an instance of {@link GetJobResponse }
     * 
     */
    public GetJobResponse createGetJobResponse() {
        return new GetJobResponse();
    }

    /**
     * Create an instance of {@link ContentType }
     * 
     */
    public ContentType createContentType() {
        return new ContentType();
    }

    /**
     * Create an instance of {@link SubmitBinder }
     * 
     */
    public SubmitBinder createSubmitBinder() {
        return new SubmitBinder();
    }

    /**
     * Create an instance of {@link DuplicateItemException }
     * 
     */
    public DuplicateItemException createDuplicateItemException() {
        return new DuplicateItemException();
    }

    /**
     * Create an instance of {@link ArrayOfItem }
     * 
     */
    public ArrayOfItem createArrayOfItem() {
        return new ArrayOfItem();
    }

    /**
     * Create an instance of {@link ArrayOfLabel }
     * 
     */
    public ArrayOfLabel createArrayOfLabel() {
        return new ArrayOfLabel();
    }

    /**
     * Create an instance of {@link RestartJobResponse }
     * 
     */
    public RestartJobResponse createRestartJobResponse() {
        return new RestartJobResponse();
    }

    /**
     * Create an instance of {@link GetAgilityMediaVersionsResponse }
     * 
     */
    public GetAgilityMediaVersionsResponse createGetAgilityMediaVersionsResponse() {
        return new GetAgilityMediaVersionsResponse();
    }

    /**
     * Create an instance of {@link GetVariables }
     * 
     */
    public GetVariables createGetVariables() {
        return new GetVariables();
    }

    /**
     * Create an instance of {@link ArrayOfStatusContext }
     * 
     */
    public ArrayOfStatusContext createArrayOfStatusContext() {
        return new ArrayOfStatusContext();
    }

    /**
     * Create an instance of {@link MD5HashKey }
     * 
     */
    public MD5HashKey createMD5HashKey() {
        return new MD5HashKey();
    }

    /**
     * Create an instance of {@link Complex }
     * 
     */
    public Complex createComplex() {
        return new Complex();
    }

    /**
     * Create an instance of {@link FileType }
     * 
     */
    public FileType createFileType() {
        return new FileType();
    }

    /**
     * Create an instance of {@link GetContentMediaResponse }
     * 
     */
    public GetContentMediaResponse createGetContentMediaResponse() {
        return new GetContentMediaResponse();
    }

    /**
     * Create an instance of {@link Context }
     * 
     */
    public Context createContext() {
        return new Context();
    }

    /**
     * Create an instance of {@link Manifest }
     * 
     */
    public Manifest createManifest() {
        return new Manifest();
    }

    /**
     * Create an instance of {@link GetBinder }
     * 
     */
    public GetBinder createGetBinder() {
        return new GetBinder();
    }

    /**
     * Create an instance of {@link ItemDoesNotExistException }
     * 
     */
    public ItemDoesNotExistException createItemDoesNotExistException() {
        return new ItemDoesNotExistException();
    }

    /**
     * Create an instance of {@link UniqueListOfConditionuZpbrClh }
     * 
     */
    public UniqueListOfConditionuZpbrClh createUniqueListOfConditionuZpbrClh() {
        return new UniqueListOfConditionuZpbrClh();
    }

    /**
     * Create an instance of {@link GetSessionStatus }
     * 
     */
    public GetSessionStatus createGetSessionStatus() {
        return new GetSessionStatus();
    }

    /**
     * Create an instance of {@link PauseResumeInvalidStateException }
     * 
     */
    public PauseResumeInvalidStateException createPauseResumeInvalidStateException() {
        return new PauseResumeInvalidStateException();
    }

    /**
     * Create an instance of {@link GetMediaVersions }
     * 
     */
    public GetMediaVersions createGetMediaVersions() {
        return new GetMediaVersions();
    }

    /**
     * Create an instance of {@link WorkflowInvalidStateException }
     * 
     */
    public WorkflowInvalidStateException createWorkflowInvalidStateException() {
        return new WorkflowInvalidStateException();
    }

    /**
     * Create an instance of {@link GuidField }
     * 
     */
    public GuidField createGuidField() {
        return new GuidField();
    }

    /**
     * Create an instance of {@link GetContentsForJob }
     * 
     */
    public GetContentsForJob createGetContentsForJob() {
        return new GetContentsForJob();
    }

    /**
     * Create an instance of {@link GetPercentageJobCompleted }
     * 
     */
    public GetPercentageJobCompleted createGetPercentageJobCompleted() {
        return new GetPercentageJobCompleted();
    }

    /**
     * Create an instance of {@link XmlSerializerNamespaces }
     * 
     */
    public XmlSerializerNamespaces createXmlSerializerNamespaces() {
        return new XmlSerializerNamespaces();
    }

    /**
     * Create an instance of {@link ArrayOfSession }
     * 
     */
    public ArrayOfSession createArrayOfSession() {
        return new ArrayOfSession();
    }

    /**
     * Create an instance of {@link FieldOfguid }
     * 
     */
    public FieldOfguid createFieldOfguid() {
        return new FieldOfguid();
    }

    /**
     * Create an instance of {@link UpdateItemInBinder }
     * 
     */
    public UpdateItemInBinder createUpdateItemInBinder() {
        return new UpdateItemInBinder();
    }

    /**
     * Create an instance of {@link CatalogAccessException }
     * 
     */
    public CatalogAccessException createCatalogAccessException() {
        return new CatalogAccessException();
    }

    /**
     * Create an instance of {@link SessionType }
     * 
     */
    public SessionType createSessionType() {
        return new SessionType();
    }

    /**
     * Create an instance of {@link JobDoesNotExistException }
     * 
     */
    public JobDoesNotExistException createJobDoesNotExistException() {
        return new JobDoesNotExistException();
    }

    /**
     * Create an instance of {@link Procedure }
     * 
     */
    public Procedure createProcedure() {
        return new Procedure();
    }

    /**
     * Create an instance of {@link FieldOfdouble }
     * 
     */
    public FieldOfdouble createFieldOfdouble() {
        return new FieldOfdouble();
    }

    /**
     * Create an instance of {@link Store }
     * 
     */
    public Store createStore() {
        return new Store();
    }

    /**
     * Create an instance of {@link SubmitFileAndItemsResponse }
     * 
     */
    public SubmitFileAndItemsResponse createSubmitFileAndItemsResponse() {
        return new SubmitFileAndItemsResponse();
    }

    /**
     * Create an instance of {@link UniqueType }
     * 
     */
    public UniqueType createUniqueType() {
        return new UniqueType();
    }

    /**
     * Create an instance of {@link ArrayOfItemType }
     * 
     */
    public ArrayOfItemType createArrayOfItemType() {
        return new ArrayOfItemType();
    }

    /**
     * Create an instance of {@link ManifestList }
     * 
     */
    public ManifestList createManifestList() {
        return new ManifestList();
    }

    /**
     * Create an instance of {@link StopJobResponse }
     * 
     */
    public StopJobResponse createStopJobResponse() {
        return new StopJobResponse();
    }

    /**
     * Create an instance of {@link Record }
     * 
     */
    public Record createRecord() {
        return new Record();
    }

    /**
     * Create an instance of {@link GetSession }
     * 
     */
    public GetSession createGetSession() {
        return new GetSession();
    }

    /**
     * Create an instance of {@link ListBindersResponse }
     * 
     */
    public ListBindersResponse createListBindersResponse() {
        return new ListBindersResponse();
    }

    /**
     * Create an instance of {@link SubmitBinderResponse }
     * 
     */
    public SubmitBinderResponse createSubmitBinderResponse() {
        return new SubmitBinderResponse();
    }

    /**
     * Create an instance of {@link FieldOfint }
     * 
     */
    public FieldOfint createFieldOfint() {
        return new FieldOfint();
    }

    /**
     * Create an instance of {@link Label }
     * 
     */
    public Label createLabel() {
        return new Label();
    }

    /**
     * Create an instance of {@link ArrayOfProperty }
     * 
     */
    public ArrayOfProperty createArrayOfProperty() {
        return new ArrayOfProperty();
    }

    /**
     * Create an instance of {@link GetJobStateResponse }
     * 
     */
    public GetJobStateResponse createGetJobStateResponse() {
        return new GetJobStateResponse();
    }

    /**
     * Create an instance of {@link RemoveFolderResponse }
     * 
     */
    public RemoveFolderResponse createRemoveFolderResponse() {
        return new RemoveFolderResponse();
    }

    /**
     * Create an instance of {@link ContentDoesNotExistException }
     * 
     */
    public ContentDoesNotExistException createContentDoesNotExistException() {
        return new ContentDoesNotExistException();
    }

    /**
     * Create an instance of {@link GetWorkflowItemRequirements }
     * 
     */
    public GetWorkflowItemRequirements createGetWorkflowItemRequirements() {
        return new GetWorkflowItemRequirements();
    }

    /**
     * Create an instance of {@link GetWorkflowStateResponse }
     * 
     */
    public GetWorkflowStateResponse createGetWorkflowStateResponse() {
        return new GetWorkflowStateResponse();
    }

    /**
     * Create an instance of {@link ArrayOfEvent }
     * 
     */
    public ArrayOfEvent createArrayOfEvent() {
        return new ArrayOfEvent();
    }

    /**
     * Create an instance of {@link Track }
     * 
     */
    public Track createTrack() {
        return new Track();
    }

    /**
     * Create an instance of {@link GetLabel }
     * 
     */
    public GetLabel createGetLabel() {
        return new GetLabel();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link UpdateItemResponse }
     * 
     */
    public UpdateItemResponse createUpdateItemResponse() {
        return new UpdateItemResponse();
    }

    /**
     * Create an instance of {@link TrackTrackValue }
     * 
     */
    public TrackTrackValue createTrackTrackValue() {
        return new TrackTrackValue();
    }

    /**
     * Create an instance of {@link GetLabelResponse }
     * 
     */
    public GetLabelResponse createGetLabelResponse() {
        return new GetLabelResponse();
    }

    /**
     * Create an instance of {@link SubmitFileAndItems }
     * 
     */
    public SubmitFileAndItems createSubmitFileAndItems() {
        return new SubmitFileAndItems();
    }

    /**
     * Create an instance of {@link Activate }
     * 
     */
    public Activate createActivate() {
        return new Activate();
    }

    /**
     * Create an instance of {@link GetItemFiles }
     * 
     */
    public GetItemFiles createGetItemFiles() {
        return new GetItemFiles();
    }

    /**
     * Create an instance of {@link UnlicensedSdkException }
     * 
     */
    public UnlicensedSdkException createUnlicensedSdkException() {
        return new UnlicensedSdkException();
    }

    /**
     * Create an instance of {@link GetItemFilePaths }
     * 
     */
    public GetItemFilePaths createGetItemFilePaths() {
        return new GetItemFilePaths();
    }

    /**
     * Create an instance of {@link ResumeSessionResponse }
     * 
     */
    public ResumeSessionResponse createResumeSessionResponse() {
        return new ResumeSessionResponse();
    }

    /**
     * Create an instance of {@link GetSummary }
     * 
     */
    public GetSummary createGetSummary() {
        return new GetSummary();
    }

    /**
     * Create an instance of {@link ArrayOfParameter }
     * 
     */
    public ArrayOfParameter createArrayOfParameter() {
        return new ArrayOfParameter();
    }

    /**
     * Create an instance of {@link RemoveBinder }
     * 
     */
    public RemoveBinder createRemoveBinder() {
        return new RemoveBinder();
    }

    /**
     * Create an instance of {@link GetSessionState }
     * 
     */
    public GetSessionState createGetSessionState() {
        return new GetSessionState();
    }

    /**
     * Create an instance of {@link BindableFieldOfanyURI }
     * 
     */
    public BindableFieldOfanyURI createBindableFieldOfanyURI() {
        return new BindableFieldOfanyURI();
    }

    /**
     * Create an instance of {@link ListFolders }
     * 
     */
    public ListFolders createListFolders() {
        return new ListFolders();
    }

    /**
     * Create an instance of {@link GetItemLocation }
     * 
     */
    public GetItemLocation createGetItemLocation() {
        return new GetItemLocation();
    }

    /**
     * Create an instance of {@link FieldOflong }
     * 
     */
    public FieldOflong createFieldOflong() {
        return new FieldOflong();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileProperties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FileProperties")
    public JAXBElement<FileProperties> createFileProperties(FileProperties value) {
        return new JAXBElement<FileProperties>(_FileProperties_QNAME, FileProperties.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowInvalidStateException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "WorkflowInvalidStateException")
    public JAXBElement<WorkflowInvalidStateException> createWorkflowInvalidStateException(WorkflowInvalidStateException value) {
        return new JAXBElement<WorkflowInvalidStateException>(_WorkflowInvalidStateException_QNAME, WorkflowInvalidStateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfEvent")
    public JAXBElement<ArrayOfEvent> createArrayOfEvent(ArrayOfEvent value) {
        return new JAXBElement<ArrayOfEvent>(_ArrayOfEvent_QNAME, ArrayOfEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "StatusContext")
    public JAXBElement<StatusContext> createStatusContext(StatusContext value) {
        return new JAXBElement<StatusContext>(_StatusContext_QNAME, StatusContext.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMedia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfMedia")
    public JAXBElement<ArrayOfMedia> createArrayOfMedia(ArrayOfMedia value) {
        return new JAXBElement<ArrayOfMedia>(_ArrayOfMedia_QNAME, ArrayOfMedia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContentDoesNotExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ContentDoesNotExistException")
    public JAXBElement<ContentDoesNotExistException> createContentDoesNotExistException(ContentDoesNotExistException value) {
        return new JAXBElement<ContentDoesNotExistException>(_ContentDoesNotExistException_QNAME, ContentDoesNotExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuidField }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", name = "GuidField")
    public JAXBElement<GuidField> createGuidField(GuidField value) {
        return new JAXBElement<GuidField>(_GuidField_QNAME, GuidField.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfdouble }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FieldOfdouble")
    public JAXBElement<FieldOfdouble> createFieldOfdouble(FieldOfdouble value) {
        return new JAXBElement<FieldOfdouble>(_FieldOfdouble_QNAME, FieldOfdouble.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Summary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Summary")
    public JAXBElement<Summary> createSummary(Summary value) {
        return new JAXBElement<Summary>(_Summary_QNAME, Summary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfContentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfContentType")
    public JAXBElement<ArrayOfContentType> createArrayOfContentType(ArrayOfContentType value) {
        return new JAXBElement<ArrayOfContentType>(_ArrayOfContentType_QNAME, ArrayOfContentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnlicensedSdkException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "UnlicensedSdkException")
    public JAXBElement<UnlicensedSdkException> createUnlicensedSdkException(UnlicensedSdkException value) {
        return new JAXBElement<UnlicensedSdkException>(_UnlicensedSdkException_QNAME, UnlicensedSdkException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Media }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Media")
    public JAXBElement<Media> createMedia(Media value) {
        return new JAXBElement<Media>(_Media_QNAME, Media.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Value }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Value")
    public JAXBElement<Value> createValue(Value value) {
        return new JAXBElement<Value>(_Value_QNAME, Value.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidJobStateException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "InvalidJobStateException")
    public JAXBElement<InvalidJobStateException> createInvalidJobStateException(InvalidJobStateException value) {
        return new JAXBElement<InvalidJobStateException>(_InvalidJobStateException_QNAME, InvalidJobStateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UriField }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "UriField")
    public JAXBElement<UriField> createUriField(UriField value) {
        return new JAXBElement<UriField>(_UriField_QNAME, UriField.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemDoesNotExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ItemDoesNotExistException")
    public JAXBElement<ItemDoesNotExistException> createItemDoesNotExistException(ItemDoesNotExistException value) {
        return new JAXBElement<ItemDoesNotExistException>(_ItemDoesNotExistException_QNAME, ItemDoesNotExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Event }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Event")
    public JAXBElement<Event> createEvent(Event value) {
        return new JAXBElement<Event>(_Event_QNAME, Event.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormatSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FormatSummary")
    public JAXBElement<FormatSummary> createFormatSummary(FormatSummary value) {
        return new JAXBElement<FormatSummary>(_FormatSummary_QNAME, FormatSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Component }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Component")
    public JAXBElement<Component> createComponent(Component value) {
        return new JAXBElement<Component>(_Component_QNAME, Component.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Element }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", name = "Element")
    public JAXBElement<Element> createElement(Element value) {
        return new JAXBElement<Element>(_Element_QNAME, Element.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaskState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "TaskState")
    public JAXBElement<TaskState> createTaskState(TaskState value) {
        return new JAXBElement<TaskState>(_TaskState_QNAME, TaskState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TypeCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "TypeCode")
    public JAXBElement<TypeCode> createTypeCode(TypeCode value) {
        return new JAXBElement<TypeCode>(_TypeCode_QNAME, TypeCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFolderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfFolderType")
    public JAXBElement<ArrayOfFolderType> createArrayOfFolderType(ArrayOfFolderType value) {
        return new JAXBElement<ArrayOfFolderType>(_ArrayOfFolderType_QNAME, ArrayOfFolderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Context }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Context")
    public JAXBElement<Context> createContext(Context value) {
        return new JAXBElement<Context>(_Context_QNAME, Context.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Session }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Session")
    public JAXBElement<Session> createSession(Session value) {
        return new JAXBElement<Session>(_Session_QNAME, Session.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProperty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfProperty")
    public JAXBElement<ArrayOfProperty> createArrayOfProperty(ArrayOfProperty value) {
        return new JAXBElement<ArrayOfProperty>(_ArrayOfProperty_QNAME, ArrayOfProperty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ConditionValue")
    public JAXBElement<ConditionValue> createConditionValue(ConditionValue value) {
        return new JAXBElement<ConditionValue>(_ConditionValue_QNAME, ConditionValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextEncoderFallback }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", name = "TextEncoderFallback")
    public JAXBElement<TextEncoderFallback> createTextEncoderFallback(TextEncoderFallback value) {
        return new JAXBElement<TextEncoderFallback>(_TextEncoderFallback_QNAME, TextEncoderFallback.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemplateDoesNotExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "TemplateDoesNotExistException")
    public JAXBElement<TemplateDoesNotExistException> createTemplateDoesNotExistException(TemplateDoesNotExistException value) {
        return new JAXBElement<TemplateDoesNotExistException>(_TemplateDoesNotExistException_QNAME, TemplateDoesNotExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Operation")
    public JAXBElement<Operation> createOperation(Operation value) {
        return new JAXBElement<Operation>(_Operation_QNAME, Operation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Unique }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Unique")
    public JAXBElement<Unique> createUnique(Unique value) {
        return new JAXBElement<Unique>(_Unique_QNAME, Unique.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JobSessionState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "JobSessionState")
    public JAXBElement<JobSessionState> createJobSessionState(JobSessionState value) {
        return new JAXBElement<JobSessionState>(_JobSessionState_QNAME, JobSessionState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JobType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "JobType")
    public JAXBElement<JobType> createJobType(JobType value) {
        return new JAXBElement<JobType>(_JobType_QNAME, JobType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfItem")
    public JAXBElement<ArrayOfItem> createArrayOfItem(ArrayOfItem value) {
        return new JAXBElement<ArrayOfItem>(_ArrayOfItem_QNAME, ArrayOfItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Record }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Record")
    public JAXBElement<Record> createRecord(Record value) {
        return new JAXBElement<Record>(_Record_QNAME, Record.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuplicateItemException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "DuplicateItemException")
    public JAXBElement<DuplicateItemException> createDuplicateItemException(DuplicateItemException value) {
        return new JAXBElement<DuplicateItemException>(_DuplicateItemException_QNAME, DuplicateItemException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManifestList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ManifestList")
    public JAXBElement<ManifestList> createManifestList(ManifestList value) {
        return new JAXBElement<ManifestList>(_ManifestList_QNAME, ManifestList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextEncoding }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", name = "TextEncoding")
    public JAXBElement<TextEncoding> createTextEncoding(TextEncoding value) {
        return new JAXBElement<TextEncoding>(_TextEncoding_QNAME, TextEncoding.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfItemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfItemType")
    public JAXBElement<ArrayOfItemType> createArrayOfItemType(ArrayOfItemType value) {
        return new JAXBElement<ArrayOfItemType>(_ArrayOfItemType_QNAME, ArrayOfItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link File }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "File")
    public JAXBElement<File> createFile(File value) {
        return new JAXBElement<File>(_File_QNAME, File.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlSerializerNamespaces }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/System.Xml.Serialization", name = "XmlSerializerNamespaces")
    public JAXBElement<XmlSerializerNamespaces> createXmlSerializerNamespaces(XmlSerializerNamespaces value) {
        return new JAXBElement<XmlSerializerNamespaces>(_XmlSerializerNamespaces_QNAME, XmlSerializerNamespaces.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Parameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Parameter")
    public JAXBElement<Parameter> createParameter(Parameter value) {
        return new JAXBElement<Parameter>(_Parameter_QNAME, Parameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBinderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfBinderType")
    public JAXBElement<ArrayOfBinderType> createArrayOfBinderType(ArrayOfBinderType value) {
        return new JAXBElement<ArrayOfBinderType>(_ArrayOfBinderType_QNAME, ArrayOfBinderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetaSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "MetaSummary")
    public JAXBElement<MetaSummary> createMetaSummary(MetaSummary value) {
        return new JAXBElement<MetaSummary>(_MetaSummary_QNAME, MetaSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link History }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "History")
    public JAXBElement<History> createHistory(History value) {
        return new JAXBElement<History>(_History_QNAME, History.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "BinderType")
    public JAXBElement<BinderType> createBinderType(BinderType value) {
        return new JAXBElement<BinderType>(_BinderType_QNAME, BinderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfstring")
    public JAXBElement<ArrayOfstring> createArrayOfstring(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_ArrayOfstring_QNAME, ArrayOfstring.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Procedure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Procedure")
    public JAXBElement<Procedure> createProcedure(Procedure value) {
        return new JAXBElement<Procedure>(_Procedure_QNAME, Procedure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfguid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FieldOfguid")
    public JAXBElement<FieldOfguid> createFieldOfguid(FieldOfguid value) {
        return new JAXBElement<FieldOfguid>(_FieldOfguid_QNAME, FieldOfguid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Complex }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Complex")
    public JAXBElement<Complex> createComplex(Complex value) {
        return new JAXBElement<Complex>(_Complex_QNAME, Complex.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnitType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "UnitType")
    public JAXBElement<UnitType> createUnitType(UnitType value) {
        return new JAXBElement<UnitType>(_UnitType_QNAME, UnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfanyURI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FieldOfanyURI")
    public JAXBElement<FieldOfanyURI> createFieldOfanyURI(FieldOfanyURI value) {
        return new JAXBElement<FieldOfanyURI>(_FieldOfanyURI_QNAME, FieldOfanyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Store }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Store")
    public JAXBElement<Store> createStore(Store value) {
        return new JAXBElement<Store>(_Store_QNAME, Store.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowJobQualifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "WorkflowJobQualifierType")
    public JAXBElement<WorkflowJobQualifierType> createWorkflowJobQualifierType(WorkflowJobQualifierType value) {
        return new JAXBElement<WorkflowJobQualifierType>(_WorkflowJobQualifierType_QNAME, WorkflowJobQualifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FolderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FolderType")
    public JAXBElement<FolderType> createFolderType(FolderType value) {
        return new JAXBElement<FolderType>(_FolderType_QNAME, FolderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BindableFieldOfanyURI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "BindableFieldOfanyURI")
    public JAXBElement<BindableFieldOfanyURI> createBindableFieldOfanyURI(BindableFieldOfanyURI value) {
        return new JAXBElement<BindableFieldOfanyURI>(_BindableFieldOfanyURI_QNAME, BindableFieldOfanyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ContentType")
    public JAXBElement<ContentType> createContentType(ContentType value) {
        return new JAXBElement<ContentType>(_ContentType_QNAME, ContentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AudioSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "AudioSummary")
    public JAXBElement<AudioSummary> createAudioSummary(AudioSummary value) {
        return new JAXBElement<AudioSummary>(_AudioSummary_QNAME, AudioSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrackTrackValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Track.TrackValue")
    public JAXBElement<TrackTrackValue> createTrackTrackValue(TrackTrackValue value) {
        return new JAXBElement<TrackTrackValue>(_TrackTrackValue_QNAME, TrackTrackValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Task }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Task")
    public JAXBElement<Task> createTask(Task value) {
        return new JAXBElement<Task>(_Task_QNAME, Task.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PauseResumeInvalidStateException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "PauseResumeInvalidStateException")
    public JAXBElement<PauseResumeInvalidStateException> createPauseResumeInvalidStateException(PauseResumeInvalidStateException value) {
        return new JAXBElement<PauseResumeInvalidStateException>(_PauseResumeInvalidStateException_QNAME, PauseResumeInvalidStateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FieldOfboolean")
    public JAXBElement<FieldOfboolean> createFieldOfboolean(FieldOfboolean value) {
        return new JAXBElement<FieldOfboolean>(_FieldOfboolean_QNAME, FieldOfboolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FieldOfint")
    public JAXBElement<FieldOfint> createFieldOfint(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_FieldOfint_QNAME, FieldOfint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "SessionType")
    public JAXBElement<SessionType> createSessionType(SessionType value) {
        return new JAXBElement<SessionType>(_SessionType_QNAME, SessionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfTask")
    public JAXBElement<ArrayOfTask> createArrayOfTask(ArrayOfTask value) {
        return new JAXBElement<ArrayOfTask>(_ArrayOfTask_QNAME, ArrayOfTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfOperation")
    public JAXBElement<ArrayOfOperation> createArrayOfOperation(ArrayOfOperation value) {
        return new JAXBElement<ArrayOfOperation>(_ArrayOfOperation_QNAME, ArrayOfOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MD5HashKey }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "MD5HashKey")
    public JAXBElement<MD5HashKey> createMD5HashKey(MD5HashKey value) {
        return new JAXBElement<MD5HashKey>(_MD5HashKey_QNAME, MD5HashKey.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionDoesNotExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "SessionDoesNotExistException")
    public JAXBElement<SessionDoesNotExistException> createSessionDoesNotExistException(SessionDoesNotExistException value) {
        return new JAXBElement<SessionDoesNotExistException>(_SessionDoesNotExistException_QNAME, SessionDoesNotExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCondition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfCondition")
    public JAXBElement<ArrayOfCondition> createArrayOfCondition(ArrayOfCondition value) {
        return new JAXBElement<ArrayOfCondition>(_ArrayOfCondition_QNAME, ArrayOfCondition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfRecord")
    public JAXBElement<ArrayOfRecord> createArrayOfRecord(ArrayOfRecord value) {
        return new JAXBElement<ArrayOfRecord>(_ArrayOfRecord_QNAME, ArrayOfRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfguid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfguid")
    public JAXBElement<ArrayOfguid> createArrayOfguid(ArrayOfguid value) {
        return new JAXBElement<ArrayOfguid>(_ArrayOfguid_QNAME, ArrayOfguid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfParameter")
    public JAXBElement<ArrayOfParameter> createArrayOfParameter(ArrayOfParameter value) {
        return new JAXBElement<ArrayOfParameter>(_ArrayOfParameter_QNAME, ArrayOfParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTrackTrackValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfTrack.TrackValue")
    public JAXBElement<ArrayOfTrackTrackValue> createArrayOfTrackTrackValue(ArrayOfTrackTrackValue value) {
        return new JAXBElement<ArrayOfTrackTrackValue>(_ArrayOfTrackTrackValue_QNAME, ArrayOfTrackTrackValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Manifest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Manifest")
    public JAXBElement<Manifest> createManifest(Manifest value) {
        return new JAXBElement<Manifest>(_Manifest_QNAME, Manifest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrackView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "TrackView")
    public JAXBElement<TrackView> createTrackView(TrackView value) {
        return new JAXBElement<TrackView>(_TrackView_QNAME, TrackView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Item")
    public JAXBElement<Item> createItem(Item value) {
        return new JAXBElement<Item>(_Item_QNAME, Item.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FileType")
    public JAXBElement<FileType> createFileType(FileType value) {
        return new JAXBElement<FileType>(_FileType_QNAME, FileType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfLabel")
    public JAXBElement<ArrayOfLabel> createArrayOfLabel(ArrayOfLabel value) {
        return new JAXBElement<ArrayOfLabel>(_ArrayOfLabel_QNAME, ArrayOfLabel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", name = "ConditionList")
    public JAXBElement<ConditionList> createConditionList(ConditionList value) {
        return new JAXBElement<ConditionList>(_ConditionList_QNAME, ConditionList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Property }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Property")
    public JAXBElement<Property> createProperty(Property value) {
        return new JAXBElement<Property>(_Property_QNAME, Property.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowJobState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "WorkflowJobState")
    public JAXBElement<WorkflowJobState> createWorkflowJobState(WorkflowJobState value) {
        return new JAXBElement<WorkflowJobState>(_WorkflowJobState_QNAME, WorkflowJobState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStatusContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfStatusContext")
    public JAXBElement<ArrayOfStatusContext> createArrayOfStatusContext(ArrayOfStatusContext value) {
        return new JAXBElement<ArrayOfStatusContext>(_ArrayOfStatusContext_QNAME, ArrayOfStatusContext.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UniqueListOfConditionuZpbrClh }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "UniqueListOfConditionuZpbrClh")
    public JAXBElement<UniqueListOfConditionuZpbrClh> createUniqueListOfConditionuZpbrClh(UniqueListOfConditionuZpbrClh value) {
        return new JAXBElement<UniqueListOfConditionuZpbrClh>(_UniqueListOfConditionuZpbrClh_QNAME, UniqueListOfConditionuZpbrClh.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Document }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", name = "Document")
    public JAXBElement<Document> createDocument(Document value) {
        return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Condition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Condition")
    public JAXBElement<Condition> createCondition(Condition value) {
        return new JAXBElement<Condition>(_Condition_QNAME, Condition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOflong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FieldOflong")
    public JAXBElement<FieldOflong> createFieldOflong(FieldOflong value) {
        return new JAXBElement<FieldOflong>(_FieldOflong_QNAME, FieldOflong.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJobType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfJobType")
    public JAXBElement<ArrayOfJobType> createArrayOfJobType(ArrayOfJobType value) {
        return new JAXBElement<ArrayOfJobType>(_ArrayOfJobType_QNAME, ArrayOfJobType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Label }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Label")
    public JAXBElement<Label> createLabel(Label value) {
        return new JAXBElement<Label>(_Label_QNAME, Label.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StorePosition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "StorePosition")
    public JAXBElement<StorePosition> createStorePosition(StorePosition value) {
        return new JAXBElement<StorePosition>(_StorePosition_QNAME, StorePosition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JobDoesNotExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "JobDoesNotExistException")
    public JAXBElement<JobDoesNotExistException> createJobDoesNotExistException(JobDoesNotExistException value) {
        return new JAXBElement<JobDoesNotExistException>(_JobDoesNotExistException_QNAME, JobDoesNotExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAudioSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfAudioSummary")
    public JAXBElement<ArrayOfAudioSummary> createArrayOfAudioSummary(ArrayOfAudioSummary value) {
        return new JAXBElement<ArrayOfAudioSummary>(_ArrayOfAudioSummary_QNAME, ArrayOfAudioSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UniqueType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "UniqueType")
    public JAXBElement<UniqueType> createUniqueType(UniqueType value) {
        return new JAXBElement<UniqueType>(_UniqueType_QNAME, UniqueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogAccessException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "CatalogAccessException")
    public JAXBElement<CatalogAccessException> createCatalogAccessException(CatalogAccessException value) {
        return new JAXBElement<CatalogAccessException>(_CatalogAccessException_QNAME, CatalogAccessException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Track }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Track")
    public JAXBElement<Track> createTrack(Track value) {
        return new JAXBElement<Track>(_Track_QNAME, Track.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Collection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Collection")
    public JAXBElement<Collection> createCollection(Collection value) {
        return new JAXBElement<Collection>(_Collection_QNAME, Collection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowDoesNotExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "WorkflowDoesNotExistException")
    public JAXBElement<WorkflowDoesNotExistException> createWorkflowDoesNotExistException(WorkflowDoesNotExistException value) {
        return new JAXBElement<WorkflowDoesNotExistException>(_WorkflowDoesNotExistException_QNAME, WorkflowDoesNotExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FieldOfstring")
    public JAXBElement<FieldOfstring> createFieldOfstring(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_FieldOfstring_QNAME, FieldOfstring.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UniqueListOfFileuZpbrClh }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "UniqueListOfFileuZpbrClh")
    public JAXBElement<UniqueListOfFileuZpbrClh> createUniqueListOfFileuZpbrClh(UniqueListOfFileuZpbrClh value) {
        return new JAXBElement<UniqueListOfFileuZpbrClh>(_UniqueListOfFileuZpbrClh_QNAME, UniqueListOfFileuZpbrClh.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSessionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfSessionType")
    public JAXBElement<ArrayOfSessionType> createArrayOfSessionType(ArrayOfSessionType value) {
        return new JAXBElement<ArrayOfSessionType>(_ArrayOfSessionType_QNAME, ArrayOfSessionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VideoSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "VideoSummary")
    public JAXBElement<VideoSummary> createVideoSummary(VideoSummary value) {
        return new JAXBElement<VideoSummary>(_VideoSummary_QNAME, VideoSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PauseResumeNotSupportedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "PauseResumeNotSupportedException")
    public JAXBElement<PauseResumeNotSupportedException> createPauseResumeNotSupportedException(PauseResumeNotSupportedException value) {
        return new JAXBElement<PauseResumeNotSupportedException>(_PauseResumeNotSupportedException_QNAME, PauseResumeNotSupportedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ItemType")
    public JAXBElement<ItemType> createItemType(ItemType value) {
        return new JAXBElement<ItemType>(_ItemType_QNAME, ItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProcedure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfProcedure")
    public JAXBElement<ArrayOfProcedure> createArrayOfProcedure(ArrayOfProcedure value) {
        return new JAXBElement<ArrayOfProcedure>(_ArrayOfProcedure_QNAME, ArrayOfProcedure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Constraint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Constraint")
    public JAXBElement<Constraint> createConstraint(Constraint value) {
        return new JAXBElement<Constraint>(_Constraint_QNAME, Constraint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowState }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "WorkflowState")
    public JAXBElement<WorkflowState> createWorkflowState(WorkflowState value) {
        return new JAXBElement<WorkflowState>(_WorkflowState_QNAME, WorkflowState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ArrayOfSession")
    public JAXBElement<ArrayOfSession> createArrayOfSession(ArrayOfSession value) {
        return new JAXBElement<ArrayOfSession>(_ArrayOfSession_QNAME, ArrayOfSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfContentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetContentsForJobResult", scope = GetContentsForJobResponse.class)
    public JAXBElement<ArrayOfContentType> createGetContentsForJobResponseGetContentsForJobResult(ArrayOfContentType value) {
        return new JAXBElement<ArrayOfContentType>(_GetContentsForJobResponseGetContentsForJobResult_QNAME, ArrayOfContentType.class, GetContentsForJobResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "AspectWidth", scope = VideoSummary.class)
    public JAXBElement<FieldOfint> createVideoSummaryAspectWidth(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_VideoSummaryAspectWidth_QNAME, FieldOfint.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfdouble }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Framerate", scope = VideoSummary.class)
    public JAXBElement<FieldOfdouble> createVideoSummaryFramerate(FieldOfdouble value) {
        return new JAXBElement<FieldOfdouble>(_VideoSummaryFramerate_QNAME, FieldOfdouble.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "AspectHeight", scope = VideoSummary.class)
    public JAXBElement<FieldOfint> createVideoSummaryAspectHeight(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_VideoSummaryAspectHeight_QNAME, FieldOfint.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Width", scope = VideoSummary.class)
    public JAXBElement<FieldOfint> createVideoSummaryWidth(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_VideoSummaryWidth_QNAME, FieldOfint.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Vbr", scope = VideoSummary.class)
    public JAXBElement<FieldOfboolean> createVideoSummaryVbr(FieldOfboolean value) {
        return new JAXBElement<FieldOfboolean>(_VideoSummaryVbr_QNAME, FieldOfboolean.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Ancillary", scope = VideoSummary.class)
    public JAXBElement<FieldOfstring> createVideoSummaryAncillary(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_VideoSummaryAncillary_QNAME, FieldOfstring.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Bitrate", scope = VideoSummary.class)
    public JAXBElement<FieldOfint> createVideoSummaryBitrate(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_VideoSummaryBitrate_QNAME, FieldOfint.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Codec", scope = VideoSummary.class)
    public JAXBElement<FieldOfstring> createVideoSummaryCodec(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_VideoSummaryCodec_QNAME, FieldOfstring.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Height", scope = VideoSummary.class)
    public JAXBElement<FieldOfint> createVideoSummaryHeight(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_VideoSummaryHeight_QNAME, FieldOfint.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Order", scope = VideoSummary.class)
    public JAXBElement<FieldOfboolean> createVideoSummaryOrder(FieldOfboolean value) {
        return new JAXBElement<FieldOfboolean>(_VideoSummaryOrder_QNAME, FieldOfboolean.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "IFrame", scope = VideoSummary.class)
    public JAXBElement<FieldOfboolean> createVideoSummaryIFrame(FieldOfboolean value) {
        return new JAXBElement<FieldOfboolean>(_VideoSummaryIFrame_QNAME, FieldOfboolean.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Chroma", scope = VideoSummary.class)
    public JAXBElement<FieldOfstring> createVideoSummaryChroma(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_VideoSummaryChroma_QNAME, FieldOfstring.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Interlaced", scope = VideoSummary.class)
    public JAXBElement<FieldOfboolean> createVideoSummaryInterlaced(FieldOfboolean value) {
        return new JAXBElement<FieldOfboolean>(_VideoSummaryInterlaced_QNAME, FieldOfboolean.class, VideoSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = JobType.class)
    public JAXBElement<String> createJobTypeName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, JobType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = ItemDoesNotExistException.class)
    public JAXBElement<String> createItemDoesNotExistExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, ItemDoesNotExistException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCondition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetVariablesResult", scope = GetVariablesResponse.class)
    public JAXBElement<ArrayOfCondition> createGetVariablesResponseGetVariablesResult(ArrayOfCondition value) {
        return new JAXBElement<ArrayOfCondition>(_GetVariablesResponseGetVariablesResult_QNAME, ArrayOfCondition.class, GetVariablesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetaSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Meta", scope = Summary.class)
    public JAXBElement<MetaSummary> createSummaryMeta(MetaSummary value) {
        return new JAXBElement<MetaSummary>(_SummaryMeta_QNAME, MetaSummary.class, Summary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAudioSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Audio", scope = Summary.class)
    public JAXBElement<ArrayOfAudioSummary> createSummaryAudio(ArrayOfAudioSummary value) {
        return new JAXBElement<ArrayOfAudioSummary>(_SummaryAudio_QNAME, ArrayOfAudioSummary.class, Summary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VideoSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Video", scope = Summary.class)
    public JAXBElement<VideoSummary> createSummaryVideo(VideoSummary value) {
        return new JAXBElement<VideoSummary>(_SummaryVideo_QNAME, VideoSummary.class, Summary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormatSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Format", scope = Summary.class)
    public JAXBElement<FormatSummary> createSummaryFormat(FormatSummary value) {
        return new JAXBElement<FormatSummary>(_SummaryFormat_QNAME, FormatSummary.class, Summary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "newItemDefinition", scope = UpdateItem.class)
    public JAXBElement<Item> createUpdateItemNewItemDefinition(Item value) {
        return new JAXBElement<Item>(_UpdateItemNewItemDefinition_QNAME, Item.class, UpdateItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = PauseResumeInvalidStateException.class)
    public JAXBElement<String> createPauseResumeInvalidStateExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, PauseResumeInvalidStateException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Procedure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetWorkflowResult", scope = GetWorkflowResponse.class)
    public JAXBElement<Procedure> createGetWorkflowResponseGetWorkflowResult(Procedure value) {
        return new JAXBElement<Procedure>(_GetWorkflowResponseGetWorkflowResult_QNAME, Procedure.class, GetWorkflowResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfItemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetContentLabelsResult", scope = GetContentLabelsResponse.class)
    public JAXBElement<ArrayOfItemType> createGetContentLabelsResponseGetContentLabelsResult(ArrayOfItemType value) {
        return new JAXBElement<ArrayOfItemType>(_GetContentLabelsResponseGetContentLabelsResult_QNAME, ArrayOfItemType.class, GetContentLabelsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = WorkflowInvalidStateException.class)
    public JAXBElement<String> createWorkflowInvalidStateExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, WorkflowInvalidStateException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Description", scope = Component.class)
    public JAXBElement<String> createComponentDescription(String value) {
        return new JAXBElement<String>(_ComponentDescription_QNAME, String.class, Component.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = StatusContext.class)
    public JAXBElement<String> createStatusContextName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, StatusContext.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Context }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "context", scope = SubmitFile.class)
    public JAXBElement<Context> createSubmitFileContext(Context value) {
        return new JAXBElement<Context>(_SubmitFileContext_QNAME, Context.class, SubmitFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "jobName", scope = SubmitFile.class)
    public JAXBElement<String> createSubmitFileJobName(String value) {
        return new JAXBElement<String>(_SubmitFileJobName_QNAME, String.class, SubmitFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "sourceFilename", scope = SubmitFile.class)
    public JAXBElement<String> createSubmitFileSourceFilename(String value) {
        return new JAXBElement<String>(_SubmitFileSourceFilename_QNAME, String.class, SubmitFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Context }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetWorkflowVariableRequirementsResult", scope = GetWorkflowVariableRequirementsResponse.class)
    public JAXBElement<Context> createGetWorkflowVariableRequirementsResponseGetWorkflowVariableRequirementsResult(Context value) {
        return new JAXBElement<Context>(_GetWorkflowVariableRequirementsResponseGetWorkflowVariableRequirementsResult_QNAME, Context.class, GetWorkflowVariableRequirementsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetDomainVersionResult", scope = GetDomainVersionResponse.class)
    public JAXBElement<String> createGetDomainVersionResponseGetDomainVersionResult(String value) {
        return new JAXBElement<String>(_GetDomainVersionResponseGetDomainVersionResult_QNAME, String.class, GetDomainVersionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Constraint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Default", scope = ConditionValue.class)
    public JAXBElement<Constraint> createConditionValueDefault(Constraint value) {
        return new JAXBElement<Constraint>(_ConditionValueDefault_QNAME, Constraint.class, ConditionValue.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSessionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetSessionsForJobResult", scope = GetSessionsForJobResponse.class)
    public JAXBElement<ArrayOfSessionType> createGetSessionsForJobResponseGetSessionsForJobResult(ArrayOfSessionType value) {
        return new JAXBElement<ArrayOfSessionType>(_GetSessionsForJobResponseGetSessionsForJobResult_QNAME, ArrayOfSessionType.class, GetSessionsForJobResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJobType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetJobsForWorkflowResult", scope = GetJobsForWorkflowResponse.class)
    public JAXBElement<ArrayOfJobType> createGetJobsForWorkflowResponseGetJobsForWorkflowResult(ArrayOfJobType value) {
        return new JAXBElement<ArrayOfJobType>(_GetJobsForWorkflowResponseGetJobsForWorkflowResult_QNAME, ArrayOfJobType.class, GetJobsForWorkflowResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "itemToUpdate", scope = UpdateItemInBinder.class)
    public JAXBElement<Item> createUpdateItemInBinderItemToUpdate(Item value) {
        return new JAXBElement<Item>(_UpdateItemInBinderItemToUpdate_QNAME, Item.class, UpdateItemInBinder.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Copyright", scope = MetaSummary.class)
    public JAXBElement<FieldOfstring> createMetaSummaryCopyright(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_MetaSummaryCopyright_QNAME, FieldOfstring.class, MetaSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Author", scope = MetaSummary.class)
    public JAXBElement<FieldOfstring> createMetaSummaryAuthor(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_MetaSummaryAuthor_QNAME, FieldOfstring.class, MetaSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Abstract", scope = MetaSummary.class)
    public JAXBElement<FieldOfstring> createMetaSummaryAbstract(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_MetaSummaryAbstract_QNAME, FieldOfstring.class, MetaSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Title", scope = MetaSummary.class)
    public JAXBElement<FieldOfstring> createMetaSummaryTitle(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_MetaSummaryTitle_QNAME, FieldOfstring.class, MetaSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Ancillary", scope = MetaSummary.class)
    public JAXBElement<FieldOfstring> createMetaSummaryAncillary(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_VideoSummaryAncillary_QNAME, FieldOfstring.class, MetaSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Rating", scope = MetaSummary.class)
    public JAXBElement<FieldOfstring> createMetaSummaryRating(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_MetaSummaryRating_QNAME, FieldOfstring.class, MetaSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = CatalogAccessException.class)
    public JAXBElement<String> createCatalogAccessExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, CatalogAccessException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = SessionType.class)
    public JAXBElement<String> createSessionTypeName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, SessionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Description", scope = SessionType.class)
    public JAXBElement<String> createSessionTypeDescription(String value) {
        return new JAXBElement<String>(_ComponentDescription_QNAME, String.class, SessionType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = JobDoesNotExistException.class)
    public JAXBElement<String> createJobDoesNotExistExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, JobDoesNotExistException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = Procedure.class)
    public JAXBElement<String> createProcedureName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, Procedure.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Conditions", scope = Procedure.class)
    public JAXBElement<ConditionList> createProcedureConditions(ConditionList value) {
        return new JAXBElement<ConditionList>(_ProcedureConditions_QNAME, ConditionList.class, Procedure.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Description", scope = Procedure.class)
    public JAXBElement<String> createProcedureDescription(String value) {
        return new JAXBElement<String>(_ComponentDescription_QNAME, String.class, Procedure.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "itemToAdd", scope = AddItemToBinder.class)
    public JAXBElement<Item> createAddItemToBinderItemToAdd(Item value) {
        return new JAXBElement<Item>(_AddItemToBinderItemToAdd_QNAME, Item.class, AddItemToBinder.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfItemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetContentAttachmentsResult", scope = GetContentAttachmentsResponse.class)
    public JAXBElement<ArrayOfItemType> createGetContentAttachmentsResponseGetContentAttachmentsResult(ArrayOfItemType value) {
        return new JAXBElement<ArrayOfItemType>(_GetContentAttachmentsResponseGetContentAttachmentsResult_QNAME, ArrayOfItemType.class, GetContentAttachmentsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManifestList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Manifests", scope = Store.class)
    public JAXBElement<ManifestList> createStoreManifests(ManifestList value) {
        return new JAXBElement<ManifestList>(_StoreManifests_QNAME, ManifestList.class, Store.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Data", scope = Store.class)
    public JAXBElement<byte[]> createStoreData(byte[] value) {
        return new JAXBElement<byte[]>(_StoreData_QNAME, byte[].class, Store.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = ItemType.class)
    public JAXBElement<String> createItemTypeName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, ItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Item", scope = ItemType.class)
    public JAXBElement<Item> createItemTypeItem(Item value) {
        return new JAXBElement<Item>(_Item_QNAME, Item.class, ItemType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = SessionDoesNotExistException.class)
    public JAXBElement<String> createSessionDoesNotExistExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, SessionDoesNotExistException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFolderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetCatalogsResult", scope = GetCatalogsResponse.class)
    public JAXBElement<ArrayOfFolderType> createGetCatalogsResponseGetCatalogsResult(ArrayOfFolderType value) {
        return new JAXBElement<ArrayOfFolderType>(_GetCatalogsResponseGetCatalogsResult_QNAME, ArrayOfFolderType.class, GetCatalogsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStatusContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Contexts", scope = History.class)
    public JAXBElement<ArrayOfStatusContext> createHistoryContexts(ArrayOfStatusContext value) {
        return new JAXBElement<ArrayOfStatusContext>(_HistoryContexts_QNAME, ArrayOfStatusContext.class, History.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Operations", scope = History.class)
    public JAXBElement<ArrayOfOperation> createHistoryOperations(ArrayOfOperation value) {
        return new JAXBElement<ArrayOfOperation>(_HistoryOperations_QNAME, ArrayOfOperation.class, History.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfanyURI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FilePath", scope = FileProperties.class)
    public JAXBElement<FieldOfanyURI> createFilePropertiesFilePath(FieldOfanyURI value) {
        return new JAXBElement<FieldOfanyURI>(_FilePropertiesFilePath_QNAME, FieldOfanyURI.class, FileProperties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOflong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FileSize", scope = FileProperties.class)
    public JAXBElement<FieldOflong> createFilePropertiesFileSize(FieldOflong value) {
        return new JAXBElement<FieldOflong>(_FilePropertiesFileSize_QNAME, FieldOflong.class, FileProperties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FileName", scope = FileProperties.class)
    public JAXBElement<FieldOfstring> createFilePropertiesFileName(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_FilePropertiesFileName_QNAME, FieldOfstring.class, FileProperties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FileExtension", scope = FileProperties.class)
    public JAXBElement<FieldOfstring> createFilePropertiesFileExtension(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_FilePropertiesFileExtension_QNAME, FieldOfstring.class, FileProperties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetFileResult", scope = GetFileResponse.class)
    public JAXBElement<FileType> createGetFileResponseGetFileResult(FileType value) {
        return new JAXBElement<FileType>(_GetFileResponseGetFileResult_QNAME, FileType.class, GetFileResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBinderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ListBindersResult", scope = ListBindersResponse.class)
    public JAXBElement<ArrayOfBinderType> createListBindersResponseListBindersResult(ArrayOfBinderType value) {
        return new JAXBElement<ArrayOfBinderType>(_ListBindersResponseListBindersResult_QNAME, ArrayOfBinderType.class, ListBindersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Complex }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ComplexValue", scope = Value.class)
    public JAXBElement<Complex> createValueComplexValue(Complex value) {
        return new JAXBElement<Complex>(_ValueComplexValue_QNAME, Complex.class, Value.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Text", scope = Value.class)
    public JAXBElement<ArrayOfstring> createValueText(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_ValueText_QNAME, ArrayOfstring.class, Value.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Entry", scope = Record.class)
    public JAXBElement<String> createRecordEntry(String value) {
        return new JAXBElement<String>(_RecordEntry_QNAME, String.class, Record.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfguid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetItemFilesResult", scope = GetItemFilesResponse.class)
    public JAXBElement<ArrayOfguid> createGetItemFilesResponseGetItemFilesResult(ArrayOfguid value) {
        return new JAXBElement<ArrayOfguid>(_GetItemFilesResponseGetItemFilesResult_QNAME, ArrayOfguid.class, GetItemFilesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = Event.class)
    public JAXBElement<String> createEventName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, Event.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Detail", scope = Event.class)
    public JAXBElement<String> createEventDetail(String value) {
        return new JAXBElement<String>(_EventDetail_QNAME, String.class, Event.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Events", scope = Task.class)
    public JAXBElement<ArrayOfEvent> createTaskEvents(ArrayOfEvent value) {
        return new JAXBElement<ArrayOfEvent>(_TaskEvents_QNAME, ArrayOfEvent.class, Task.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = Task.class)
    public JAXBElement<String> createTaskName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, Task.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Detail", scope = Task.class)
    public JAXBElement<String> createTaskDetail(String value) {
        return new JAXBElement<String>(_EventDetail_QNAME, String.class, Task.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetWorkflowItemRequirementsResult", scope = GetWorkflowItemRequirementsResponse.class)
    public JAXBElement<ArrayOfItem> createGetWorkflowItemRequirementsResponseGetWorkflowItemRequirementsResult(ArrayOfItem value) {
        return new JAXBElement<ArrayOfItem>(_GetWorkflowItemRequirementsResponseGetWorkflowItemRequirementsResult_QNAME, ArrayOfItem.class, GetWorkflowItemRequirementsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = FolderType.class)
    public JAXBElement<String> createFolderTypeName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, FolderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetLabelsResult", scope = GetLabelsResponse.class)
    public JAXBElement<ArrayOfLabel> createGetLabelsResponseGetLabelsResult(ArrayOfLabel value) {
        return new JAXBElement<ArrayOfLabel>(_GetLabelsResponseGetLabelsResult_QNAME, ArrayOfLabel.class, GetLabelsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "CategoryValue", scope = Parameter.class)
    public JAXBElement<String> createParameterCategoryValue(String value) {
        return new JAXBElement<String>(_ParameterCategoryValue_QNAME, String.class, Parameter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Unit", scope = Parameter.class)
    public JAXBElement<String> createParameterUnit(String value) {
        return new JAXBElement<String>(_ParameterUnit_QNAME, String.class, Parameter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = Parameter.class)
    public JAXBElement<String> createParameterName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, Parameter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Description", scope = Parameter.class)
    public JAXBElement<String> createParameterDescription(String value) {
        return new JAXBElement<String>(_ComponentDescription_QNAME, String.class, Parameter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Tag", scope = Parameter.class)
    public JAXBElement<String> createParameterTag(String value) {
        return new JAXBElement<String>(_ParameterTag_QNAME, String.class, Parameter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Bitrate", scope = FormatSummary.class)
    public JAXBElement<FieldOfint> createFormatSummaryBitrate(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_VideoSummaryBitrate_QNAME, FieldOfint.class, FormatSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Ancillary", scope = FormatSummary.class)
    public JAXBElement<FieldOfstring> createFormatSummaryAncillary(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_VideoSummaryAncillary_QNAME, FieldOfstring.class, FormatSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOflong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FileSize", scope = FormatSummary.class)
    public JAXBElement<FieldOflong> createFormatSummaryFileSize(FieldOflong value) {
        return new JAXBElement<FieldOflong>(_FilePropertiesFileSize_QNAME, FieldOflong.class, FormatSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Description", scope = FormatSummary.class)
    public JAXBElement<FieldOfstring> createFormatSummaryDescription(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_ComponentDescription_QNAME, FieldOfstring.class, FormatSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Duration", scope = FormatSummary.class)
    public JAXBElement<FieldOfstring> createFormatSummaryDuration(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_FormatSummaryDuration_QNAME, FieldOfstring.class, FormatSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FileName", scope = FormatSummary.class)
    public JAXBElement<FieldOfstring> createFormatSummaryFileName(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_FilePropertiesFileName_QNAME, FieldOfstring.class, FormatSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetSessionDetailResult", scope = GetSessionDetailResponse.class)
    public JAXBElement<Operation> createGetSessionDetailResponseGetSessionDetailResult(Operation value) {
        return new JAXBElement<Operation>(_GetSessionDetailResponseGetSessionDetailResult_QNAME, Operation.class, GetSessionDetailResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = ContentDoesNotExistException.class)
    public JAXBElement<String> createContentDoesNotExistExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, ContentDoesNotExistException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFolderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ListFoldersResult", scope = ListFoldersResponse.class)
    public JAXBElement<ArrayOfFolderType> createListFoldersResponseListFoldersResult(ArrayOfFolderType value) {
        return new JAXBElement<ArrayOfFolderType>(_ListFoldersResponseListFoldersResult_QNAME, ArrayOfFolderType.class, ListFoldersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FolderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetFolderResult", scope = GetFolderResponse.class)
    public JAXBElement<FolderType> createGetFolderResponseGetFolderResult(FolderType value) {
        return new JAXBElement<FolderType>(_GetFolderResponseGetFolderResult_QNAME, FolderType.class, GetFolderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetItemFilePathsResult", scope = GetItemFilePathsResponse.class)
    public JAXBElement<ArrayOfstring> createGetItemFilePathsResponseGetItemFilePathsResult(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetItemFilePathsResponseGetItemFilePathsResult_QNAME, ArrayOfstring.class, GetItemFilePathsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FolderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetCatalogResult", scope = GetCatalogResponse.class)
    public JAXBElement<FolderType> createGetCatalogResponseGetCatalogResult(FolderType value) {
        return new JAXBElement<FolderType>(_GetCatalogResponseGetCatalogResult_QNAME, FolderType.class, GetCatalogResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Bitrate", scope = AudioSummary.class)
    public JAXBElement<FieldOfint> createAudioSummaryBitrate(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_VideoSummaryBitrate_QNAME, FieldOfint.class, AudioSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Ancillary", scope = AudioSummary.class)
    public JAXBElement<FieldOfstring> createAudioSummaryAncillary(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_VideoSummaryAncillary_QNAME, FieldOfstring.class, AudioSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Channels", scope = AudioSummary.class)
    public JAXBElement<FieldOfint> createAudioSummaryChannels(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_AudioSummaryChannels_QNAME, FieldOfint.class, AudioSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Codec", scope = AudioSummary.class)
    public JAXBElement<FieldOfstring> createAudioSummaryCodec(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_VideoSummaryCodec_QNAME, FieldOfstring.class, AudioSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Samplerate", scope = AudioSummary.class)
    public JAXBElement<FieldOfint> createAudioSummarySamplerate(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_AudioSummarySamplerate_QNAME, FieldOfint.class, AudioSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "BitsPerSample", scope = AudioSummary.class)
    public JAXBElement<FieldOfint> createAudioSummaryBitsPerSample(FieldOfint value) {
        return new JAXBElement<FieldOfint>(_AudioSummaryBitsPerSample_QNAME, FieldOfint.class, AudioSummary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetItemLocationResult", scope = GetItemLocationResponse.class)
    public JAXBElement<String> createGetItemLocationResponseGetItemLocationResult(String value) {
        return new JAXBElement<String>(_GetItemLocationResponseGetItemLocationResult_QNAME, String.class, GetItemLocationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetContentFromBinderResult", scope = GetContentFromBinderResponse.class)
    public JAXBElement<ContentType> createGetContentFromBinderResponseGetContentFromBinderResult(ContentType value) {
        return new JAXBElement<ContentType>(_GetContentFromBinderResponseGetContentFromBinderResult_QNAME, ContentType.class, GetContentFromBinderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = InvalidJobStateException.class)
    public JAXBElement<String> createInvalidJobStateExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, InvalidJobStateException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link History }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetSessionStatusResult", scope = GetSessionStatusResponse.class)
    public JAXBElement<History> createGetSessionStatusResponseGetSessionStatusResult(History value) {
        return new JAXBElement<History>(_GetSessionStatusResponseGetSessionStatusResult_QNAME, History.class, GetSessionStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTrackTrackValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Values", scope = Track.class)
    public JAXBElement<ArrayOfTrackTrackValue> createTrackValues(ArrayOfTrackTrackValue value) {
        return new JAXBElement<ArrayOfTrackTrackValue>(_TrackValues_QNAME, ArrayOfTrackTrackValue.class, Track.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Tasks", scope = Session.class)
    public JAXBElement<ArrayOfTask> createSessionTasks(ArrayOfTask value) {
        return new JAXBElement<ArrayOfTask>(_SessionTasks_QNAME, ArrayOfTask.class, Session.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = Session.class)
    public JAXBElement<String> createSessionName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, Session.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Log", scope = Session.class)
    public JAXBElement<ArrayOfRecord> createSessionLog(ArrayOfRecord value) {
        return new JAXBElement<ArrayOfRecord>(_SessionLog_QNAME, ArrayOfRecord.class, Session.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Detail", scope = Session.class)
    public JAXBElement<String> createSessionDetail(String value) {
        return new JAXBElement<String>(_EventDetail_QNAME, String.class, Session.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProcedure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetWorkflowsResult", scope = GetWorkflowsResponse.class)
    public JAXBElement<ArrayOfProcedure> createGetWorkflowsResponseGetWorkflowsResult(ArrayOfProcedure value) {
        return new JAXBElement<ArrayOfProcedure>(_GetWorkflowsResponseGetWorkflowsResult_QNAME, ArrayOfProcedure.class, GetWorkflowsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = WorkflowDoesNotExistException.class)
    public JAXBElement<String> createWorkflowDoesNotExistExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, WorkflowDoesNotExistException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMedia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetMediaVersionsResult", scope = GetMediaVersionsResponse.class)
    public JAXBElement<ArrayOfMedia> createGetMediaVersionsResponseGetMediaVersionsResult(ArrayOfMedia value) {
        return new JAXBElement<ArrayOfMedia>(_GetMediaVersionsResponseGetMediaVersionsResult_QNAME, ArrayOfMedia.class, GetMediaVersionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ManifestList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Manifests", scope = Media.class)
    public JAXBElement<ManifestList> createMediaManifests(ManifestList value) {
        return new JAXBElement<ManifestList>(_StoreManifests_QNAME, ManifestList.class, Media.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Label }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetLabelResult", scope = GetLabelResponse.class)
    public JAXBElement<Label> createGetLabelResponseGetLabelResult(Label value) {
        return new JAXBElement<Label>(_GetLabelResponseGetLabelResult_QNAME, Label.class, GetLabelResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UriField }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Location", scope = File.class)
    public JAXBElement<UriField> createFileLocation(UriField value) {
        return new JAXBElement<UriField>(_FileLocation_QNAME, UriField.class, File.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UriField }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Path", scope = File.class)
    public JAXBElement<UriField> createFilePath(UriField value) {
        return new JAXBElement<UriField>(_FilePath_QNAME, UriField.class, File.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "PathRelevantEnabled", scope = File.class)
    public JAXBElement<String> createFilePathRelevantEnabled(String value) {
        return new JAXBElement<String>(_FilePathRelevantEnabled_QNAME, String.class, File.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Context }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "context", scope = SubmitFileAndItems.class)
    public JAXBElement<Context> createSubmitFileAndItemsContext(Context value) {
        return new JAXBElement<Context>(_SubmitFileContext_QNAME, Context.class, SubmitFileAndItems.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "jobName", scope = SubmitFileAndItems.class)
    public JAXBElement<String> createSubmitFileAndItemsJobName(String value) {
        return new JAXBElement<String>(_SubmitFileJobName_QNAME, String.class, SubmitFileAndItems.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "requiredItems", scope = SubmitFileAndItems.class)
    public JAXBElement<ArrayOfItem> createSubmitFileAndItemsRequiredItems(ArrayOfItem value) {
        return new JAXBElement<ArrayOfItem>(_SubmitFileAndItemsRequiredItems_QNAME, ArrayOfItem.class, SubmitFileAndItems.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "sourceFilename", scope = SubmitFileAndItems.class)
    public JAXBElement<String> createSubmitFileAndItemsSourceFilename(String value) {
        return new JAXBElement<String>(_SubmitFileSourceFilename_QNAME, String.class, SubmitFileAndItems.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = PauseResumeNotSupportedException.class)
    public JAXBElement<String> createPauseResumeNotSupportedExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, PauseResumeNotSupportedException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = TemplateDoesNotExistException.class)
    public JAXBElement<String> createTemplateDoesNotExistExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, TemplateDoesNotExistException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Summary", scope = Collection.class)
    public JAXBElement<String> createCollectionSummary(String value) {
        return new JAXBElement<String>(_Summary_QNAME, String.class, Collection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Parameters", scope = Collection.class)
    public JAXBElement<ArrayOfParameter> createCollectionParameters(ArrayOfParameter value) {
        return new JAXBElement<ArrayOfParameter>(_CollectionParameters_QNAME, ArrayOfParameter.class, Collection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = Collection.class)
    public JAXBElement<String> createCollectionName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, Collection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UriField }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Location", scope = Item.class)
    public JAXBElement<UriField> createItemLocation(UriField value) {
        return new JAXBElement<UriField>(_FileLocation_QNAME, UriField.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UniqueListOfFileuZpbrClh }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Files", scope = Item.class)
    public JAXBElement<UniqueListOfFileuZpbrClh> createItemFiles(UniqueListOfFileuZpbrClh value) {
        return new JAXBElement<UniqueListOfFileuZpbrClh>(_ItemFiles_QNAME, UniqueListOfFileuZpbrClh.class, Item.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = UnlicensedSdkException.class)
    public JAXBElement<String> createUnlicensedSdkExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, UnlicensedSdkException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetSessionResult", scope = GetSessionResponse.class)
    public JAXBElement<SessionType> createGetSessionResponseGetSessionResult(SessionType value) {
        return new JAXBElement<SessionType>(_GetSessionResponseGetSessionResult_QNAME, SessionType.class, GetSessionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JobType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetJobResult", scope = GetJobResponse.class)
    public JAXBElement<JobType> createGetJobResponseGetJobResult(JobType value) {
        return new JAXBElement<JobType>(_GetJobResponseGetJobResult_QNAME, JobType.class, GetJobResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Media }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetMediaVersionResult", scope = GetMediaVersionResponse.class)
    public JAXBElement<Media> createGetMediaVersionResponseGetMediaVersionResult(Media value) {
        return new JAXBElement<Media>(_GetMediaVersionResponseGetMediaVersionResult_QNAME, Media.class, GetMediaVersionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = ContentType.class)
    public JAXBElement<String> createContentTypeName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, ContentType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "LastError", scope = Operation.class)
    public JAXBElement<String> createOperationLastError(String value) {
        return new JAXBElement<String>(_OperationLastError_QNAME, String.class, Operation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Sessions", scope = Operation.class)
    public JAXBElement<ArrayOfSession> createOperationSessions(ArrayOfSession value) {
        return new JAXBElement<ArrayOfSession>(_OperationSessions_QNAME, ArrayOfSession.class, Operation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = Operation.class)
    public JAXBElement<String> createOperationName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, Operation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ExecutedOn", scope = Operation.class)
    public JAXBElement<String> createOperationExecutedOn(String value) {
        return new JAXBElement<String>(_OperationExecutedOn_QNAME, String.class, Operation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = BinderType.class)
    public JAXBElement<String> createBinderTypeName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, BinderType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Context }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "context", scope = SubmitBinder.class)
    public JAXBElement<Context> createSubmitBinderContext(Context value) {
        return new JAXBElement<Context>(_SubmitFileContext_QNAME, Context.class, SubmitBinder.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "jobName", scope = SubmitBinder.class)
    public JAXBElement<String> createSubmitBinderJobName(String value) {
        return new JAXBElement<String>(_SubmitFileJobName_QNAME, String.class, SubmitBinder.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Message", scope = DuplicateItemException.class)
    public JAXBElement<String> createDuplicateItemExceptionMessage(String value) {
        return new JAXBElement<String>(_ItemDoesNotExistExceptionMessage_QNAME, String.class, DuplicateItemException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMedia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetAgilityMediaVersionsResult", scope = GetAgilityMediaVersionsResponse.class)
    public JAXBElement<ArrayOfMedia> createGetAgilityMediaVersionsResponseGetAgilityMediaVersionsResult(ArrayOfMedia value) {
        return new JAXBElement<ArrayOfMedia>(_GetAgilityMediaVersionsResponseGetAgilityMediaVersionsResult_QNAME, ArrayOfMedia.class, GetAgilityMediaVersionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Key", scope = MD5HashKey.class)
    public JAXBElement<FieldOfstring> createMD5HashKeyKey(FieldOfstring value) {
        return new JAXBElement<FieldOfstring>(_MD5HashKeyKey_QNAME, FieldOfstring.class, MD5HashKey.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfProperty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Properties", scope = Complex.class)
    public JAXBElement<ArrayOfProperty> createComplexProperties(ArrayOfProperty value) {
        return new JAXBElement<ArrayOfProperty>(_ComplexProperties_QNAME, ArrayOfProperty.class, Complex.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = Complex.class)
    public JAXBElement<String> createComplexName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, Complex.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Summary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetSummaryResult", scope = GetSummaryResponse.class)
    public JAXBElement<Summary> createGetSummaryResponseGetSummaryResult(Summary value) {
        return new JAXBElement<Summary>(_GetSummaryResponseGetSummaryResult_QNAME, Summary.class, GetSummaryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuidField }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Condition", scope = BindableFieldOfanyURI.class)
    public JAXBElement<GuidField> createBindableFieldOfanyURICondition(GuidField value) {
        return new JAXBElement<GuidField>(_Condition_QNAME, GuidField.class, BindableFieldOfanyURI.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "ConditionValue", scope = Condition.class)
    public JAXBElement<ConditionValue> createConditionConditionValue(ConditionValue value) {
        return new JAXBElement<ConditionValue>(_ConditionValue_QNAME, ConditionValue.class, Condition.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "FullPathName", scope = FileType.class)
    public JAXBElement<String> createFileTypeFullPathName(String value) {
        return new JAXBElement<String>(_FileTypeFullPathName_QNAME, String.class, FileType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Name", scope = FileType.class)
    public JAXBElement<String> createFileTypeName(String value) {
        return new JAXBElement<String>(_JobTypeName_QNAME, String.class, FileType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetBinderResult", scope = GetBinderResponse.class)
    public JAXBElement<BinderType> createGetBinderResponseGetBinderResult(BinderType value) {
        return new JAXBElement<BinderType>(_GetBinderResponseGetBinderResult_QNAME, BinderType.class, GetBinderResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfItemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetContentMediaResult", scope = GetContentMediaResponse.class)
    public JAXBElement<ArrayOfItemType> createGetContentMediaResponseGetContentMediaResult(ArrayOfItemType value) {
        return new JAXBElement<ArrayOfItemType>(_GetContentMediaResponseGetContentMediaResult_QNAME, ArrayOfItemType.class, GetContentMediaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConditionList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "Conditions", scope = Context.class)
    public JAXBElement<ConditionList> createContextConditions(ConditionList value) {
        return new JAXBElement<ConditionList>(_ProcedureConditions_QNAME, ConditionList.class, Context.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Condition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Telestream.Vantage.Sdk/2010/07", name = "GetVariableResult", scope = GetVariableResponse.class)
    public JAXBElement<Condition> createGetVariableResponseGetVariableResult(Condition value) {
        return new JAXBElement<Condition>(_GetVariableResponseGetVariableResult_QNAME, Condition.class, GetVariableResponse.class, value);
    }

}
