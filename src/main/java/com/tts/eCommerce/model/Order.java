package com.tts.eCommerce.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long id; 
	
	private String firstName;
	
	private String lastName; 
	
	@CreationTimestamp
	private Date createdAt; 
	
	/* add a variable for list of products in cart? */
	
	private List<HashMap<Product, Integer>> lineItems;
	
	private Double subTotal;

}
