package com.online.shopping.cart.spring.learning.restTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RestTemplateServiceImpl implements RestTemplateService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Posts getPostById() {
		
		Posts post = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", Posts.class);
		return post;
	}

	@Override
	public Posts[] getAllPost() {

		Posts [] listOfPosts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", Posts[].class);
		return listOfPosts;
	}

	@Override
	public Posts getPostByIdEntity() {
		
		ResponseEntity<Posts> post = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", Posts.class);
		return post.getBody();
	}

}
