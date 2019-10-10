package com.splitApp.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import org.apache.struts2.dispatcher.SessionMap;

public class LoginInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;
	SessionMap<String,Object> sessionMap;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invoke) throws Exception {
		// TODO Auto-generated method stub
		sessionMap= (SessionMap<String, Object>) invoke.getInvocationContext().getSession();
		Object obj = sessionMap.get("phNo");
		if(obj==null){
			return "login";
		}
		return invoke.invoke();
	}

}
