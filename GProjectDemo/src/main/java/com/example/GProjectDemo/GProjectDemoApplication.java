package com.example.GProjectDemo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.GProjectDemo.model.Customer;
import com.example.GProjectDemo.model.CustomerRepository;
import com.example.GProjectDemo.model.FitnessClass;
import com.example.GProjectDemo.model.FitnessClassRepository;
import com.example.GProjectDemo.model.Manager;
import com.example.GProjectDemo.model.ManagerRepository;
import com.example.GProjectDemo.model.Product;
import com.example.GProjectDemo.model.ProductRepository;

@SpringBootApplication
public class GProjectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GProjectDemoApplication.class, args);
	}
	
	
	@Bean
	ApplicationRunner init(FitnessClassRepository fintessClassRepository, CustomerRepository customerRepository, 
			ManagerRepository managerRepository, ProductRepository productRepository) {
		return args -> {
			
			FitnessClass[] classes = {new FitnessClass("Yoga",1, "Jan",2,"Monday", "12:30","Tiffany", "Vancouver")
					
			};
			
			Customer[] customers = {new Customer("1234", "Seunghee Ko", "kos6@student.douglascollege.ca", "1234567"),
					new Customer("5678", "Seunghee Ko", "kos6@student.douglascollege.ca", "1234567"),
					new Customer("3456", "Seunghee Ko", "kos6@student.douglascollege.ca", "1234567")
					};
			

			Manager[] managers = {new Manager("riako", "Seunghee Ko", "kos6@student.douglascollege.ca", "1234567")
					
			};
			
			Product[] products = {new Product("Vegetarian", 150.00)
				
			};
			
			
			customers[0].addClass(classes[0]);

			
			for(int i =0; i < classes.length; i++) {
				fintessClassRepository.save(classes[i]);
			}
			

			for(int i =0; i < customers.length; i++) {
				customerRepository.save(customers[i]);
			}
		
			for(int i =0; i < managers.length; i++) {
				managerRepository.save(managers[i]);
			}
			
			for(int i =0; i < products.length; i++) {
				productRepository.save(products[i]);
			}
			
			
		
			
			fintessClassRepository.findAll().forEach(System.out::println);
			customerRepository.findAll().forEach(System.out::println);
			managerRepository.findAll().forEach(System.out::println);
			productRepository.findAll().forEach(System.out::println);
	
			
		};
	}

}
 