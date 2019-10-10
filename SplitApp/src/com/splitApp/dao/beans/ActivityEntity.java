package com.splitApp.dao.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.splitApp.appProperty.AppConstants;

@Entity
@Table(name="activity_details", schema=AppConstants.SCHEMA_NAME)
public class ActivityEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="elementsId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer elementsId;
	
	@Column(name="selfPhNo")
	private String selfPhNo;
	
	@Column(name="friendPhNo")
	private String friendPhNo;
	
	@Column(name="balance")
	private Integer balance;
	
	@Column(name="descrition")
	private String descrition;
	
	@Column(name="date")
	private Date date;

	public Integer getElementsId() {
		return elementsId;
	}

	public void setElementsId(Integer elementsId) {
		this.elementsId = elementsId;
	}

	public String getSelfPhNo() {
		return selfPhNo;
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

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((descrition == null) ? 0 : descrition.hashCode());
		result = prime * result + ((elementsId == null) ? 0 : elementsId.hashCode());
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
		ActivityEntity other = (ActivityEntity) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (descrition == null) {
			if (other.descrition != null)
				return false;
		} else if (!descrition.equals(other.descrition))
			return false;
		if (elementsId == null) {
			if (other.elementsId != null)
				return false;
		} else if (!elementsId.equals(other.elementsId))
			return false;
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
		return "ActivityEntity [elementsId=" + elementsId + ", selfPhNo=" + selfPhNo + ", friendPhNo=" + friendPhNo
				+ ", balance=" + balance + ", descrition=" + descrition + "]";
	}
	
}
