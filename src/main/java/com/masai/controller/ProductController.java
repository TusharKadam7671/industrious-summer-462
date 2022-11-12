package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.ProductDto;
import com.masai.exceptions.ProductException;
import com.masai.model.Product;
import com.masai.service.ProductServiceImpl;

import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
public class ProductController {
	@Autowired
   private ProductServiceImpl productService;
	
	@GetMapping("/vieallproduct")
	public List<Product> getAllProduct(){
		return productService.viewAllProducts();
	}

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product product2 = productService.addProduct(product);
        return new ResponseEntity<Product>(product2, HttpStatus.OK); 
        		}

    @DeleteMapping("/deleteproduct/{productId}")
    public ResponseEntity<Void> removeProduct(@PathVariable int productId) throws ProductException {
        productService.removeProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/viewproductbyid/{productId}")
    public Product viewProduct(@PathVariable int productId) throws ProductException {
        return productService.viewProduct(productId);
    }

}
