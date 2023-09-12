package com.truper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truper.dto.StoreDto;
import com.truper.dto.request.StoreRequestDto;
import com.truper.exception.ResourceNotFoundException;
import com.truper.model.StoreEntity;
import com.truper.repository.StoreRepository;
import com.truper.service.StoreService;

/**
 *This class contain business rules for create and search in StoryEntity
 * @author Invitado1
 */
@Service
public class StoreServiceImpl implements StoreService{

	/*
	 * Object persist to StoreEntity
	 */
	@Autowired
	private StoreRepository storeRepository;
	
	/*
	 * Method for search by id in StoryEntity
	 * @param idStore
	 * @return StoreDto
	 */
	@Override
	public StoreDto getStoreById(Long idStore) throws ResourceNotFoundException {

		StoreEntity storeEntity = storeRepository.findById(idStore)
				.orElseThrow(() -> new ResourceNotFoundException("Store not found for this id :: " + idStore));
		return StoreDto.builder().id(storeEntity.getId()).name(storeEntity.getName()).build();
	}

	/*
	 * Method for create a store in StoreEntity
	 * @param idStore
	 * @return StoreRequestDto
	 */
	@Override
	public StoreDto createStore(StoreRequestDto storeRequestDto) {
		StoreEntity storeEntity = StoreEntity.builder().name(storeRequestDto.getName()).build();
		storeEntity = storeRepository.save(storeEntity);
		return StoreDto.builder()
				.name(storeEntity.getName())
				.id(storeEntity.getId()).build();
	}

}
 