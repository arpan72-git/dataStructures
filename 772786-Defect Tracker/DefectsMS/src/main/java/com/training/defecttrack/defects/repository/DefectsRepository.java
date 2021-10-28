package com.training.defecttrack.defects.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.defecttrack.defects.entity.Defect;

public interface DefectsRepository extends JpaRepository<Defect, Integer>{
	List<Defect> findByUserId(String userId);
	
}
