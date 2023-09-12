package com.truper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.dto.ProductDto;
import com.truper.dto.request.ProductRequestDto;
import com.truper.exception.ResourceNotFoundException;
import com.truper.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductControlle {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto> getStoreById(@PathVariable(value = "id", required = true) Long idOrder) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(productService.getProductById(idOrder));
	}
	
	@PostMapping("/product")
	public ResponseEntity<ProductDto> getStoreById(@RequestBody ProductRequestDto productRequestDto) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(productService.createProduct(productRequestDto));
	}
}
