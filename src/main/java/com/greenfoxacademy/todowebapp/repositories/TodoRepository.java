package com.greenfoxacademy.todowebapp.repositories;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.models.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  Todo findById(long id);
  List<Todo> findAll();
  List<Todo> findByCompleted(boolean isCompleted);
  List<Todo> findByPriority(boolean isPriority);


}
