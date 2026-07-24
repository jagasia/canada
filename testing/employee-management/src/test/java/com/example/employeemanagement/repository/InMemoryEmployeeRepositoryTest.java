package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Basic repository test demonstrating in-memory repository behavior.
 */
class InMemoryEmployeeRepositoryTest {

    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        employeeRepository = new InMemoryEmployeeRepository();
    }

    @Test
    void saveAndFindById_returnsSavedEmployee() {
        Employee employee = new Employee(UUID.randomUUID(), "Frank", "Miller", "frank.miller@example.com");
        employeeRepository.save(employee);

        Optional<Employee> optional = employeeRepository.findById(employee.getId());

        assertThat(optional).isPresent();
        assertThat(optional.get()).isEqualTo(employee);
    }

    @Test
    void findAll_returnsAllSavedEmployees() {
        employeeRepository.save(new Employee(UUID.randomUUID(), "Gina", "Hill", "gina.hill@example.com"));

        List<Employee> all = employeeRepository.findAll();

        assertThat(all).hasSize(1);
    }
}
