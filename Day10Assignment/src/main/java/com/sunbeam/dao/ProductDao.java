package com.sunbeam.dao;

import java.util.List;


import com.sunbeam.entities.Category1;
import com.sunbeam.entities.Product;

public interface ProductDao {
	String addProduct(Product product);
	Product getProductDetailsById(Long productId );
	List<Product> getProductByPriceAndCategory(double strtPrice, double endPrice, Category1 category);
	String applyDiscount(Category1 category,double discount);
	String deleteProductDetails(Long ProductId);
	String purchaseProduct(String name);

}
