package com.sunbeam.dao;

import java.util.List;


import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {
	String addProduct(Product product);
	Product getProductDetailsById(Long productId );
	List<Product> getProductByPriceAndCategory(double strtPrice, double endPrice, Category category);
	String applyDiscount(Category category,double discount);
	String deleteProductDetails(Long ProductId);
	String purchaseProduct(String name);

}
