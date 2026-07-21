package com.canadalife.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.canadalife.demo.document.Employee;


public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}
