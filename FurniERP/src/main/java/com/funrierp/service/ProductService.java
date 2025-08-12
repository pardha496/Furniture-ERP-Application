package com.funrierp.service;

import java.util.List;

import org.springframework.http.HttpStatusCode;

import com.funrierp.dto.ProductRequestDTO;
import com.funrierp.dto.ProductResponseDTO;
import com.funrierp.entity.Product;

public interface ProductService {
	
	ProductResponseDTO createProduct(ProductRequestDTO dto);

	List<ProductResponseDTO> getAllProducts();

	ProductResponseDTO getProductById(Long id);
 
	ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto);

	boolean deleteProduct(Long id);


}
