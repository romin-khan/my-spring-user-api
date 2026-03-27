package com.romin.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romin.myApp.model.OrderItem;

@Repository
public interface OderItemRepository extends JpaRepository<OrderItem, Long>{
   
}
