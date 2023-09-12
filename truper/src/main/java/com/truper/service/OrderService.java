package com.truper.service;

import com.truper.dto.OrderDto;
import com.truper.dto.request.OrderRequestDto;
import com.truper.exception.ResourceNotFoundException;

/**
 * This interface OrderService for add and search by id of model OrderEntity
 * @author Invitado1
 */
public interface OrderService {

	/*
	 * This Method search order by id
	 *@param idStore
	 *@return StoreDto
	 */
	public OrderDto getOrderById(Long idOrder) throws ResourceNotFoundException;
	
	/*
	 * This Method create order
	 *@param OrderRequestDto
	 *@return StoreDto
	 */
	public OrderDto createOrder(OrderRequestDto orderRequestDto) throws ResourceNotFoundException;
}
