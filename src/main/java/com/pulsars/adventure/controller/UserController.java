package com.pulsars.adventure.controller;

import com.pulsars.adventure.model.User;
import com.pulsars.adventure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

}
