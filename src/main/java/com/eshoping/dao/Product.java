package com.eshoping.dao;

import java.util.List;

import com.eshoping.entity.Products;

public interface Product {
	
	public Products saveProducts(Products products);
	List<Products> getProducts();
	public List<Products> filterpro(String filter);

}
