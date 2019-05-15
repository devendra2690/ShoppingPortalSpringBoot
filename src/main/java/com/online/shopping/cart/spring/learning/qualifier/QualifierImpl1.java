package com.online.shopping.cart.spring.learning.qualifier;

import org.springframework.stereotype.Repository;

@Repository("qualifierImpl1")
public class QualifierImpl1 implements QualifierService{

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "Impl 1";
	}

	
}
