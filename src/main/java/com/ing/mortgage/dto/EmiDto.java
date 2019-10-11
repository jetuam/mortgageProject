package com.ing.mortgage.dto;



public class EmiDto {

	private Double loanAmount;
	private Double tenure;
	private Double rateOfInterest;
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Double getTenure() {
		return tenure;
	}
	public void setTenure(Double tenure) {
		this.tenure = tenure;
	}
	public Double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	
	
}
