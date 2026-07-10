package com.canadalife.demo.service;

import com.canadalife.demo.controller.ProductController;
import com.canadalife.demo.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canadalife.demo.entity.Customer;
import com.canadalife.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    private final ProductRepository productRepository;
	private final ProductController productController;
	@Autowired
    private CustomerRepository customerRepository;

	CustomerService(ProductController productController, ProductRepository productRepository) {
		this.productController = productController;
		this.productRepository = productRepository;
	}

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
    
    public List<Customer> findCustomersByName(String name) {
    	return customerRepository.findByName(name);
    }
    
    public List<Customer> findCustomersByPhone(String phone) {
    	return customerRepository.findByPhone(phone);
    }
}