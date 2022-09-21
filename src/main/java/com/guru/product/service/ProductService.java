package com.guru.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.product.model.Product;
import com.guru.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public Product getProductById(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		if(product.isPresent()) {
			return product.get();
		}
		return null;
	}

	public void delete(int productId) {
		productRepository.deleteById(productId);
	}

	public Product saveOrUpdate(Product product) {
		Product p = productRepository.save(product);
		return p;
	}

}
