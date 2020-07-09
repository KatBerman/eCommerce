package com.tts.eCommerce.model;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Cart {
	
	private List<HashMap<Optional<Product>, Integer>> lineItems;
	private Double subTotal;
	
	
	public Cart() {	}


	public Cart(List<HashMap<Optional<Product>, Integer>> lineItems, Double subTotal) {
		this.lineItems = lineItems;
		this.subTotal = subTotal;
	}


	public List<HashMap<Optional<Product>, Integer>> getLineItems() {
		return lineItems;
	}


	public void setLineItems(List<HashMap<Optional<Product>, Integer>> lineItems) {
		this.lineItems = lineItems;
	}


	public Double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}


	@Override
	public String toString() {
		return "Cart [lineItems=" + lineItems + ", subTotal=" + subTotal + "]";
	}	

	
	
	

}
