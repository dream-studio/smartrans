package com.dream.smartrans.action.api;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.james.common.utils.ajax.Reply;

import com.dream.smartrans.action.BaseAction;


@Results({ @Result(name = "json", type = "json", params = { "root", "reply" }) })
public class APIAction extends BaseAction {
	private static final long serialVersionUID = 8256468859982232293L;

	public static final String JSON = "json";
	
	private int type;
	private String username;
	private String password;
	
	@Override
	public String invalidUser() {
		this.setFailure("Invalid User!");
		return JSON;
	}

	public String execute() {
		reply.setMsg("It Works!!");
		return JSON;
	}
	
	public boolean testUser(){
		return false;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
