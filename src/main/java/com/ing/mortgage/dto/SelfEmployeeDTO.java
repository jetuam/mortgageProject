/**
 * 
 */
package com.ing.mortgage.dto;

/**
 * @author User1
 *
 */
public class SelfEmployeeDTO {
	private String nameofBusiness;
	private String natureOfBusiness;
	private Double latestTurnover;

	public String getNameofBusiness() {
		return nameofBusiness;
	}

	public void setNameofBusiness(String nameofBusiness) {
		this.nameofBusiness = nameofBusiness;
	}

	public String getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public void setNatureOfBusiness(String natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
	}

	public Double getLatestTurnover() {
		return latestTurnover;
	}

	public void setLatestTurnover(Double latestTurnover) {
		this.latestTurnover = latestTurnover;
	}

}
