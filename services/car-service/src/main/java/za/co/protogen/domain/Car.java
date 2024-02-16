
package za.co.protogen.domain;

import java.util.List;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private String engine;
    private String transmission;
    private String fuelType;
    private int mileage;
    private String vin;
    private double price;
    private int ownerId;
    private List<String> features;

    // Constructor
    public Car() {
    }

    public Car(String make, String model, int year, String color, String engine, String transmission, 
               String fuelType, int mileage, String vin, double price, int ownerId, List<String> features) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.vin = vin;
        this.price = price;
        this.ownerId = ownerId;
        this.features = features;
       
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getMileage() {
        return mileage;
    }

    public String getVin() {
        return vin;
    }

    public double getPrice() {
        return price;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public List<String> getFeatures() {
        return features;
    }

    // Setters
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }
}
