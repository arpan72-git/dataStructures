package com.training.defecttrack.userregistration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.defecttrack.userregistration.dto.LoginDTO;
import com.training.defecttrack.userregistration.dto.UserDTO;
import com.training.defecttrack.userregistration.exception.UserRegistrationException;
import com.training.defecttrack.userregistration.service.LoginService;
import com.training.defecttrack.userregistration.service.RegistrationService;
import com.training.defecttrack.userregistration.service.UserDetailsService;

@RestController
@PropertySource(value = { "classpath:configuration.properties" })
public class UserController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	@Autowired
	RegistrationService regservice;
	
	@Autowired
	LoginService loginservice;
	
	@Autowired
	UserDetailsService userservice;
	
	
	//User Registration
	@RequestMapping(value= "/register",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean createCustomer(@RequestBody UserDTO userDTO) throws UserRegistrationException {
		logger.info("Creation request for user {}",userDTO);
		boolean result = false;
		//try {
		result = regservice.registerUser(userDTO);
		System.out.println(env.getProperty("UserRespository.REGISTRATION_SUCCESS"));
		//}
		//catch (Exception e) {
		//	System.out.println(env.getProperty(e.getMessage()));
		//}
		return result;
	}
	
	//User Login
	@RequestMapping(value = "/login",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for user {}",loginDTO);
		boolean result = loginservice.login(loginDTO);
		if(result)
			System.out.println(env.getProperty("UserRespository.LOGIN_SUCCESS"));
		else
			System.out.println(env.getProperty("UserRespository.LOGIN_FAILURE"));
		return result;
	}

	// Fetch user details of specific user
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO getSpecificUsers(@PathVariable String userId) {
		logger.info("Fetching details of user {}",userId);
		return userservice.getSpecificUser(userId);
	}
	
	// Fetch user details of specific user
	@RequestMapping(value = "/checkuser/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean checkUsers(@PathVariable String userId) {
		logger.info("Checking existance of user id {}",userId);
		return userservice.checkUser(userId);
		}
}
