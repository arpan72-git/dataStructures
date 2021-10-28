package com.training.defecttrack.userregistration.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.defecttrack.userregistration.dto.LoginDTO;
import com.training.defecttrack.userregistration.entity.User;
import com.training.defecttrack.userregistration.repository.UserRepository;

@Service
public class LoginService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepository userRepo;
	
	public boolean login(LoginDTO loginDTO) {
		logger.info("Login request for user {} with password {}", loginDTO.getUserId(),loginDTO.getPassword());
		Optional<User> user = userRepo.findById(loginDTO.getUserId());
		
		if (user.isPresent() && user.get().getPassword().equals(loginDTO.getPassword())) {
			return true;
		}
		return false;
	}
}
