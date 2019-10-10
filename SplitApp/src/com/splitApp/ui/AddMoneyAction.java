package com.splitApp.ui;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.splitApp.bean.AddNewFriendDB;

public class AddMoneyAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	public SessionMap<String, Object> sessionMap;
	
	private String friendPhNo;
	private String des;
	private String money;
	private String paid;
	
	public String execute(){
		
		
		String selfPhNo = (String) sessionMap.get("phNo");
		
		AddNewFriendDB addFriend = new AddNewFriendDB();
		
		int money = Integer.parseInt(this.money);
		
		if(paid.equals("self")){
			addFriend.addTx(selfPhNo, friendPhNo, money,des);
		}else{
			addFriend.addTx(friendPhNo, selfPhNo, money,des);
		}
		
		
		
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


	public String getDes() {
		return des;
	}


	public void setDes(String des) {
		this.des = des;
	}


	public String getMoney() {
		return money;
	}


	public void setMoney(String money) {
		this.money = money;
	}


	public String getPaid() {
		return paid;
	}


	public void setPaid(String paid) {
		this.paid = paid;
	}
	
	
	
}
