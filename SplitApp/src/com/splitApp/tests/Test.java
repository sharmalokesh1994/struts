package com.splitApp.tests;

import java.util.Date;

import com.splitApp.dao.beans.ActivityEntity;
import com.splitApp.dao.beans.FriendsEntity;
import com.splitApp.dao.beans.UserEntity;
import com.splitApp.daos.UniversalDaoImpl;

public class Test {
	
	public static void main(String args[]){
		UserEntity user = new UserEntity();
		user.setEmail("aa@aa.aa");
		user.setPhNo("123");
		user.setfName("fName");
		user.setlName("lName");
		user.setPass("123");
		
		UniversalDaoImpl uni = new UniversalDaoImpl();
		
		
		
		FriendsEntity friend = new FriendsEntity();
		
		friend.setBalance(0);
		friend.setSelfPhNo("121");
		friend.setFriendPhNo("211");
		//friend.setElementsId(1);
		
//		uni.addObject(friend);
//		uni.addObject(user);
		
		ActivityEntity ac = new ActivityEntity();
		
		ac.setBalance(0);
		ac.setDescrition("abc");
		ac.setFriendPhNo("12");
		ac.setSelfPhNo("12");
		ac.setDate(new Date());
		
		uni.addObject(ac);
		
	}

}
