package com.online.shopping.cart.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shopping.cart.bean.User;
import com.online.shopping.cart.dao.UserDao;
import com.online.shopping.cart.service.UserService;

@Repository
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	@Transactional
	public User validateUser(User user) {
		
		return userDao.validateUser(user);
	}

	
}
