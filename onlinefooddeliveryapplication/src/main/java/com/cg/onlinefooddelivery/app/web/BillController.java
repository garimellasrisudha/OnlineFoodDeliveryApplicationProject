package com.cg.onlinefooddelivery.app.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinefooddelivery.app.domain.Bill;
import com.cg.onlinefooddelivery.app.service.BillService;
import com.cg.onlinefooddelivery.app.serviceimpl.MapValidationServiceImpl;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	@Autowired
	private MapValidationServiceImpl mapValidationServiceImpl;
	
	@GetMapping("/getAllBills")
	public List<Bill> getAllBills() {
		return billService.getAllBills();
		
	
	}
	
	@PostMapping("/saveBill")
	public  ResponseEntity<?> saveBill(@Valid @RequestBody Bill bill,BindingResult result) {
		ResponseEntity<?> errorMap=mapValidationServiceImpl.mapValidationError(result);
		if(errorMap!=null)
		{
			return errorMap;
		}
		Bill billStore=billService.saveorUpdate(bill);
		return new ResponseEntity<Bill>(billStore,HttpStatus.OK); 
		
	}
	@DeleteMapping("/deleteBill")
	public  ResponseEntity<Map<String, Object>> deleteBill(Integer billId) {
		return null;
		
	}
	
	@GetMapping("/getBill")
	public ResponseEntity<Map<String, Object>> getBill(Integer billId) {
		return null;
		
	}
	
}
