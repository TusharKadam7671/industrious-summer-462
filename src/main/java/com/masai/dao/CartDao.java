package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Cart;
import com.masai.model.Customer;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{
	
	public Cart findByCustomer(Customer customer);

}
