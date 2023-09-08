package com.truper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
