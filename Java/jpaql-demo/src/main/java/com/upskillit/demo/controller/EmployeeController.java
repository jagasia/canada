package com.upskillit.demo.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.upskillit.demo.entity.*;
import com.upskillit.demo.service.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService s;

	@PostMapping
	public Employee c(@RequestBody Employee e) {
		return s.create(e);
	}

	@GetMapping
	public List<Employee> a() {
		return s.read();
	}

	@GetMapping("/{id}")
	public Employee g(@PathVariable Long id) {
		return s.read(id);
	}

	@PutMapping
	public Employee u(@RequestBody Employee e) {
		return s.update(e);
	}

	@DeleteMapping("/{id}")
	public void d(@PathVariable Long id) {
		s.delete(id);
	}
	
	@GetMapping("/sumofsalary/{department}")
	public Double findSumOfSalaryByDepartment(@PathVariable String department) {
		return s.findSumOfSalaryByDepartment(department);
	}
}