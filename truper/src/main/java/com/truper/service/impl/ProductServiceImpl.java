package com.truper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truper.dto.OrderDto;
import com.truper.dto.ProductDto;
import com.truper.dto.StoreDto;
import com.truper.dto.request.ProductRequestDto;
import com.truper.dto.request.StoreRequestDto;
import com.truper.exception.ResourceNotFoundException;
import com.truper.model.OrderEntity;
import com.truper.model.ProductEntity;
import com.truper.model.StoreEntity;
import com.truper.repository.OrderRepository;
import com.truper.repository.ProductRepository;
import com.truper.repository.StoreRepository;
import com.truper.service.ProductService;
import com.truper.service.StoreService;

/**
 * This class contain business rules for create and search in StoreEntity
 * 
 * @author Invitado1
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDto getProductById(Long idProduct) throws ResourceNotFoundException {
		ProductEntity productEntity = productRepository.findById(idProduct)
				.orElseThrow(() -> new ResourceNotFoundException("Store not found for this id :: " + idProduct));

		StoreDto storeDto = StoreDto.builder().id(productEntity.getOrder().getStore().getId())
				.name(productEntity.getOrder().getStore().getName()).build();

		OrderDto orderDto = OrderDto.builder().id(productEntity.getOrder().getId()).store(storeDto)
				.date(productEntity.getOrder().getDate()).total(productEntity.getOrder().getTotal()).build();

		return ProductDto.builder().id(productEntity.getId()).code(productEntity.getCode())
				.description(productEntity.getDescription()).order(orderDto).price(productEntity.getPrice()).build();
	}

	@Override
	public ProductDto createProduct(ProductRequestDto productRequestDto) throws ResourceNotFoundException {

		OrderEntity orderEntity = orderRepository.findById(productRequestDto.getIdOrder())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Order not found for this id :: " + productRequestDto.getIdOrder()));

		ProductEntity productEntity = productRepository
				.save(ProductEntity.builder().order(orderEntity).code(productRequestDto.getCode())
						.description(productRequestDto.getDescription()).price(productRequestDto.getPrice()).build());

		StoreDto storeDto = StoreDto.builder().id(productEntity.getOrder().getStore().getId())
				.name(productEntity.getOrder().getStore().getName()).build();

		OrderDto orderDto = OrderDto.builder().id(productEntity.getOrder().getId()).store(storeDto)
				.date(productEntity.getOrder().getDate()).total(productEntity.getOrder().getTotal()).build();

		return ProductDto.builder().id(productEntity.getId()).code(productEntity.getCode())
				.description(productEntity.getDescription()).order(orderDto).price(productEntity.getPrice()).build();

	}

}
