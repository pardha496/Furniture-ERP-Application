package com.funrierp.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private String category;
	
	private double price;
	
	private int quantity;
	
	private Date createdDate;
	
	private Date updatedDate;

}