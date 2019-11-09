package com.splitApp.dao.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.splitApp.appProperty.AppConstants;

@Entity
@Table(name="group_details", schema=AppConstants.SCHEMA_NAME)
public class GroupEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="groupId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer groupId;
	
//	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
//	@JoinTable(name = "group_details_friends_details", joinColumns = { @JoinColumn (name = "groupId") }, inverseJoinColumns = { @JoinColumn(name = "friendsEntityId") })
//	private List<FriendsEntity>  friendsEntityId = new ArrayList<>();
	
	@Column(name="groupName")
	private String groupName;
	
	@Column(name="balance")
	private Integer balance;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

//	public List<FriendsEntity> getFriendsEntityId() {
//		return friendsEntityId;
//	}
//
//	public void setFriendsEntityId(List<FriendsEntity> friendsEntityId) {
//		this.friendsEntityId = friendsEntityId;
//	}
//
//	public Integer getBalance() {
//		return balance;
//	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}


}
