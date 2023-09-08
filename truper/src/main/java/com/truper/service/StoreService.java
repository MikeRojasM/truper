package com.truper.service;

import org.springframework.stereotype.Service;

import com.truper.dto.StoreDto;
import com.truper.dto.request.StoreRequestDto;
import com.truper.exception.ResourceNotFoundException;

/**
 * This interface StoreService for add, update and search by id of model StoreEntity
 * @author Invitado1
 */
@Service
public interface StoreService {
	
	/*
	 * This Method search store by id
	 *@param idStore
	 *@return StoreDto
	 */
	public StoreDto getStoreById(Long idStore)throws ResourceNotFoundException ;
	
	/*
	 * This Method create store
	 *@param StoreRequestDto
	 *@return StoreDto
	 */
	public StoreDto createStore(StoreRequestDto storeRequestDto);

}
