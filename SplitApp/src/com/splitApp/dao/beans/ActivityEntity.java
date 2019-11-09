package com.splitApp.dao.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.splitApp.appProperty.AppConstants;

@Entity
@Table(name="activity_details", schema=AppConstants.SCHEMA_NAME)
public class ActivityEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="activityEntityId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer activityEntityId;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="friendsEntityId")
	private FriendsEntity friendsEntityId;
	
	
	@Column(name="balance")
	private Integer balance;
	
	@Column(name="descrition")
	private String descrition;
	
	@Column(name="date")
	private Date date;


	public Integer getActivityEntityId() {
		return activityEntityId;
	}

	public void setActivityEntityId(Integer activityEntityId) {
		this.activityEntityId = activityEntityId;
	}

	public FriendsEntity getFriendsEntityId() {
		return friendsEntityId;
	}

	public void setFriendsEntityId(FriendsEntity friendsEntityId) {
		this.friendsEntityId = friendsEntityId;
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
		result = prime * result + ((activityEntityId == null) ? 0 : activityEntityId.hashCode());
		result = prime * result + ((friendsEntityId == null) ? 0 : friendsEntityId.hashCode());
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
		if (activityEntityId == null) {
			if (other.activityEntityId != null)
				return false;
		} else if (!activityEntityId.equals(other.activityEntityId))
			return false;
		if (friendsEntityId == null) {
			if (other.friendsEntityId != null)
				return false;
		} else if (!friendsEntityId.equals(other.friendsEntityId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ActivityEntity [activityEntityId=" + activityEntityId + ", friendsEntityId=" + friendsEntityId
				+ ", balance=" + balance + ", descrition=" + descrition + "]";
	}
	
}
