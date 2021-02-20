package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefooddelivery.app.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address , Integer>  {
 
public Address findById(int id);
}
