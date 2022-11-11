package com.masai.service;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer cust) throws CustomerException;
	public Customer updateCustomer(Customer cust) throws CustomerException;
	public Customer removeCustomer(Integer customerId) throws CustomerException;
	public Customer viewCustomer(Integer CustomerId) throws CustomerException;
	public List<Customer> viewAllCustomers(String location) throws CustomerException;

}
