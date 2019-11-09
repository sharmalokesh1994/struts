package com.splitApp.bean;

import java.util.Date;
import java.util.List;

import com.splitApp.dao.beans.ActivityEntity;
import com.splitApp.dao.beans.FriendsEntity;
import com.splitApp.daos.UniversalDaoImpl;

public class AddNewFriendDB {
	
	@SuppressWarnings("all")
	public void addFriend(String selfPhNo,String friendPhNo){
		FriendsEntity friend = new FriendsEntity();
		friend.setBalance(0);
		friend.setFriendPhNo(friendPhNo);
		friend.setSelfPhNo(selfPhNo);
		
		FriendsEntity oppFriend = new FriendsEntity();
		oppFriend.setBalance(0);
		oppFriend.setFriendPhNo(selfPhNo);
		oppFriend.setSelfPhNo(friendPhNo);
		
		UniversalDaoImpl uni = new UniversalDaoImpl();
		
		List<FriendsEntity> list = (List<FriendsEntity>) uni.getFreindList(FriendsEntity.class,selfPhNo, friendPhNo);
		
		if(list==null || list.size()==0){
			uni.addObject(friend);
			uni.addObject(oppFriend);
		}
		
	}
	
	
	@SuppressWarnings("all")
	public void addTx(String selfPhNo,String friendPhNo, int money, String des){
		FriendsEntity friend = new FriendsEntity();
			
		FriendsEntity oppFriend = new FriendsEntity();
		
		UniversalDaoImpl uni = new UniversalDaoImpl();
		
		List<FriendsEntity> list1 = (List<FriendsEntity>) uni.getFreindList(FriendsEntity.class,selfPhNo, friendPhNo);
		List<FriendsEntity> list2 = (List<FriendsEntity>) uni.getFreindList(FriendsEntity.class,friendPhNo,selfPhNo);
		
		if(list1!=null && list1.size()!=0){
			
			friend = (FriendsEntity)list1.get(0);
			
			oppFriend = (FriendsEntity)list2.get(0);
			
			int selfBalance = friend.getBalance() + money;
			
			friend.setBalance(selfBalance);
			
			selfBalance = oppFriend.getBalance() - money;
			
			oppFriend.setBalance(selfBalance);
			
			uni.updateObject(friend);
			uni.updateObject(oppFriend);
			
			//self to friend
			ActivityEntity activity1 = new ActivityEntity();
			//friend to self
			ActivityEntity activity2 = new ActivityEntity();
			
			activity1.setBalance(money);
			activity1.setDate(new Date());
			activity1.setDescrition(des);
			activity1.setFriendsEntityId(friend);
			
			
			activity2.setBalance(-money);
			activity2.setDate(new Date());
			activity2.setDescrition(des);
			activity2.setFriendsEntityId(oppFriend);
			
			
			uni.addObject(activity1);
			uni.addObject(activity2);
			 
		}
		
	}
	
	
	@SuppressWarnings("all")
	public void settelAcc(String selfPhNo,String friendPhNo){
		FriendsEntity friend = new FriendsEntity();
			
		FriendsEntity oppFriend = new FriendsEntity();
		
		UniversalDaoImpl uni = new UniversalDaoImpl();
		
		List<FriendsEntity> list1 = (List<FriendsEntity>) uni.getFreindList(FriendsEntity.class,selfPhNo, friendPhNo);
		List<FriendsEntity> list2 = (List<FriendsEntity>) uni.getFreindList(FriendsEntity.class,friendPhNo,selfPhNo);
		
		if(list1!=null && list1.size()!=0){
			
			friend = (FriendsEntity)list1.get(0);
			
			oppFriend = (FriendsEntity)list2.get(0);
			
			
			
			friend.setBalance(0);
			
			oppFriend.setBalance(0);
			
			uni.updateObject(friend);
			uni.updateObject(oppFriend);
			
			
			//self to friend
			ActivityEntity activity1 = new ActivityEntity();
			//friend to self
			ActivityEntity activity2 = new ActivityEntity();
			
			activity1.setBalance(0);
			activity1.setDate(new Date());
			activity1.setDescrition("Settle");
			activity1.setFriendsEntityId(friend);
			
			
			activity2.setBalance(0);
			activity2.setDate(new Date());
			activity2.setDescrition("Settle");
			activity2.setFriendsEntityId(oppFriend);
			uni.addObject(activity1);
			uni.addObject(activity2);

			
			 
		}
		
	}
	
	

}
