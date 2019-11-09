package com.splitApp.bean;

import java.util.ArrayList;
import java.util.List;

import com.splitApp.dao.beans.FriendsEntity;
import com.splitApp.dao.beans.GroupEntity;
import com.splitApp.dao.beans.GroupFriendsEntity;
import com.splitApp.daos.UniversalDaoImpl;

public class CreateGroup {
	
	UniversalDaoImpl uni = new UniversalDaoImpl();
	
	@SuppressWarnings("all")
	public void addGroup(String selfPhNo,List<String> friendsList, String groupName){
		
		
		
		
		GroupEntity groupEntity = new GroupEntity();
		
		groupEntity.setGroupName(groupName);
		
		int groupId = uni.addGroup(groupEntity);
		
		groupEntity.setGroupId(groupId);
		
		GroupFriendsEntity groupFriendsEntity = new GroupFriendsEntity();
		
		groupFriendsEntity.setGroupId(groupEntity);
		
		friendsList.forEach((friendPhNo)->{
			addFriend(selfPhNo,friendPhNo);
			
			List<FriendsEntity> list = (List<FriendsEntity>) uni.getFreindList(FriendsEntity.class,selfPhNo, friendPhNo);
			
			groupFriendsEntity.setFriendsEntityId(list.get(0));
			
			uni.addObject(groupFriendsEntity);
			
			list = (List<FriendsEntity>) uni.getFreindList(FriendsEntity.class, friendPhNo,selfPhNo);
			
			groupFriendsEntity.setFriendsEntityId(list.get(0));
			
			uni.addObject(groupFriendsEntity);
			
		});
		
		
		
		
	}
	
	
	public void addFriend(String selfPhNo,String friendPhNo) {
		
		FriendsEntity friend = new FriendsEntity();
		friend.setBalance(0);
		friend.setFriendPhNo(friendPhNo);
		friend.setSelfPhNo(selfPhNo);
		
		FriendsEntity oppFriend = new FriendsEntity();
		oppFriend.setBalance(0);
		oppFriend.setFriendPhNo(selfPhNo);
		oppFriend.setSelfPhNo(friendPhNo);
		
		
		
		List<FriendsEntity> list = (List<FriendsEntity>) uni.getFreindList(FriendsEntity.class,selfPhNo, friendPhNo);
		
		if(list==null || list.size()==0){
			uni.addObject(friend);
			uni.addObject(oppFriend);
		}
	}
	
	
	

}
