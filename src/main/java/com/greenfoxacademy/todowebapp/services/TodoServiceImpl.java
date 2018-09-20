package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
  public ArrayList<TodoList> getLists() {
    return todoRepository.todolists;
  }

  @Override
  public TodoList getListById(int listId) {
    return todoRepository.todolists.get(listId);
  }

  @Override
  public void addTodo(int listId, Todo todo) {

  }

  public void addList(TodoList todoList) {
    todoRepository.todolists.add(todoList);
  }

  public void removeList(int id) {
    todoRepository.todolists.remove(id);
  }
}
