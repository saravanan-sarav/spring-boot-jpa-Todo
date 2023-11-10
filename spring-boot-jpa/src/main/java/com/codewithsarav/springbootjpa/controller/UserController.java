package com.codewithsarav.springbootjpa.controller;

import com.codewithsarav.springbootjpa.model.User;
import com.codewithsarav.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userService.login(user);
    }
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }
}
