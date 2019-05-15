package com.online.shopping.cart.spring.learning.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.cart.spring.learning.modal.attribute.methodlevel.User;

@RestController
@RequestMapping(value="/enabelCaching")
public class EnableCachineController {

	
	@Autowired
	IEnableChaching ienableCaching;
	
	@RequestMapping(value="/url1/{id}")
	public String enableCaching(@PathVariable("id") int id) {
		
		User user = ienableCaching.getStudenyID(id);
		
		return "User id is "+user.getId();
	}
}
