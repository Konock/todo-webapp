package com.greenfoxacademy.todowebapp.controllers;

import com.greenfoxacademy.todowebapp.models.User;
import com.greenfoxacademy.todowebapp.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  UserServiceImpl userService;

  public LoginController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String showForm() {
    return "login";
  }

  @PostMapping("/login")
  public String loginUser(User user) {
    if (userService.validateUser(user)) {
      userService.loginUser(user);
      return "redirect:/";
    } else {
      return "login";
    }
  }


}
