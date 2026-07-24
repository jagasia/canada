package com.demo.debugging.model;

import java.util.List;

import com.demo.debugging.model.Employee;

public class SalaryService {

    private TaxCalculator calculator = new TaxCalculator();

    public double calculateTotalPayout(List<Employee> employees) {

        double total = 0;

        for (Employee emp : employees) {

            double tax = calculator.calculateTax(emp.getSalary());

            double netSalary = emp.getSalary() - tax;
            System.out.println("I did this change");

            total += netSalary;

            System.out.println(emp.getName() + " -> " + netSalary);
        }

        return total;
    }

}