package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.dtos.UserDTO;
import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.models.TodoUser;

import java.util.List;

public interface UserService {
  List<TodoList> getUsersTodolists(TodoUser todoUser);
  void addListToUser(TodoUser user, TodoList list);
  void saveUser(TodoUser user);
  TodoUser createUser(UserDTO userDTO);
}
