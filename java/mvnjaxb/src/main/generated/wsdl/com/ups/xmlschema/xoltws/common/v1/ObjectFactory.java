
package com.ups.xmlschema.xoltws.common.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ups.xmlschema.xoltws.common.v1 package. 
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

    private final static QName _ClientInformation_QNAME = new QName("http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0", "ClientInformation");
    private final static QName _Response_QNAME = new QName("http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0", "Response");
    private final static QName _Request_QNAME = new QName("http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0", "Request");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ups.xmlschema.xoltws.common.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClientInformationType }
     * 
     */
    public ClientInformationType createClientInformationType() {
        return new ClientInformationType();
    }

    /**
     * Create an instance of {@link ClientInformationType.Property }
     * 
     */
    public ClientInformationType.Property createClientInformationTypeProperty() {
        return new ClientInformationType.Property();
    }

    /**
     * Create an instance of {@link CodeDescriptionType }
     * 
     */
    public CodeDescriptionType createCodeDescriptionType() {
        return new CodeDescriptionType();
    }

    /**
     * Create an instance of {@link ResponseType }
     * 
     */
    public ResponseType createResponseType() {
        return new ResponseType();
    }

    /**
     * Create an instance of {@link TransactionReferenceType }
     * 
     */
    public TransactionReferenceType createTransactionReferenceType() {
        return new TransactionReferenceType();
    }

    /**
     * Create an instance of {@link RequestType }
     * 
     */
    public RequestType createRequestType() {
        return new RequestType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientInformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0", name = "ClientInformation")
    public JAXBElement<ClientInformationType> createClientInformation(ClientInformationType value) {
        return new JAXBElement<ClientInformationType>(_ClientInformation_QNAME, ClientInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0", name = "Response")
    public JAXBElement<ResponseType> createResponse(ResponseType value) {
        return new JAXBElement<ResponseType>(_Response_QNAME, ResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0", name = "Request")
    public JAXBElement<RequestType> createRequest(RequestType value) {
        return new JAXBElement<RequestType>(_Request_QNAME, RequestType.class, null, value);
    }

}
