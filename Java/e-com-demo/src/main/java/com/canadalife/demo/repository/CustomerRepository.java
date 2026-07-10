package com.canadalife.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canadalife.demo.entity.Customer;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByName(String name);
	
	List<Customer> findByPhone(String phone);
}