package com.training.defecttrack.defects.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.defecttrack.defects.dto.DefectsDTO;
import com.training.defecttrack.defects.entity.Defect;
import com.training.defecttrack.defects.exception.DefectIdNotExistException;
import com.training.defecttrack.defects.exception.DefectsException;
import com.training.defecttrack.defects.exception.InvalidDateException;
import com.training.defecttrack.defects.exception.InvalidPriorityException;
import com.training.defecttrack.defects.exception.InvalidStatusChangeException;
import com.training.defecttrack.defects.exception.InvalidStatusException;
import com.training.defecttrack.defects.exception.InvalidYearOfPurchaseException;
import com.training.defecttrack.defects.exception.NoDefectFoundException;
import com.training.defecttrack.defects.repository.DefectsRepository;


@Service
public class DefectsService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DefectsRepository defectsRepo;
	
	//Add defects
	public Integer addDefect(DefectsDTO defectDTO) throws DefectsException {
		logger.info("Defect addition request {}",defectDTO );
		validateDefect(defectDTO);
		Defect defect = defectDTO.createEntity();
		defect.setStatus("CREATED");
		Defect de = defectsRepo.save(defect);
		return de.getDefectId();
		
	}
	
	public void validateDefect(DefectsDTO defect) throws DefectsException {
		if (!isValidYearOfPurchase(defect.getYearOfPurchase()))
			throw new InvalidYearOfPurchaseException("DefectsService.INVALID_YEAR_OF_PURCHASE");
		if (!isValidDate(defect.getDate()))
			throw new InvalidDateException("DefectsService.INVALID_DATE");
		if (!isValidPriority(defect.getPriority()))
			throw new InvalidPriorityException("DefectsService.INVALID_PRIORITY");
	}
	
	public Boolean isValidYearOfPurchase(Integer number) {
		Boolean b1 = false;
		String regex6 = "[0-9]{4}";

		Pattern pattern6 = Pattern.compile(regex6);
		Matcher matcher6 = pattern6.matcher(String.valueOf(number));
		if (matcher6.matches())
			b1 = true;
		return b1;
	}
	
	public Boolean isValidDate(Date number) {
		Boolean b1 = false;
		String regex6 = "^(19|20)\\d\\d[-](0?[1-9]|1[012])[-](0?[1-9]|[12][0-9]|3[01])$";

		Pattern pattern6 = Pattern.compile(regex6);
		Matcher matcher6 = pattern6.matcher(String.valueOf(number));
		if (matcher6.matches())
			b1 = true;
		return b1;
	}
	
	public Boolean isValidPriority(Integer number) {
		Boolean b1 = false;
		String regex6 = "[1-5]{1}";

		Pattern pattern6 = Pattern.compile(regex6);
		Matcher matcher6 = pattern6.matcher(String.valueOf(number));
		if (matcher6.matches())
			b1 = true;
		return b1;
	}
	
	//Update defect status
	public boolean updateDefectStatus(Integer defectId, String status) throws DefectsException{
		boolean result=false;
		
		if(!isValidStatus(status))
			throw new InvalidStatusException("DefectsService.INVALID_STATUS");
		
		Optional<Defect> optdefect = defectsRepo.findById(defectId);
		
		if(optdefect.isPresent()) {
			Defect defect = optdefect.get();
			if(!isValidStatusChange(status, defect.getStatus()))
				throw new InvalidStatusChangeException("DefectsService.INVALID_STATUS_CHANGE");
			defect.setStatus(status);
			defectsRepo.save(defect);
			result = true;
		}
		return result;
	}
	
	//View defect by defect id
	public DefectsDTO viewDefectbyDefectId(Integer defectId) throws DefectsException{
		DefectsDTO defectDTO = new DefectsDTO();
		Optional<Defect> defect = defectsRepo.findById(defectId);
		if(defect.isPresent())
			defectDTO = DefectsDTO.valueOf(defect.get());
		else
			throw new DefectIdNotExistException("DefectsRepository.DEFECTID_NOT_EXIST");
		
		return defectDTO;
				
	}
	
	//View defect by user id
		public List<DefectsDTO> viewDefectbyUserId(String userId) throws DefectsException{
			List<DefectsDTO> defectDTO = new ArrayList<DefectsDTO>();
			List<Defect> defects = defectsRepo.findByUserId(userId);
			if(!defects.isEmpty())
				for(Defect defect : defects)
					defectDTO.add(DefectsDTO.valueOf(defect));
			else
				throw new NoDefectFoundException("DefectsRepository.NO_DEFECTS_FOUND");
			
			return defectDTO;
					
		}

    public boolean isValidStatusChange(String status,String status_db) {
    	boolean b=true;
    	if(status_db.equals("CLOSED") && status.equals("OPEN") )
    		b = false;
    	return b;
    }
    
    public boolean isValidStatus(String status){
    	boolean b=false;
    	if(status.equals("OPEN") || status.equals("CLOSED"))
    		b = true;
    	return b;
    }
}
