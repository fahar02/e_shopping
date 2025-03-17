package com.eshoping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eshoping.entity.Products;
import com.eshoping.repo.ProductRepo;

@Component
public class ProductDaoImp implements Product{
	@Autowired
	ProductRepo repo;

	@Override
	public Products saveProducts(Products products) {
		
		return repo.save(products);
	}

	@Override
	public List<Products> getProducts() {
		
		return repo.findAll();
	}

}
