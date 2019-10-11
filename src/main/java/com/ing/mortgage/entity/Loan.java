package com.ing.mortgage.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Loan {
@Id
@GeneratedValue(strategy=GenerationType.AUTO) 	
 private Long loanId;

 private Double loanAmount;

 private Integer tenure;
 
 private Double rateOfInterest;

 private Double balanceAmount;

 private Double emi;

 private Long loanAccountNo;
 
 private Date loanCreatedDate;

 @ManyToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "customerId",referencedColumnName = "customerId")
 private Customer customer;
	
 
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Long getLoanId() {
	return loanId;
}
public void setLoanId(Long loanId) {
	this.loanId = loanId;
}
public Double getLoanAmount() {
	return loanAmount;
}
public void setLoanAmount(Double loanAmount) {
	this.loanAmount = loanAmount;
}
public Integer getTenure() {
	return tenure;
}
public void setTenure(Integer tenure) {
	this.tenure = tenure;
}
public Double getRateOfInterest() {
	return rateOfInterest;
}
public void setRateOfInterest(Double rateOfInterest) {
	this.rateOfInterest = rateOfInterest;
}
public Double getBalanceAmount() {
	return balanceAmount;
}
public void setBalanceAmount(Double balanceAmount) {
	this.balanceAmount = balanceAmount;
}
public Double getEmi() {
	return emi;
}
public void setEmi(Double emi) {
	this.emi = emi;
}
public Long getLoanAccountNo() {
	return loanAccountNo;
}
public void setLoanAccountNo(Long loanAccountNo) {
	this.loanAccountNo = loanAccountNo;
}
public Date getLoanCreatedDate() {
	return loanCreatedDate;
}
public void setLoanCreatedDate(Date loanCreatedDate) {
	this.loanCreatedDate = loanCreatedDate;
}
 
 
}
