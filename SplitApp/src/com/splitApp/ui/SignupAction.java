package com.splitApp.ui;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.splitApp.appProperty.AppConstants;
import com.splitApp.bo.UserBo;
import com.splitApp.bo.UserBoImpl;

public class SignupAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	public SessionMap<String, Object> sessionMap;
	
	private String fName;
	private String lName;
	private String pass;
	private String email;
	private String phNo;
	private String cnfPass;
	
	public String execute(){
		
		System.out.println("fNmae: "+fName);
		System.out.println("lNmae: "+lName);
		System.out.println("pass: "+pass);
		System.out.println("email: "+email);
		System.out.println("phNo: "+phNo);
		
		UserBo user = new UserBoImpl();
		user.registerUser(phNo, fName, lName, pass, email);
		return "success";
	}
	
	
	
	
	
	public void validate(){
		
		if(phNo==null || phNo.trim().equals("")){
			addActionError(AppConstants.PHONE_ERROR);
		}
		
		if( ! phNo.trim().matches("\\d{10}") ){
			addActionError(AppConstants.PHONE_ERROR);
		}
		
		if(pass==null || !pass.equals(cnfPass)){
			addActionError(AppConstants.PASS_ERROR);
		}
		UserBoImpl user = new UserBoImpl();
		if(user.doesUserExist(phNo)){
			addActionError(AppConstants.USER_ERROR);
		}
		
	}
	
	
	@Override
	@SuppressWarnings("all")
	public void setSession(Map map) {
		// TODO Auto-generated method stub
		sessionMap = (SessionMap) map;
		
	}


	public String getFName() {
		return fName;
	}


	public void setFName(String fName) {
		this.fName = fName;
	}


	public String getLName() {
		return lName;
	}


	public void setLName(String lName) {
		this.lName = lName;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhNo() {
		return phNo;
	}


	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}


	public String getCnfPass() {
		return cnfPass;
	}


	public void setCnfPass(String cnfPass) {
		this.cnfPass = cnfPass;
	}

	
}
