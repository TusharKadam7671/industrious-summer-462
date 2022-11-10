package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyErrorDetail> studentExceptionHandler(AddressException ae, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> ExceptionHandler(Exception se, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
}
