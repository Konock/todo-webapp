package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.repositories.TodoListRepository;
import com.greenfoxacademy.todowebapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
  TodoRepository todoRepository;
  TodoListRepository todoListRepository;

  @Autowired
  public TodoServiceImpl(TodoRepository todoRepository, TodoListRepository todoListRepository) {
    this.todoRepository = todoRepository;
    this.todoListRepository = todoListRepository;
  }

  @Override
  public TodoList createList(String listname) {
    TodoList todoList = new TodoList(listname);
    todoListRepository.save(todoList);
    return todoList;
  }

  @Override
  public List<TodoList> getLists() {
    return todoListRepository.findAll();
  }

  @Override
  public TodoList getListById(long listId) {
    return todoListRepository.findById(listId);
  }

  @Override
  @Transactional
  public Todo addTodo(long listId, Todo newTodo) {
    TodoList todoList = todoListRepository.findById(listId);
    todoList.add(newTodo);
    todoListRepository.save(todoList);
    return newTodo;
  }

  public void removeList(long id) {
    todoListRepository.delete(todoListRepository.findById(id));
  }

  @Transactional
  public void removeTodo(long listId, long todoId) {
    TodoList todoList = todoListRepository.findById(listId);
    todoList.remove(todoRepository.findById(todoId));
    todoListRepository.save(todoList);
  }
}
