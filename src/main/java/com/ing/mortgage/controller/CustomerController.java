/**
 * 
 */
package com.ing.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.CustomerRequestDTO;
import com.ing.mortgage.dto.CustomerResponseDTO;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.service.CustomerService;

/**
 * @author User1
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@PostMapping("/loans")
	public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
		Customer saveCustomer = customerService.saveCustomer(customerRequestDTO);
		CustomerResponseDTO customerResponseDTO=new CustomerResponseDTO();
		customerResponseDTO.setCustomerId(saveCustomer.getCustomerId());
		customerResponseDTO.setMessage("loan applied succesfully");
		customerResponseDTO.setStatusCode(201);
		return customerResponseDTO;
	}
}
