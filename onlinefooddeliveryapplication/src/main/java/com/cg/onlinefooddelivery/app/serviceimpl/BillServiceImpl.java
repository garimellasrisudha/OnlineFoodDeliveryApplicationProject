package com.cg.onlinefooddelivery.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinefooddelivery.app.domain.Bill;
import com.cg.onlinefooddelivery.app.domain.FoodCart;
import com.cg.onlinefooddelivery.app.domain.Item;
import com.cg.onlinefooddelivery.app.domain.OrderDetail;
import com.cg.onlinefooddelivery.app.repository.BillRepository;
import com.cg.onlinefooddelivery.app.service.BillService;


@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Override
	public List<Bill> getAllBills() {
		return  billRepository.findAll();
	}

	@Override
	public Bill getBillById(int billId) {
		return billRepository.getBillById(billId);
		
	}

	@Override
	public Bill saveorUpdate(Bill bill) {
		
		return billRepository.save(bill);
	}

	@Override
	public void deleteBill(int billId) {
		 billRepository.deleteById(billId);
		
	}

	@Override
	public int calculateBill(int billId) {
		int sum=1;
		Bill bill=getBillById(billId);
		OrderDetail  order=bill.getOrder();
		FoodCart cart=order.getCart();
		List<Item> itemlist=cart.getItemList();
		for(Item item:itemlist)
		{
			sum=(int) (sum+(item.getCost()*item.getQuantity()));
			System.out.println(sum);
			System.out.print(order);
		}
		
		cart.getItemList();
	}

	

	
}
