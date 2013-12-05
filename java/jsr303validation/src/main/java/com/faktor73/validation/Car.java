package com.faktor73.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.faktor73.validation.custom.SelectiveValidLength;
import com.faktor73.validation.custom.UpperCase;

class Car {

    @NotNull
    private String manufacturer;

    @SelectiveValidLength(sizes = {
            @Size(min = 2, max = 14, groups = { ValidationClasses.Celeritas.class }),
            @Size(min = 3, max = 60, groups = { ValidationClasses.Hermes.class }) })
    @UpperCase
    private String licensePlate;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Car(String manufacturer, String licensePlate) {
        super();
        this.manufacturer = manufacturer;
        this.licensePlate = licensePlate;
    }

}

class ValidationClasses {
    interface UPS {
    }

    interface Hermes {
    }

    interface Celeritas {
    }
}