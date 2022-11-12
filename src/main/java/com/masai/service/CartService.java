package com.masai.service;

import java.util.List;

import com.masai.dto.ProductDto;
import com.masai.exceptions.CartException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.model.Cart;


public interface CartService {
	
	public Cart addProductToCart(Integer productId, int quantity,String key) throws CartException, LoginException, ProductException ;
	
	public List<ProductDto> removeProductFromCart(Integer productId,String key) throws CartException, ProductException, LoginException  ;
	
	public List<ProductDto> updateProductQuantity(Integer productId,Integer quantity,String key) throws CartException, LoginException, ProductException ;
	
	public Cart removeAllProducts(String key) throws CartException, LoginException ;
	
	public List<ProductDto> viewAllProducts(String key)  throws CartException, LoginException;

}
