package com.tts.eCommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product _id")
	private Long id; 
	
	@NotBlank(message = "Product name cannot be blank")
	private String name;
	
	@NotBlank(message = "Product brand cannot be blank")
	private String brand;
	
	@NotBlank(message = "Product category cannot be blank")
	private String category;
	
	@PositiveOrZero(message = "Product cannot have a negative wholesale price")
	private Double wholesalePrice; 
	
	@PositiveOrZero(message = "Product cannot have a negative retail price")
	private Double retailPrice;
	
	@PositiveOrZero(message = "Product cannot have a negative inventory")
	private Integer inventory;
	
	private String description;
	
	private String image;
	
	@CreationTimestamp
	private Date createdAt; 
	
	@UpdateTimestamp
	private Date updatedAt;

	public Product() {}

	public Product(String name, String brand, Double wholesalePrice, Double retailPrice, Integer inventory,
			String description, String image, Date createdAt, Date updatedAt) {
		this.name = name;
		this.brand = brand;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.inventory = inventory;
		this.description = description;
		this.image = image;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(Double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", wholesalePrice=" + wholesalePrice
				+ ", retailPrice=" + retailPrice + ", inventory=" + inventory + ", description=" + description
				+ ", image=" + image + "]";
	}
	
	@Override
	public int hashCode(){
	  final int temp = 14;
	  int ans = 1;
	  ans = (int)(temp * ans + id);
	  return ans;
	}

	@Override
	public boolean equals(Object obj){
	  if (this == obj) {
	    return true;
	  }
	  if (obj == null) {
	    return false;
	  }
	  if (this.getClass() != obj.getClass()) {
	    return false;
	  }
	  Product other = (Product)obj;
	  if (this.id != other.id) {
	    return false;
	  }
	  return true;
	}
	
	

}
