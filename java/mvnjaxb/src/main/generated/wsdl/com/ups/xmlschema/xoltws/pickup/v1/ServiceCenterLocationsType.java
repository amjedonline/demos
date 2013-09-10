
package com.ups.xmlschema.xoltws.pickup.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceCenterLocationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceCenterLocationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DropOffFacilities" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}DropOffFacilitiesType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PickupFacilities" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}PickupFacilitiesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceCenterLocationsType", propOrder = {
    "dropOffFacilities",
    "pickupFacilities"
})
public class ServiceCenterLocationsType {

    @XmlElement(name = "DropOffFacilities")
    protected List<DropOffFacilitiesType> dropOffFacilities;
    @XmlElement(name = "PickupFacilities")
    protected PickupFacilitiesType pickupFacilities;

    /**
     * Gets the value of the dropOffFacilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dropOffFacilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDropOffFacilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DropOffFacilitiesType }
     * 
     * 
     */
    public List<DropOffFacilitiesType> getDropOffFacilities() {
        if (dropOffFacilities == null) {
            dropOffFacilities = new ArrayList<DropOffFacilitiesType>();
        }
        return this.dropOffFacilities;
    }

    /**
     * Gets the value of the pickupFacilities property.
     * 
     * @return
     *     possible object is
     *     {@link PickupFacilitiesType }
     *     
     */
    public PickupFacilitiesType getPickupFacilities() {
        return pickupFacilities;
    }

    /**
     * Sets the value of the pickupFacilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link PickupFacilitiesType }
     *     
     */
    public void setPickupFacilities(PickupFacilitiesType value) {
        this.pickupFacilities = value;
    }

}
