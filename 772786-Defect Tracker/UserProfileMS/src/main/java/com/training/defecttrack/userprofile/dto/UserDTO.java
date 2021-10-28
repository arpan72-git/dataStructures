package com.training.defecttrack.userprofile.dto;


public class UserDTO {

	String userId;
	String password;
	String name;
	String email;
	Long phoneNo;
	String address;
	String userRole;
	
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
	
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
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
	
	
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", address=" + address + ", userRole=" + userRole + "]";
	}
	
}
