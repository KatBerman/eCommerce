package com.tts.eCommerce.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.repository.ProductRepository;

@Service
public class CartService {

	@Autowired
	private ProductRepository productRepository;

	public Cart addLineItemToCart(Cart cart, Long productId, Integer quantity) {
		Product productToAdd = productRepository.findProductById(productId);
		HashMap<Product, Integer> lineItemToAdd = new HashMap<>();
		lineItemToAdd.put(productToAdd, quantity);
		List<HashMap<Product, Integer>> cartItems = cart.getLineItems();
		cartItems.add(lineItemToAdd);
		cart.setLineItems(cartItems);
		return cart;
	}

	public Cart updateLineItemQuantity(Cart cart, Product product, Integer quantity){ 
		List<HashMap<Product, Integer>> cartItems = cart.getLineItems();
		for (HashMap<Product, Integer> cartItem : cartItems) {
			cartItem.replace(product, quantity);
		}
		cart.setLineItems(cartItems);
		return cart;
	}
	 

}
