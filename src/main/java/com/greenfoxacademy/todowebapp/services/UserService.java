package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.dtos.UserDTO;
import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.models.TodoUser;

import java.util.List;

public interface UserService {
  boolean validateUser(TodoUser todoUser);
  void loginUser(TodoUser todoUser);
  TodoUser getLoggedInUser();
  List<TodoList> getUsersTodolists(TodoUser todoUser);
  void addListToUser(TodoList list);
  void saveUser();
  TodoUser createUser(UserDTO userDTO);
}
