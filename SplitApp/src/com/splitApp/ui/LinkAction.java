package com.splitApp.ui;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LinkAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	public SessionMap<String, Object> sessionMap;
	
	public String login(){
		
		String phNo = null;
		
		Object object = sessionMap.get("phNo");
		
		if(object!=null){
			phNo = (String) object;
		}
		
		if(phNo !=null ){
			return "home";
		}
		
		return "login";
	}

	@Override
	@SuppressWarnings("all")
	public void setSession(Map map) {
		// TODO Auto-generated method stub
		sessionMap = (SessionMap) map;
		
	}

}
