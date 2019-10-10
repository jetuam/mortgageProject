package com.ing.mortgage.dto;

import java.util.List;

import com.ing.mortgage.entity.Loan;

public class ResponseLoginDto {
  public  List<Loan> LoanDetails;
  

public List<Loan> getLoanDetails() {
	return LoanDetails;
}

public void setLoanDetails(List<Loan> loanDetails) {
	LoanDetails = loanDetails;
}
  
}
