package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefooddelivery.app.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{
	public Category findById(int id);


}
