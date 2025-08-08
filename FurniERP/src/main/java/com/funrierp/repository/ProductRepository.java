package com.funrierp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funrierp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	List<Product> findByCategory(String category);

	Optional<Product> findByName(String name);

}
