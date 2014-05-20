package com.dream.smartrans.action.json;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;

import com.dream.smartrans.dict.UserType;
import com.dream.smartrans.po.Customer;
import com.dream.smartrans.po.User;
import com.dream.smartrans.service.SystemService;

@InterceptorRefs({ @InterceptorRef("basicStack") })
public final class SystemAction extends JsonAction {

	private static final long serialVersionUID = -4051414049841931428L;
	
	private SystemService systemService;
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
//	private CustomerService customerService;
//	private DoctorService doctorService;

	public String ping(){
		setSuccess();
		return JSON;
	}
	
	private String userName;
	private String password;
	private int type;
	
	public String login(){
		User user = systemService.login(1, userName, password);
		if (user != null){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute(User.SESSION_USER_KEY, user);
			
			switch(user.getType()){
			case DRIVER:
				// TODO add driver info
//				session.setAttribute(Driver.SESSION_KEY, doctorService.getDoctorByUserId(user.getId()));
				break;
			case CUSTOMER:
				// TODO add customer info
//				session.setAttribute(Customer.SESSION_KEY, customerService.getCustomerByUserId(user.getId()));
				break;
			default:
				break;	
			}
			
			setSuccess("login success!");
		}else{
			setFailure("Invalid username or password!");
		}
		return JSON;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
