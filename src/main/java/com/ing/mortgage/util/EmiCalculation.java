package com.ing.mortgage.util;

import org.springframework.stereotype.Component;

@Component
public class EmiCalculation {

	
	/**
	 * 
	 * @param rateOfInterest
	 * @param principalAmount
	 * @param tenure
	 * @apiNote for overall emi calculation
	 * @author Sharath
	 * @return
	 */
	public Double emiTenureCalculation(Double rateOfInterest, Double principalAmount, Double tenure)
	{
		Double trend = 1 + (rateOfInterest/MortgageUtil.month/MortgageUtil.overallPercentage);
		Double tenureMonths = tenure * MortgageUtil.month;
		Double overallTrend = Math.pow(trend, tenureMonths);
		Double principalCalculation = principalAmount * (rateOfInterest/MortgageUtil.month/MortgageUtil.overallPercentage);
		
		return (principalCalculation * overallTrend)/(overallTrend -1);
	}
	
}
