package com.splitApp.ui;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	public SessionMap<String, Object> sessionMap;
	
	public String execute(){
		
		sessionMap.invalidate();
		
		return "success";
	}
	
	@Override
	@SuppressWarnings("all")
	public void setSession(Map map) {
		// TODO Auto-generated method stub
		sessionMap = (SessionMap) map;
		
	}

}
