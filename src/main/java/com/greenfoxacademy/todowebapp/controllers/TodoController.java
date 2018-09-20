package com.greenfoxacademy.todowebapp.controllers;

import com.greenfoxacademy.todowebapp.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
  TodoServiceImpl todoService;

  @Autowired
  public TodoController(TodoServiceImpl todoService) {
    this.todoService = todoService;
  }

  @GetMapping(value={"/", "todoapp"})
  public String loadApp() {
    return "index";
  }
}
