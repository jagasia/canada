package com.canadalife.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canadalife.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}