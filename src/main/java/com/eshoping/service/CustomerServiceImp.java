package com.eshoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.eshoping.dao.CustomerDetailsDao;
import com.eshoping.entity.Customer;
import com.eshoping.exception.CustomerException;
@Component
public class CustomerServiceImp implements CustomerService {

	public CustomerServiceImp() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	CustomerDetailsDao customerDetailsDao;
	@Override
	public ResponseEntity<Customer> customerRegistration(Customer customer) 
	{
//		List<Customer> list=customerDetailsDao.getAllDetails();
//		long email=list.stream().filter((userdetails->userdetails.getEmail().equals(customer.getEmail()))).count();
//		if(email>0)
//		{
//			throw new CustomerException("email is present");
//		}
//		long password=list.stream().filter((userdetails->userdetails.getPassword().equals(customer.getPassword()))).count();
//		if(password>0)
//		{
//			throw new CustomerException("password is present");
//		}
//	return	customerDetailsDao.insertCustomer(customer);
		List<Customer> list=customerDetailsDao.getAllDetails();
		long email=list.stream().filter((userdetails->userdetails.getEmail().equals(customer.getEmail()))).count();
		if(email>0)
		{
			throw new CustomerException("email is present");
		}
		long password=list.stream().filter((userdetails->userdetails.getPassword().equals(customer.getPassword()))).count();
		if(password>0)
		{
			throw new CustomerException("password is present");
		}
	    Customer customerdb=customerDetailsDao.insertCustomer(customer);
	    if(customerdb!=null)
	    {
	    	return new ResponseEntity<Customer>(customerdb,HttpStatus.CREATED);
	    }
	    else {
	    	return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public Customer getCustomer(String email,String password) {
		
		return customerDetailsDao.getDetails(email,password);
	}

	@Override
	public ResponseEntity<Customer> cuslogin(String email, String password) {
		Customer customer=customerDetailsDao.getDetails(email, password);
		if(customer!=null)
		{
			return new ResponseEntity<Customer>(customer,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		
	}

	

}
