package com.dream.smartrans.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dream.smartrans.action.BaseAction;
import com.dream.smartrans.action.api.APIAction;
import com.dream.smartrans.po.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthInterceptor implements Interceptor {

	private static final long serialVersionUID = -7640005163717210819L;

	@Override
	public void destroy() {}

	@Override
	public void init() {}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = "json";
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Object action = invocation.getAction();
		
		User u = (User) request.getSession()
				.getAttribute(User.SESSION_USER_KEY);
		if (u == null) {
			BaseAction ba = (BaseAction) action;
			if (ba.testUser()){
				result = invocation.invoke();
			}else{
				result = ba.invalidUser();
			}
		} else {
			result = invocation.invoke();
		}
		
		result = invocation.invoke();
		
		return result;
	}

}
