package com.canadalife.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canadalife.demo.model.Department;
import com.canadalife.demo.model.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository er;
	
	public Department create(Department department) {
		//add a new Department
		return er.save(department);
	}
	public List<Department> read() {
		//retrieve all Departments
		return er.findAll();
	}
	public Department read(Integer id) {
		//find Department by id
		Optional<Department> temp = er.findById(id);
		Department e=null;
		if(temp.isPresent()) {
			e=temp.get();
		}
		return e;
	}
	public Department update(Department department) {
		//update Department
		return er.save(department);
	}
	public void delete(Integer id) {
		//delete Department
		er.deleteById(id);
	}
	
}
