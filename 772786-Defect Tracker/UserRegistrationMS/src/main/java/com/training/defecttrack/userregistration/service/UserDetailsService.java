package com.training.defecttrack.userregistration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.defecttrack.userregistration.dto.UserDTO;
import com.training.defecttrack.userregistration.entity.User;
import com.training.defecttrack.userregistration.repository.UserRepository;

@Service
public class UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	public UserDTO getSpecificUser(String userId) {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent())
			return UserDTO.valueOf(user.get());
		else
			return null;
	}
	
	public boolean checkUser(String userId) {
		return userRepo.existsById(userId);
	}
}
