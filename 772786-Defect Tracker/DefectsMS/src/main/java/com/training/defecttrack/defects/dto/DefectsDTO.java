package com.training.defecttrack.defects.dto;

import java.sql.Date;

import com.training.defecttrack.defects.entity.Defect;

public class DefectsDTO {
	
	Integer defectId;
	String productName;
	Integer yearOfPurchase;
	String description;
	String status;
	Integer priority;
	Date date;
	String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getDefectId() {
		return defectId;
	}
	public void setDefectId(Integer defectId) {
		this.defectId = defectId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getYearOfPurchase() {
		return yearOfPurchase;
	}
	public void setYearOfPurchase(Integer yearOfPurchase) {
		this.yearOfPurchase = yearOfPurchase;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	@Override
	public String toString() {
		return "DefectsDTO [defectId=" + defectId + ", productName=" + productName + ", yearOfPurchase="
				+ yearOfPurchase + ", description=" + description + ", status=" + status + ", priority=" + priority
				+ ", date=" + date + ", userId=" + userId + "]";
	}
	
	
	//converts entity to dto
	public static DefectsDTO valueOf(Defect defect) {
		DefectsDTO defectsDTO = new DefectsDTO();
		defectsDTO.setDefectId(defect.getDefectId());
		defectsDTO.setProductName(defect.getProductName());
		defectsDTO.setStatus(defect.getStatus());
		defectsDTO.setPriority(defect.getPriority());
		defectsDTO.setDate(defect.getDate());
		defectsDTO.setDescription(defect.getDescription());
		defectsDTO.setYearOfPurchase(defect.getYearOfPurchase());
		defectsDTO.setUserId(defect.getUserId());
		return defectsDTO;
	}
	
	public Defect createEntity() {
		Defect defect = new Defect();
		defect.setDefectId(this.getDefectId());
		defect.setProductName(this.getProductName());
		defect.setStatus(this.getStatus());
		defect.setPriority(this.getPriority());
		defect.setDate(this.getDate());
		defect.setDescription(this.getDescription());
		defect.setYearOfPurchase(this.getYearOfPurchase());
		defect.setUserId(this.getUserId());
		
		return defect;
	}
}
