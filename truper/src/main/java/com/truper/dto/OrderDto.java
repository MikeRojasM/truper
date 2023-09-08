package com.truper.dto;

import java.time.LocalDate;

import com.truper.model.StoreEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderDto {
	
	private StoreEntity store;
	private LocalDate date;
	private Double total;
}
