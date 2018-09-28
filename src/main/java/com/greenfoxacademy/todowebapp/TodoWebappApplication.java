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
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TodoWebappApplication implements CommandLineRunner {
  @Autowired
  TodoRepository todoRepository;
  @Autowired
  TodoListRepository todoListRepository;
  @Autowired
  UserRepository userRepository;


  public static void main(String[] args) {
    SpringApplication.run(TodoWebappApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Todo todo = new Todo("meh");
    TodoList todoList = new TodoList();
    todoList.add(todo);
    User user = new User("admin", "admin");
    List<TodoList> userlists = new ArrayList<>();
    userlists.add(todoList);
    user.setTodoLists(userlists);
    userRepository.save(user);
    todoListRepository.save(todoList);
    todoRepository.save(todo);
  }
}
