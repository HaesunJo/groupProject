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
import com.example.GProjectDemo.model.CustomerRepository;
import com.example.GProjectDemo.request.CustomerLoginRequest;
import com.example.GProjectDemo.response.MessageResponse;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")

public class LoginController {

	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> loging(@Valid @RequestBody CustomerLoginRequest loginRequest){
		try {
			Optional<Customer> customerData = customerRepository.findByCustomerId(loginRequest.getCustomerId());
			if(customerData.isPresent()) {
				String password = customerData.get().getCustomerPw();
				if(password.contentEquals(loginRequest.getPassword())) {
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
}
