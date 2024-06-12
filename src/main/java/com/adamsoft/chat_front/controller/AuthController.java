package com.adamsoft.chat_front.controller;

import com.adamsoft.chat_front.domain.User;
import com.adamsoft.chat_front.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && userService.checkPassword(user.getPassword(), foundUser.getPassword())) {
            return foundUser;
        }
        throw new RuntimeException("Invalid login credentials");
    }
}
