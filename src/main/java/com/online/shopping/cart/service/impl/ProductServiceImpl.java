package com.online.shopping.cart.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.cart.bean.Categories;
import com.online.shopping.cart.bean.OrderCart;
import com.online.shopping.cart.bean.Product;
import com.online.shopping.cart.dao.ProductDao;
import com.online.shopping.cart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Categories> listAllCategories() {

		List<Categories> categoryList = productDao.listAllCategories(); 
		return categoryList;
	}

	@Override
	public Product validateProduct(Product product) {

		Product resultObj = productDao.validateProductName(product);
		return resultObj;
	}

	@Override
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}

	@Override
	public List<Product> fetchAllProduct() {
		return productDao.fetchAllProduct();
	}

	@Override
	public Product getProductById(BigInteger productID) {
		return productDao.getProductById(productID);
	}

	@Override
	public Product updateProductDetails(Product product) {
		return productDao.updateProductDetails(product);
	}

	@Override
	public List<Product> deleteProductByID(BigInteger productID) {
		return productDao.deleteProductByID(productID);
	}

	@Override
	public String saveOrder(OrderCart orderCart) {
		return null;
	}

	@Override
	public List<Product> fetchAllProductsByType(String productType) {
		// TODO Auto-generated method stub
		return productDao.fetchAllProductsByType(productType);
	}	
}
