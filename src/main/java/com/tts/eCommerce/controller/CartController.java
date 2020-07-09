package com.tts.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.service.CartService;
import com.tts.eCommerce.service.ProductService;
import com.tts.eCommerce.service.UserService;

@Controller
@RequestMapping("/storefront")
public class CartController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;

	@PostMapping("/cart")
	public String addToCart(@RequestParam Long productId, @RequestParam Integer quantity, Cart cart, Model model) {
		cart = cartService.addLineItemToCart(cart, productId, quantity);
		model.addAttribute("cart", cart);
		return "storefront/cart";
	}

	@PostMapping("/cart")
	public String updateQuantity(@RequestParam Long productId, @RequestParam Integer quantity, Cart cart, Model model) {
		Product product = productService.findProductById(productId);
		cart = cartService.updateLineItemQuantity(cart, product, quantity);
		model.addAttribute("cart", cart);
		return "storefront/cart";
	}

	
	@GetMapping("/cart")
	public String viewCart(Cart cart, Model model) {
		model.addAttribute("cart", cart);
		return "storefront/cart";
	}

}
