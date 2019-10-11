package com.ing.mortgage.dto;



public class RequestLoanDto {
  private Long loanAccountNo;
  private Long customerId;
  private Long loanId;
  


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
  
  
}
