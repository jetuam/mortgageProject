/**
 * 
 */
package com.ing.mortgage.dto;

/**
 * @author User1
 *
 */
public class SalariedEmployeeDTO {
	private String organizationName;
	private String officialEmailId;
	private Double monthlySalary;
	private Long officialPhoneNumber;
	private String designation;

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOfficialEmailId() {
		return officialEmailId;
	}

	public void setOfficialEmailId(String officialEmailId) {
		this.officialEmailId = officialEmailId;
	}

	public Double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(Double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public Long getOfficialPhoneNumber() {
		return officialPhoneNumber;
	}

	public void setOfficialPhoneNumber(Long officialPhoneNumber) {
		this.officialPhoneNumber = officialPhoneNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
