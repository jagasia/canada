package com.canadalife.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/product")
public class ProductController {

	
	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addProducgt() {
		return "Product is added";
	}
	
	@PutMapping
	public String updateProduct() {
		return "Updated the product";
	}
	
	@GetMapping
	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	public String getAllProducts() {
		return "All products are listed now";
	}
	
	@DeleteMapping
	public String deleteProduct() {
		return "Deleting the product";
	}
	
}
