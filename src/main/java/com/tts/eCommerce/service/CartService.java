package com.tts.eCommerce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.eCommerce.model.Cart;
import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.repository.ProductRepository;
import com.tts.eCommerce.repository.UserRepository;

@Service
public class CartService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Cart addLineItemToCart(Cart cart, Long productId, Integer quantity) {
		  Optional<Product> productToAdd = productRepository.findById(productId);
		  HashMap<Product, Integer> lineItemToAdd = new HashMap<>();
		  lineItemToAdd.put(productToAdd, quantity);
		  List<HashMap<Product, Integer>> cartItems = cart.getLineItems();
		  cartItems.add(lineItemToAdd);
		  cart.setLineItems(cartItems);
		  return cart;
		}

		public Cart updateLineItemQuantity(Cart cart, Product product, Integer quantity){
			List<HashMap<Product, Integer>> cartItems = cart.getLineItems();
			if (quantity > 0) {
		    cart.getLineItems().put(product, quantity);
		  } else {
		    cart.getLineItems().remove(product);
		  }
		  return cart;
		}

}
