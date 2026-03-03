package com.romin.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romin.myApp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}