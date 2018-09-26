package com.greenfoxacademy.todowebapp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TodoList {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Todo> todolist;

  public TodoList() {
    todolist = new ArrayList<>();
  }

  public TodoList(String name) {
    this.name = name;
    todolist = new ArrayList<>();
  }

  public void setTodolist(List<Todo> todolist) {
    this.todolist = todolist;
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

  public List<Todo> getTodolist() {
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
