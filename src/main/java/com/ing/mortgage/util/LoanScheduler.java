package com.ing.mortgage.util;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ing.mortgage.entity.Loan;
import com.ing.mortgage.repository.LoanRepository;

@Component
public class LoanScheduler {

	@Autowired
	LoanRepository loanRepository;
	
	
	/**
	 * @author Sharath
	 * @apiNote scheduler for emi calculation
	 */
	@Scheduled(cron = "0 0/1 * * * *")
	public void loanDeduction()
	{
		List<Loan> loans = loanRepository.findAll();
		
		List<Loan> recurredLoan = new ArrayList<>();
		
		
		loans.stream().forEach(loan ->{
			Loan loanData = new Loan();
			Double interestAmount = interestCalculation(loan.getRateOfInterest(), loan.getBalanceAmount());
			Double balance = principalCalculation(loan.getEmi(), interestAmount);
			Double overAllBalance = balanceAmount(loan.getBalanceAmount(), balance);
			loan.setTenure(loan.getTenure()-1);
			loan.setBalanceAmount(overAllBalance);
			BeanUtils.copyProperties(loan, loanData);
			recurredLoan.add(loanData);
		});
		
		loanRepository.saveAll(recurredLoan);
	}
	
	
	/**
	 * 
	 * @param rateOfInterest
	 * @param balanceAmount
	 * @author Sharath
	 * @return interest calculation for the balance amount
	 */
	public Double interestCalculation(Double rateOfInterest, Double balanceAmount)
	{
		
		return ((balanceAmount * rateOfInterest)/MortgageUtil.month)/MortgageUtil.overallPercentage;
	}
	
	
	/**
	 * 
	 * @param emi
	 * @param interestAmount
	 * @author Sharath
	 * @return principal amount calculation
	 */
	public Double principalCalculation(Double emi, Double interestAmount)
	{
		return emi - interestAmount;
	}
	
	
	/**
	 * 
	 * @param balanceAmount
	 * @param monthlyPrinicipalAmount
	 * @author Sharath
	 * @return to calculate balance amount from the monthly prinicipal amount deduction
	 */
	public Double balanceAmount(Double balanceAmount, Double monthlyPrinicipalAmount)
	{
		return balanceAmount - monthlyPrinicipalAmount;
	}
	
}
