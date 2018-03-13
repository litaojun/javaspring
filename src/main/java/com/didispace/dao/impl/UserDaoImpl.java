package com.didispace.dao.impl;

import org.springframework.stereotype.Repository;

import com.didispace.dao.UserDao;
import com.didispace.web.User;
@Repository("UserDaoTest")   
public class UserDaoImpl implements UserDao {

	@Override
	public User getUserByIdFromDB(String id) 
	{
		// TODO Auto-generated method stub
		User user= new User();
		user.setAge(19);
		user.setBirthday("2011-1-1");
		user.setPassword("111111");
		user.setUsername("chencong");
		user.setSex("1");
		return user;
	}

}
