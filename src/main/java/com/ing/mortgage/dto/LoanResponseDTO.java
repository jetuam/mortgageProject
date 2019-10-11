/**
 * 
 */
package com.ing.mortgage.dto;

import com.ing.mortgage.entity.Loan;

/**
 * @author User1
 *
 */
public class LoanResponseDTO {
	private int statusCode;
	private String message;
	private LoanDetailsResponseDTO loanDetails;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LoanDetailsResponseDTO getLoanDetails() {
		return loanDetails;
	}
	public void setLoanDetails(LoanDetailsResponseDTO loanDetails) {
		this.loanDetails = loanDetails;
	}
	
}
