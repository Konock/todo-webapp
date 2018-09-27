package com.greenfoxacademy.todowebapp.controllers;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {
  TodoServiceImpl todoService;

  @Autowired
  public TodoController(TodoServiceImpl todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/")
  public String loadApp() {
    if (todoService.getLists() == null) {
      return "nolistsview";
    } else {
      return "redirect:/getlist";
    }
  }

  @GetMapping("getlist")
  public String getLists(Model model) {
    model.addAttribute("todolistlist", todoService.getLists());
    return "getlistsview";
  }

  @GetMapping("getlist/{todolist.id}")
  public String getList(@PathVariable(value = "todolist.id") int id, Model model) {
    model.addAttribute("todolistlist", todoService.getLists());
    model.addAttribute("todolistobject", todoService.getListById(id));
    model.addAttribute("todolist", todoService.getListById(id).getTodolist());
    return "index";
  }

  @PostMapping("/addlist")
  public String addList(@ModelAttribute(value = "name") String name) {
    todoService.createList(name);
    return "redirect:/";
  }

  @RequestMapping("deletelist/{todolist.id}")
  public String deleteList(@PathVariable(value = "todolist.id") long id) {
    todoService.removeList(id);
    return "redirect:/";
  }

  @PostMapping(value = {"/{todolistobject.id}/addtodo", "/getlist/{todolistobject.id}/addtodo"})
  public String addTodo(@PathVariable(value = "todolistobject.id") long listid, @ModelAttribute(value = "task") String task) {
    todoService.addTodo(listid, new Todo(task));
    return "redirect:/getlist/{todolistobject.id}";
  }

  @GetMapping(value = {"/{todolistobject.id}/delete/{todo.id}", "/getlist/{todolistobject.id}/delete/{todo.id}"})
  public String deleteTodo(@PathVariable(value = "todolistobject.id") long listid, @PathVariable(value = "todo.id") long todoid) {
    todoService.removeTodo(listid, todoid);
    return "redirect:/getlist/{todolistobject.id}";
  }

  @GetMapping(value = {"/{todolistobject.id}/check/{todo.id}", "/getlist/{todolistobject.id}/check/{todo.id}"})
  public String checkTodo(@PathVariable(value = "todolistobject.id") long listid, @PathVariable(value = "todo.id") long todoid) {
    todoService.checkTodo(todoid);
    return "redirect:/getlist/{todolistobject.id}";
  }
}
