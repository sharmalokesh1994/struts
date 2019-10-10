package com.splitApp.ui;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.splitApp.bean.AddNewFriendDB;

public class SettelAccountAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	public SessionMap<String, Object> sessionMap;
	private String friendPhNo;
	
	public String execute(){
		
		
		String selfPhNo = (String) sessionMap.get("phNo");
		
		AddNewFriendDB addFriend = new AddNewFriendDB();
		
		addFriend.settelAcc(selfPhNo, friendPhNo);
		
		return "success";
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
