package com.guru.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guru.product.model.Product;
import com.guru.product.service.ProductService;

@RestController
public class ProductController {
	
	@GetMapping(value = "/")
	public String home() {
		return "Hello World";
	}
	
	//autowire the ProductService class  
	@Autowired  
	ProductService productService;  
	
	//creating a get mapping that retrieves all the product detail from the database   
	@GetMapping("/product")  
	private List<Product> getAllProduct() {  
		return productService.getAllProduct();  
	}  
	//creating a get mapping that retrieves the detail of a specific product  
	@GetMapping("/product/{productId}")  
	private Product getProduct(@PathVariable("productId") int productId){  
		return productService.getProductById(productId);  
	}  
	
	//creating a delete mapping that deletes a specified product  
	@DeleteMapping("/product/{productId}")  
	private void deleteProduct(@PathVariable("productId") int productId){  
		productService.delete(productId);  
	} 
	
	//creating post mapping that post the product detail in the database  
	@PostMapping("/product")  
	private Product saveProduct(@RequestBody Product product){  
		Product p = productService.saveOrUpdate(product);  
		return p;  
	}  
	
	//creating put mapping that updates the product detail   
	@PutMapping("/product")  
	private Product update(@RequestBody Product product){  
		Product p = productService.saveOrUpdate(product);  
		return p;  
	} 
}
