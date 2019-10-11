package com.ing.mortgage.util;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ing.mortgage.entity.Loan;
import com.ing.mortgage.repository.LoanRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoanScheduler {

	@Autowired
	LoanRepository loanRepository;
	
	
	/**
	 * @author Sharath
	 * @apiNote scheduler for emi calculation
	 */
	@Scheduled(cron = "0 0/10 * * * *")
	public void loanDeduction()
	{
		log.info("scheduler is running for this day");
		List<Loan> loans = loanRepository.findAll();
		
		List<Loan> recurredLoan = new ArrayList<>();
		
		
		loans.stream().forEach(loan ->{
			if(loan.getLoanCreatedDate().getDate() == LocalDateTime.now().getDayOfMonth())
			{
				if(loan.getBalanceAmount() > 0)
				{
					log.info("same day is matched");
					Loan loanData = new Loan();
					Double interestAmount = interestCalculation(loan.getRateOfInterest(), loan.getBalanceAmount());
					Double balance = principalCalculation(loan.getEmi(), interestAmount);
					Double overAllBalance = balanceAmount(loan.getBalanceAmount(), balance);
					loan.setTenure(loan.getTenure()-1);
					loan.setBalanceAmount(overAllBalance);
					BeanUtils.copyProperties(loan, loanData);
					recurredLoan.add(loanData);
					System.out.println("loanData "+loanData);
				}
			}
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
		log.info("interest calculation");
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
		log.info("principal calculation");
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
		log.info("balance amount");
		return balanceAmount - monthlyPrinicipalAmount;
	}
	
}
