package com.online.shopping.cart.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shopping.cart.bean.User;
import com.online.shopping.cart.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public User validateUser(User user) {
		
		Session session = getSession();
		
		org.hibernate.query.Query<User> query = session.createQuery("from User where email_id=:emailId and password=:password");
		query.setParameter("emailId", user.getEmailid());
		query.setParameter("password", user.getPassword());
		
		List<User> resultObj = query.getResultList();
		
		return resultObj.size() != 0 ? resultObj.get(0) :new User();
	}

	
	private Session getSession() {
		
		Session session = entityManager.unwrap(Session.class);
		return session;
	}
	
}
