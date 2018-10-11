package com.greenfoxacademy.todowebapp.controllers;

import com.greenfoxacademy.todowebapp.models.TodoUser;
import com.greenfoxacademy.todowebapp.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginRestController(UserRepository userRepository,
                               BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody TodoUser todoUser) {
        todoUser.setPassword(bCryptPasswordEncoder.encode(todoUser.getPassword()));
        userRepository.save(todoUser);
    }
}