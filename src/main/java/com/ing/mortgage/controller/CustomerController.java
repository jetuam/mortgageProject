package com.ing.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.CalculatedEmiDto;
import com.ing.mortgage.dto.EmiDto;
import com.ing.mortgage.service.EmiCalculationServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/mortgage")
@Slf4j
public class CustomerController {

	
	@Autowired
	EmiCalculationServiceImpl emiCalculation;
	
	/**
	 * 
	 * @param emiDto
	 * @author Sharath
	 * @return emi calculation for loan amount given by the user
	 */
	@PostMapping("/emiCalculation")
	public ResponseEntity<CalculatedEmiDto> emiCalculate(@RequestBody EmiDto emiDto)
	{
		log.info("Customer Controller is called");
	    return new ResponseEntity<>(emiCalculation.calculatedEmi(emiDto),HttpStatus.OK);	
	}
	
}
