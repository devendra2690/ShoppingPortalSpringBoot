package com.online.shopping.cart.spring.learning.qualifier;

import org.springframework.stereotype.Repository;

@Repository("qualifierImpl2")
public class QualifierImpl2 implements QualifierService{

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "Impl 2";
	}

}
