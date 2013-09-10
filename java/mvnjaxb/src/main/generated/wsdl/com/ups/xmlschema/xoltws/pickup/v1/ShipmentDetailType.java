
package com.ups.xmlschema.xoltws.pickup.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShipmentDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShipmentDetailType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HazmatIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PalletInformation" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}PalletInformationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentDetailType", propOrder = {
    "hazmatIndicator",
    "palletInformation"
})
public class ShipmentDetailType {

    @XmlElement(name = "HazmatIndicator")
    protected String hazmatIndicator;
    @XmlElement(name = "PalletInformation")
    protected PalletInformationType palletInformation;

    /**
     * Gets the value of the hazmatIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHazmatIndicator() {
        return hazmatIndicator;
    }

    /**
     * Sets the value of the hazmatIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHazmatIndicator(String value) {
        this.hazmatIndicator = value;
    }

    /**
     * Gets the value of the palletInformation property.
     * 
     * @return
     *     possible object is
     *     {@link PalletInformationType }
     *     
     */
    public PalletInformationType getPalletInformation() {
        return palletInformation;
    }

    /**
     * Sets the value of the palletInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PalletInformationType }
     *     
     */
    public void setPalletInformation(PalletInformationType value) {
        this.palletInformation = value;
    }

}
