
package com.ups.xmlschema.xoltws.pickup.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FreightOptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FreightOptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShipmentServiceOptions" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}ShipmentServiceOptionsType" minOccurs="0"/>
 *         &lt;element name="OriginServiceCenterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginServiceCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DestinationAddress" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}DestinationAddressType" minOccurs="0"/>
 *         &lt;element name="ShipmentDetail" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}ShipmentDetailType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FreightOptionsType", propOrder = {
    "shipmentServiceOptions",
    "originServiceCenterCode",
    "originServiceCountryCode",
    "destinationAddress",
    "shipmentDetail"
})
public class FreightOptionsType {

    @XmlElement(name = "ShipmentServiceOptions")
    protected ShipmentServiceOptionsType shipmentServiceOptions;
    @XmlElement(name = "OriginServiceCenterCode")
    protected String originServiceCenterCode;
    @XmlElement(name = "OriginServiceCountryCode")
    protected String originServiceCountryCode;
    @XmlElement(name = "DestinationAddress")
    protected DestinationAddressType destinationAddress;
    @XmlElement(name = "ShipmentDetail", required = true)
    protected ShipmentDetailType shipmentDetail;

    /**
     * Gets the value of the shipmentServiceOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentServiceOptionsType }
     *     
     */
    public ShipmentServiceOptionsType getShipmentServiceOptions() {
        return shipmentServiceOptions;
    }

    /**
     * Sets the value of the shipmentServiceOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentServiceOptionsType }
     *     
     */
    public void setShipmentServiceOptions(ShipmentServiceOptionsType value) {
        this.shipmentServiceOptions = value;
    }

    /**
     * Gets the value of the originServiceCenterCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginServiceCenterCode() {
        return originServiceCenterCode;
    }

    /**
     * Sets the value of the originServiceCenterCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginServiceCenterCode(String value) {
        this.originServiceCenterCode = value;
    }

    /**
     * Gets the value of the originServiceCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginServiceCountryCode() {
        return originServiceCountryCode;
    }

    /**
     * Sets the value of the originServiceCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginServiceCountryCode(String value) {
        this.originServiceCountryCode = value;
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
     * Gets the value of the shipmentDetail property.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentDetailType }
     *     
     */
    public ShipmentDetailType getShipmentDetail() {
        return shipmentDetail;
    }

    /**
     * Sets the value of the shipmentDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentDetailType }
     *     
     */
    public void setShipmentDetail(ShipmentDetailType value) {
        this.shipmentDetail = value;
    }

}
