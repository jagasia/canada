package com.upskillit.demo.service;

import java.util.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.upskillit.demo.entity.*;
import com.upskillit.demo.repository.*;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeRepository r;

	public Employee create(Employee e) {
		return r.save(e);
	}

	public List<Employee> read() {
		return r.findAll();
	}

	public Employee read(Long id) {
		return r.findById(id).orElse(null);
	}

	public Employee update(Employee e) {
		return r.save(e);
	}

	public void delete(Long id) {
		r.deleteById(id);
	}
	
	public Double findSumOfSalaryByDepartment(String department) {
		return r.findSumOfSalaryByDepartment(department);
	}
}