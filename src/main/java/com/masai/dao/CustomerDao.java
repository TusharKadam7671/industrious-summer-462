package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	public Customer findByMobileNumber(String mobileNo);

}
