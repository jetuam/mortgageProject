/**
 * 
 */
package com.ing.mortgage.service;

import com.ing.mortgage.dto.LoanDetailsResponseDTO;

/**
 * @author User1
 *
 */
public interface LoanService {
	
	public LoanDetailsResponseDTO loanDetails(Long  loanId);

}
