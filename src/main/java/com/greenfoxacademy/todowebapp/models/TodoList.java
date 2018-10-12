package com.greenfoxacademy.todowebapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class TodoList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
