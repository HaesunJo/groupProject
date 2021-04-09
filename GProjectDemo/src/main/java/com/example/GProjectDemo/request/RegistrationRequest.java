package com.example.GProjectDemo.request;

import javax.validation.constraints.NotBlank;

public class RegistrationRequest {
	

	@NotBlank(message = "Customer Id cannot be blank")
	private String action;
	
	@NotBlank(message = "Class name cannot be blank")
	private String className;
	
	@NotBlank(message = "Class ID cannot be blank")
	private Long classId;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}
	
	

}
