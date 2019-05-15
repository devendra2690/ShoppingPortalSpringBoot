package com.online.shopping.cart.spring.learning.request.response.body;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/requestAndResponse")
public class RequestAndResponseBodyController {

	/**
	 * The @RestController annotation in Spring MVC is nothing but a combination of @Controller and @ResponseBody annotation.

       
	 * @param productObj
	 * @return
	 */
	@RequestMapping(value="/getProduct",method=RequestMethod.POST)
	public  Product getProductList(@RequestBody Product productObj) {
		
		Product product = new Product();
		product.setProductID(productObj.getProductID());
		product.setProductName("Apple");
		product.setProductCategory("Fruits");
		
		return product;
	}
}
