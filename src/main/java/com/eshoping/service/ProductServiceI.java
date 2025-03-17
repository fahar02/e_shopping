package com.eshoping.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.eshoping.entity.Products;

public interface ProductServiceI {
	
	public ResponseEntity<Products> insert(Products products);
	
	public ResponseEntity<List<Products>> getAll();

}
