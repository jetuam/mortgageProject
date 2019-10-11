package com.ing.mortgage.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ing.mortgage.dto.RequestLoanDto;
import com.ing.mortgage.dto.RequestLoginDto;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.entity.Loan;
import com.ing.mortgage.exception.CommonException;
import com.ing.mortgage.repository.CustomerRepository;
import com.ing.mortgage.repository.LoanRepository;
import com.ing.mortgage.util.ExceptionConstants;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoanRepository loanRepository;
	@Autowired 
	CustomerRepository customerRepository;
	
public List<RequestLoanDto> loanDetails(RequestLoginDto requestLoginDto)
{   
	List<RequestLoanDto> loanAccountDetails=new ArrayList<>();
	Customer customerDetails=customerRepository.findByEmailIdAndPassword(requestLoginDto.getEmailId(),
			requestLoginDto.getPassword());
	if(customerDetails!=null)
	{
	 Long customerId=customerDetails.getCustomerId();
	 List<Loan> loanDetails=loanRepository.findAllById(customerId);
	  if(loanDetails!=null){
	     loanDetails.forEach(loan->{
		 RequestLoanDto requestLoanDto=new RequestLoanDto();
		 requestLoanDto.setLoanAccountNo(loan.getLoanAccountNo());
		 requestLoanDto.setLoanId(loan.getLoanId());
		 requestLoanDto.setCustomerId(loan.getCustomer().getCustomerId());
		      requestLoanDto.setFirstName(loan.getCustomer().getFirstName());
		 requestLoanDto.setLastName(loan.getCustomer().getLastName());
		 requestLoanDto.setEmailId(loan.getCustomer().getEmailId());
		 requestLoanDto.setMobileNo(loan.getCustomer().getMobileNo());
		 loanAccountDetails.add(requestLoanDto);
		});
	return loanAccountDetails;
	}
	
	else
	{
		
		throw new CommonException(ExceptionConstants.USER_NOT_FOUND);
		
	}
	
	}
	else
	{
		throw new CommonException(ExceptionConstants.INVALID_CREDENTIALS);
		
	}
}	

}
