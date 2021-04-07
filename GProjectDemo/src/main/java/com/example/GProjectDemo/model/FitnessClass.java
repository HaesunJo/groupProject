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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="classes")

public class FitnessClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="className")
	private String className;
	
	@Column(name="classSection")
	private int classSection;
	
	@Column(name="time")
	private String time;
	
	@Column(name="duration")
	private int duration;

	@Column(name="day")
	private String day;
	
	@Column(name="instructor")
	private String instructor;
	
	@Column(name="location")
	private String location;

	
	// CREATE TABLE
	@JsonIgnore 
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "customer_class", 
	joinColumns = {
			@JoinColumn(name = "classId", referencedColumnName="id")}, 
	inverseJoinColumns= 
				{@JoinColumn(name="customerId", referencedColumnName="id")}) 
	private Set<Customer> customers = new HashSet<>();
		
	
	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomer(Set<Customer> customers) {
		this.customers = customers;
	}
	
	
	
	
	
	// Default Constructor
	
	public FitnessClass() {}
	
//	public FitnessClass(String s, int i, String ins, int d, String loc, String m, String t) {
//		
//	}
//	
	// Constructor
	public FitnessClass(String name, int classSection, 
		 String day, String time, int duration, String instructor, String location) {
		this.className = name;
		this.classSection = classSection;
		this.day = day;
		this.time = time;
		this.duration = duration;
		this.instructor = instructor;
		this.location = location;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getClassSection() {
		return classSection;
	}

	public void setClassSection(int classSection) {
		this.classSection = classSection;
	}


	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	

	
	public String toString() {
		return "Class: " + this.className + " " + this.classSection + " " +
	this.time + " " +this.duration + " " + this.day + " " + this.instructor +
	" " + this.location;
	}
	
	
}
