package com.demo.debugging.model;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
   

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "John", 25000));
        employees.add(new Employee(102, "David", 45000));
        employees.add(new Employee(103, "Peter", 75000));
        employees.add(new Employee(104, "Mary", 95000));

        SalaryService service = new SalaryService();

        double total = service.calculateTotalPayout(employees);

        System.out.println("\nTotal Payout = " + total);
    }
}