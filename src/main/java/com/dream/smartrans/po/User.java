package com.dream.smartrans.po;

import com.dream.smartrans.dict.UserStatus;
import com.dream.smartrans.dict.UserType;

public class User {

	public static final String SESSION_USER_KEY = "user_key_in_session";
	
	private String id;
	private String username;
	private String password;
	private UserStatus status;
	private UserType type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
