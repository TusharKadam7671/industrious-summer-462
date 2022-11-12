package com.masai.service;

import com.masai.exceptions.CartException;
import com.masai.exceptions.ProductException;
import com.masai.model.Cart;
import com.masai.model.Product;

public interface CartService {
	
	public Cart addProductToCart(Cart cart, Product p, Integer quantity) throws CartException, ProductException;

}
