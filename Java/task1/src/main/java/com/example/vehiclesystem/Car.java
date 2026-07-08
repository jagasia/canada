package com.example.vehiclesystem;

// Part 2: Create the Car Subclass
public class Car extends Vehicle {
    // TODO: 1. Declare private instance variables specific to a Car: numberOfDoors (int), fuelType (String)
    private int numberOfDoors;
    private String fuelType;

    // TODO: 2. Implement a public constructor that accepts make, model, year, numberOfDoors, and fuelType as parameters.
    //        Use super() to call the constructor of the Vehicle parent class, and then initialize the Car-specific attributes.
    public Car(String make, String model, int year, int numberOfDoors, String fuelType) {
        super(make, model, year);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    // TODO: 3. Override the displayInfo() method from the Vehicle class.
    //        This overridden method should first call super.displayInfo() to print the general vehicle information,
    //        and then print the car-specific information on a new line:
    //        "  Doors: [numberOfDoors], Fuel: [fuelType]".
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Doors: " + numberOfDoors + ", Fuel: " + fuelType);
    }
}
