package org.gp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	
	@Column(nullable=false)
	private String category;
	
	@Column(nullable=false)
	private int inventory;
	
	@Column(nullable=false)
	private double rating;
	
	@Column(nullable=false)
	private String currency;
	
	@Column(nullable=false)
	private double price;
	
	@Column(nullable=false)
	private  String origin;
	
	@Column(nullable=false)
	private  String product;
	
//	Add Discount or Promotion later
	
}
