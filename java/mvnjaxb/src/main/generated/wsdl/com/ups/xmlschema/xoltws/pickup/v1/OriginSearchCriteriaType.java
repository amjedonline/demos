
package com.ups.xmlschema.xoltws.pickup.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OriginSearchCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OriginSearchCriteriaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchRadius" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DistanceUnitOfMeasure" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MaximumLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginSearchCriteriaType", propOrder = {
    "searchRadius",
    "distanceUnitOfMeasure",
    "maximumLocation"
})
public class OriginSearchCriteriaType {

    @XmlElement(name = "SearchRadius")
    protected String searchRadius;
    @XmlElement(name = "DistanceUnitOfMeasure", required = true)
    protected String distanceUnitOfMeasure;
    @XmlElement(name = "MaximumLocation")
    protected String maximumLocation;

    /**
     * Gets the value of the searchRadius property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchRadius() {
        return searchRadius;
    }

    /**
     * Sets the value of the searchRadius property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchRadius(String value) {
        this.searchRadius = value;
    }

    /**
     * Gets the value of the distanceUnitOfMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistanceUnitOfMeasure() {
        return distanceUnitOfMeasure;
    }

    /**
     * Sets the value of the distanceUnitOfMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistanceUnitOfMeasure(String value) {
        this.distanceUnitOfMeasure = value;
    }

    /**
     * Gets the value of the maximumLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximumLocation() {
        return maximumLocation;
    }

    /**
     * Sets the value of the maximumLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximumLocation(String value) {
        this.maximumLocation = value;
    }

}
