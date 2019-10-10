package com.ing.mortgage.dto;

import lombok.Getter;
import lombok.Setter;


public class CalculatedEmiDto {

	private Double emiAmount;
	private int statusCode;
	public Double getEmiAmount() {
		return emiAmount;
	}
	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
