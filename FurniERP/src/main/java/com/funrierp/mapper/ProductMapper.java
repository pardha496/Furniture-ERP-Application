package com.funrierp.mapper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.funrierp.dto.ProductRequestDTO;
import com.funrierp.dto.ProductResponseDTO;
import com.funrierp.entity.Product;

public class ProductMapper {
	
	public static Product dtoToProductEntity(ProductRequestDTO dto) {
		LocalDate localDate = LocalDate.now();
		
		return Product.builder().name(dto.getName())
				.description(dto.getDescription())
				.category(dto.getCategory())
				.price(dto.getPrice())
				.quantity(dto.getQuantity())
				.createdDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())).build();
		
	}
	
	public static ProductResponseDTO entityToProdectDto(Product product) {
		
		return ProductResponseDTO.builder()
				.product_id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.category(product.getCategory())
				.price(product.getPrice())
				.createdDate(product.getCreatedDate().toInstant()
				        .atZone(ZoneId.systemDefault()).toLocalDate())
				.quantity(product.getQuantity())
				.updatedDate(LocalDate.now())
				.build();
		
	}

}
