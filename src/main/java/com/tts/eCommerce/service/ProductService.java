package com.tts.eCommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public List<Product> findByBrand(String brand) {
		List<Product> products = productRepository.findByBrand(brand);
		return products; 
	}
	
	public Product findByName(String name) {
		Product product = productRepository.findByName(name);
		return product;
	}
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

}
