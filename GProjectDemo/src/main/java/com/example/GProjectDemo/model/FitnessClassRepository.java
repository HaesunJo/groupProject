package com.example.GProjectDemo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessClassRepository extends JpaRepository<FitnessClass, Long>{
	
	List<FitnessClass> findByClassName(String className);
	List<FitnessClass> findByClassSection(String classSection);
	List<FitnessClass> findByInstructor(String instructor);
	List<FitnessClass> findByMonth(String month);
	List<FitnessClass> findByDate(String date);
	List<FitnessClass> findByDay(String day);
	List<FitnessClass> findByTime(String time);
	List<FitnessClass> findByLocation(String location);
}
