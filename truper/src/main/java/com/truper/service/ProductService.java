package com.truper.service;

import com.truper.dto.ProductDto;
import com.truper.dto.request.ProductRequestDto;

public interface ProductService {

	public ProductDto getProductById(Long idProduct);
	
	public ProductDto createProduct(ProductRequestDto productRequestDto);
}
