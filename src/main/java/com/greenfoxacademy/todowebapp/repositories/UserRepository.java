package com.greenfoxacademy.todowebapp.repositories;

import com.greenfoxacademy.todowebapp.models.TodoUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<TodoUser, Long> {
  List<TodoUser> findAll();
  TodoUser findByUserId(long userId);
  TodoUser findByUsername(String username);
}
