package com.canadalife.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canadalife.demo.entity.Product;
import com.canadalife.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	private ProductService ps;
	
	public ProductController(ProductService ps) {
		this.ps=ps;
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product data = ps.create(product);
		return new ResponseEntity<>(data, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable Long id) {
		Product product = ps.read(id);
		ResponseEntity<Product> re=null;
		if(product!=null) {
			re = ResponseEntity.ok(product);
		}else {
			re = ResponseEntity.notFound().build();	
		}
		return re;
	}
}
