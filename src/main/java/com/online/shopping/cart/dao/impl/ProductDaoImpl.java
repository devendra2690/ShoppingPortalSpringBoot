package com.online.shopping.cart.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shopping.cart.bean.Categories;
import com.online.shopping.cart.bean.OrderCart;
import com.online.shopping.cart.bean.Product;
import com.online.shopping.cart.dao.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao{


	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Categories> listAllCategories() {

		try {
			
			Session session = getSession();		
			Query<Categories> query = session.createQuery("from Categories");
			
			List<Categories> categoryList = query.getResultList();		
			return categoryList;
		}catch(Exception exception) {
			
			exception.printStackTrace();
			return new ArrayList<Categories>();
		}		
	}
	
	@Override
	public Product validateProductName(Product product) {
		
		try {
			
			Session session = getSession();
			Query<Product> query = session.createQuery("from Product where title=:title and category=:category");
			query.setParameter("category", product.getCategory());
			query.setParameter("title", product.getTitle());
			
			List<Product> productList = query.getResultList();			
			return productList.size() > 0 ? productList.get(0):new Product();
		}catch(Exception exception) {
			
			exception.printStackTrace();
			return null;
		}		
	}
	
	@Override
	@Transactional
	public Product saveProduct(Product product) {
		
	    try {
	    	
	    	Session session = getSession();		
			
			Query<Categories> query = session.createNativeQuery("INSERT INTO Product (id,title, price,category_name,image_url) VALUES(?,?,?,?,?)");
			query.setParameter(1, System.currentTimeMillis());
			query.setParameter(2, product.getTitle());
			query.setParameter(3, product.getPrice());
			query.setParameter(4, product.getCategory());
			query.setParameter(5, product.getImageUrl());		
			query.executeUpdate();
			
			/*product.setId(BigInteger.valueOf(System.currentTimeMillis()));
			session.saveOrUpdate(product);*/		    	
	    }catch(Exception exception) {
	    	
	    	exception.printStackTrace();
	    	return new Product();
	    }		

		return product;
	}

	
	@Override
	public List<Product> fetchAllProduct() {

		try {
			
			Session session = getSession();
			
			Query<Product> query = session.createQuery("from Product");
			
			List<Product> productsList = query.getResultList();
			return productsList;
		}catch(Exception exception) {
		
			exception.printStackTrace();
			return new ArrayList<Product>();
		}
	}
	
	@Override
	public Product getProductById(BigInteger productId) {

		try {
			
			Session session = getSession();			
			
			/**
			 *  Another way to get data from DB
			 * 
			 *  Query<Product> query = session.createQuery("from Product where id=:productId");
			    query.setParameter("productId", productId);
			    List<Product> productList = query.getResultList();
			 * 
			 * 
			 */
			
			Product product = session.get(Product.class, productId);
			return product != null ? product : new Product();
		}catch(Exception exception) {
			
			exception.printStackTrace();
			return new Product();
		}
	}
	
	@Override
	@Transactional
	public Product updateProductDetails(Product product) {

		try {
			
			Session session = getSession();
			Query<Categories> query = session.createNativeQuery("UPDATE Product SET title =:title, category_name =:category, price =:price, image_url =:imageUrl where id =:id");
			query.setParameter("title", product.getTitle());
			query.setParameter("category", product.getCategory());
			query.setParameter("price", product.getPrice());
			query.setParameter("imageUrl", product.getImageUrl());
			query.setParameter("id", product.getId());
			
			query.executeUpdate();			
		}catch (Exception exceptoion) {
			
			exceptoion.printStackTrace();
			return new Product();
		}	
		
		return product;
	}
	
	@Override
	@Transactional
	public List<Product> deleteProductByID(BigInteger productId) {
		
         try {
			
			Session session = getSession();
			Query<Categories> query = session.createNativeQuery("DELETE FROM Product where id =:id");
			query.setParameter("id", productId);
			query.executeUpdate();	
			
			List<Product> productList = fetchAllProduct();			
			return productList.size() > 0 ? productList : new ArrayList<Product>();
		}catch (Exception exceptoion) {
			
			exceptoion.printStackTrace();
			return new ArrayList<Product>();
		}	
	}
	
	@Override
	public String saveOrder(OrderCart orderCart) {

		Session session = getSession();
		
		return null;
	}
	
	private Session getSession() {
			
		Session session = entityManager.unwrap(Session.class);
		return session;
	}

	@Override
	public List<Product> fetchAllProductsByType(String productType) {
        
		try {
			
			Session session = getSession();
			Query<Product> query;
			if(productType.equals("All")) {				
				query = session.createQuery("from Product");
			}else{
				
				query = session.createQuery("from Product where category=:category");
				query.setParameter("category", productType);
			}			
			
			List<Product> productsList = query.getResultList();
			return productsList;
		}catch(Exception exception) {
		
			exception.printStackTrace();
			return new ArrayList<Product>();
		}
	}

	
}
