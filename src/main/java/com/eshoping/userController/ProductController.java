package com.eshoping.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshoping.entity.Products;
import com.eshoping.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	
	@PostMapping("/insertproduct")
	public ResponseEntity<Products> insertpro(@RequestBody Products products)
	{
		return service.insert(products);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Products>> allPro()
	{
		return service.getAll();
	}
	
}
