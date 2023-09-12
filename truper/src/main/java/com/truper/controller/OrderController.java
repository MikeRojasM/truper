package com.truper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.dto.OrderDto;
import com.truper.dto.request.OrderRequestDto;
import com.truper.exception.ResourceNotFoundException;
import com.truper.service.OrderService;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/{id}")
	public ResponseEntity<OrderDto> getStoreById(@PathVariable(value = "id", required = true) Long idOrder) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(orderService.getOrderById(idOrder));
	}
	
	@PostMapping("/order")
	public ResponseEntity<OrderDto> getStoreById(@RequestBody OrderRequestDto orderRequestDto) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(orderService.createOrder(orderRequestDto));
	}
}
