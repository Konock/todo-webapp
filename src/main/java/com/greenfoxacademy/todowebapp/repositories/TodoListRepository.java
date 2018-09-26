package com.greenfoxacademy.todowebapp.repositories;

import com.greenfoxacademy.todowebapp.models.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Long> {
  TodoList findById(long id);
  List<TodoList> findAll();
}
