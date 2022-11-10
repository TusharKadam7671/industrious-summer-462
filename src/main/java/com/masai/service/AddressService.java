package com.masai.service;

import java.util.List;

import com.masai.dao.AddressDao;
import com.masai.exceptions.AddressException;
import com.masai.model.Address;



public interface AddressService {
	
	public Address addAddress(Address address)throws AddressException;
	
	public Address updateAddress(Address address)throws AddressException;
	
	public Address deleteAddressId(Integer addressId) throws AddressException;
	
	public List<Address> getAllAddress() throws AddressException;
	
//	public Address getAddressById(Integer addressId)throws AddressException;
}
