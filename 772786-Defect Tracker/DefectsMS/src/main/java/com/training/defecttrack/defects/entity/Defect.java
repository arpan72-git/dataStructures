package com.training.defecttrack.defects.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEFECT_DETAILS")
public class Defect {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="defect_id", nullable = false, length = 5)
	Integer defectId;
	@Column(name="product_name", nullable = false, length = 30)
	String productName;
	@Column(name="year_of_purchase", nullable = false, length = 4)
	Integer yearOfPurchase;
	@Column(nullable = false, length = 100)
	String description;
	@Column(nullable = false, length = 10)
	String status;
	@Column(nullable = false, length = 2)
	Integer priority;
	@Column(nullable = false)
	Date date;
	@Column(name="user_id",nullable = false,length = 15)
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
	
	
}
