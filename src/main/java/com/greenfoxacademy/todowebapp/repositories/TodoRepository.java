package com.greenfoxacademy.todowebapp.repositories;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.models.TodoList;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TodoRepository {
  public ArrayList<TodoList> todolists;

  public TodoRepository() {
    todolists = new ArrayList<>();
    todolists.add(new TodoList("Learn this"));
    todolists.get(0).add(new Todo("CSS"));
    todolists.get(0).add(new Todo("Spring"));
    todolists.get(0).add(new Todo("Thymeleaf"));
    todolists.add(new TodoList("Buy this"));
    todolists.get(1).add(new Todo("milk"));
    todolists.get(1).add(new Todo("cat food"));
    todolists.get(1).add(new Todo("new bike"));
    todolists.add(new TodoList("Do this"));
    todolists.get(2).add(new Todo("create todo app"));
    todolists.get(2).add(new Todo("enjoy enjoy"));
    todolists.get(2).add(new Todo("pet Furkesz"));
  }
}
