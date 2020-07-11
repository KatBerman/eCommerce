package com.tts.eCommerce.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long id; 
	
	private List<HashMap<Product, Integer>> orderItem;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	private User user;
	
	@CreationTimestamp
	private Date createdAt; 
	
	private Double subtotal; 
	
	private Double tax;
	
	private Double total;

	public Order() {}

	public Order(List<HashMap<Product, Integer>> orderItem, User user, Date createdAt, Double subtotal, Double tax,
			Double total) {
		this.orderItem = orderItem;
		this.user = user;
		this.createdAt = createdAt;
		this.subtotal = subtotal;
		this.tax = tax;
		this.total = total;
	}

	public List<HashMap<Product, Integer>> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<HashMap<Product, Integer>> orderItem) {
		this.orderItem = orderItem;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderItem=" + orderItem + ", user=" + user + ", createdAt=" + createdAt
				+ ", subtotal=" + subtotal + ", tax=" + tax + ", total=" + total + "]";
	}
	
	
	
	

}
