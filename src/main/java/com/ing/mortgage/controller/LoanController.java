/**
 * 
 */
package com.ing.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.LoanDetailsResponseDTO;
import com.ing.mortgage.dto.LoanResponseDTO;
import com.ing.mortgage.service.LoanService;

/**
 * @author User1
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/loans")
public class LoanController {
	@Autowired
	private LoanService loanService;
	
	@GetMapping("/{loanId}")
	public LoanResponseDTO saveCustomer(@PathVariable Long loanId) {
		LoanDetailsResponseDTO loanDetails = loanService.loanDetails(loanId);
		LoanResponseDTO loanResponseDTO=new LoanResponseDTO();
		loanResponseDTO.setLoanDetails(loanDetails);
		loanResponseDTO.setStatusCode(200);
		loanResponseDTO.setMessage("success");
		return loanResponseDTO;
	}
}
