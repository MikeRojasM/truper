package com.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
