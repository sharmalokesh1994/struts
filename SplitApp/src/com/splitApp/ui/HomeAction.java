package com.splitApp.ui;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.splitApp.dao.beans.FriendsEntity;
import com.splitApp.daos.UniversalDaoImpl;

public class HomeAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	public SessionMap<String, Object> sessionMap;
	
	private List<FriendsEntity> friends;
	
	
	@SuppressWarnings("unchecked")
	public String execute(){
	
		try{
			String phNo = (String) sessionMap.get("phNo");
			friends = (List<FriendsEntity>)UniversalDaoImpl.retrieveValueByField(FriendsEntity.class, "selfPhNo", phNo);
		}catch(Exception e){
			System.out.println(e);
		}
		
		return "success";
	}
	
	
	@Override
	@SuppressWarnings("all")
	public void setSession(Map map) {
		// TODO Auto-generated method stub
		sessionMap = (SessionMap) map;
		
	}


	public List<FriendsEntity> getFriends() {
		return friends;
	}


	public void setFriends(List<FriendsEntity> friends) {
		this.friends = friends;
	}
	
	
	

}
