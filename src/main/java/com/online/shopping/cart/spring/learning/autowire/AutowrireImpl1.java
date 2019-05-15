package com.online.shopping.cart.spring.learning.autowire;

import org.springframework.stereotype.Repository;

@Repository
public class AutowrireImpl1 implements AutowireService{

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "Impl 1";
	}

	
}
