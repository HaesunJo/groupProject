package com.example.GProjectDemo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GProjectDemo.model.Customer;
import com.example.GProjectDemo.model.Manager;
import com.example.GProjectDemo.model.CustomerRepository;
import com.example.GProjectDemo.model.ManagerRepository;
import com.example.GProjectDemo.request.CustomerLoginRequest;
import com.example.GProjectDemo.request.ManagerLoginRequest;
import com.example.GProjectDemo.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:8081") 
@RestController
@RequestMapping("/api")

public class LoginController {

	@Autowired
	CustomerRepository customerRepository;
	ManagerRepository managerRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody CustomerLoginRequest loginRequest){
		try {
			Optional<Customer> customerData = customerRepository.findByCustomerId(loginRequest.getCustomerId());
			System.out.println("LoginInfo: " + loginRequest);
			if(customerData.isPresent()) {
				String password = customerData.get().getCustomerPw();
				if(password.equals(loginRequest.getCustomerPw())) {
					return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
				}
				MessageResponse msg = new MessageResponse("Incorrect password");
				return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
			}
			MessageResponse msg = new MessageResponse("No customer data");
			return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
		} catch(Exception e) {
			MessageResponse msg = new MessageResponse("Server error");
			return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/loginmanager")
	public ResponseEntity<?> login(@Valid @RequestBody ManagerLoginRequest loginRequest){
		try {
			Optional<Manager> managerData = managerRepository.findByManagerId(loginRequest.getManagerId());
			System.out.println("LoginInfo: " + loginRequest);
			if(managerData.isPresent()) {
				String password = managerData.get().getManagerPw();
				if(password.equals(loginRequest.getManagerPw())) {
					return new ResponseEntity<>(managerData.get(), HttpStatus.OK);
				}
				MessageResponse msg = new MessageResponse("Incorrect password");
				return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
			}
			MessageResponse msg = new MessageResponse("No manager data");
			return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
		} catch(Exception e) {
			MessageResponse msg = new MessageResponse("Server error");
			return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
