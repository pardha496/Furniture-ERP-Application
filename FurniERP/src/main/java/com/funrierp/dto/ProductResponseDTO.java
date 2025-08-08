package com.funrierp.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductResponseDTO {
	
	private String name;
	
	private String description;

	private String category;

	private double price;

	private int quantity;
	
	private LocalDate createdDate;
	
	private LocalDate updatedDate;

}
