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
import com.canadalife.demo.service.DepartmentService;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
	@Autowired
	private DepartmentService es;

	@PostMapping
	public Department addDepartment(@RequestBody Department department) {
		
		return es.create(department);
	}
	
	@GetMapping
	public List<Department> retrieveAllDepartment() {
		return es.read();
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Integer departmentId) {
		return es.read(departmentId);
	}
	
	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable Integer id, @RequestBody Department department) {
		return es.update(department);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteDepartmentById(@PathVariable Integer id) {
		es.delete(id);
	}
	
}
