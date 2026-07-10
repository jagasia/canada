package com.canadalife.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canadalife.demo.model.Department;
import com.canadalife.demo.model.Employee;
import com.canadalife.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService es;

	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return es.create(employee);
	}
	
	@GetMapping
	public List<Employee> retrieveAllEmployee() {
		return es.read();
	}
	
	@GetMapping("/{id}")
	public Employee findEmployeeById(@PathVariable("id") Integer employeeId) {
		return es.read(employeeId);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		return es.update(employee);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable Integer id) {
		es.delete(id);
	}
	
}
