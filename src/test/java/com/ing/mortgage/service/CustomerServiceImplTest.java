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

import com.ing.mortgage.dto.CustomerDTO;
import com.ing.mortgage.dto.CustomerRequestDTO;
import com.ing.mortgage.dto.LoanDTO;
import com.ing.mortgage.dto.SalariedEmployeeDTO;
import com.ing.mortgage.dto.SelfEmployeeDTO;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.entity.Loan;
import com.ing.mortgage.entity.SalariedEmployee;
import com.ing.mortgage.entity.SelfEmployee;
import com.ing.mortgage.repository.CustomerRepository;
import com.ing.mortgage.repository.LoanRepository;
import com.ing.mortgage.repository.SalariedEmployeeRepository;
import com.ing.mortgage.repository.SelfEmployeeRepository;

import junit.framework.Assert;

/**
 * @author User1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
	@Mock
	private LoanRepository loanRepository;
	@Mock
	private CustomerRepository customerRepository;
	@Mock
	private SalariedEmployeeRepository salariedEmployeeRepository;
	@Mock
	private SelfEmployeeRepository selfEmployeeRepository;
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	@Test()
	public void testShowProducts() {
		SelfEmployeeDTO selfEmployeeDTO=new SelfEmployeeDTO();
		selfEmployeeDTO.setSelfEmployeeId(1L);
		SalariedEmployeeDTO salariedEmployeedto=new SalariedEmployeeDTO();
		salariedEmployeedto.setSalariedEmployeeId(1L);
		LoanDTO loandto=new LoanDTO();
		loandto.setLoanId(1L);
		CustomerDTO customerDto=new CustomerDTO();
		customerDto.setCustomerId(1L);
		CustomerRequestDTO customerRequestDTO=new CustomerRequestDTO();
		customerRequestDTO.setCustomer(customerDto);
		customerRequestDTO.setLoan(loandto);
		customerRequestDTO.setSalariedEmployee(salariedEmployeedto);
		customerRequestDTO.setSelfEmployee(selfEmployeeDTO);
		Loan loan=new Loan();
		loan.setBalanceAmount(2000.00);
		loan.setEmi(1233.00);
		loan.setLoanAccountNo(12345L);
		loan.setLoanAmount(123455.00);
		loan.setLoanId(1L);
		loan.setRateOfInterest(12.00);
		loan.setTenure(24);
		Customer customer=new Customer();
		customer.setCustomerId(1L);
		SalariedEmployee salariedEmployee=new SalariedEmployee();
		salariedEmployee.setSalariedEmployeeId(1L);
		SelfEmployee selfEmployee=new SelfEmployee();
		selfEmployee.setSelfEmployeeId(1L);
		Optional<Customer> OptinalCustomer=Optional.of(customer);
		Optional<Loan> optionalLoan=Optional.of(loan);
		Optional<SalariedEmployee> optionalSalariedEmployee=Optional.of(salariedEmployee);
		Optional<SelfEmployee> optionalSelfEmployee=Optional.of(selfEmployee);
		Mockito.when(customerRepository.findById(1L)).thenReturn(OptinalCustomer);
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		Mockito.when(loanRepository.findById(1L)).thenReturn(optionalLoan);
		Mockito.when(loanRepository.save(loan)).thenReturn(loan);		
		Mockito.when(salariedEmployeeRepository.findById(1L)).thenReturn(optionalSalariedEmployee);
		Mockito.when(salariedEmployeeRepository.save(salariedEmployee)).thenReturn(salariedEmployee);
		
		Mockito.when(selfEmployeeRepository.findById(1L)).thenReturn(optionalSelfEmployee);
		Mockito.when(selfEmployeeRepository.save(selfEmployee)).thenReturn(selfEmployee);
		
		
		Customer saveCustomer = customerServiceImpl.saveCustomer(customerRequestDTO);

		Assert.assertNotNull(saveCustomer);

	}

}
