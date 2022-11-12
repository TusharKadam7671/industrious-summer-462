package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.ProductDto;
import com.masai.exceptions.CartException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.model.Cart;
import com.masai.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService ctService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Cart> addToCartHandler(@RequestParam Integer productId,
			@RequestParam Integer quantity,
			@RequestParam String key) throws CartException, LoginException, ProductException
	{
		Cart added = ctService.addProductToCart(productId, quantity, key);
		
		return new ResponseEntity<Cart>(added, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> viewAllProductsHandler(@RequestParam String key) throws CartException, LoginException
	{
		List<ProductDto> list = ctService.viewAllProducts(key);
		
		return new ResponseEntity<List<ProductDto>>(list, HttpStatus.OK);
	}
	
	@PutMapping("/products")
	public ResponseEntity<List<ProductDto>> updateProductQuantityHandler(
			@RequestParam Integer productId,
			@RequestParam Integer quantity,
			@RequestParam String key) throws CartException, LoginException, ProductException
	{
		List<ProductDto> list = ctService.updateProductQuantity(productId, quantity, key);
		
		return new ResponseEntity<List<ProductDto>>(list, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/products/remove")
	public ResponseEntity<List<ProductDto>> removeProductFromCartHandler(
			@RequestParam Integer productId,
			@RequestParam String key) throws CartException, ProductException, LoginException
	{
		List<ProductDto> list = ctService.removeProductFromCart(productId, key);
		
		return new ResponseEntity<List<ProductDto>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/products")
	public ResponseEntity<Cart> removeAllProductsHandler(@RequestParam String key) throws CartException, LoginException
	{
		Cart cart = ctService.removeAllProducts(key);
		
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	

}
