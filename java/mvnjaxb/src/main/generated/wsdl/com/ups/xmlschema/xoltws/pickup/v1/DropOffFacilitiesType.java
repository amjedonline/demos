
package com.ups.xmlschema.xoltws.pickup.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DropOffFacilitiesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DropOffFacilitiesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Address" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}AddressType"/>
 *         &lt;element name="SLIC" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Timezone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityTime" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}FacilityTimeType" minOccurs="0"/>
 *         &lt;element name="LocalizedInstruction" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}LocalizedInstructionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Distance" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}DistanceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DropOffFacilitiesType", propOrder = {
    "name",
    "address",
    "slic",
    "type",
    "timezone",
    "phone",
    "fax",
    "facilityTime",
    "localizedInstruction",
    "distance"
})
public class DropOffFacilitiesType {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Address", required = true)
    protected AddressType address;
    @XmlElement(name = "SLIC", required = true)
    protected String slic;
    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "Timezone", required = true)
    protected String timezone;
    @XmlElement(name = "Phone", required = true)
    protected String phone;
    @XmlElement(name = "Fax", required = true)
    protected String fax;
    @XmlElement(name = "FacilityTime")
    protected FacilityTimeType facilityTime;
    @XmlElement(name = "LocalizedInstruction")
    protected List<LocalizedInstructionType> localizedInstruction;
    @XmlElement(name = "Distance")
    protected DistanceType distance;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the slic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSLIC() {
        return slic;
    }

    /**
     * Sets the value of the slic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSLIC(String value) {
        this.slic = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the timezone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimezone(String value) {
        this.timezone = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the facilityTime property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityTimeType }
     *     
     */
    public FacilityTimeType getFacilityTime() {
        return facilityTime;
    }

    /**
     * Sets the value of the facilityTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityTimeType }
     *     
     */
    public void setFacilityTime(FacilityTimeType value) {
        this.facilityTime = value;
    }

    /**
     * Gets the value of the localizedInstruction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localizedInstruction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalizedInstruction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalizedInstructionType }
     * 
     * 
     */
    public List<LocalizedInstructionType> getLocalizedInstruction() {
        if (localizedInstruction == null) {
            localizedInstruction = new ArrayList<LocalizedInstructionType>();
        }
        return this.localizedInstruction;
    }

    /**
     * Gets the value of the distance property.
     * 
     * @return
     *     possible object is
     *     {@link DistanceType }
     *     
     */
    public DistanceType getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistanceType }
     *     
     */
    public void setDistance(DistanceType value) {
        this.distance = value;
    }

}
