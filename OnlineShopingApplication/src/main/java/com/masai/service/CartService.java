package com.masai.service;

import com.masai.model.Cart;
import com.masai.model.Product;

public interface CartService {
	
	public Cart addProductToCart(Cart cart,Product p,int quantity);

}
