package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for employee persistence operations.
 */
public interface EmployeeRepository {

    Employee save(Employee employee);

    Optional<Employee> findById(UUID id);

    List<Employee> findAll();

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
