package com.guru.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
