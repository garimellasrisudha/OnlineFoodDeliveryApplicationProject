package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefooddelievery.domain.Bill;


@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
	Bill getBillById(int id);
	
}
