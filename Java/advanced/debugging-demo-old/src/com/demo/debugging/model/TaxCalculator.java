package com.demo.debugging.model;

public class TaxCalculator {

    public double calculateTax(double salary) {

        double tax;

        if (salary <= 30000) {
            tax = salary * 0.05;
        }
        else if (salary <= 60000) {
            tax = salary * 0.10;
        }
        else {
            tax = salary * 0.20;
        }

        return tax;
    }

}