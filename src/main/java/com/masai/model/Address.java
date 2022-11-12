package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor

public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	
	@Size(min = 3, max = 10, message = "Street no. should min of 3 and max of 10 Characters")
	private String streetNo;
	private String buildingName;
	
	@NotBlank(message = "City should not be blank.")
	private String city;
	
	@NotBlank(message = "State cannot be blank.")
	private String state;
	
	@NotBlank(message = "Country cannot be blank.")
	private String country;
	
	@NotBlank(message = "Pincode cannot be blank.")
	private String pincode;
	
	
		
}
