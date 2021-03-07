package com.example.GProjectDemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="customerId")
	private String customerId;
	
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="customerEmail")
	private String customerEmail;
	
	@Column(name="customerPw")
	private String customerPw;
	

	//ManyToMany
	@ManyToMany(mappedBy="customers", fetch=FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	
	private Set<FitnessClass> classes = new HashSet<>();

	public Set<FitnessClass> getClaases() {
		return classes;
	}
	
	public void setClaases(Set<FitnessClass> classes) {
		this.classes = classes;
	}
	
	
	// Add class
	public void addClass(FitnessClass fitnessClass) {
		this.classes.add(fitnessClass);
		fitnessClass.getCustomers().add(this);
	}
	
	// Remove Class
	public void removeClass(FitnessClass fitnessClass) {
		fitnessClass.getCustomers().remove(this);
		this.classes.remove(fitnessClass);
	}
	
	
	
	// Default Constructor
	public Customer() {
		
	}
	
	// Constructor
	public Customer(String id, String name, String email,String pw ) {
		this.customerId = id;
		this.customerName = name;
		this.customerEmail = email;
		this.customerPw = pw;
	}
	

	// Getter, Setter
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}
	
	
}
