package com.masai.service;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.OrderDao;
import com.masai.exceptions.AddressException;
import com.masai.exceptions.OrderException;
import com.masai.model.Orders;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao oRepo;

	@Override
	public Orders addOrder(Orders order) {
		// TODO Auto-generated method stub
		Orders saveOrders= oRepo.save(order);
		return saveOrders;
	}
	@Override
	public Orders updateOrders(Orders order) throws OrderException {
		// TODO Auto-generated method stub
		Optional<Orders> check=oRepo.findById(order.getOrderId());
		if(check.isPresent()) {
			return oRepo.save(order);
		}else {
			throw new OrderException("Order not exist by this id ");
		}
		
	}

	@Override
	public Orders removeOrders(Orders order) throws OrderException {
		// TODO Auto-generated method stub
		Orders check1= oRepo.findById(order.getOrderId())
						   .orElseThrow(()->new OrderException("order not exist with given id.."));
		oRepo.delete(check1);
		return order;
	}

	

//	@Override
//	public Orders viewOrders(Orders order) throws OrderException{
//		// TODO Auto-generated method stub
//		Optional<Orders> check2=oRepo.findById(order.getOrderId());
//		if(check2.isPresent()) {
//			return check2.get();
//		}else {
//			throw new OrderException("No order found by this id "+order.getOrderId());
//		}
//		
//	}
	@Override
	public Orders viewOrder(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub
		Optional<Orders> opt1=  oRepo.findById(orderId);
		
		if(opt1.isPresent()) {
			return opt1.get();
		}
		else {
			throw new OrderException("No order found");
		}
		
	}
	@Override
	public List<Orders> viewAllOrders(LocalDate date) throws OrderException {
		// TODO Auto-generated method stub
		List<Orders> allOrders= oRepo.findByOrderDate(date);
		if(allOrders.size()>0) {
			return allOrders;
		}else {
			throw new OrderException("order not exist by given date :"+date);
		}
		
	}
	@Override
	public List<Orders> viewAllOrdersByLocation(String Location) throws OrderException,AddressException {
		// TODO Auto-generated method stub
		List<Orders> list=oRepo.getOrderByCity(Location);
		if(list.size()>0) {
			return list;
		}else {
			throw new OrderException("No order found with this userId.");
		}
		
	}
	@Override
	public List<Orders> viewAllOrdersByuserId(String userId) throws OrderException {
		// TODO Auto-generated method stub
		List<Orders> list2=oRepo.getOrdersByUserId(userId);
		if( list2.size() < 1) {
			throw new OrderException("No order found with this userId.");
		}
		
		return list2;
		
	}
	



	

}
