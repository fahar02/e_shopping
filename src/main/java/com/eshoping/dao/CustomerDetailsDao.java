package com.eshoping.dao;

import java.util.List;

import com.eshoping.entity.Customer;

public interface CustomerDetailsDao {
	
	List<Customer> getAllDetails();
	Customer insertCustomer(Customer customer);
	Customer getDetails(String email,String password);
	

}
