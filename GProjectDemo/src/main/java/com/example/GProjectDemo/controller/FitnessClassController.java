package com.example.GProjectDemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GProjectDemo.model.FitnessClass;
import com.example.GProjectDemo.model.FitnessClassRepository;

@CrossOrigin(origins = "http://localhost:8081") 
@RestController
@RequestMapping("/api")

public class FitnessClassController {
	
	@Autowired
	FitnessClassRepository fitnessClassRepository;
	
	@GetMapping("/classes")
	public ResponseEntity<List<FitnessClass>> getAllFitnessClasses(
			@RequestParam(required = false) String className) {
		try {
			List<FitnessClass> classes = new ArrayList<FitnessClass>();
			if(className == null) {
				fitnessClassRepository.findAll().forEach(classes::add);
			} else {
				fitnessClassRepository.findByClassName(className).forEach(classes::add);
			}
			
			if(className.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(classes, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/classes/{id}")
	public ResponseEntity<FitnessClass> getFitnessClassById(@PathVariable("id") long id){
		Optional<FitnessClass> classData = fitnessClassRepository.findById(id);
		
		if(classData.isPresent()) {
			return new ResponseEntity<>(classData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/classes")
	public ResponseEntity<FitnessClass> createFClass(@RequestBody FitnessClass fclass){
		try {
			FitnessClass _fclass = fitnessClassRepository.save(new FitnessClass(fclass.getClassName(), fclass.getClassSection(), fclass.getInstructor(), fclass.getDay(), fclass.getDuration(), fclass.getLocation(), fclass.getTime()));
			return new ResponseEntity<>(_fclass, HttpStatus.CREATED);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/classe")
	public ResponseEntity<FitnessClass> updateFClass(@RequestBody FitnessClass fclass){
		try {
			FitnessClass _fclass = fitnessClassRepository.save(new FitnessClass(fclass.getClassName(), fclass.getClassSection(), fclass.getInstructor(), fclass.getDay(),fclass.getDuration(), fclass.getLocation(), fclass.getTime()));
			return new ResponseEntity<>(_fclass, HttpStatus.CREATED);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/classes/{id}")
	public ResponseEntity<FitnessClass> updateFClass(@PathVariable("id") long id, @RequestBody FitnessClass fClass){
		Optional<FitnessClass> classData = fitnessClassRepository.findById(id);
		
		if(classData.isPresent()) {
			FitnessClass _fClass = classData.get();
			_fClass.setClassName(fClass.getClassName());
			_fClass.setTime(fClass.getTime());
			_fClass.setDuration(fClass.getDuration());
			_fClass.setInstructor(fClass.getInstructor());
			_fClass.setClassSection(fClass.getClassSection());
			_fClass.setDay(fClass.getDay());
			_fClass.setLocation(fClass.getLocation());
			
			return new ResponseEntity<>(fitnessClassRepository.save(fClass), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/classes/{id}")
	public ResponseEntity<HttpStatus> deleteClass(@PathVariable("id") long id){
		try {
			fitnessClassRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/classes")
	public ResponseEntity<HttpStatus> deleteAllClass(@PathVariable("id") long id){
		try {
			fitnessClassRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
