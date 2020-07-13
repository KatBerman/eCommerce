package com.tts.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.PurchaseOrder;
import com.tts.eCommerce.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	public PurchaseOrder makePurchase(Cart cart) {
		//Need code here - not sure what the method would be
		return null;
	}
	
	
	private Double findSalesTax(Double subtotal) {
		Double tax = 0.1 * subtotal;
		return tax;
	}

}
