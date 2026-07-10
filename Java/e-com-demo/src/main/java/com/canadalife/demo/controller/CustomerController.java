package com.canadalife.demo.controller;

import com.canadalife.demo.service.ProductService;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.canadalife.demo.entity.Customer;
import com.canadalife.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final ProductService productService;
	@Autowired
    private CustomerService customerService;

	CustomerController(ProductService productService) {
		this.productService = productService;
	}

    // Create
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

        Customer savedCustomer = customerService.create(customer);

        return ResponseEntity
                .created(URI.create("/customers/" + savedCustomer.getId())) // 201 Created
                .body(savedCustomer);
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers() {

        List<Customer> customers = customerService.read();

        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();   // 204 No Content
        }

        return ResponseEntity.ok(customers);             // 200 OK
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {

        Customer customer = customerService.read(id);

        if (customer == null) {
            return ResponseEntity.notFound().build();    // 404 Not Found
        }

        return ResponseEntity.ok(customer);              // 200 OK
    }

    // Update
    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {

        Customer updatedCustomer = customerService.update(customer);

        return ResponseEntity.ok(updatedCustomer);       // 200 OK
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

        Customer customer = customerService.read(id);

        if (customer == null) {
            return ResponseEntity.notFound().build();    // 404 Not Found
        }

        customerService.delete(id);

        return ResponseEntity.noContent().build();       // 204 No Content
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Customer>> findCustomersByName(@PathVariable String name) {
    	List<Customer> customers = customerService.findCustomersByName(name);
//    	if(customers.size()==0)
    	if(customers.isEmpty()) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(customers);
    }
    
    
    @GetMapping("/phone/{phone}")
    public ResponseEntity<List<Customer>> findCustomersByPhone(@PathVariable String phone) {
    	List<Customer> customers = customerService.findCustomersByPhone(phone);
    	return ResponseEntity.ok(customers);
    }
}