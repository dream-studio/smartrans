package com.dream.smartrans.action;

import org.james.common.utils.ajax.Reply;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 8256468859982232293L;

	public static final String JSON = "json";
	public static final String JSONP = "jsonp";

	protected Reply reply = new Reply();

	public String execute() {
		reply.setMsg("It Works!!");
		return JSON;
	}
	
	public abstract String invalidUser();
	
	protected void setSuccess(){
		this.setSuccess(0, "");
	}
	
	protected void setSuccess(String msg){
		this.setSuccess(0, msg);
	}
	
	protected void setSuccess(int status, String msg){
		reply.setCode(status);
		reply.setSuccess(true);
		reply.setMsg(msg);
	}
	
	protected void setFailure(){
		this.setFailure(999, "");
	}
	
	protected void setFailure(String msg){
		this.setFailure(999, msg);
		
	}
	
	protected void setFailure(int status, String msg){
		reply.setCode(status);
		reply.setSuccess(false);
		reply.setMsg(msg);
	}
//	
//	protected Doctor getSessionDoctor(){
//		return (Doctor) ServletActionContext.getRequest().getSession().getAttribute(Doctor.SESSION_KEY);
//	}
//	
//	protected Customer getSessionCustomer(){
//		return (Customer) ServletActionContext.getRequest().getSession().getAttribute(Customer.SESSION_KEY);
//	}
//	
//	protected User getCurrentUser(){
//		return (User) ServletActionContext.getRequest().getSession().getAttribute(User.SESSION_USER_KEY);
//	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

}
