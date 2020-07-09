package com.tts.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.service.ProductService;
import com.tts.eCommerce.service.UserService;

@Controller
public class CartController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private CartService cartService;
	
	@GetMapping("/cart")
	public String showCart() {
	  return "storefront/cart";
	}
	 
	@PostMapping("/cart")
	public String addToCart(@RequestParam long id) {
	  Product product = productService.findById(id);
	  setQuantity(product, cart().getOrDefault(product, 0) + 1);
	  return "storefront/cart";
	}

	@PatchMapping("/cart")
	public String updateQuantities(@RequestParam Long[] productId, @RequestParam Integer[] quantity) {
	  for(int i = 0; i < productId.length; i++) {
	      Product product = productService.findById(productId[i]);
	      setQuantity(product, quantity[i]);
	  }
	  return "storefront/cart";
	}
	
	@RequestMapping("/storefront")
		@GetMapping("/cart")
		public String viewCart(Cart cart, Model model) {
			model.addAttribute("cart", cart);
			return "storefront/cart";
		}
	

	@DeleteMapping("/cart")
	public String removeFromCart(@RequestParam long id) {
	  Product product = productService.findById(id);
	  setQuantity(product, 0);
	  return "storefront/cart";
	}

	private void setQuantity(Product p, int quantity) {
	  if(quantity > 0){
	    cart().put(p, quantity);
	  } else {
	    cart().remove(p);
	  }
	  userService.updateCart(cart());
	}
}
