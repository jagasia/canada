package com.canadalife.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canadalife.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}