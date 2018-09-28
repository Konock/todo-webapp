package com.greenfoxacademy.todowebapp.controllers;

import com.greenfoxacademy.todowebapp.models.User;
import com.greenfoxacademy.todowebapp.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  UserServiceImpl userService;

  public LoginController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String showLoginForm() {
    return "login/login.html";
  }

  @PostMapping("/login")
  public String loginUser(User user) {
    if (userService.validateUser(user)) {
      userService.loginUser(user);
      return "redirect:/";
    } else {
      return "login/login.html";
    }
  }

  @GetMapping("/signup")
  public String showSignupForm() {
    return "login/signup.html";
  }

  @PostMapping("/signup")
  public String signupUser(User user) {
    userService.createUser(user);
    return "login/login.html";
  }


}
