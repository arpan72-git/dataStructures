package com.training.defecttrack.userregistration.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.defecttrack.userregistration.dto.UserDTO;
import com.training.defecttrack.userregistration.entity.User;
import com.training.defecttrack.userregistration.exception.EmaiIdAlreadyPresentException;
import com.training.defecttrack.userregistration.exception.InvalidEmailException;
import com.training.defecttrack.userregistration.exception.InvalidPasswordException;
import com.training.defecttrack.userregistration.exception.InvalidPhoneNumberException;
import com.training.defecttrack.userregistration.exception.InvalidUserIdException;
import com.training.defecttrack.userregistration.exception.InvalidUserRoleException;
import com.training.defecttrack.userregistration.exception.UserIdAlreadyPresentException;
import com.training.defecttrack.userregistration.exception.UserRegistrationException;
import com.training.defecttrack.userregistration.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	UserRepository userRepo;
	
	String regex1 = "^[a-zA-Z0-9]{4,15}+$";
	
	public boolean registerUser(UserDTO userDTO) throws UserRegistrationException{
		validateUser(userDTO);
		boolean uid_check =userRepo.existsById(userDTO.getUserId());
		if (uid_check)
			throw new UserIdAlreadyPresentException("RegistrationService.USERID_PRESENT");
		if(userRepo.findByEmail(userDTO.getEmail()) !=null)
			throw new EmaiIdAlreadyPresentException("RegistrationService.EMAILID_PRESENT");

		User user = userDTO.createEntity();
        userRepo.save(user);
		
        return true;
		
		
	}
	
	public void validateUser(UserDTO user) throws UserRegistrationException {
		if (!isValidUserId(user.getUserId()))
			throw new InvalidUserIdException("RegistrationService.INVALID_USER_ID");
		if (!isValidPassword(user.getPassword()))
			throw new InvalidPasswordException("RegistrationService.INVALID_PASSWORD");
		if (!isValidEmail(user.getEmail()))
			throw new InvalidEmailException("RegistrationService.INVALID_EMAIL");
		if (!isValidPhoneNumber(user.getPhoneNo()))
			throw new InvalidPhoneNumberException("RegistrationService.INVALID_PHONE_NUMBER");
		if (!isValidUserRole(user.getUserRole()))
			throw new InvalidUserRoleException("RegistrationService.INVALID_USER_ROLE");
	}

	public Boolean isValidUserId(String userid) {
		Boolean b1 = false;

		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(userid);
		if (matcher1.matches())
			b1 = true;
		return b1;
	}

	public Boolean isValidPassword(String password) {
		Boolean b1 = false;

		String regex2 = "^[a-zA-Z0-9]{8,15}+$";

		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(password);
		if (matcher2.matches())
			b1 = true;

		return b1;
	}

	
	public Boolean isValidEmail(String email) {
		Boolean b1 = false;
		String regex5 = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

		Pattern pattern5 = Pattern.compile(regex5);
		Matcher matcher5 = pattern5.matcher(email);
		if (matcher5.matches())
			b1 = true;
		return b1;
	}

	public Boolean isValidPhoneNumber(Long number) {
		Boolean b1 = false;
		String regex6 = "[0-9]{10}";

		Pattern pattern6 = Pattern.compile(regex6);
		Matcher matcher6 = pattern6.matcher(String.valueOf(number));
		if (matcher6.matches())
			b1 = true;
		return b1;
	}
	public Boolean isValidUserRole(String role) {
		Boolean b1 = false;
		
		if(role.equalsIgnoreCase("developer") || role.equalsIgnoreCase("tester"))
			b1=true;
		
		return b1;
	}
}
