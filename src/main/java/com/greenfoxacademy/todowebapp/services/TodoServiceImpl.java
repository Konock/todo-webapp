package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.repositories.TodoListRepository;
import com.greenfoxacademy.todowebapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

  public List<Todo> getAllTodos() {
    return todoRepository.findAll();
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
  public List<Todo> getSortedTodosByListId(long listId) {
    List<Todo> todolist = todoListRepository.findById(listId).getTodolist().stream()
        .sorted(Comparator.comparing(Todo::isCompleted))
        .sorted(Comparator.comparing(Todo::isPriority).reversed())
        .collect(Collectors.toList());
    return todolist;
  }

  @Override
  public List<Todo> searchTodoByTask(String task) {
    List<Todo> alltodos = todoRepository.findAll();
    List<Todo> foundTodos = new ArrayList<>();
    for (Todo todo : alltodos)
      if (todo.getTask().toLowerCase().contains(task.toLowerCase()))
        foundTodos.add(todo);
    return foundTodos;
  }

  @Override
  public List<Todo> getCompletedTodos() {
    return todoRepository.findByCompleted(true);
  }

  @Override
  public List<Todo> getPriorityTodos() {
    return todoRepository.findByPriority(true);
  }

  @Override
  public Todo getTodoById(long todoId) {
    return todoRepository.findById(todoId);
  }

  public void removeList(long id) {
    todoListRepository.delete(todoListRepository.findById(id));
  }

  @Override
  @Transactional
  public Todo addTodo(long listId, Todo newTodo) {
    TodoList todoList = todoListRepository.findById(listId);
    todoList.add(newTodo);
    todoListRepository.save(todoList);
    return newTodo;
  }

  @Override
  public Todo checkTodo(long todoId) {
    Todo todo = getTodoById(todoId);
    if (!todo.isCompleted()) {
      todo.setCompleted(true);
      todo.setPriority(false);
    } else {
      todo.setCompleted(false);
    }
    todoRepository.save(todo);
    return todo;
  }

  @Override
  public Todo editTodo(String task, long todoId) {
    Todo todo = getTodoById(todoId);
    todo.setTask(task);
    todoRepository.save(todo);
    return todo;
  }

  @Override
  public Todo raiseTodoPrio(long todoId) {
    Todo todo = getTodoById(todoId);
    if (!todo.isPriority())
      todo.setPriority(true);
    else
      todo.setPriority(false);
    todoRepository.save(todo);
    return todo;
  }

  @Transactional
  public void removeTodo(long listId, long todoId) {
    TodoList todoList = todoListRepository.findById(listId);
    todoList.remove(todoRepository.findById(todoId));
    todoListRepository.save(todoList);
    todoRepository.deleteById(todoId);
  }
}
