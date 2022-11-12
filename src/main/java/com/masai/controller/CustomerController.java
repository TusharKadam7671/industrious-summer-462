package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired 
	private CustomerService custService;
	
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer)throws CustomerException {
		
		Customer saveCustomer= custService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(saveCustomer, HttpStatus.CREATED);
	}
		
	
	@PutMapping ("/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException{
		
		Customer updateCustomer= custService.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(updateCustomer,HttpStatus.ACCEPTED);		
	}
	
	
	
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customer> deleteCustomerByIdHandler (@PathVariable("customerId")Integer customerId) throws CustomerException{
		
		Customer delCustomer = custService.removeCustomer(customerId);
		
		return new ResponseEntity<Customer>(delCustomer,HttpStatus.OK);
	}
	
	
	@GetMapping("/getcustomer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId")Integer customerId) throws CustomerException{
		
		Customer viewCustomer= custService.viewCustomer(customerId);
		
		return new ResponseEntity<Customer>(viewCustomer, HttpStatus.OK);
	}
	
	
	@GetMapping("/getcustomer")
	public ResponseEntity<List<Customer>> getAllCustomer(@PathVariable("city") String location) throws CustomerException{
		
		List<Customer> viewAll= custService.viewAllCustomers(location); 
		return new ResponseEntity<List<Customer>>(viewAll, HttpStatus.OK);
	}
	

}
