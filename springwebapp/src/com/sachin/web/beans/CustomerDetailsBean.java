package com.sachin.web.beans;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class CustomerDetailsBean {

	private int CustId;

	@Size(min = 4, max = 20, message = "Name should be have min 4 charcator")
	private String CustName;

	@NotNull
	@Pattern(regexp = ".*\\@.*\\..*", message = "Its  not a valid mail id")
	
	//@ValidEmail
	private String CustEmail;

	
	@Size(min = 3 , max = 15 , message = "Enter the City Name")
	private String City;

	public CustomerDetailsBean() {
		
	}
	public CustomerDetailsBean(int custId, String custName, String custEmail,
			String city) {

		this.CustId = custId;
		this.CustName = custName;
		this.CustEmail = custEmail;
		this.City = city;
	}

	public int getCustId() {
		return CustId;
	}

	public void setCustId(int custId) {
		CustId = custId;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public String getCustEmail() {
		return CustEmail;
	}

	public void setCustEmail(String custEmail) {
		CustEmail = custEmail;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	@Override
	public String toString() {
		return "CustomerDetailsBean [CustId=" + CustId + ", CustName="
				+ CustName + ", CustEmail=" + CustEmail + ", City=" + City
				+ "]";
	}
}
