package com.truper.service;

import com.truper.dto.ProductDto;
import com.truper.dto.request.ProductRequestDto;
import com.truper.exception.ResourceNotFoundException;

/**
 * This interface ProductService for add and search by id of model ProductEntity
 * @author Invitado1
 */
public interface ProductService {

	/*
	 * This Method search product by id
	 *@param idProduct
	 *@return ProductDto
	 */
	public ProductDto getProductById(Long idProduct) throws ResourceNotFoundException;

	/*
	 * This Method create product
	 *@param ProductRequestDto
	 *@return ProductDto
	 */
	public ProductDto createProduct(ProductRequestDto productRequestDto) throws ResourceNotFoundException;
}
