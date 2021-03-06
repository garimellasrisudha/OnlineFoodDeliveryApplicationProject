package com.cg.onlinefooddelivery.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinefooddelivery.app.domain.FoodCart;
import com.cg.onlinefooddelivery.app.exception.ResourceNotFoundException;
import com.cg.onlinefooddelivery.app.repository.FoodCartRepository;

@Service
public class FoodCartServiceImpl {

	@Autowired
	private FoodCartRepository cartRepository;
	
	public FoodCart saveOrUpdate(FoodCart cart) {
		try {
		return cartRepository.save(cart);
	}
		catch(Exception e) {
			throw new ResourceNotFoundException("Cart Not Found");
		}
	}
	
	public FoodCart findById(int cartId) {
		FoodCart cart=cartRepository.findById(cartId);
		if(cart==null) {
			throw new ResourceNotFoundException("Cart doesn't exist");
		}
		return cart;
	}
}
