package com.online.shopping.cart.spring.learning.autowire;

import org.springframework.stereotype.Repository;

@Repository
public class AutowireImpl2 implements AutowireService{

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "Impl 2";
	}

}
