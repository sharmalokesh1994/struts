package com.splitApp.dao.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.splitApp.appProperty.AppConstants;

@Entity
@Table(name="friends_details", schema=AppConstants.SCHEMA_NAME)
public class FriendsEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="friendsEntityId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer friendsEntityId;
	
	@Column(name="selfPhNo")
	private String selfPhNo;
	
	@Column(name="friendPhNo")
	private String friendPhNo;
	
	@Column(name="balance")
	private Integer balance;
	
	
	

	/*public int getElementsId() {
		return elementsId;
	}

	public void setElementsId(int elementsId) {
		this.elementsId = elementsId;
	}
*/
	
	
	public String getSelfPhNo() {
		return selfPhNo;
	}

	public Integer getFriendsEntityId() {
		return friendsEntityId;
	}

	public void setFriendsEntityId(Integer friendsEntityId) {
		this.friendsEntityId = friendsEntityId;
	}

	public void setSelfPhNo(String selfPhNo) {
		this.selfPhNo = selfPhNo;
	}

	public String getFriendPhNo() {
		return friendPhNo;
	}

	public void setFriendPhNo(String friendPhNo) {
		this.friendPhNo = friendPhNo;
	}


	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friendPhNo == null) ? 0 : friendPhNo.hashCode());
		result = prime * result + ((selfPhNo == null) ? 0 : selfPhNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendsEntity other = (FriendsEntity) obj;
		if (friendPhNo == null) {
			if (other.friendPhNo != null)
				return false;
		} else if (!friendPhNo.equals(other.friendPhNo))
			return false;
		if (selfPhNo == null) {
			if (other.selfPhNo != null)
				return false;
		} else if (!selfPhNo.equals(other.selfPhNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FriendsEntity [selfPhNo=" + selfPhNo + ", friendPhNo=" + friendPhNo + ", balance=" + balance + "]";
	}

	
	
}
