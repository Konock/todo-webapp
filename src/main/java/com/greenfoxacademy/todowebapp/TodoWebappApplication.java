package com.greenfoxacademy.todowebapp;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.services.TodoServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoWebappApplication implements CommandLineRunner {
  TodoServiceImpl todoService;

  public TodoWebappApplication(TodoServiceImpl todoService) {
    this.todoService = todoService;
  }

  public static void main(String[] args) {
    SpringApplication.run(TodoWebappApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    todoService.createList("Shopping");
    todoService.addTodo(1, new Todo("milk"));
    todoService.addTodo(1, new Todo("sugar"));
    todoService.addTodo(1, new Todo("chocolate"));
    todoService.createList("Learning");
    todoService.addTodo(2, new Todo("HTML"));
    todoService.addTodo(2, new Todo("CSS"));
    todoService.addTodo(2, new Todo("Heroku"));
    todoService.createList("Chores");
    todoService.addTodo(3, new Todo("do dishes"));
    todoService.addTodo(3, new Todo("vacuum floor"));
    todoService.addTodo(3, new Todo("clean cat toilet"));
  }
}
