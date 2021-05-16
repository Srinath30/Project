package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Product;

public interface ProductDao {

	Product getProductById(int productId);

	void deleteProduct(int productId);

	void addProduct(Product product);

	void updateProduct(Product product);

	List<Product> getAllProducts();
}
