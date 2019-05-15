package com.online.shopping.cart.spring.learning.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.online.shopping.cart.spring.learning.modal.attribute.methodlevel.User;

@Repository
public class EnableCachingServiceImpl implements IEnableChaching{

	/**
	 * 
	 * @Cacheable will tell Spring to cache data in userRecord and return record if it gets same url request.
	 * Code inside try block only gets executed when method receive different ID.
	 * 
	 */
	@Cacheable("userRecord")
	@Override
	public User getStudenyID(int id) {
		
		try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
		
		User user = new User();
		user.setId(id);
		return user;
	}
}
