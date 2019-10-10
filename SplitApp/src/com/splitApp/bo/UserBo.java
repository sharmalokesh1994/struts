package com.splitApp.bo;

public interface UserBo {
	
	void registerUser(String phNo, String fName, String lName, String pass, String email);
	boolean authenticate(String phNo,String pass);

}
