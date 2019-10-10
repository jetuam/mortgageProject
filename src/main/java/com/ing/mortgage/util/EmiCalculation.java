package com.ing.mortgage.util;

import org.springframework.stereotype.Component;

@Component
public class EmiCalculation {

	public Double emiTenureCalculation(Double rateOfInterest, Double principalAmount, Double tenure)
	{
		Double trend = 1 + (rateOfInterest/MortgageUtil.month/MortgageUtil.overallPercentage);
		Double tenureMonths = tenure * MortgageUtil.month;
		Double overallTrend = Math.pow(trend, tenureMonths);
		Double principalCalculation = principalAmount * (rateOfInterest/MortgageUtil.month/MortgageUtil.overallPercentage);
		
		Double emi = (principalCalculation * overallTrend)/(overallTrend -1);
		
		return emi;
	}
	
}
