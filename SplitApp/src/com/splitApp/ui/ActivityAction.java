package com.splitApp.ui;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.splitApp.dao.beans.ActivityEntity;
import com.splitApp.daos.UniversalDaoImpl;

public class ActivityAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	public SessionMap<String, Object> sessionMap;
	
	private List<ActivityEntity> activities;
	
	@SuppressWarnings("unchecked")
	public String execute(){
	
		try{
			String phNo = (String) sessionMap.get("phNo");
			activities = (List<ActivityEntity>)UniversalDaoImpl.retrieveValueByField(ActivityEntity.class, "selfPhNo", phNo);
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


	public List<ActivityEntity> getActivities() {
		return activities;
	}


	public void setActivities(List<ActivityEntity> activities) {
		this.activities = activities;
	}
	
	

}
