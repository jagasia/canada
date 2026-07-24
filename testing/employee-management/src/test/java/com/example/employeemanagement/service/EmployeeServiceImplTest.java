package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for EmployeeServiceImpl using JUnit 5 and Mockito.
 */
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Captor
    private ArgumentCaptor<Employee> employeeCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addEmployee_whenIdIsNull_assignsIdAndSaves() {
        Employee employee = new Employee(null, "Alice", "Blue", "alice.blue@example.com");

        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Employee result = employeeService.addEmployee(employee);

        assertThat(result.getId()).isNotNull();
        assertThat(result.getFirstName()).isEqualTo("Alice");
        verify(employeeRepository).save(employeeCaptor.capture());
        assertThat(employeeCaptor.getValue().getId()).isEqualTo(result.getId());
    }

    @Test
    void addEmployee_whenIdIsNotNull_keepsExistingId() {
        UUID existingId = UUID.randomUUID();
        Employee employee = new Employee(existingId, "Anna", "Frost", "anna.frost@example.com");

        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Employee result = employeeService.addEmployee(employee);

        assertThat(result.getId()).isEqualTo(existingId);
        assertThat(result.getFirstName()).isEqualTo("Anna");
        verify(employeeRepository).save(employeeCaptor.capture());
        assertThat(employeeCaptor.getValue().getId()).isEqualTo(existingId);
    }

    @Test
    void getEmployeeById_whenEmployeeExists_returnsEmployee() {
        UUID employeeId = UUID.randomUUID();
        Employee employee = new Employee(employeeId, "Bob", "Smith", "bob.smith@example.com");
        doReturn(Optional.of(employee)).when(employeeRepository).findById(employeeId);

        Optional<Employee> result = employeeService.getEmployeeById(employeeId);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(employee);
    }

    @Test
    void getAllEmployees_returnsEmployeeList() {
        Employee employee = new Employee(UUID.randomUUID(), "Carol", "Jones", "carol.jones@example.com");
        doReturn(List.of(employee)).when(employeeRepository).findAll();

        List<Employee> result = employeeService.getAllEmployees();

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(employee);
    }

    @Test
    void updateEmployee_whenEmployeeExists_updatesAndReturns() {
        UUID employeeId = UUID.randomUUID();
        Employee updated = new Employee(null, "Derek", "Lee", "derek.lee@example.com");

        doReturn(true).when(employeeRepository).existsById(employeeId);
        when(employeeRepository.save(any(Employee.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Optional<Employee> result = employeeService.updateEmployee(employeeId, updated);

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(employeeId);
        assertThat(result.get().getFirstName()).isEqualTo("Derek");
    }

    @Test
    void updateEmployee_whenEmployeeDoesNotExist_returnsEmpty() {
        UUID employeeId = UUID.randomUUID();
        Employee updated = new Employee(null, "Eve", "Grant", "eve.grant@example.com");

        doReturn(false).when(employeeRepository).existsById(employeeId);

        Optional<Employee> result = employeeService.updateEmployee(employeeId, updated);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteEmployee_whenEmployeeExists_deletesAndReturnsTrue() {
        UUID employeeId = UUID.randomUUID();
        doReturn(true).when(employeeRepository).existsById(employeeId);

        boolean result = employeeService.deleteEmployee(employeeId);

        assertTrue(result);
        verify(employeeRepository).deleteById(employeeId);
    }

    @Test
    void deleteEmployee_whenEmployeeDoesNotExist_returnsFalse() {
        UUID employeeId = UUID.randomUUID();
        doReturn(false).when(employeeRepository).existsById(employeeId);

        boolean result = employeeService.deleteEmployee(employeeId);

        assertFalse(result);
    }
}
