package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of EmployeeService containing business logic for employee operations.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * Constructor injection ensures the repository dependency is available when service is created.
     * @param employeeRepository repository implementing employee persistence operations
     */
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(UUID.randomUUID());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(UUID id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> updateEmployee(UUID id, Employee updatedEmployee) {
        if (!employeeRepository.existsById(id)) {
            return Optional.empty();
        }

        updatedEmployee.setId(id);
        Employee savedEmployee = employeeRepository.save(updatedEmployee);
        return Optional.of(savedEmployee);
    }

    @Override
    public boolean deleteEmployee(UUID id) {
        if (!employeeRepository.existsById(id)) {
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }
}
