package com.app.TripSnap.Controller;

import com.app.TripSnap.Models.User;
import com.app.TripSnap.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository uc;

    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user) {
        uc.save(user);
        return user;
    }

    @GetMapping("/user/{id}")
    public Optional<User> viewUser(@PathVariable(value="id") Long id){
        return uc.findById(id);
    }

    @GetMapping("/user")
    public List<User> getAllUser(){
        return (List<User>) uc.findAll();
    }
}
