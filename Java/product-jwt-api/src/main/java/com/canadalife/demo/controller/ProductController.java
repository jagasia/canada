package com.canadalife.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canadalife.demo.entity.Product;
import com.canadalife.demo.service.ProductService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/v2/products")
@CrossOrigin
@SecurityRequirement(name = "Bearer Authentication")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    // Read All
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Product> getAll() {
        return productService.getAll();
    }

    // Read By Id
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<Product> getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    // Update
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Product update(@PathVariable Long id,
                          @RequestBody Product product) {
        return productService.update(id, product);
    }

    // Delete
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}