package com.masai.service;

import com.masai.exception.AddressException;
import com.masai.model.Address;

public interface AddressService {

	public Address addAddress(Address address)throws AddressException;

}
