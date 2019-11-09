package com.splitApp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.splitApp.bean.CreateGroup;

public class AddFriendInGroupAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	public SessionMap<String, Object> sessionMap;
	
	
	private List<String> friendPhNo = new ArrayList<>();
	private String groupName;
	
	public String execute(){
		String selfPhNo = (String) sessionMap.get("phNo");
		
		CreateGroup createGroup = new CreateGroup();
		
		createGroup.addGroup(selfPhNo, friendPhNo,groupName);
		
		return "success";
	}
	
	
	@Override
	@SuppressWarnings("all")
	public void setSession(Map map) {
		// TODO Auto-generated method stub
		sessionMap = (SessionMap) map;
		
	}


	public List<String> getFriendPhNo() {
		return friendPhNo;
	}


	public void setFriendPhNo(List<String> friendPhNo) {
		this.friendPhNo = friendPhNo;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	

	
}
