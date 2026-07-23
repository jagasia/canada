package com.canadalife.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.canadalife.demo.model.Employee;
import com.canadalife.demo.model.EmployeeRepository;
import com.canadalife.demo.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    public void testGetEmployees() {

        List<Employee> list = Arrays.asList(
                new Employee(1, "Jag"),
                new Employee(2, "John")
        );

        when(repository.findAll()).thenReturn(list);

        List<Employee> result = service.read();

        assertEquals(2, result.size());
    }
}