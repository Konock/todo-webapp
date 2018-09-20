package com.greenfoxacademy.todowebapp.repositories;

import com.greenfoxacademy.todowebapp.models.TodoList;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

  TodoList todolist1 = new TodoList("Learn this");
  TodoList todolist2 = new TodoList("Buy this");
  TodoList todolist3 = new TodoList("Write this");
}
