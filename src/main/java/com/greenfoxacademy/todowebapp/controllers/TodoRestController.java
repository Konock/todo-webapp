package com.greenfoxacademy.todowebapp.controllers;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoRestController {
  @Autowired
  TodoServiceImpl todoService;

  @GetMapping("/todos")
  public ResponseEntity<List<Todo>> listAllTodos() {
    return ResponseEntity.status(HttpStatus.FOUND).body(todoService.getAllTodos());
  }
}
