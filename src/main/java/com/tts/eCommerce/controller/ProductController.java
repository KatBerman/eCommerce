package com.tts.eCommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.eCommerce.model.Product;
import com.tts.eCommerce.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/products/{productId}")
	public String show(@PathVariable Long id, Model model) {
	  Product product = productService.findProductById(id);
	  model.addAttribute("product", product);
	  return "storefront/product";
	}

	@RequestMapping(value = {"/products/new", "/products/{productId}/edit"}, method = {RequestMethod.POST, RequestMethod.PUT })
	public String createOrUpdate(@Valid Product product) {
	  productService.save(product);
	  return "redirect:/storefront/products/" + product.getId();
	}

}
