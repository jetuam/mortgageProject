/**
 * 
 */
package com.ing.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.mortgage.entity.Loan;

/**
 * @author User1
 *
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
