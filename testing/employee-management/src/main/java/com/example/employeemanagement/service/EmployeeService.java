package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service contract for employee management operations.
 */
public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Optional<Employee> getEmployeeById(UUID id);

    List<Employee> getAllEmployees();

    Optional<Employee> updateEmployee(UUID id, Employee updatedEmployee);

    boolean deleteEmployee(UUID id);
}
