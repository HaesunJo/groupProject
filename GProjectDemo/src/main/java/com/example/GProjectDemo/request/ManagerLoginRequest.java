package com.example.GProjectDemo.request;

import javax.validation.constraints.NotBlank;

public class ManagerLoginRequest {
	

	@NotBlank(message = "Manager Id cannot be blank")
	private String managerId;
	
	@NotBlank(message = "Password cannot be blank")
	private String password;

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerPw() {
		return password;
	}

	public void setManagerPw(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return managerId + " " + password;
	}

}
