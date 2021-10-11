/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.time.Year;
import java.time.LocalDateTime;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author Lavina
 */
public class UberCars {
    
    private String modelName;
    private String modelNumber;
    private String serialNumber;
    private String manufacturer;
    private boolean availability;
    private String city;
    private Year manufacturingYear;
    private int seats;
    private boolean validility;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public UberCars(){
        this.createdOn = LocalDateTime.now();
        this.updatedOn = LocalDateTime.now();
    }

    public UberCars(String modelName, String modelNumber, String serialNumber, String manufacturer, boolean availability, String city, Year manufacturingYear, int seats, boolean validility, LocalDateTime createdOn, LocalDateTime updatedOn) {
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.availability = availability;
        this.city = city;
        this.manufacturingYear = manufacturingYear;
        this.seats = seats;
        this.validility = validility;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }
    
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    public String getModelName() {
        return modelName;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelNumber () {
        return modelNumber;
    }

    public void setModelNumber (String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Year getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(Year manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isValidility() {
        return validility;
    }

    public void setValidility(boolean validility) {
        this.validility = validility;
    }

    public String toString(){
        return modelName;
    }
   
   
}
