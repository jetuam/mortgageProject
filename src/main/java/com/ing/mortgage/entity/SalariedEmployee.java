package com.ing.mortgage.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SalariedEmployee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 	
	private Long salariedEmployeeId;
	private String organizationName;
	private String officialEmailId;
	private Double monthlySalary;
	private Long officialPhoneNumber;
	private String designation;
  @OneToOne(cascade={CascadeType.ALL})
  @JoinColumn(name="customerId")
	private Customer customer;
public Long getSalariedEmployeeId() {
	return salariedEmployeeId;
}
public void setSalariedEmployeeId(Long salariedEmployeeId) {
	this.salariedEmployeeId = salariedEmployeeId;
}
public String getOrganizationName() {
	return organizationName;
}
public void setOrganizationName(String organizationName) {
	this.organizationName = organizationName;
}
public String getOfficialEmailId() {
	return officialEmailId;
}
public void setOfficialEmailId(String officialEmailId) {
	this.officialEmailId = officialEmailId;
}
public Double getMonthlySalary() {
	return monthlySalary;
}
public void setMonthlySalary(Double monthlySalary) {
	this.monthlySalary = monthlySalary;
}
public Long getOfficialPhoneNumber() {
	return officialPhoneNumber;
}
public void setOfficialPhoneNumber(Long officialPhoneNumber) {
	this.officialPhoneNumber = officialPhoneNumber;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
  
}
