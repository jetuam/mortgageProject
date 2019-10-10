package com.ing.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.CalculatedEmiDto;
import com.ing.mortgage.dto.EmiDto;
import com.ing.mortgage.util.EmiCalculation;

@Service
public class EmiCalculationService implements EmiCalculationServiceImpl {

	@Autowired
	EmiCalculation emiCalculation;
	
	@Override
	public CalculatedEmiDto calculatedEmi(EmiDto emiDto) {
		
		Double emi = emiCalculation.emiTenureCalculation(emiDto.getInterestRate(), emiDto.getLoanAmount(), emiDto.getTenure());
		CalculatedEmiDto emiDtoValue = new CalculatedEmiDto();
		emiDtoValue.setEmiAmount(emi);
		emiDtoValue.setStatusCode(HttpStatus.OK.value());
		return emiDtoValue;
	}

}
