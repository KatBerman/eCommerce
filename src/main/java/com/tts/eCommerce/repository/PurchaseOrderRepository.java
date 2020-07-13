package com.tts.eCommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.PurchaseOrder;
import com.tts.eCommerce.model.User;

@Repository
public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Long> {
	
	public List<PurchaseOrder> findAll();
	public PurchaseOrder findOrderById(Long id); 
	public PurchaseOrder findByUser(User user);
}
