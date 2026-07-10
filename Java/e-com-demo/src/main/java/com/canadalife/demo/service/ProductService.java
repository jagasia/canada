package com.canadalife.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canadalife.demo.entity.Product;
import com.canadalife.demo.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create
    public Product create(Product product) {
        return productRepository.save(product);
    }

    // Read all
    public List<Product> read() {
        return productRepository.findAll();
    }

    // Read by ID
    public Product read(Long id) {
        Optional<Product> temp = productRepository.findById(id);
        Product product = null;

        if (temp.isPresent()) {
            product = temp.get();
        }

        return product;
    }

    // Update
    public Product update(Product product) {
        return productRepository.save(product);
    }

    // Delete
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}