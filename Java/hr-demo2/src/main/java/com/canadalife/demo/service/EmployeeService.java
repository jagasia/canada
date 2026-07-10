package com.canadalife.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canadalife.demo.model.Department;
import com.canadalife.demo.model.DepartmentRepository;
import com.canadalife.demo.model.Employee;
import com.canadalife.demo.model.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository er;
	@Autowired
	private DepartmentRepository dr;
	
	public Employee create(Employee employee) {
		
			return er.save(employee);
	}
	public List<Employee> read() {
		//retrieve all employees
		return er.findAll();
	}
	public Employee read(Integer id) {
		//find employee by id
		Optional<Employee> temp = er.findById(id);
		Employee e=null;
		if(temp.isPresent()) {
			e=temp.get();
		}
		return e;
	}
	public Employee update(Employee employee) {
		//update employee
		return er.save(employee);
	}
	public void delete(Integer id) {
		//delete employee
		er.deleteById(id);
	}
	
}
