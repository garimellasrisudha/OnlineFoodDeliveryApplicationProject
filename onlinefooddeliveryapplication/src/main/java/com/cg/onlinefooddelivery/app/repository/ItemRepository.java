package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefooddelivery.app.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{
	Item findById(int id);
	
}
