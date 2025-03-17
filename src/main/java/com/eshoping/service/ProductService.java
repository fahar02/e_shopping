package com.eshoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eshoping.dao.ProductDaoImp;
import com.eshoping.entity.Products;
import com.eshoping.exception.ProductException;
@Service
public class ProductService implements ProductServiceI{
	@Autowired
	ProductDaoImp dao;

	@Override
	public ResponseEntity<Products> insert(Products products) {
		
	Products products2=dao.saveProducts(products);
	return new ResponseEntity<Products>(products2,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Products>> getAll() {
		List<Products> list=dao.getProducts();
		if(list.size()!=0)
		{
			return new ResponseEntity<List<Products>>(list,HttpStatus.FOUND);
		}
		else {
			throw new ProductException("product not found");
		}
	}

}
