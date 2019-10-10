package com.ing.mortgage.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.mortgage.dto.RequestLoanDto;
import com.ing.mortgage.dto.RequestLoginDto;
import com.ing.mortgage.dto.ResponseLoanDto;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.entity.Loan;
import com.ing.mortgage.repository.CustomerRepository;
import com.ing.mortgage.repository.LoanRepository;

@RunWith(MockitoJUnitRunner.class) 
public class LoginServiceTest {

	@InjectMocks
	LoginServiceImpl loginService;

	@Mock
	LoanRepository loanRepository;
	@Mock
	CustomerRepository customerRepository;
	RequestLoginDto requestLoginDto;
	Customer customer;
	Loan loan;
	  List<Loan> loanAccountDetails;
	  RequestLoanDto requestLoanDto;
	  ResponseLoanDto responseLoanDto;
	@Before
	public void setup()
	{
		customer=new Customer();
		Date dob=new Date(1994-06-05);
		Date loanCreatedDate=new Date(2009-06-05);
		customer.setCustomerId(1L);
		customer.setCustomerType("salaried employee");
		customer.setCity("Sirsi");
		customer.setDob(dob);
		customer.setEmailId("pri@gmail.com");
		customer.setFirstName("Priyanka");
		customer.setLastName("Sharma");
		customer.setMiddleName("Singh");
		customer.setMobileNo(7986543210L);
		customer.setPanNumber("BSCH4567");
		customer.setPassword("absg123");
		customer.setPinCode(765432L);
		requestLoginDto=new RequestLoginDto();
		requestLoginDto.setEmailId("pri@gmail.com");
		requestLoginDto.setPassword("absg123");
		
		loan=new Loan();
		loan.setCustomer(customer);
		loan.setBalanceAmount(234567.0);
		loan.setEmi(345.0);
		loan.setLoanAccountNo(2345L);
		loan.setLoanCreatedDate(loanCreatedDate);
		loan.setLoanId(1L);
		loan.setRateOfInterest(10.0);
		loan.setTenure(3);
		loanAccountDetails=new ArrayList<>();
		requestLoanDto=new RequestLoanDto();
		requestLoanDto.setLoanAccountNo(loan.getLoanAccountNo());
		loanAccountDetails.add(loan);
		
	}
	
	
	@Test
	public void loanDetailsTest()
	{
		Mockito.when(customerRepository.findByEmailIdAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(customer);
		Mockito.when(loanRepository.findAllById(Mockito.anyLong())).thenReturn(loanAccountDetails);
		List<RequestLoanDto> loanDetails=loginService.loanDetails(requestLoginDto);
		assertEquals(new Long(2345),loanDetails.get(0).getLoanAccountNo());
	}
}
