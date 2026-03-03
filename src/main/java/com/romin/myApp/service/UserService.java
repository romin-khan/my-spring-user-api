package com.romin.myApp.service;

import com.romin.myApp.model.User;
import com.romin.myApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // This connects to the DB

    public List<User> getAllUsers() {
        return userRepository.findAll(); // Logic is handled by JPA
    }

    public User addUser(User user) {
        return userRepository.save(user); // Logic is handled by JPA
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUser(){
        userRepository.deleteAll();
    }
    
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {

            if (updatedUser.getName() != null) user.setName(updatedUser.getName());
            if (updatedUser.getEmail() != null) user.setEmail(updatedUser.getEmail());
            if (updatedUser.getContactNo() != null) user.setContactNo(updatedUser.getContactNo());

            return userRepository.save(user);

        }).orElse(null);
    }
}