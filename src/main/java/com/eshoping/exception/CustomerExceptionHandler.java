package com.eshoping.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eshoping.service.CustomerService;
//it is use to specify handle the exception 
@RestControllerAdvice
public class CustomerExceptionHandler {
	
	@Autowired
	CustomerService service;

	public CustomerExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	//it is use to specify which class exception can be handle
	@ExceptionHandler(CustomerException.class)
	private ResponseEntity<String> handlingCustomerDetailsException(CustomerException customer) {
		 
		return new ResponseEntity<String>(customer.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ProductException.class)
	private ResponseEntity<String> handlingProductDetailsException(ProductException pe)
	{
		return new ResponseEntity<String>(pe.getMessage(),HttpStatus.NOT_FOUND);
	}

}
