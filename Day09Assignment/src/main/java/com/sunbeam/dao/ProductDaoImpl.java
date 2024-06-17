//Solve 
//3.1 Display all the product details under specified category n between the given price range.
//Hint - jpql with named IN params - getResultList
//
//3.2 Apply discount to all the products , from given category
//i/p - product category, discount
//o/p a message how many products were discounted
//Hint - update JPQL -use single arg createQuery -  set 2 named IN params
//-executeUpdate 
//
//3.3 Purchase a product
//Product id n quantity
//Validation - Check if product is available (check the available quantity )
//Customer should be able to purchase a product if n only if it's available !
//o/p a message indicating success or failure
//Hint -get product details (session.get)
//validate --in case of success --setter (set Qty) --upon commit : update query will be fired!
//
//3.4 Delete product details
//i/p product name(unique)
//o/p a message
//Hint -select jpql - session.delete(product) -
//upon commit -delete query will be fired.



package com.sunbeam.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public class ProductDaoImpl implements ProductDao{

	@Override
	public String addProduct(Product product) {
		String mesg="Product added failed!!!!";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Serializable productId = session.save(product);
			tx.commit();
			mesg="Product added successfully!!!! , with ID"+productId;

		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Product getProductDetailsById(Long productId) {
		Product product = null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			product = session.get(Product.class, productId);
			
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return product;
	}
	
	public List<Product> getProductByPriceAndCategory(double strtPrice, double endPrice, Category category){
		String jpql = "select p from Product p where p.price between :start and :end and p.category=:cat";
		List<Product> products = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			products = session.createQuery(jpql,Product.class)
					   .setParameter("start",strtPrice )
					   .setParameter("end",endPrice)
					   .setParameter("cat",category )
					   .getResultList();
					   
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return products;	
		
	}
	
	@Override
	public String applyDiscount(Category category,double discount) {
		String mesg = "applying discount failed !!!!";
		String jpql = "update Product p set p.price = p.price-:disc where p.category=:cat";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			int rows = session.createQuery(jpql)
						.setParameter("disc",discount )
						.setParameter("cat", category)
						.executeUpdate();
			tx.commit();
			mesg = "Applied discount to products - " + rows;
	
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}

		return mesg;

		
	}
	
public String deleteProductDetails(Long ProductId) {	
	String mesg = "deletion failed";
	
	Session session = getFactory().getCurrentSession();
	Transaction tx = session.beginTransaction();
	
	try {
		Product product = session.get(Product.class, ProductId);
		if(product != null) {
			session.delete(product);
			mesg = "product details deleted...";	
		}
		tx.commit();
		
		
	} catch (RuntimeException e) {
		
		if (tx != null)
			tx.rollback();
		
		throw e;
	}
	
	return mesg;
	
}

public String purchaseProduct(String name) {	
	String mesg = "Product purchased failed....";
	String jpql = "select p from Product p where p.name=:nm";

	Session session = getFactory().getCurrentSession();
	Transaction tx = session.beginTransaction();
	
	try {
	Product product = session.createQuery(jpql, Product.class)
				  .setParameter("nm", name)
				  .getSingleResult();
		if(product.getAvlQty() > 1) {
			product.setAvlQty(product.getAvlQty()-1);
			mesg = "Product purchased successfully....";	
		}
		tx.commit();
		
		
	} catch (RuntimeException e) {
		
		if (tx != null)
			tx.rollback();
		
		throw e;
	}
	
	return mesg;
	
}
	
	
	
	
	
	
	
	
	
	
}
