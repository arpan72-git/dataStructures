package com.training.defecttrack.userregistration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class User {

	@Id
	@Column(name="user_id",nullable = false,length = 15)
	String userId;
	@Column(nullable = false,length = 15)
	String password;
	@Column(nullable = false,length = 20)
	String name;
	@Column(nullable = false,length = 30)
	String email;
	@Column(nullable = false,length = 10)
	Long phoneNo;
	@Column(nullable = false,length = 30)
	String address;
	@Column(nullable = false,length = 15)
	String userRole;
	
	
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
