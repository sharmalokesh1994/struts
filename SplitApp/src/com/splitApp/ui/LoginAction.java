package com.splitApp.ui;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.splitApp.appProperty.AppConstants;
import com.splitApp.bo.UserBoImpl;

public class LoginAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	public SessionMap<String, Object> sessionMap;
	private String phNo;
	private String pass;
	
	
	public String execute(){
		this.sessionMap.put("phNo",phNo);
		return "success";
	}
	
	
	public void validate(){
		
		UserBoImpl user = new UserBoImpl();
		
		boolean isValidUser = false;
		
		if(phNo==null || pass == null){
			addActionError(AppConstants.AUTH_ERROR);
		}
		
		
		isValidUser = user.authenticate(phNo, pass);
		
		if(!isValidUser ){
			addActionError(AppConstants.AUTH_ERROR);
		}
		
	}
	
	
	
	
	@Override
	@SuppressWarnings("all")
	public void setSession(Map map) {
		// TODO Auto-generated method stub
		sessionMap = (SessionMap) map;
		
	}


	public String getPhNo() {
		return phNo;
	}


	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
