package com.eshoping.service;

import org.springframework.http.ResponseEntity;

import com.eshoping.entity.Customer;

public interface CustomerService {
	
	public ResponseEntity<Customer> customerRegistration(Customer customer);
	public Customer getCustomer(String email,String password);
	public ResponseEntity<Customer> cuslogin(String email, String password);

}
