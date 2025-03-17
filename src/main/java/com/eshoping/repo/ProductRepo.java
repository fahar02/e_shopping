package com.eshoping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshoping.entity.Products;

public interface ProductRepo extends JpaRepository<Products,Integer>{

}
