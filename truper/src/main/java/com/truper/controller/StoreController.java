package com.truper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.dto.StoreDto;
import com.truper.dto.request.StoreRequestDto;
import com.truper.exception.ResourceNotFoundException;
import com.truper.service.StoreService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1")
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@GetMapping("/store/{id}")
	public ResponseEntity<StoreDto> getStoreById(@PathParam(value = "id") Long idStore) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(storeService.getStoreById(idStore));
	}
	
	@PostMapping("/store")
	public ResponseEntity<StoreDto> getStoreById(@RequestBody StoreRequestDto storeRequestDto){
		return ResponseEntity.ok().body(storeService.createStore(storeRequestDto));
	}
}
