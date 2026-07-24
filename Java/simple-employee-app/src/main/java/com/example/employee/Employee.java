package com.example.employee;

/**
 * Simple Employee POJO for demo purposes
 */
public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    // Example legacy method annotated with @Old
    @Old("legacy API - use newServiceOperation instead")
    public void legacyOperation() {
        System.out.println("Executing legacy operation for employee: " + id);
    }
}
