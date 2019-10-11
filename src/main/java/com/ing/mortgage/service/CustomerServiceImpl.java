/**
 * 
 */
package com.ing.mortgage.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.CustomerRequestDTO;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.entity.Loan;
import com.ing.mortgage.entity.SalariedEmployee;
import com.ing.mortgage.entity.SelfEmployee;
import com.ing.mortgage.exception.CustomerExistException;
import com.ing.mortgage.repository.CustomerRepository;
import com.ing.mortgage.repository.LoanRepository;
import com.ing.mortgage.repository.SalariedEmployeeRepository;
import com.ing.mortgage.repository.SelfEmployeeRepository;

/**
 * @author User1
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private SalariedEmployeeRepository salariedEmployeeRepository;
	@Autowired
	private SelfEmployeeRepository selfEmployeeRepository;
	Random random = new Random();

	@Override
	public Customer saveCustomer(CustomerRequestDTO customerRequestDTO) {

		Customer customer = new Customer();
		BeanUtils.copyProperties(customerRequestDTO.getCustomer(), customer);
		Loan loan = new Loan();
		BeanUtils.copyProperties(customerRequestDTO.getLoan(), loan);

		Optional<Customer> findByCustomerId = customerRepository.findByEmailId(customer.getEmailId());
		if (findByCustomerId.isPresent()) {
			throw new CustomerExistException("Customer exists in DB");
		} else {
			Customer savedcustomer = customerRepository.save(customer);
			loan.setLoanAccountNo((long) random.nextInt(10000000));
			loan.setCustomer(savedcustomer);
			loanRepository.save(loan);

			if (customerRequestDTO.getSalariedEmployee() != null) {
				SalariedEmployee salariedEmployee = new SalariedEmployee();
				BeanUtils.copyProperties(customerRequestDTO.getSalariedEmployee(), salariedEmployee);
				salariedEmployee.setCustomer(savedcustomer);
				salariedEmployeeRepository.save(salariedEmployee);
			}
			if (customerRequestDTO.getSelfEmployee() != null) {

				SelfEmployee selfEmployee = new SelfEmployee();
				BeanUtils.copyProperties(customerRequestDTO.getSelfEmployee(), selfEmployee);

				selfEmployee.setCustomer(savedcustomer);
				selfEmployeeRepository.save(selfEmployee);
			}
			return savedcustomer;

		}
	}

}
