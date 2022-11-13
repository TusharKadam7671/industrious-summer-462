package com.masai;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableWebMvc

@SpringBootApplication
@EnableSwagger2
public class IndustriousSummer462Application {

	public static void main(String[] args) {
		SpringApplication.run(IndustriousSummer462Application.class, args);
	}

}
