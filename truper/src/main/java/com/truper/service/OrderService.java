package com.truper.service;

import com.truper.dto.OrderDto;
import com.truper.dto.request.OrderRequestDto;

public interface OrderService {

	public OrderDto getOrderById(Long idOrder);
	
	public OrderDto createOrder(OrderRequestDto orderRequestDto);
}
