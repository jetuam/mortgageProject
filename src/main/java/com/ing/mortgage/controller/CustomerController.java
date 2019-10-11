package com.ing.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.CalculatedEmiDto;
import com.ing.mortgage.dto.EmiDto;
import com.ing.mortgage.service.EmiCalculationServiceImpl;

@RestController
@RequestMapping("/mortgage")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CustomerController {

	
	@Autowired
	EmiCalculationServiceImpl emiCalculation;
	
	@PostMapping("/emiCalculation")
	public ResponseEntity<CalculatedEmiDto> emiCalculate(@RequestBody EmiDto emiDto)
	{
	    return new ResponseEntity<>(emiCalculation.calculatedEmi(emiDto),HttpStatus.OK);	
	}
	
}
