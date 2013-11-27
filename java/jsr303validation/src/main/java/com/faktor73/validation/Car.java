package com.faktor73.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.faktor73.validation.custom.UpperCase;

class Car {

    @NotNull
    private String manufacturer;

    @Size(min = 2, max = 14)
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