package com.canadalife.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canadalife.demo.entity.Customer;
import com.canadalife.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create
    public Customer create(Customer customer) {
        Customer c = customerRepository.save(customer);
        return c;
    }

    // Read all
    public List<Customer> read() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    // Read by ID
    public Customer read(Long id) {
        Optional<Customer> temp = customerRepository.findById(id);
        Customer customer = null;

        if (temp.isPresent()) {
            customer = temp.get();
        }

        return customer;
    }

    // Update
    public Customer update(Customer customer) {
        Customer updatedCustomer = customerRepository.save(customer);
        return updatedCustomer;
    }

    // Delete
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}