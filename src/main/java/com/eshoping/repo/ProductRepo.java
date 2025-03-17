package com.eshoping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eshoping.entity.Products;

public interface ProductRepo extends JpaRepository<Products,Integer>{

	@Query("select product from Products product where product.name=?1or product.brand=?1or product.category=?1")
	List<Products> getByNameOrBrandOrCategory(String filter);

}
