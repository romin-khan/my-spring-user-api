package com.romin.myApp.repository;

import com.romin.myApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // That's it. No code inside. 
    // You now have save(), findById(), findAll(), and deleteById() for free.
}