package com.truper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truper.dto.OrderDto;
import com.truper.dto.StoreDto;
import com.truper.dto.request.OrderRequestDto;
import com.truper.exception.ResourceNotFoundException;
import com.truper.model.OrderEntity;
import com.truper.model.StoreEntity;
import com.truper.repository.OrderRepository;
import com.truper.repository.StoreRepository;
import com.truper.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDto getOrderById(Long idOrder) throws ResourceNotFoundException {

		OrderEntity orderEntity = orderRepository.findById(idOrder)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + idOrder));
		StoreDto storeDto = StoreDto.builder().id(orderEntity.getStore().getId()).name(orderEntity.getStore().getName())
				.build();
		return OrderDto.builder().id(orderEntity.getId()).store(storeDto).date(orderEntity.getDate())
				.total(orderEntity.getTotal()).build();
	}

	@Override
	public OrderDto createOrder(OrderRequestDto orderRequestDto) throws ResourceNotFoundException {

		StoreEntity storeEntity = storeRepository.findById(orderRequestDto.getIdStore()).orElseThrow(
				() -> new ResourceNotFoundException("Store not found for this id :: " + orderRequestDto.getIdStore()));
		OrderEntity orderEntity = orderRepository.save(OrderEntity.builder().store(storeEntity)
				.date(orderRequestDto.getDate()).total(orderRequestDto.getTotal()).build());
		StoreDto storeDto = StoreDto.builder().id(orderEntity.getStore().getId()).name(orderEntity.getStore().getName())
				.build();
		return OrderDto.builder().id(orderEntity.getId()).store(storeDto).date(orderEntity.getDate())
				.total(orderEntity.getTotal()).build();
	}

}
