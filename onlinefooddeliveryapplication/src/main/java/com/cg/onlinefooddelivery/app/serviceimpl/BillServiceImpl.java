package com.cg.onlinefooddelivery.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinefooddelievery.domain.Bill;
import com.cg.onlinefooddelievery.exception.BillException;
import com.cg.onlinefooddelievery.repository.BillRepository;
import com.cg.onlinefooddelievery.service.BillService;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	public Iterable<Bill> viewAllBills() {
		return  billRepository.findAll();
	}
	
	public Bill saveorUpdate(Bill bill) {
		return billRepository.save(bill);
	}
	
	public void deleteBill(int billId) throws BillException {
		Bill bill = null;
		try {
			bill = billRepository.getBillById(billId);
			billRepository.delete(bill);
		} catch(Exception e) {
			throw new BillException("Bill not found");
		}
	}
	
	public Bill getBillById(Integer billId) {
		return billRepository.getBillById(billId);
	}

	@Override
	public void deleteBill(Integer billId) throws BillException {
		// TODO Auto-generated method stub
		
	}
}
