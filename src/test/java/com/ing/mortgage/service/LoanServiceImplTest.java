/**
 * 
 */
package com.ing.mortgage.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.mortgage.dto.LoanDetailsResponseDTO;
import com.ing.mortgage.entity.Loan;
import com.ing.mortgage.repository.LoanRepository;

import junit.framework.Assert;

/**
 * @author User1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LoanServiceImplTest {
	@Mock
	private LoanRepository loanRepository;
	@InjectMocks
	LoanServiceImpl loanServiceImpl;

	@Test()
	public void testLoanDetails() {
		Loan loan=new Loan();
		loan.setBalanceAmount(2000.00);
		loan.setEmi(1233.00);
		loan.setLoanAccountNo(12345L);
		loan.setLoanAmount(123455.00);
		loan.setLoanId(1L);
		loan.setRateOfInterest(12.00);
		loan.setTenure(24);
		Optional<Loan> optionalLoan=Optional.of(loan);
		Mockito.when(loanRepository.findById(1L)).thenReturn(optionalLoan);
		LoanDetailsResponseDTO loanDetails = loanServiceImpl.loanDetails(1L);

		Assert.assertNotNull(loanDetails);

	}

}
