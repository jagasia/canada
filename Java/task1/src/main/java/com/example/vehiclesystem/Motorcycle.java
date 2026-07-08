package com.example.vehiclesystem;

// Part 3: Create the Motorcycle Subclass
public class Motorcycle extends Vehicle {
    // TODO: 1. Declare a private instance variable specific to a Motorcycle: hasSidecar (boolean)
    private boolean hasSidecar;
    // TODO: 2. Implement a public constructor that accepts make, model, year, and hasSidecar as parameters.
    //        Use super() to call the constructor of the Vehicle parent class, and then initialize the Motorcycle-specific attribute.
    public Motorcycle(String make, String model, int year, boolean hasSidecar) {
        super(make, model, year);
        this.hasSidecar = hasSidecar;
    }

    // TODO: 3. Override the displayInfo() method from the Vehicle class.
    //        This overridden method should first call super.displayInfo() to print the general vehicle information,
    //        and then print the motorcycle-specific information on a new line:
    //        "  Has Sidecar: [hasSidecar]".
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Has Sidecar: " + hasSidecar);
    }
}
