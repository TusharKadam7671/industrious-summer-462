package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exceptions.AddressException;
import com.masai.exceptions.OrderException;
import com.masai.model.Orders;

public interface OrderService {
	
	public Orders addOrder(Orders order);
	public Orders updateOrders(Orders order)throws OrderException;
	public Orders removeOrders(Orders order)throws OrderException;
	public Orders viewOrder(Integer orderId)throws OrderException;
	
	public List<Orders> viewAllOrders(LocalDate date) throws OrderException ;
	
	public List<Orders> viewAllOrdersByLocation(String Location) throws OrderException,AddressException ;
	
	public List<Orders> viewAllOrdersByuserId(String userId) throws OrderException ;
}
