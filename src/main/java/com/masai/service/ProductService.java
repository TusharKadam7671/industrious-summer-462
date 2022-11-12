package com.masai.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.masai.dto.ProductDto;

import com.masai.exceptions.ProductException;

import com.masai.model.Product;

public interface ProductService {
	
	public List<Product> viewAllProducts();
	
	public ResponseEntity<List<Product>> viewAllProduct ();
	public Product viewProduct(int productId);
	public void removeProduct(int productId);
	public Product addProduct(Product product);

	public Product updateProduct(Product product) throws ProductException;


}