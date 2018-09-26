package com.greenfoxacademy.todowebapp.repositories;

import com.greenfoxacademy.todowebapp.models.TodoList;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TodoListRepository extends CrudRepository<TodoList, Long> {
  TodoList findById(long id);
  ArrayList<TodoList> findAll();
}
