package com.greenfoxacademy.todowebapp;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.services.TodoServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoWebappApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoWebappApplication.class, args);
  }
}
