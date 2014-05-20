package com.dream.smartrans.service;

import com.dream.smartrans.po.User;

public interface SystemService {

	User login(int type, String username, String pwd);

}
