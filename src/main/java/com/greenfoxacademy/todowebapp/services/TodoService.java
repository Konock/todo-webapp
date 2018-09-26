package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.models.TodoList;

import java.util.List;

public interface TodoService {

  TodoList createList(String listname);
  List<TodoList> getLists();
  TodoList getListById(long listId);
  Todo getTodoById(long todoId);
  Todo addTodo(long listId, Todo todo);
  void removeList(long id);
}
