package com.example.GProjectDemo.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GProjectDemo.model.Customer;
import com.example.GProjectDemo.model.CustomerRepository;
import com.example.GProjectDemo.model.FitnessClass;
import com.example.GProjectDemo.model.FitnessClassRepository;
import com.example.GProjectDemo.request.RegistrationRequest;
import com.example.GProjectDemo.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:8081") 
@RestController
@RequestMapping("/api")
public class RegistrationController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	FitnessClassRepository fitnessClassRepository;
	
	@GetMapping("/{cid}/classes")
	public ResponseEntity<?> findFitnessClassByRegistration(@PathVariable("cid") Long cid, @RequestParam(required = false) boolean registered){
		try {
			Optional<Customer> customerData = customerRepository.findById(cid);
			if(customerData.isPresent()) {
				Customer customer = customerData.get();
				Set<FitnessClass> registeredClasses = customer.getClaases();
				if(registered) {
					return new ResponseEntity<>(registeredClasses, HttpStatus.OK);
				}
				Set<FitnessClass> unregClasses = new HashSet<FitnessClass>(fitnessClassRepository.findAll());
				unregClasses.removeAll(registeredClasses);
				if(unregClasses.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(unregClasses, HttpStatus.OK);
			}
			else {
				MessageResponse msg = new MessageResponse("No such a customer");
				return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
			}
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/{cid}/classes")
	public ResponseEntity<?> addRemoveClass(@PathVariable("cid") Long cid, @Valid @RequestBody RegistrationRequest registrationRequest){
		try{
			String action = registrationRequest.getAction();
			Long className = registrationRequest.getClassName();
			Optional<Customer> CustomerData = customerRepository.findById(cid);
			
			if(CustomerData.isPresent()) {
				Customer customer = CustomerData.get();
				Optional<FitnessClass> classData = fitnessClassRepository.findById(className);
				if(CustomerData.isPresent()) {
					FitnessClass fitnessClass = classData.get();
					if(action.equals("add")) {
						customer.addClass(fitnessClass);						
					} else if (action.equals("remove")){
						customer.removeClass(fitnessClass);
					}
					customer = customerRepository.save(customer);
					return new ResponseEntity<>(customer, HttpStatus.OK);
				} else {
					MessageResponse msg = new MessageResponse("No such a class");
					return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
				}
			} else {
				MessageResponse msg = new MessageResponse("No such a class");
				return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
			}
			
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
