package com.masai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.CartDao;
import com.masai.dao.CustomerDao;
import com.masai.dao.ProductDao;
import com.masai.dao.SessionDao;
import com.masai.dto.ProductDto;
import com.masai.exceptions.CartException;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.login.CurrentUserSession;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Product;



@Service
public class CartServiceImpl implements CartService{
	
	
	@Autowired
	SessionDao sDao;
	
	@Autowired
	ProductDao pDao;
	
	@Autowired
	CartDao ctDao;
	
	@Autowired
	CustomerDao cDao;
	

	
	
	
	

	@Override
	public Cart addProductToCart(Integer productId, int quantity, String key)
			throws CartException, LoginException, ProductException {

		CurrentUserSession currentSession = sDao.findByUuid(key);
		
		Customer currentCustomer = cDao.findById(currentSession.getUserId()).get();
		
		if(currentCustomer == null)
		{
			throw new LoginException("Please login first to add product to the cart");
		}
		
		Product product;
		
		if(pDao.findById(productId).isPresent())
		{
			product = pDao.findById(productId).get();
		}
		else
		{
			throw new ProductException("Product is not available with id: "+productId);
		}

		if(product.getQuantity() < quantity)
		{
			throw new ProductException("Out of stock");
		}
		
		Cart cart = ctDao.findByCustomer(currentCustomer);
		
		if(cart == null)
		{
			cart = new Cart();
			cart.setCustomer(currentCustomer);
			List<ProductDto> list = cart.getProducts();
			
			ProductDto productdto = new ProductDto(product.getProductId(), 
					product.getProductName(), 
					product.getPrice(), 
					product.getColor(), 
					product.getDimension(), 
					product.getManufacturer(),
					product.getSpecification(), 
					quantity);
			
			product.setQuantity(product.getQuantity() - quantity);
			list.add(productdto);
			cart.setProducts(list);
			
			ctDao.save(cart);
			pDao.save(product);
			
			return cart;
			
		}
		else
		{
			List<ProductDto> list = cart.getProducts();
			
			ProductDto productDto = new ProductDto( product.getProductId(),
													product.getProductName(),
													product.getPrice(), 
													product.getColor(), 
													product.getDimension(),
													product.getManufacturer(),
													product.getSpecification(),
													quantity);
			
			product.setQuantity(product.getQuantity() - quantity);
			
			list.add(productDto);
			cart.setProducts(list);
			
			ctDao.save(cart) ;
			pDao.save(product);
			 
			return cart;
		}
		
	}

	@Override
	public List<ProductDto> removeProductFromCart(Integer productId, String key)
			throws CartException, ProductException, LoginException {

		CurrentUserSession currentSession = sDao.findByUuid(key);
		
		Customer currentCustomer = cDao.findById(currentSession.getUserId()).get();
		
		if(currentCustomer == null)
		{
			throw new LoginException("Please login first to add product to the cart");
		}

		Product product;
		
		if(pDao.findById(productId).isPresent())
		{
			product = pDao.findById(productId).get();
		}
		else
		{
			throw new ProductException("Product is not available with id: "+productId);
		}

		
		Cart cart = ctDao.findByCustomer(currentCustomer);
		
		if(cart != null)
		{
			List<ProductDto> list = cart.getProducts();
			boolean flag = false;
			
			for(int i = 0; i < list.size(); i++) {
				
				ProductDto productdto = list.get(i) ;
				
				if(productdto.getProductId() == productId) {
					
					
					
					pDao.deleteById(productdto.getId());
					
					flag = true;
					
					product.setQuantity(product.getQuantity() + productdto.getQuantity());
					pDao.save(product);
					
					list.remove(i) ;
					break;
				}
				
			}
			
			if(!flag)
			{
				throw new ProductException("Product is not available with product id: "+productId);
			}
			
			cart.setProducts(list);
			ctDao.save(cart);
			
			return list;
			
		}
		else
		{
			throw new CartException("The cart is empty");
		}
		
	}

	@Override
	public List<ProductDto> updateProductQuantity(Integer productId, Integer quantity, String key)
			throws CartException, LoginException, ProductException {

		CurrentUserSession currentSession = sDao.findByUuid(key);
		
		Customer currentCustomer = cDao.findById(currentSession.getUserId()).get();
		
		if(currentCustomer == null)
		{
			throw new LoginException("Please login first to update the product quantity");
		}
		
		Product product;
		
		if(pDao.findById(productId).isPresent())
		{
			product = pDao.findById(productId).get();
		}
		else
		{
			throw new ProductException("Product is not available with id: "+productId);
		}

		
		Cart cart = ctDao.findByCustomer(currentCustomer);
		
		if(cart != null)
		{
			List<ProductDto> list = cart.getProducts();
			
			boolean flag = false;
			
			for(ProductDto productdto : list)
			{
				if(productdto.getProductId() == productId)
				{
					flag = true;
					
					if(product.getQuantity() < quantity)
					{
						throw new ProductException("Product is less in quntity than you requested");
					}
					else
					{
					product.setQuantity(product.getQuantity() - quantity);
					productdto.setQuantity(productdto.getQuantity() + quantity);
					
					pDao.save(product);
					cart.setProducts(list);
					ctDao.save(cart);
					
					break;
					
					}
				}
			}
			
			if(!flag)
			{
				throw new ProductException("Product is not available in cart with product id: "+productId);
			}
			
			return list;
		}
		else
		{
			throw new CartException("Cart is empty");
		}
		
	}

	@Override
	public Cart removeAllProducts(String key) throws CartException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession currentSession = sDao.findByUuid(key);
		
		Customer currentCustomer = cDao.findById(currentSession.getUserId()).get();
		
		if(currentCustomer == null)
		{
			throw new LoginException("Please login first to update the product quantity");
		}
		
		Cart cart = ctDao.findByCustomer(currentCustomer);
		
		if(cart == null)
		{
			throw new CartException("Cart is empty");
		}
		else
		{
			cart.setProducts(new ArrayList<>());
			return ctDao.save(cart);
		}
	}

	@Override
	public List<ProductDto> viewAllProducts(String key) throws CartException, LoginException {

		CurrentUserSession currentSession = sDao.findByUuid(key);
		
		Customer currentCustomer = cDao.findById(currentSession.getUserId()).get();
		
		if(currentCustomer == null)
		{
			throw new LoginException("Please login first to update the product quantity");
		}
		
		Cart cart = ctDao.findByCustomer(currentCustomer);
		
		if(cart == null)
		{
			throw new CartException("Cart is empty");
		}
		
		return cart.getProducts();
	}

	
}
