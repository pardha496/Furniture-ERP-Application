package com.funrierp.service;

import java.util.List;

import com.funrierp.dto.ProductRequestDTO;
import com.funrierp.dto.ProductResponseDTO;
import com.funrierp.entity.Product;

public interface ProductService {
	
	ProductResponseDTO createProduct(ProductRequestDTO dto);

	List<ProductResponseDTO> getAllProducts();

	ProductResponseDTO getProductById(int id);
 
	ProductResponseDTO updateProduct(int id, ProductRequestDTO dto);

	boolean deleteProduct(int id);

}
