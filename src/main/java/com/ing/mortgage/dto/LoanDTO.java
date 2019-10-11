/**
 * 
 */
package com.ing.mortgage.dto;

/**
 * @author User1
 *
 */
public class LoanDTO {
	private Double loanAmount;

	private Integer tenure;

	private Double rateOfInterest;
	private Double emi;

	public Double getEmi() {
		return emi;
	}

	public void setEmi(Double emi) {
		this.emi = emi;
	}

	Double getLoanAmount() {
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

}
