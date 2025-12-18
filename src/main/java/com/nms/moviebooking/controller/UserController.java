package com.nms.moviebooking.controller;

import com.nms.moviebooking.model.User;
import com.nms.moviebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public Optional<User> login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
}
