package com.canadalife.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canadalife.demo.document.Employee;
import com.canadalife.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository er;

	public Employee create(Employee employee) {
		return er.save(employee);
	}
	public List<Employee> read() {
		return er.findAll();
	}
	public Optional<Employee> read(Long id) {
		return er.findById(id);
	}
	public Employee update(Employee employee) {
		return er.save(employee);
	}
	public void delete(Long id) {
		er.deleteById(id);
		return;
	}
	

}
