package com.dream.smartrans.dao;

import java.util.List;

import com.dream.smartrans.po.User;

public interface UserDao {

	User findUser(int type, String username, String password);

	User findById(String userId);

	String update(User user);

	String delete(String userId);

	String insert(User user);

	List<User> findAll();

}
