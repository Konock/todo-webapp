package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.models.User;

import java.util.List;

public interface UserService {
  boolean validateUser(User user);
  void loginUser(User user);
  User getLoggedInUser();
  List<TodoList> getUsersTodolists(User user);
  void addListToUser(TodoList list);
  void saveUser();
  User createUser(User user);
}
