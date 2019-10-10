package com.splitApp.bo;

import com.splitApp.dao.beans.UserEntity;
import com.splitApp.daos.UniversalDao;
import com.splitApp.daos.UniversalDaoImpl;

public class UserBoImpl implements UserBo{
	
	

	@Override
	public void registerUser(String phNo, String fName, String lName, String pass, String email) {
		// TODO Auto-generated method stub
		
		UserEntity user = new UserEntity();
		user.setPhNo(phNo);
		user.setfName(fName);
		user.setlName(lName);
		user.setPass(pass);
		user.setEmail(email);
		
		System.out.println("pass : " + pass);
		
		UniversalDao uni = new UniversalDaoImpl();
		uni.addObject(user);
		
	}
	
	public boolean authenticate(String phNo,String pass){
		
		UniversalDaoImpl uni = new UniversalDaoImpl();
		
		System.out.println("Ph_NO : "+phNo);
		
		UserEntity user = (UserEntity) uni.lookup(UserEntity.class, "phNo", phNo);
		if(user==null){
			return false;
		}else{
			
			String realPass = user.getPass();
			
			if( !realPass.equals(pass) ){
				return false;
			}
			
			return true;
		}
		
	}
	
	public boolean doesUserExist(String phNo) {
		
		UniversalDaoImpl uni = new UniversalDaoImpl();
		UserEntity user = (UserEntity) uni.lookup(UserEntity.class, "phNo", phNo);
		
		if(user != null)
		{
			return true;
		}
		
		return false;
	}

}
