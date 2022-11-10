package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.masai.dto.AddressDto;
import com.masai.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private LocalDate orderDate;
	
	private String orderStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_order",joinColumns = @JoinColumn(name="order_id",referencedColumnName = "orderId"))
	private Customer customer;
	
	@Embedded
	private AddressDto orderAddress;
	
	@ElementCollection
	@CollectionTable(name = "order_productlist", joinColumns = @JoinColumn(name="order_id",referencedColumnName = "orderId"))
	private List<ProductDto> productList = new ArrayList<>();

	public Orders(LocalDate orderDate, String orderStatus, Customer customer, AddressDto orderAddress,
			List<ProductDto> productList) {
		super();
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.orderAddress = orderAddress;
		this.productList = productList;
	}
	
	
	
	
	
	
}


