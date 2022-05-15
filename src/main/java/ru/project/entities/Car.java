package ru.project.entities;

public class Car {
    String VIN, brand, model, country, number, year, name;

    public Car(String VIN, String brand, String model, String country, String number, String year, String name) {
        this.VIN = VIN;
        this.brand = brand;
        this.model = model;
        this.country = country;
        this.number = number;
        this.name = name;
        this.year = year;
    }

    public String getVIN() { return VIN; }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCountry() {
        return country;
    }

    public String getNumber() {
        return number;
    }

    public String getYear() {
        return year;
    }
}
