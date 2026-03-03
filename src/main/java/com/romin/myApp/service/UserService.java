package com.romin.myApp.service;

import com.romin.myApp.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    
    private final List<User> database = new ArrayList<>();

    public List<User> findAll() {
        return database;
    }

    public User findSpecificUser(long id) {
    return database.stream()
            .filter(user -> user.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public void save(User user) {
        database.add(user);
    }

    public String removeSpecificUser(long id){
        boolean remove =  database.removeIf(user -> user.getId() == id);
        return remove ? "user deleted" : "user not found";
    }

    public String removeAll() {
        database.clear();
        return "deleted";
    }

    public String UpdateUser(long id, User incomingUser){
        User existingUser = findSpecificUser(id);

        if(existingUser == null){ return "User not found";}

        if(incomingUser.getName() != null){
            existingUser.setName(incomingUser.getName());
        }
        if(incomingUser.getEmail() != null){
            existingUser.setEmail(incomingUser.getEmail());
        }
        if(incomingUser.getContactNo() != null){
            existingUser.setContactNo(incomingUser.getContactNo());
        }
        
        return "User update succesful";
    }
}