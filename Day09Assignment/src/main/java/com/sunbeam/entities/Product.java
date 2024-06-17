//Refer - products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,
//product name(unique)  , price , available quantity


package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name="products")

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Category category;
	
	@Column(name="Prod_name", length = 25, unique = true)
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="avl_Qty")
	private int avlQty;
	
	
	public Product() {
		super();
	}


	public Product( Category category, String name, double price, int avlQty) {
		
		
		this.category = category;
		this.name = name;
		this.price = price;
		this.avlQty = avlQty;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getAvlQty() {
		return avlQty;
	}


	public void setAvlQty(int avlQty) {
		this.avlQty = avlQty;
	}


	@Override
	public String toString() {
		return "products [id=" + id + ", category=" + category + ", name=" + name + ", price=" + price + ", avlQty="
				+ avlQty + "]";
	}
	
	
	
	
	
}
