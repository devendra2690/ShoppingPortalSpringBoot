package com.online.shopping.cart.spring.learning.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autowire")
public class AutowireTryController {

	/**
	 * 
	 * Autowire by Name
	 * 
	 * Two implementation available for AutowireService
	 * 
	 * So we are Autowiring by Name by providing  autowrireImpl1 which is name of one of the implementation
	 * 
	 */
	@Autowired
	AutowireService autowrireImpl1;
	
	@RequestMapping(value="/autowireExample",method=RequestMethod.GET)
	public String getAutowrireResult() {
		
		return autowrireImpl1.getValue();
	}
}
