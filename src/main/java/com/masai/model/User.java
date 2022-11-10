package com.masai.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@NotNull(message = "User Id cannot be null...")
	@NotBlank(message = "User Id cannot be blank.")
	@NotEmpty(message = "User Id cannot be empty.")
	private String userId;
	
	private String password;
	
	@NotNull(message = "Please enter your role")
	@NotBlank(message = "Please enter your role")
	@NotEmpty(message = "Please enter your role")
	private String role;
	
	
}
