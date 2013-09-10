
package com.ups.xmlschema.xoltws.pickup.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.ups.xmlschema.xoltws.common.v1.ResponseType;


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
 *         &lt;element ref="{http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0}Response"/>
 *         &lt;element name="ServiceCenterLocation" type="{http://www.ups.com/XMLSchema/XOLTWS/Pickup/v1.1}ServiceCenterLocationsType"/>
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
    "response",
    "serviceCenterLocation"
})
@XmlRootElement(name = "PickupGetServiceCenterFacilitiesResponse")
public class PickupGetServiceCenterFacilitiesResponse {

    @XmlElement(name = "Response", namespace = "http://www.ups.com/XMLSchema/XOLTWS/Common/v1.0", required = true)
    protected ResponseType response;
    @XmlElement(name = "ServiceCenterLocation", required = true)
    protected ServiceCenterLocationsType serviceCenterLocation;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setResponse(ResponseType value) {
        this.response = value;
    }

    /**
     * Gets the value of the serviceCenterLocation property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCenterLocationsType }
     *     
     */
    public ServiceCenterLocationsType getServiceCenterLocation() {
        return serviceCenterLocation;
    }

    /**
     * Sets the value of the serviceCenterLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCenterLocationsType }
     *     
     */
    public void setServiceCenterLocation(ServiceCenterLocationsType value) {
        this.serviceCenterLocation = value;
    }

}
