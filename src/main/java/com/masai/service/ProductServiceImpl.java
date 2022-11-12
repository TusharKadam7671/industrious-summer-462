package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.dao.ProductDao;
import com.masai.dto.ProductDto;

import com.masai.exceptions.ProductException;

import com.masai.model.Product;


@Service
public class ProductServiceImpl implements ProductService{
	
	
    @Autowired
	private ProductDao pr;

	@Override
	public List<Product> viewAllProducts() {
		List<Product> list=pr.findAll();
		if(list.size()==0) {
//		throw ExceptionInInitializerError;
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public ResponseEntity<List<Product>> viewAllProduct() {
		// TODO Auto-generated method stub
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
	Product	pr2 =pr.save(product);
		return pr2;
	}

	public void removeProduct(int productId) {
		// TODO Auto-generated method stub
		pr.deleteById(productId);
		
	}

	public Product viewProduct(int productId) {
		// TODO Auto-generated method stub
	Optional<Product> pr3 = 	pr.findById(productId);
		return pr3.get();
	}


	@Override
	public Product updateProduct(Product product) throws ProductException {
		
		
		Optional<Product> opt= pr.findById(product.getProductId());
		if(opt.isPresent()) {
			Product updateCustomer= pr.save(product);
			return updateCustomer;
		}
		else 
			throw new ProductException("Invalid Product Details Please Check");
		
	}

		

    
	
}
