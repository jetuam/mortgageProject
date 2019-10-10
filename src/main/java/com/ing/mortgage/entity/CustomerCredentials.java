package com.ing.mortgage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerCredentials {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO) 
	 private Long customerCredentialId;
	 private String emailId;
	 private String password;
	public Long getCustomerCredentialId() {
		return customerCredentialId;
	}
	public void setCustomerCredentialId(Long customerCredentialId) {
		this.customerCredentialId = customerCredentialId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
}
