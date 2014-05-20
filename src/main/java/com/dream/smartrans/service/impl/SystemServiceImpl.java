package com.dream.smartrans.service.impl;

import com.dream.smartrans.dao.UserDao;
import com.dream.smartrans.po.User;
import com.dream.smartrans.service.SystemService;

public class SystemServiceImpl implements SystemService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User login(int type, String username, String pwd){
		return userDao.findUser(type, username, pwd);
	}
}
