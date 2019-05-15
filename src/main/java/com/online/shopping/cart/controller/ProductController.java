
package com.online.shopping.cart.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.cart.bean.Categories;
import com.online.shopping.cart.bean.OrderCart;
import com.online.shopping.cart.bean.Product;
import com.online.shopping.cart.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
public class ProductController {

	@Autowired 
	ProductService productService;
	
	@GetMapping("/categories")
	public List<Categories> listAllCategories() {
		
		return productService.listAllCategories();
	}
	
	@PostMapping("/validateProductName")
	public Product validateProduct(@RequestBody Product product) {
		
		return productService.validateProduct(product);
	}
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		
		return productService.saveProduct(product);
	}
	
	@GetMapping("/fetchAllProduct")
	public List<Product> fetchAllProductList() {
		
		return productService.fetchAllProduct();
	}
	
	@GetMapping("/fetchProducts")
	public List<Product> fetchAllProductList(@RequestParam("product") String productType) {
		
		System.out.println("Product Type "+productType);
		
		return productService.fetchAllProductsByType(productType);
	}
	
	@GetMapping("/getProductByID/{id}")
	public Product getProductByID(@PathVariable("id") BigInteger productid) {
		
		return productService.getProductById(productid);
	}
	
	@PutMapping("/updateProductDetails")
	public Product updateProductDetails(@RequestBody Product product) {
		
		return productService.updateProductDetails(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Product> deleteProductByID(@PathVariable("id") BigInteger productid) {
		
		return productService.deleteProductByID(productid);
	}
	
	@PostMapping("/saveOrder")
	public String saveOrder(@RequestBody OrderCart orderCart) {
		
		System.out.println("");
		return "Success";
	}
}
 