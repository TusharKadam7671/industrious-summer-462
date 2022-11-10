package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer>{

}
