package com.funrierp.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funrierp.dto.ProductRequestDTO;
import com.funrierp.dto.ProductResponseDTO;
import com.funrierp.entity.Product;
import com.funrierp.exceptions.NoProductFoundException;
import com.funrierp.mapper.ProductMapper;
import com.funrierp.repository.ProductRepository;
import com.funrierp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepo;

	@Override
	public ProductResponseDTO createProduct(ProductRequestDTO dto) {
		// TODO Auto-generated method stub
		return ProductMapper.entityToProdectDto( productRepo.save(ProductMapper.dtoToProductEntity(dto)));
	}

	@Override
	public List<ProductResponseDTO> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll().stream().map(product->ProductMapper.entityToProdectDto(product))
				.collect(Collectors.toList());
	}

	@Override
	public ProductResponseDTO getProductById(Long id) {
		// TODO Auto-generated method stub
		return ProductMapper.entityToProdectDto( productRepo.findById(id).orElseThrow(()-> new NoProductFoundException(id)));
	}

	@Override
	public ProductResponseDTO updateProduct( Long id,ProductRequestDTO dto) {
		// TODO Auto-generated method stub
		productRepo.findById(id).orElseThrow(()-> new NoProductFoundException(id));
		
		return ProductMapper.entityToProdectDto( productRepo.save(ProductMapper.dtoToProductEntity(dto)));
	}

	@Override
	public boolean deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
