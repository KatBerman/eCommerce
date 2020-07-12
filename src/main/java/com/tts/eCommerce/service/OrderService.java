package com.tts.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.Order;
import com.tts.eCommerce.repository.OrderRepository;

public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order makePurchase(Cart cart) {
		//Need code here - not sure what the method would be
		return null;
	}
	
	
	private Double findSalesTax(Double subtotal) {
		Double tax = 0.1 * subtotal;
		return tax;
	}

}
