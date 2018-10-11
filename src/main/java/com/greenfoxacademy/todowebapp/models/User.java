package com.greenfoxacademy.todowebapp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="todoUser")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;
  private String username;
  private String password;
  @OneToMany(cascade = CascadeType.ALL)
  private List<TodoList> todoLists;

  public User() {
    todoLists = new ArrayList<>();
  }

  // public User(String username, String password) {
  //   todoLists = new ArrayList<>();
  //   this.username = username;
  //   this.password = password;
  // }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<TodoList> getTodoLists() {
    return todoLists;
  }

  public void setTodoLists(List<TodoList> todoLists) {
    this.todoLists = todoLists;
  }
}
