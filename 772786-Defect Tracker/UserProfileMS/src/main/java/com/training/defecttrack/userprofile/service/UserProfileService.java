package com.training.defecttrack.userprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.defecttrack.userprofile.controller.UserRegisterFeign;
import com.training.defecttrack.userprofile.dto.UserDTO;

@Service
public class UserProfileService {
	
	@Autowired
	UserRegisterFeign userFeign;
	
	public UserDTO getSpecificUser(String userId) {
		return userFeign.getSpecificUser(userId);
	}

}
