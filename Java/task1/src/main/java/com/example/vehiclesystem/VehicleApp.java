package com.example.vehiclesystem;

// Part 4: Test Your Classes in a Main Method
public class VehicleApp {
    public static void main(String[] args) {
        // TODO: 1. Create an instance of Car, e.g., new Car("Toyota", "Camry", 2020, 4, "Gasoline")
        Car car = new Car("Toyota", "Camry", 2020, 4, "Gasoline");  
        // TODO: 2. Create an instance of Motorcycle, e.g., new Motorcycle("Harley-Davidson", "Sportster", 2021, false)
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2021, false);
        // TODO: 3. Call the displayInfo() method for both the Car and Motorcycle objects you created
        car.displayInfo();
        motorcycle.displayInfo();   
        //        to demonstrate their information and verify the overridden methods work correctly.
        
    }
}
