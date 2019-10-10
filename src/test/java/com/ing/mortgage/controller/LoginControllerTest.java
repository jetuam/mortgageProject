package com.ing.mortgage.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.mortgage.dto.RequestLoanDto;
import com.ing.mortgage.dto.RequestLoginDto;
import com.ing.mortgage.dto.ResponseLoanDto;
import com.ing.mortgage.entity.Loan;
import com.ing.mortgage.service.LoginServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@Mock
	LoginServiceImpl loginService;
	@InjectMocks
	LoginController loginController;
	
	@Test
	public void loanAccountDetailsTest()
	{
		RequestLoginDto requestLoginDto=new RequestLoginDto();
		RequestLoanDto requestLoanDto=new RequestLoanDto();
		requestLoanDto.setCustomerId(1L);
		requestLoanDto.setLoanAccountNo(23456L);
		List<RequestLoanDto> loanDetails=new ArrayList<>();
		requestLoginDto.setEmailId("shashi@gmail.com");
		requestLoginDto.setPassword("asd123");
		ResponseLoanDto responseLoanDto=new ResponseLoanDto();
		loanDetails.add(requestLoanDto);
		Mockito.when(loginService.loanDetails(Mockito.any())).thenReturn(loanDetails);
		responseLoanDto.setLoanDetails(loanDetails);
		responseLoanDto.setStatusCode(200);
		responseLoanDto.setMessage("Loan Account Details");
		ResponseLoanDto loanDetails1=loginController.loanAccountDetails(requestLoginDto);
		assertEquals(new Long(23456L),loanDetails1.getLoanDetails().get(0).getLoanAccountNo());
	}
}
