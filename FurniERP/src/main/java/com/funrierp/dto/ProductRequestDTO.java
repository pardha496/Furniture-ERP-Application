package com.funrierp.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequestDTO {
	
	private Long id;
	
	@NotEmpty(message = "Username should not be empty")
	private String name;
	
	private String description;

	@NotEmpty(message = "Category should not be empty")
	private String category;

	@NotNull(message = "Price should not be null")
    @Min(value = 1, message = "Price must be at least 1")
    private Double price; // Changed from primitive to wrapper

    @NotNull(message = "Quantity should not be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

}
