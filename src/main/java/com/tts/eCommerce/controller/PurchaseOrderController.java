package com.tts.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.PurchaseOrder;
import com.tts.eCommerce.service.PurchaseOrderService;

@Controller
@RequestMapping("/storefront")
public class PurchaseOrderController {
	
	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	@GetMapping("/purchaseOrder")
	public String order(Cart cart, Model model) {
		PurchaseOrder makeOrder = purchaseOrderService.makePurchase(cart);
		model.addAttribute("makeOrder", makeOrder);
		return "storefront/purchaseOrder";
	}

}
