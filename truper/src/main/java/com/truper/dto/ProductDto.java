package com.truper.dto;

import com.truper.model.OrderEntity;

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
public class ProductDto {

	private OrderEntity order;
	private String code;
	private Double description;
	private Double price;
}
