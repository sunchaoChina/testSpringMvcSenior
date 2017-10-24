package com.homedate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedate.dao.UserDao;
import com.homedate.pojo.User;
import com.homedate.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(int userId) {
		User result = userDao.selectByPrimaryKey(userId);
		return result;
	}
}
