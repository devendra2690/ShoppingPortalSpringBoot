package com.online.shopping.cart.service;

import java.math.BigInteger;
import java.util.List;

import com.online.shopping.cart.bean.Categories;
import com.online.shopping.cart.bean.OrderCart;
import com.online.shopping.cart.bean.Product;

public interface ProductService {
	
  public List<Categories> listAllCategories();
  
  public Product validateProduct(Product product);
  
  public Product saveProduct(Product product);
  
  public List<Product> fetchAllProduct();
  
  public List<Product> fetchAllProductsByType(String productType);
  
  public Product getProductById(BigInteger productID);
  
  public Product updateProductDetails(Product product);
  
  public List<Product> deleteProductByID(BigInteger productID);
  
  public String saveOrder(OrderCart orderCart);
}
