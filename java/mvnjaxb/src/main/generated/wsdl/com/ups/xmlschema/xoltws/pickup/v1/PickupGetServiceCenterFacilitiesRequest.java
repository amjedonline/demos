
package com.ups.xmlschema.xoltws.pickup.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.ups.xmlschema.xoltws.common.v1.RequestType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0}Request"/>
 *         &lt;element name="PickupPiece" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}PickupPieceServiceType" maxOccurs="unbounded"/>
 *         &lt;element name="OriginAddress" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}OriginAddressType" minOccurs="0"/>
 *         &lt;element name="DestinationAddress" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}DestinationAddressType" minOccurs="0"/>
 *         &lt;element name="Locale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProximitySearchIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "request",
    "pickupPiece",
    "originAddress",
    "destinationAddress",
    "locale",
    "proximitySearchIndicator"
})
@XmlRootElement(name = "PickupGetServiceCenterFacilitiesRequest")
public class PickupGetServiceCenterFacilitiesRequest {

    @XmlElement(name = "Request", namespace = "http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0", required = true)
    protected RequestType request;
    @XmlElement(name = "PickupPiece", required = true)
    protected List<PickupPieceServiceType> pickupPiece;
    @XmlElement(name = "OriginAddress")
    protected OriginAddressType originAddress;
    @XmlElement(name = "DestinationAddress")
    protected DestinationAddressType destinationAddress;
    @XmlElement(name = "Locale")
    protected String locale;
    @XmlElement(name = "ProximitySearchIndicator")
    protected String proximitySearchIndicator;

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link RequestType }
     *     
     */
    public RequestType getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestType }
     *     
     */
    public void setRequest(RequestType value) {
        this.request = value;
    }

    /**
     * Gets the value of the pickupPiece property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pickupPiece property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPickupPiece().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PickupPieceServiceType }
     * 
     * 
     */
    public List<PickupPieceServiceType> getPickupPiece() {
        if (pickupPiece == null) {
            pickupPiece = new ArrayList<PickupPieceServiceType>();
        }
        return this.pickupPiece;
    }

    /**
     * Gets the value of the originAddress property.
     * 
     * @return
     *     possible object is
     *     {@link OriginAddressType }
     *     
     */
    public OriginAddressType getOriginAddress() {
        return originAddress;
    }

    /**
     * Sets the value of the originAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginAddressType }
     *     
     */
    public void setOriginAddress(OriginAddressType value) {
        this.originAddress = value;
    }

    /**
     * Gets the value of the destinationAddress property.
     * 
     * @return
     *     possible object is
     *     {@link DestinationAddressType }
     *     
     */
    public DestinationAddressType getDestinationAddress() {
        return destinationAddress;
    }

    /**
     * Sets the value of the destinationAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link DestinationAddressType }
     *     
     */
    public void setDestinationAddress(DestinationAddressType value) {
        this.destinationAddress = value;
    }

    /**
     * Gets the value of the locale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets the value of the locale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Gets the value of the proximitySearchIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProximitySearchIndicator() {
        return proximitySearchIndicator;
    }

    /**
     * Sets the value of the proximitySearchIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProximitySearchIndicator(String value) {
        this.proximitySearchIndicator = value;
    }

}
