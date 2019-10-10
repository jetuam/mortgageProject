package com.ing.mortgage.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SelfEmployee {

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO) 
	private Long selfEmployeeId;
	private String nameofBusiness;
	private String natureOfBusiness;
	private Double latestTurnover;
	@OneToOne(cascade={CascadeType.ALL})
	 @JoinColumn(name="customerId") 
	private Customer customer;
	public Long getSelfEmployeeId() {
		return selfEmployeeId;
	}
	public void setSelfEmployeeId(Long selfEmployeeId) {
		this.selfEmployeeId = selfEmployeeId;
	}
	public String getNameofBusiness() {
		return nameofBusiness;
	}
	public void setNameofBusiness(String nameofBusiness) {
		this.nameofBusiness = nameofBusiness;
	}
	public String getNatureOfBusiness() {
		return natureOfBusiness;
	}
	public void setNatureOfBusiness(String natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
	}
	public Double getLatestTurnover() {
		return latestTurnover;
	}
	public void setLatestTurnover(Double latestTurnover) {
		this.latestTurnover = latestTurnover;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
