package com.greenfoxacademy.todowebapp.models;

import java.util.ArrayList;

public class TodoList {
  private static int idCounter = 0;
  private long id;
  private String name;
  private ArrayList<Todo> todolist;

  public TodoList() {
    id = idCounter++;
    todolist = new ArrayList<>();
  }

  public TodoList(String name) {
    id = idCounter++;
    this.name = name;
    todolist = new ArrayList<>();
  }

  public void add(Todo todo) {
    todolist.add(todo);
  }

  public void remove(Todo todo) {
    if (todolist.contains(todo))
      todolist.remove(todo);
  }

  public Todo getTodoById(int todoID) {
    int num = 0;
    for (int i = 0; i < todolist.size(); i++) {
      if (todolist.get(i).getId() == todoID)
        num = i;
    }
    return todolist.get(num);
  }

  public ArrayList<Todo> getTodolist() {
    return todolist;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
