package com.splitApp.ui;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.splitApp.appProperty.AppConstants;
import com.splitApp.bean.AddNewFriendDB;
import com.splitApp.bo.UserBoImpl;

public class AddNewFriendAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	public SessionMap<String, Object> sessionMap;
	
	private String friendPhNo;
	
	public String execute(){
		
		
		String selfPhNo = (String) sessionMap.get("phNo");
		
		AddNewFriendDB addFriend = new AddNewFriendDB();
		
		addFriend.addFriend(selfPhNo, friendPhNo);
		
		return "success";
	}
	
	public void validate(){
		
		if(friendPhNo==null || friendPhNo.trim().equals("")){
			addActionError(AppConstants.PHONE_ERROR);
		}
		
		if( ! friendPhNo.trim().matches("\\d{10}") ){
			addActionError(AppConstants.PHONE_ERROR);
		}
		
		UserBoImpl user = new UserBoImpl();
		if(!user.doesUserExist(friendPhNo)){
			addActionError(AppConstants.PHONE_ERROR);
		}
		
	}
	@Override
	@SuppressWarnings("all")
	public void setSession(Map map) {
		// TODO Auto-generated method stub
		sessionMap = (SessionMap) map;
		
	}
	

	public String getFriendPhNo() {
		return friendPhNo;
	}

	public void setFriendPhNo(String friendPhNo) {
		this.friendPhNo = friendPhNo;
	}
	
	
	

}
