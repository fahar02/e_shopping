package com.eshoping.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eshoping.entity.Customer;
public interface CustomerDetailsRepo extends JpaRepository<Customer,Integer>{
	@Query("select c from Customer c where c.email=?1 and c.password=?2")
    Optional<Customer>	emailandpassword(String email,String password);

}
