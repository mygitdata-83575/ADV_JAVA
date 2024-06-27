//Refer - products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,
//product name(unique)  , price , available quantity


package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name="products")

public class Product extends BaseEntity {
	
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Category1 category;
	
	@Column(name="Prod_name", length = 25, unique = true)
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="avl_Qty")
	private int avlQty;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category productCategory;

	public Product() {
		super();
	}

	public Product(Category1 category, String name, double price, int avlQty, Category productCategory) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
		this.avlQty = avlQty;
		this.productCategory = productCategory;
	}

	public Category1 getCategory() {
		return category;
	}

	public void setCategory(Category1 category) {
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

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [category=" + category + ", name=" + name + ", price=" + price + ", avlQty=" + avlQty
				+ ", productCategory=" + productCategory + "]";
	}
	
	
	
	
	
	
	
}
