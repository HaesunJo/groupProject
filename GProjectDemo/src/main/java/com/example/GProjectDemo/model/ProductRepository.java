package com.example.GProjectDemo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByName(String name);
	
	List<Product> findByPrice(Double price);
	
}
