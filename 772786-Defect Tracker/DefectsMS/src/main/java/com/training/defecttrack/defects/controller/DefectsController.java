package com.training.defecttrack.defects.controller;

import java.util.List;

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
import org.springframework.web.client.RestTemplate;

import com.training.defecttrack.defects.dto.DefectsDTO;
import com.training.defecttrack.defects.exception.DefectsException;
import com.training.defecttrack.defects.service.DefectsService;

@RestController
@PropertySource(value = {"configuration.properties"})
public class DefectsController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DefectsService defectService;
	
	@Autowired
	Environment env;
	
	@Autowired
	RestTemplate template;
	
	//Add defect
	@RequestMapping(value="/adddefect", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Integer addDefect(@RequestBody DefectsDTO defectDTO) throws DefectsException{
		logger.info("Add defect request with details {}", defectDTO);
		Integer defectId=-1;
		boolean result = template.getForObject("http://USERREGISTRATIONMS"+"/checkuser/"+defectDTO.getUserId(), Boolean.class);
		if(result) {
			try {
				defectId = defectService.addDefect(defectDTO);
				System.out.println(env.getProperty("DefectsRepository.ADD_DEFECT_SUCCESS")+ defectId);
			}
			catch (Exception e) {
				System.out.println(env.getProperty(e.getMessage()));
			}
		}
		else
			System.out.println(env.getProperty("Defects.INVALID_USER_ID"));
		
		return defectId;		
	}

	//Update defect status
	@RequestMapping(value="/update/{defectId}/{status}", method = RequestMethod.PUT)
	public boolean updateDefect(@PathVariable("defectId") Integer defectId,@PathVariable("status") String status) {
		boolean result;
		logger.info("Update defect status request for defect id {} to status {}", defectId,status);
		try {
			result = defectService.updateDefectStatus(defectId,status.toUpperCase());
			
		}
		catch (Exception e) {
			System.out.println(env.getProperty(e.getMessage()));
			result = false;
		}
		return result;	
	}
	
	//View defects by defect id
	@RequestMapping(value="/view/defects/{defectId}", method = RequestMethod.GET)
	public DefectsDTO viewDefectByDefectId(@PathVariable("defectId") Integer defectId) {
		DefectsDTO defectDTO = null;
		logger.info("View defect request for defect id {}", defectId);
		try {
			defectDTO = defectService.viewDefectbyDefectId(defectId);			
		}
		catch (Exception e) {
			System.out.println(env.getProperty(e.getMessage()));
		}
		return defectDTO;	
	}
	
	//View defect by user id
	@RequestMapping(value="/view/{userId}", method = RequestMethod.GET)
	public List<DefectsDTO> viewDefectByUserId(@PathVariable("userId") String userId) {
		List<DefectsDTO> defectsDTO = null;
		logger.info("View defect request for user id {}", userId);

		boolean result = template.getForObject("http://USERREGISTRATIONMS"+"/checkuser/"+userId, Boolean.class);
		
		try {
			if(result)
				defectsDTO = defectService.viewDefectbyUserId(userId);
			else
				System.out.println(env.getProperty("Defects.INVALID_USER_ID"));
		}
		catch (Exception e) {
			System.out.println(env.getProperty(e.getMessage()));
		}
		return defectsDTO;
		
	}
}
