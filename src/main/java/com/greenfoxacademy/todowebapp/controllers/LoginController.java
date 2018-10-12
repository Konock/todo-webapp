package com.greenfoxacademy.todowebapp.controllers;

import com.greenfoxacademy.todowebapp.dtos.UserDTO;
import com.greenfoxacademy.todowebapp.services.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  private UserServiceImpl userService;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public LoginController(UserServiceImpl userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userService = userService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @GetMapping("/signup")
  public String showSignupForm(Model model) {
    model.addAttribute("newuser", new UserDTO());
    return "login/signup.html";
  }

  @PostMapping("/signup")
  public String signupUser(@ModelAttribute UserDTO user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    userService.createUser(user);
    return "redirect:login/login.html";
  }


}
