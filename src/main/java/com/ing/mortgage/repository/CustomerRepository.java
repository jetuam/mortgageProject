/**
 * 
 */
package com.ing.mortgage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.mortgage.entity.Customer;

/**
 * @author User1
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	
	Customer findByEmailIdAndPassword(String emailId, String password);

	Optional<Customer> findByEmailId(String emailId);
	

}
