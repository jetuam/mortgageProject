package com.ing.mortgage.dto;

import java.util.List;

public class ResponseLoanDto {
  private String message;
  private Integer statusCode;
  private List<RequestLoanDto> loanDetails;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Integer getStatusCode() {
	return statusCode;
}
public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
}
public List<RequestLoanDto> getLoanDetails() {
	return loanDetails;
}
public void setLoanDetails(List<RequestLoanDto> loanDetails) {
	this.loanDetails = loanDetails;
}
  
}
