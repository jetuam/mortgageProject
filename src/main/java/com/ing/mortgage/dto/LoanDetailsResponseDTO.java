/**
 * 
 */
package com.ing.mortgage.dto;

import java.util.Date;

/**
 * @author User1
 *
 */
public class LoanDetailsResponseDTO {
	private Double loanAmount;

	 private Integer tenure;
	 
	 private Double rateOfInterest;

	 private Double balanceAmount;

	 private Double emi;

	 private Long loanAccountNo;
	 
	 private Date loanCreatedDate;

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
