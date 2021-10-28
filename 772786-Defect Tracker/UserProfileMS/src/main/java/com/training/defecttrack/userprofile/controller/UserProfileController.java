package com.training.defecttrack.userprofile.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.defecttrack.userprofile.dto.DefectsDTO;
import com.training.defecttrack.userprofile.dto.UserDTO;
import com.training.defecttrack.userprofile.dto.UserProfileDTO;
import com.training.defecttrack.userprofile.exception.UserIdNotExistException;
import com.training.defecttrack.userprofile.service.UserProfileService;

@RestController
@PropertySource(value = {"configuration.properties"})
public class UserProfileController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserProfileService userProService;
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	Environment env;
	
	@RequestMapping(value="/viewuser/{userId}", method = RequestMethod.GET)
	public UserProfileDTO viewUserProfile(@PathVariable("userId") String userId) throws UserIdNotExistException{
		logger.info("View user profile request for user id {}",userId);
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		
		
		UserDTO userDTO = userProService.getSpecificUser(userId);
		if(userDTO != null) {
			userProfileDTO.setCurrentUser(userDTO);
		}
		else {
			throw new UserIdNotExistException();
		}
		
		@SuppressWarnings("unchecked")
		List<DefectsDTO> defects= template.getForObject("http://DEFECTSMS"+"/view/"+userId, List.class);
		
		userProfileDTO.setUserDefects(defects);
		return userProfileDTO;
	}

}
