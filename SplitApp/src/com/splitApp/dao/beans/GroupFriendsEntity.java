package com.splitApp.dao.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.splitApp.appProperty.AppConstants;

@Entity
@Table(name="group_details_friends_details", schema=AppConstants.SCHEMA_NAME)
public class GroupFriendsEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="friendsEntityId")
	private FriendsEntity friendsEntityId;
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="groupId")
	private GroupEntity groupId;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public FriendsEntity getFriendsEntityId() {
		return friendsEntityId;
	}


	public void setFriendsEntityId(FriendsEntity friendsEntityId) {
		this.friendsEntityId = friendsEntityId;
	}


	public GroupEntity getGroupId() {
		return groupId;
	}


	public void setGroupId(GroupEntity groupId) {
		this.groupId = groupId;
	}
	
	
	

}
