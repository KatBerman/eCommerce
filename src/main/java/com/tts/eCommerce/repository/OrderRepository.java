package com.tts.eCommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.Order;
import com.tts.eCommerce.model.User;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	
	public List<Order> findAll();
	public Order findOrderById(Long id); 
	public Order findByUser(User user);
}
