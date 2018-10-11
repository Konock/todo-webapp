package com.greenfoxacademy.todowebapp;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.models.User;
import com.greenfoxacademy.todowebapp.repositories.TodoListRepository;
import com.greenfoxacademy.todowebapp.repositories.TodoRepository;
import com.greenfoxacademy.todowebapp.repositories.UserRepository;
import com.greenfoxacademy.todowebapp.services.TodoServiceImpl;
import com.greenfoxacademy.todowebapp.services.UserService;
import com.greenfoxacademy.todowebapp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TodoWebappApplication implements CommandLineRunner {


  public static void main(String[] args) {
    SpringApplication.run(TodoWebappApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
  }
}
