package com.greenfoxacademy.todowebapp.controllers;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoRestController {
  @Autowired
  TodoServiceImpl todoService;

  @GetMapping("/todos")
  public ResponseEntity<?> listAllTodos() {
    return ResponseEntity.status(HttpStatus.FOUND).body(todoService.getAllTodos());
  }

  @PostMapping("/addtodo/{listid}")
  public ResponseEntity<?> addTodo(@PathVariable(value = "listid") long listid, @RequestBody Todo todo) {
    todoService.addTodo(listid, todo);
    return ResponseEntity.status(HttpStatus.CREATED).body(todo);
  }
}
