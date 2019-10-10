package com.ing.mortgage.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.mortgage.entity.Loan;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	
	@Query("SELECT b FROM  Loan b where b.customer.customerId=:customerId" )
	List<Loan> findAllById(@Param ("customerId") Long customerId);
}
