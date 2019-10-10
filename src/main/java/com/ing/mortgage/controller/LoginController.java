package com.ing.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.RequestLoanDto;
import com.ing.mortgage.dto.RequestLoginDto;
import com.ing.mortgage.dto.ResponseLoanDto;
import com.ing.mortgage.exception.CommonException;
import com.ing.mortgage.service.LoginService;
import com.ing.mortgage.util.ExceptionConstants;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/loans")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	@PostMapping("/login")
	public ResponseLoanDto LoanAccountDetails(@RequestBody RequestLoginDto requestLoginDto)
	{
		ResponseLoanDto responseLoanDto=new ResponseLoanDto();
		 List<RequestLoanDto> loanDetails=loginService.loanDetails(requestLoginDto);
		if(loanDetails!=null)
		{
	  
		responseLoanDto.setStatusCode(200);
		responseLoanDto.setLoanDetails(loanDetails);
		responseLoanDto.setMessage("LoanAccountDetails");
		
		return responseLoanDto;
		}
		else
		{
			throw new CommonException(ExceptionConstants.ACCOUNT_NOT_FOUND);
		}
	}
	

}
