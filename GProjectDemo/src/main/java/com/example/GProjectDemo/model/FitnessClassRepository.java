package com.example.GProjectDemo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessClassRepository extends JpaRepository<FitnessClass, Long>{
	
	List<FitnessClass> findByClassName(String className);
	
	List<FitnessClass> findByTime(String time);
	
	List<FitnessClass> findByInstructor(String instructor);

}
