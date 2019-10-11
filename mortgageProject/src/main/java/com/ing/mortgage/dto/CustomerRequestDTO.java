/**
 * 
 */
package com.ing.mortgage.dto;

/**
 * @author User1
 *
 */
public class CustomerRequestDTO {

	private CustomerDTO customer;
	private LoanDTO loan;
	private SalariedEmployeeDTO salariedEmployee;
	private SelfEmployeeDTO selfEmployee;

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public LoanDTO getLoan() {
		return loan;
	}

	public void setLoan(LoanDTO loan) {
		this.loan = loan;
	}

	public SalariedEmployeeDTO getSalariedEmployee() {
		return salariedEmployee;
	}

	public void setSalariedEmployee(SalariedEmployeeDTO salariedEmployee) {
		this.salariedEmployee = salariedEmployee;
	}

	public SelfEmployeeDTO getSelfEmployee() {
		return selfEmployee;
	}

	public void setSelfEmployee(SelfEmployeeDTO selfEmployee) {
		this.selfEmployee = selfEmployee;
	}

}
