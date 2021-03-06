package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.onlinefooddelivery.app.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
 public Customer findById(int id);
}
