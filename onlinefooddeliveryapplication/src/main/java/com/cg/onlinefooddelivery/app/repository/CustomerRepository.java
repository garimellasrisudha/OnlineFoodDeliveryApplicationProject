package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.onlinefooddelivery.app.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	
 public Customer findById(int id);
}
