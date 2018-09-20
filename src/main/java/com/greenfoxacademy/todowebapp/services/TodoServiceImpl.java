package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
  TodoRepository todoRepository;

  @Autowired
  public TodoServiceImpl(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  public TodoList createList(String listname) {
    return new TodoList(listname);
  }

  @Override
  public List<TodoList> getLists() {
    return null;
  }

  @Override
  public TodoList getListById(long listId) {
    return null;
  }

  @Override
  public void addTodo(long listId, Todo todo) {

  }
}
