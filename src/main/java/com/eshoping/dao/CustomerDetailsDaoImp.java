package com.eshoping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eshoping.entity.Customer;
import com.eshoping.repo.CustomerDetailsRepo;
@Component
public class CustomerDetailsDaoImp implements CustomerDetailsDao{
	@Autowired
	CustomerDetailsRepo repo;

	public CustomerDetailsDaoImp() {
		
	}

	@Override
	public Customer insertCustomer(Customer customer) {
		
		return repo.save(customer);
	}

	@Override
	public List<Customer> getAllDetails() {
		return repo.findAll();
		
	}

	@Override
	public Customer getDetails(String email,String password)
	{
		Optional<Customer> optional=repo.emailandpassword(email,password);
	
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
		
	}

}
