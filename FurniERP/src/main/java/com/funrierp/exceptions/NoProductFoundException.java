package com.funrierp.exceptions;

public class NoProductFoundException extends RuntimeException {

	public NoProductFoundException(Long id) {
		super(String.format("Product with given ID %s  is not found. Given existing ID", id));
	}
	
	

}
