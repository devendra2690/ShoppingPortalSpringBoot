package com.online.shopping.cart.spring.learning.restTemplate;

import java.util.List;

public interface RestTemplateService {

	public Posts getPostById();
	
	public Posts getPostByIdEntity();

	public Posts[] getAllPost();
}
