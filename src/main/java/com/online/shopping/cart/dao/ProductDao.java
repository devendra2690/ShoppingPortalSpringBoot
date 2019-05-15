package com.online.shopping.cart.dao;

import java.math.BigInteger;
import java.util.List;

import com.online.shopping.cart.bean.Categories;
import com.online.shopping.cart.bean.OrderCart;
import com.online.shopping.cart.bean.Product;

public interface ProductDao {

	public List<Categories> listAllCategories();
	
	public Product validateProductName(Product product);
	
	public Product saveProduct(Product product);
	
	public List<Product> fetchAllProduct();
	
	public Product getProductById(BigInteger productId);
	
	public Product updateProductDetails(Product product); 
	
	public List<Product> deleteProductByID(BigInteger productId);
	
	public String saveOrder(OrderCart orderCart);

	public List<Product> fetchAllProductsByType(String productType);
}
