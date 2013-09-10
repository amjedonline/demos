
package com.ups.xmlschema.xoltws.pickup.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DayOfWeekType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DayOfWeekType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Day" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OpenHours" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CloseHours" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PrepTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastDrop" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DayOfWeekType", propOrder = {
    "day",
    "openHours",
    "closeHours",
    "prepTime",
    "lastDrop"
})
public class DayOfWeekType {

    @XmlElement(name = "Day", required = true)
    protected String day;
    @XmlElement(name = "OpenHours", required = true)
    protected String openHours;
    @XmlElement(name = "CloseHours", required = true)
    protected String closeHours;
    @XmlElement(name = "PrepTime")
    protected String prepTime;
    @XmlElement(name = "LastDrop")
    protected String lastDrop;

    /**
     * Gets the value of the day property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDay(String value) {
        this.day = value;
    }

    /**
     * Gets the value of the openHours property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenHours() {
        return openHours;
    }

    /**
     * Sets the value of the openHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenHours(String value) {
        this.openHours = value;
    }

    /**
     * Gets the value of the closeHours property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCloseHours() {
        return closeHours;
    }

    /**
     * Sets the value of the closeHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCloseHours(String value) {
        this.closeHours = value;
    }

    /**
     * Gets the value of the prepTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrepTime() {
        return prepTime;
    }

    /**
     * Sets the value of the prepTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrepTime(String value) {
        this.prepTime = value;
    }

    /**
     * Gets the value of the lastDrop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastDrop() {
        return lastDrop;
    }

    /**
     * Sets the value of the lastDrop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastDrop(String value) {
        this.lastDrop = value;
    }

}
