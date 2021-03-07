package com.example.GProjectDemo.request;


public class CustomerLoginRequest {

	//Annotation doesn't work! help!
	//@NotBlank(message = "Customer Id cannot be blank")
	private String customerId;
	
	//@NotBlank(message = "Password cannot be blank")
	private String password;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
