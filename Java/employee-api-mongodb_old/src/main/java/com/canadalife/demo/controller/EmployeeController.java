package com.canadalife.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.canadalife.demo.document.Employee;
import com.canadalife.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create Employee
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    // Get All Employees
    @GetMapping
    public List<Employee> read() {
        return employeeService.read();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> read(@PathVariable Long id) {
        return employeeService.read(id);
    }

    // Update Employee
    @PutMapping
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.delete(id);
        return "Employee deleted successfully.";
    }
}