package com.ing.mortgage.dto;

import java.util.List;

import com.ing.mortgage.entity.Loan;

public class RequestLoanDto {
  private Long loanAccountNo;
 // private List<RequestLoanDto> loanDetails;
  


public Long getLoanAccountNo() {
	return loanAccountNo;
}

public void setLoanAccountNo(Long loanAccountNo) {
	this.loanAccountNo = loanAccountNo;
}
  
  
}
