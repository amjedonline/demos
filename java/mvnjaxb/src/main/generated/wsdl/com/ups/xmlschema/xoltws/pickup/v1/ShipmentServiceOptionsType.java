
package com.ups.xmlschema.xoltws.pickup.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShipmentServiceOptionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShipmentServiceOptionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OriginLiftGateIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DropoffAtUPSFacilityIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HoldForPickupIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentServiceOptionsType", propOrder = {
    "originLiftGateIndicator",
    "dropoffAtUPSFacilityIndicator",
    "holdForPickupIndicator"
})
public class ShipmentServiceOptionsType {

    @XmlElement(name = "OriginLiftGateIndicator")
    protected String originLiftGateIndicator;
    @XmlElement(name = "DropoffAtUPSFacilityIndicator")
    protected String dropoffAtUPSFacilityIndicator;
    @XmlElement(name = "HoldForPickupIndicator")
    protected String holdForPickupIndicator;

    /**
     * Gets the value of the originLiftGateIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginLiftGateIndicator() {
        return originLiftGateIndicator;
    }

    /**
     * Sets the value of the originLiftGateIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginLiftGateIndicator(String value) {
        this.originLiftGateIndicator = value;
    }

    /**
     * Gets the value of the dropoffAtUPSFacilityIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDropoffAtUPSFacilityIndicator() {
        return dropoffAtUPSFacilityIndicator;
    }

    /**
     * Sets the value of the dropoffAtUPSFacilityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDropoffAtUPSFacilityIndicator(String value) {
        this.dropoffAtUPSFacilityIndicator = value;
    }

    /**
     * Gets the value of the holdForPickupIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoldForPickupIndicator() {
        return holdForPickupIndicator;
    }

    /**
     * Sets the value of the holdForPickupIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoldForPickupIndicator(String value) {
        this.holdForPickupIndicator = value;
    }

}
