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
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User getspecificUser(@PathVariable long id){
        return userService.findSpecificUser(id);
    }

    @PostMapping
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecificUser(@PathVariable long id) {
        userService.removeSpecificUser(id);
    }

    @DeleteMapping
    public void removeAll(){
        userService.removeAll();
    }
    
    @PutMapping("/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        return userService.UpdateUser(id, user);
    }
}