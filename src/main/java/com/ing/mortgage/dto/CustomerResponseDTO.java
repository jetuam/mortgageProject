/**
 * 
 */
package com.ing.mortgage.dto;

/**
 * @author User1
 *
 */
public class CustomerResponseDTO {
	private int statusCode;
	private String message;
	private Long customerId;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
}
