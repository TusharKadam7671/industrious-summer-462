package com.masai.dto;

import javax.persistence.Embedded;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.masai.model.Category;
import com.masai.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	private Integer productId;
	
	private String productName;
	
	private Double price;
	
	
	private String color;
	
	private String dimension;
	
	private String manufacturer;
	
	private String specification;
	
	private Integer quantity;



	public ProductDto(Integer productId, String productName, Double price, String color, String dimension,
			String manufacturer, String specification, Integer quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.manufacturer = manufacturer;
		this.specification = specification;
		this.quantity = quantity;
	}

	
	
	
	


	

}
