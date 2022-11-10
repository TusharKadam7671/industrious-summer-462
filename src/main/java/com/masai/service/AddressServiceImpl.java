package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.dao.AddressDao;
import com.masai.exceptions.AddressException;
import com.masai.model.Address;


@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao aDao;
	
	@Override
	public Address addAddress(Address address) throws AddressException {
		
		Address add=aDao.save(address);
		
		return add;
	}

	
	
	@Override
	public Address updateAddress(Address address) throws AddressException {
		
		Optional<Address> opt= aDao.findById(address.getAddressId());
		
		if(opt.isPresent()) {
			
			Address updatedAddress= aDao.save(address);
			return updatedAddress;
			
		}else
			throw new AddressException("Invalid Address details..");
	
	}



	@Override
	public Address deleteAddressId(Integer addressId) throws AddressException {
		
		Optional<Address> opt= aDao.findById(addressId);
		
		if(opt.isPresent()) {
			
			Address existingAddress= opt.get();
			aDao.delete(existingAddress);
			
			return existingAddress;
			
			
		}else
			throw new AddressException("Address does not exist with Id :"+addressId);

	}



	@Override
	public List<Address> getAllAddress() throws AddressException {
		
		List<Address> address= aDao.findAll();
		
		if(address.size()==0)
			throw new AddressException("No Address is there");
		else
		return address;
	}



//	@Override
//	public Address getAddressById(Integer addressId) throws AddressException {
//		
//		Address address=aDao.findAddressById(addressId);
//		
//		if(address!=null)
//			return address;
//		else
//			throw new AddressException("Address not found with Id "+addressId);
//	}

	
	
	
	
}
