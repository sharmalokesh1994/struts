package com.splitApp.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.splitApp.dao.beans.ActivityEntity;
import com.splitApp.dao.beans.FriendsEntity;
import com.splitApp.dao.beans.GroupEntity;
import com.splitApp.dao.beans.GroupFriendsEntity;
import com.splitApp.dao.beans.UserEntity;
import com.splitApp.daos.UniversalDaoImpl;

public class Test {
	
	public static void main(String args[]){
		
		UniversalDaoImpl uni = new UniversalDaoImpl();
		
		UserEntity user = new UserEntity();
		user.setEmail("aa@aa.aa");
		user.setPhNo("123");
		user.setfName("fName");
		user.setlName("lName");
		user.setPass("123");
		
		
		
		
		
		FriendsEntity friend = new FriendsEntity();
		
		friend.setBalance(0);
		friend.setSelfPhNo("121");
		friend.setFriendPhNo("211");
		//friend.setElementsId(1);
		
		FriendsEntity friend1 = new FriendsEntity();
		
		friend1.setBalance(0);
		friend1.setSelfPhNo("1211");
		friend1.setFriendPhNo("2111");
		
		uni.addObject(friend);
		uni.addObject(user);
		uni.addObject(friend1);
		
		ActivityEntity ac = new ActivityEntity();
		
		ac.setBalance(0);
		ac.setDescrition("abc");
		ac.setFriendsEntityId(friend);
		
		
		ac.setDate(new Date());
		
		uni.addObject(ac);
		
		String phNo = "121";
		
		List<ActivityEntity> activities = new ArrayList<>();
		
		List<Object[]> list = (List<Object[]>)UniversalDaoImpl.retrieveActivityList(phNo);
		
		
		
		//activities
		
		list.forEach((l)->{
			activities.add((ActivityEntity)l[0]);
			
		});
		
		
		List<String> friendPhNo = new ArrayList<>();
		
		List<FriendsEntity> list1 = (List<FriendsEntity>) uni.getFreindList(FriendsEntity.class,"121", "211");
		
		friend = list1.get(0);
		
		list1 = (List<FriendsEntity>) uni.getFreindList(FriendsEntity.class,"1211", "2111");
		friend1 = list1.get(0);
		
		GroupEntity g = new GroupEntity();
		g.setBalance(0);
		g.setGroupName("test");
//		g.getFriendsEntityId().add(friend);
//		g.getFriendsEntityId().add(friend1);
		g.setGroupId(1);
		uni.addObject(g);
		
		GroupEntity g1 = new GroupEntity();
		g1.setBalance(0);
		g1.setGroupName("test");
//		g1.getFriendsEntityId().add(friend);
//		g1.getFriendsEntityId().add(friend1);
		g1.setGroupId(2);
		uni.addObject(g1);
		
		
		GroupFriendsEntity gf = new GroupFriendsEntity();
		
		gf.setFriendsEntityId(friend);
		gf.setGroupId(g);
		uni.addObject(gf);
		
		System.out.println(activities.get(0).getFriendsEntityId().getFriendPhNo() );
		
		
		
		
	}

}
