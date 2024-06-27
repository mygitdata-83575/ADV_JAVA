
//We will discuss - "day10-data\product category assignment with hibernate.png"
//I will get you started with 1 page flow , you can later complete others (for additional practice)
//The layers - ServletContextListener - to manage SessionFactory
//JSP - Java Beans - HibernateBased DAO -HibernateUtils - Hibernate managed entities (BaseEntity , Category n Product)
//Category - name(unique) n description
//Product - product name(unique)  , price , available quantity
//Establish a bi dir relationship n test it.
//Category  1<-->*  Product
//
//insert 3 records under categories table (in mysql cmd line client)
//Objective - add new product under the category


package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="categories")
public class Category extends BaseEntity {
	@Column(name="name",length = 30,unique = true)
	private String categoryName;
	private String description;
	//Category 1--->* BlogPost
	@OneToMany(mappedBy = "productCategory",
			cascade = CascadeType.ALL)
	private List<Product> products=new ArrayList<>();
	
	public Category() {
		super();
	}

	public Category(String categoryName, String description, List<Product> products) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.products = products;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product)
	{
		//establish category --> post (parent --> child)
		this.products.add(product);
		//establish post --> category (child -> parent)
		product.setProductCategory(this);
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", description=" + description + ", products=" + products
				+ "]";
	}
	
	

	

}
