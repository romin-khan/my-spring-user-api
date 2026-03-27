package com.romin.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romin.myApp.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
