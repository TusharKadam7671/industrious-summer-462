package com.masai.service;

import java.util.List;
import java.util.Optional;

import com.masai.exceptions.AddressException;
import com.masai.exceptions.LoginException;
import com.masai.model.Address;



public interface AddressService {
	
//	public Address addAddress(Address add, String key)throws AddressException, LoginException;
	public Address addAddress(Address address)throws AddressException;
	
	public Address updateAddress(Address address)throws AddressException;
	
	public Address deleteAddressId(Integer addressId) throws AddressException;
	
	public List<Address> getAllAddress() throws AddressException;
	
	public Address viewAddressById(Integer addressId)throws AddressException;
	
}
