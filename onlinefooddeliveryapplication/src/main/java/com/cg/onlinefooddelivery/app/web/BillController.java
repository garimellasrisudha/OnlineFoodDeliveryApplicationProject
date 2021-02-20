package com.cg.onlinefooddelivery.app.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinefooddelievery.domain.Bill;
import com.cg.onlinefooddelievery.exception.BillException;
import com.cg.onlinefooddelievery.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@GetMapping("/getAllBills")
	public ResponseEntity<Map<String, Object>> getAllBills() {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			Iterable<Bill> bills = billService.viewAllBills();
			response.put("data", bills);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			response.put("message", "Failed to get bills");
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping("/saveBill")
	public @ResponseBody ResponseEntity<Map<String, Object>> saveBill(@Valid @RequestBody Bill bill) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			Bill saveBill = billService.saveorUpdate(bill);
			response.put("data", saveBill);
			response.put("message", "Bill saved successfully");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			response.put("message", "Failed to save bill");
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/updateBill")
	public @ResponseBody ResponseEntity<Map<String, Object>> updateBill(@Valid @RequestBody Bill bill) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			Bill saveBill = billService.saveorUpdate(bill);
			response.put("data", saveBill);
			response.put("message", "Bill updated successfully");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			response.put("message", "Failed to update bill");
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping("/deleteBill")
	public  ResponseEntity<Map<String, Object>> deleteBill(Integer billId) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			billService.deleteBill(billId);
			response.put("message", "Bill deleted successfully");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(BillException be) {
			response.put("message", be.getMessage());
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		} catch(Exception e) {
			response.put("message", "Failed to delete bill");
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/getBill")
	public ResponseEntity<Map<String, Object>> getBill(Integer billId) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			Bill bill = billService.getBillById(billId);
			response.put("data", bill);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			response.put("message", "Failed to get bill data");
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
}
