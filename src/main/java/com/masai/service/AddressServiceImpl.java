package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exception.AddressException;
import com.masai.model.Address;

@Service
public class AddressServiceImpl implements AddressService{

	@Override
	public Address addAddress(Address address) throws AddressException {
		return address;
		
		

	}

}
