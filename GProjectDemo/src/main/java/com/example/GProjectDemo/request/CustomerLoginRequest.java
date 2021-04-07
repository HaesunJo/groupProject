package com.example.GProjectDemo.request;

import javax.validation.constraints.NotBlank;

public class CustomerLoginRequest {

	@NotBlank(message = "Customer Id cannot be blank")
	private String customerId;
	
	@NotBlank(message = "Password cannot be blank")
	private String password;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPw() {
		return password;
	}

	public void setCustomerPw(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return customerId + " " + password;
	}
	
}
