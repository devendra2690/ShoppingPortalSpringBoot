package com.online.shopping.cart.spring.learning.restTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/resttemplate")
public class RestTemplateController {

	@Autowired
	RestTemplateService restTemplateService;
	
	@RequestMapping(value="/getpostById",method=RequestMethod.GET)
	public Posts getMethodExample() {
		
		return restTemplateService.getPostById();
	}
	
	@RequestMapping(value="/getAllPost",method=RequestMethod.GET)
	public Posts[] getListOfPosts() {
		
		return restTemplateService.getAllPost();
	}
	
	@RequestMapping(value="/")
	public Posts postObject() {
		
		//return restTemplateService.postObject();
		return null;
	}
}
