//Refer - products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,
//product name(unique)  , price , available quantity


package com.sunbeam.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

public class Product extends BaseEntity {
	
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
	

	public Product( Category category, String name, double price, int avlQty) {
		
		
		this.category = category;
		this.name = name;
		this.price = price;
		this.avlQty = avlQty;
	}


	
	
}
