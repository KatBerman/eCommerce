package com.tts.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.Order;
import com.tts.eCommerce.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order")
	public String order(Cart cart, Model model) {
		Order makeOrder = orderService.makePurchase(cart);
		model.addAttribute("makeOrder", makeOrder);
		return "storefront/order";
	}

}
