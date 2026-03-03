package com.romin.myApp.controller;

import com.romin.myApp.model.User;
import com.romin.myApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired // Spring "injects" the Service singleton here
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getspecificUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public void create(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecificUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @DeleteMapping
    public void removeAll(){
        userService.deleteAllUser();
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}