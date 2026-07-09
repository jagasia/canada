package com.canadalife.demo.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.canadalife.demo.entity.Product;
import com.canadalife.demo.repository.ProductRepository;

@Component
public class ProductDataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public ProductDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            productRepository.saveAll(List.of(
                    new Product("Aurora Laptop", "Electronics", new BigDecimal("1299.99")),
                    new Product("Nimbus Headphones", "Audio", new BigDecimal("199.50")),
                    new Product("Terra Backpack", "Travel", new BigDecimal("89.00"))
            ));
        }
    }
}
