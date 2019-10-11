package com.ing.mortgage.service;

import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.CalculatedEmiDto;
import com.ing.mortgage.dto.EmiDto;

@Service
public interface EmiCalculationServiceImpl {

	public CalculatedEmiDto calculatedEmi(EmiDto emiDto);
	
}
