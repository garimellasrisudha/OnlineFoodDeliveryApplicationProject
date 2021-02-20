package com.cg.onlinefooddelivery.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinefooddelivery.app.domain.FoodCart;
import com.cg.onlinefooddelivery.app.domain.OrderDetail;
import com.cg.onlinefooddelivery.app.exception.ResourceNotFoundException;
import com.cg.onlinefooddelivery.app.repository.OrderDetailRepository;
import com.cg.onlinefooddelivery.app.service.OrderDetailService;
/**
 * this OrderDetailService class is used for performing all business related operations
 * @author sweta
 *
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepository orderRepository;
	
	
	public OrderDetail SaveOrUpdate(OrderDetail orderDetail)  {
		try {
		orderDetail.setOrderNo(orderDetail.getOrderNo().toUpperCase());
		FoodCart cart=new FoodCart();
		orderDetail.setCart(cart); 
	   cart.setOrderDetail(orderDetail);	
	   cart.setOrderNo(orderDetail.getOrderNo().toUpperCase());
		return orderRepository.save(orderDetail);
		}
		catch(Exception e) {
			throw new ResourceNotFoundException(orderDetail.getOrderNo().toUpperCase()+"  already exist");
		}
	}
	
	public List<OrderDetail> getAllOrderDetails(){
		return orderRepository.findAll();
	}
	
	public void deleteOrderDetailsById(int id)  {
		OrderDetail order=orderRepository.findById(id);
		if(order==null) {
			throw new ResourceNotFoundException("Order Id doesn't exists");
		}
	  orderRepository.deleteById(id);
	}

	@Override
	public OrderDetail findById(int id) {
	OrderDetail order=orderRepository.findById(id);
	if(order==null) {
		throw new ResourceNotFoundException("Order Id doesn't exists");
	}
		return order;
	}

	
}
