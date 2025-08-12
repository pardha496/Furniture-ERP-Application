package com.funrierp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.funrierp.dto.ProductRequestDTO;
import com.funrierp.dto.ProductResponseDTO;
import com.funrierp.security.JWTService;
import com.funrierp.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	JWTService jwtService;
	
	@PostMapping("saveproduct")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ProductResponseDTO> SaveProducts(@RequestBody @Valid ProductRequestDTO product) {
		return new ResponseEntity<ProductResponseDTO>(productService.createProduct(product), HttpStatus.CREATED);
	}

	@GetMapping("fetchallproducts")
	@PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
			return new ResponseEntity<List<ProductResponseDTO>>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("getproductbyid/{product_id}")
	@PreAuthorize("hasRole('ADMIN','EMPLOYEE')")
	public ResponseEntity<ProductResponseDTO> getProductBtId(@PathVariable Long product_id){
		return new ResponseEntity<ProductResponseDTO>(productService.getProductById(product_id), HttpStatus.OK);
	}
	
	@PutMapping("updateproduct/{product_id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long product_id, @RequestBody @Valid ProductRequestDTO product) {
		//TODO: process PUT request
		
		return new ResponseEntity<ProductResponseDTO>(productService.updateProduct( product_id, product), HttpStatus.OK);
	}

}
