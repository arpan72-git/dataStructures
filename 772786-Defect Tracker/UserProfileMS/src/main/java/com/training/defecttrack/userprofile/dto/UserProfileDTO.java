package com.training.defecttrack.userprofile.dto;

import java.util.List;

public class UserProfileDTO {

	UserDTO currentUser;
	List<DefectsDTO> userDefects;
	
	public UserDTO getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(UserDTO currentUser) {
		this.currentUser = currentUser;
	}
	
	public List<DefectsDTO> getUserDefects() {
		return userDefects;
	}
	public void setUserDefects(List<DefectsDTO> userDefects) {
		this.userDefects = userDefects;
	}
	@Override
	public String toString() {
		return "UserProfileDTO [currentUser=" + currentUser + ", userDefects=" + userDefects + "]";
	}

	   //Converts 

}
