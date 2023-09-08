package com.truper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truper.dto.StoreDto;
import com.truper.dto.request.StoreRequestDto;
import com.truper.exception.ResourceNotFoundException;
import com.truper.model.StoreEntity;
import com.truper.repository.StoreRepository;
import com.truper.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public StoreDto getStoreById(Long idStore) throws ResourceNotFoundException {

		StoreEntity storeEntity = storeRepository.findById(idStore)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + idStore));
		return StoreDto.builder().name(storeEntity.getName()).build();
	}

	@Override
	public StoreDto createStore(StoreRequestDto storeRequestDto) {
		StoreEntity storeEntity = StoreEntity.builder().name(storeRequestDto.getName()).build();
		storeEntity = storeRepository.save(storeEntity);
		return StoreDto.builder()
				.name(storeEntity.getName())
				.id(storeEntity.getId()).build();
	}

}
