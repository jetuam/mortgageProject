/**
 * 
 */
package com.ing.mortgage.service;

import com.ing.mortgage.dto.CustomerRequestDTO;
import com.ing.mortgage.entity.Customer;

/**
 * @author User1
 *
 */
public interface CustomerService {
	
	public Customer saveCustomer(CustomerRequestDTO customerRequestDTO);

}
