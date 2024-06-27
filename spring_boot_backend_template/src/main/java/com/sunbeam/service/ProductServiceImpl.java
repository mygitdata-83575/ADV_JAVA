package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService  {

	@Autowired
	private ProductDao productDao;
	@Override
	public Product addNewProduct(Product product) {
		return productDao.save(product);
		
	}
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}
	
	
	@Override
	public Product getProductDetails(Long productId) {
		
		return productDao.findById(productId)
				.orElseThrow(()-> new ResourceNotFoundException("Invalid Category ID!!!!"));
	}
	@Override
	public ApiResponse updateProductDetails(Long productId, Product existingProduct) {
		String mesg="Product Updation Failed : invalid id !!!!";
		
		if(productDao.existsById(productId)) {
			productDao.save(existingProduct);
			mesg="Updated product details";
		}
		return new ApiResponse(mesg);
	}
	@Override
	public ApiResponse deleteProductDetails(Long productId) {
		if(productDao.existsById(productId)) {
			productDao.deleteById(productId);
			return new ApiResponse("Delete product details !");
		}
		return new ApiResponse("Category Deletion failed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
