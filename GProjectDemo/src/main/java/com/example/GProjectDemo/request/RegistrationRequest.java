package com.example.GProjectDemo.request;

import javax.validation.constraints.NotBlank;

public class RegistrationRequest {
	

	@NotBlank(message = "Customer Id cannot be blank")
	private String action;
	
	@NotBlank(message = "Class name cannot be blank")
	private Long className;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getClassName() {
		return className;
	}

	public void setClassName(Long className) {
		this.className = className;
	}
	
	

}
