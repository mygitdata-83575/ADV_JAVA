package com.sunbeam.dao;

import java.io.Serializable;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;


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
	
}
