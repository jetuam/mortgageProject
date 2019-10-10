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
	
	public Double interestCalculation(Double rateOfInterest, Double balanceAmount)
	{
		Double interest = ((balanceAmount * rateOfInterest)/MortgageUtil.month)/MortgageUtil.overallPercentage;
		
		return interest;
	}
	
	public Double principalCalculation(Double emi, Double interestAmount)
	{
		Double principalAmount = emi - interestAmount;
		return principalAmount;
	}
	
	public Double balanceAmount(Double balanceAmount, Double monthlyPrinicipalAmount)
	{
		Double principalBalance = balanceAmount - monthlyPrinicipalAmount;
		return principalBalance;
	}
	
}
