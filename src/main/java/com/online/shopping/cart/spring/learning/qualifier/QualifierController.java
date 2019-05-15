package com.online.shopping.cart.spring.learning.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qualifier")
public class QualifierController {

	/**
	 * 
	 * Autowire by using qualifier
	 * 
	 * Two implementation available for AutowireService
	 * 
	 * So we are Autowiring by using qualifier by providing qualifier name provided on class level of Implementation
	 * 
	 */
	@Autowired
	@Qualifier("qualifierImpl2")
	QualifierService qualifierService;
	
	@RequestMapping(value="/qualifierExample",method=RequestMethod.GET)
	public String getAutowrireResult() {
		
		return qualifierService.getValue();
	}
}
