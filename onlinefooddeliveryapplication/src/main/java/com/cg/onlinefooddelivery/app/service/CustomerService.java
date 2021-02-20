package com.cg.onlinefooddelivery.app.service;

import java.util.Optional;

import com.cg.onlinefooddelivery.app.domain.Customer;
import com.cg.onlinefooddelivery.app.exception.CustomerNotFoundException;

public interface CustomerService {
	
	/*
	 * This method will save or Update Customer details
	 * @param customer
	 * @return Saved Customer 
	 */
	public Customer saveOrUpdate(Customer customer)  ;
	
/*
 * This method is for finding all  customer details
 * @return all customer details
 */
	public Iterable<Customer> getAllCustomers() ;
		
	
	/*
	 * This method is for finding customer details by id
	 * @param id
	 */
	public  Customer findCustomerById(int id) ;
		
	/*
	 * This method is for deleting the customer details by id
	 * @param id
	 */
		public void deleteCustomerById(int id);
}


