/**
 * 
 */
package com.ing.mortgage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.LoanDetailsResponseDTO;
import com.ing.mortgage.entity.Loan;
import com.ing.mortgage.exception.LoanNotFoundException;
import com.ing.mortgage.repository.LoanRepository;

/**
 * @author User1
 *
 */
@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	@Override
	public LoanDetailsResponseDTO loanDetails(Long loanId) {
		Optional<Loan> findByLoanId = loanRepository.findById(loanId);
		if (!findByLoanId.isPresent()) {
			throw new LoanNotFoundException("Loan not found");			
		}
		Loan loan = findByLoanId.get();
		LoanDetailsResponseDTO loanDetailsResponseDTO=new LoanDetailsResponseDTO();
		loanDetailsResponseDTO.setBalanceAmount(loan.getBalanceAmount());
		loanDetailsResponseDTO.setEmi(loan.getEmi());
		loanDetailsResponseDTO.setLoanAccountNo(loan.getLoanAccountNo());
		loanDetailsResponseDTO.setLoanAmount(loan.getLoanAmount());
		loanDetailsResponseDTO.setLoanCreatedDate(loan.getLoanCreatedDate());
		loanDetailsResponseDTO.setRateOfInterest(loan.getRateOfInterest());
		loanDetailsResponseDTO.setTenure(loan.getTenure());
		return loanDetailsResponseDTO;
	}

}
