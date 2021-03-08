package com.example.GProjectDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="managers")
public class Manager {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="managerId")
	private String managerId;
	
	@Column(name="managerName")
	private String managerName;
	
	@Column(name="managerEmail")
	private String managerEmail;
	
	@Column(name="managerPw")
	private String managerPw;

	
	public Manager() {
		
	}
	
	public Manager(String id, String name, String email, String pw) {
		this.managerId = id;
		this.managerName = name;
		this.managerEmail = email;
		this.managerPw = pw;
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerPw() {
		return managerPw;
	}

	public void setManagerPw(String managerPw) {
		this.managerPw = managerPw;
	}
	

	
}
