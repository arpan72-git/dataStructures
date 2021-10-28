package com.training.defecttrack.userprofile.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.defecttrack.userprofile.dto.UserDTO;

@FeignClient("UserRegistrationMS")
public interface UserRegisterFeign {
	
	@RequestMapping("/users/{userId}")
	UserDTO getSpecificUser(@PathVariable("userId") String userId);

}
