package com.truper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@GetMapping("/order")
	public ResponseEntity<String> getOrderById(){
		return ResponseEntity.ok().body("Test Rest Get Order");
	}
}
