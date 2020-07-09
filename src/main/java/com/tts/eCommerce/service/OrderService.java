package com.tts.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tts.eCommerce.repository.OrderRepository;

public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

}
