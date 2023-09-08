package com.truper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StoreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sucursal_id", nullable = false)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	private String name;

}
