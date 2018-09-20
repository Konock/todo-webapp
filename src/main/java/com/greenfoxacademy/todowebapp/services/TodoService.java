package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.models.TodoList;

import java.util.List;

public interface TodoService {

  TodoList createList(String listname);
  List<TodoList> getLists();
  TodoList getListById(int listId);
  void addTodo(int listId, Todo todo);
}
