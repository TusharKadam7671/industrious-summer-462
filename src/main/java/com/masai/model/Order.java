package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Order {
	private String orderId;
	private LocalDate orderDate;
	private String orderStatus;
	private Customer customer;
	private Address address;
	// productList : Map;
}
