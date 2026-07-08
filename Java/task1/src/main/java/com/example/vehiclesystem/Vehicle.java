package com.example.vehiclesystem;

// Part 1: Create the Vehicle Base Class
public class Vehicle {
    // TODO: 1. Declare private instance variables: make (String), model (String), year (int)
    private String make;
    private String model;
    private int year;

    // TODO: 2. Implement a public constructor that accepts make, model, and year as parameters.
    //        This constructor should initialize the instance variables.
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // TODO: 3. Provide public getter and setter methods for all three attributes (make, model, year).
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // TODO: 4. Add a public method named displayInfo() that prints the basic information
    //        of the vehicle in the format: "Vehicle: [make] [model] ([year])".
    public void displayInfo() {
        System.out.println("Vehicle: " + make + " " + model + " (" + year + ")");
    }
}
