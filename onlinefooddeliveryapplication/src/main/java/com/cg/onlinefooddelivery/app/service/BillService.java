package com.cg.onlinefooddelivery.app.service;

import javax.validation.Valid;

import com.cg.onlinefooddelievery.domain.Bill;
import com.cg.onlinefooddelievery.exception.BillException;

public interface BillService {

	Iterable<Bill> viewAllBills();

	Bill saveorUpdate(@Valid Bill bill);

	void deleteBill(Integer billId) throws BillException;

	Bill getBillById(Integer billId);

}
