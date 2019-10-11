package com.ing.mortgage.dto;



public class RequestLoanDto {
  private Long loanAccountNo;
  private Long customerId;
  private Long loanId;
  private String firstName;
  private String lastName;
  private String emailId;
  private Long mobileNo;


public Long getLoanId() {
	return loanId;
}
public void setLoanId(Long loanId) {
	this.loanId = loanId;
}
public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}
public Long getLoanAccountNo() {
	return loanAccountNo;
}
public void setLoanAccountNo(Long loanAccountNo) {
	this.loanAccountNo = loanAccountNo;
}
  public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public Long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(Long mobileNo) {
	this.mobileNo = mobileNo;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
  
}
