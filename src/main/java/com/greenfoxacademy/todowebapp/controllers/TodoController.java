package com.greenfoxacademy.todowebapp.controllers;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.services.TodoServiceImpl;
import com.greenfoxacademy.todowebapp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {
  TodoServiceImpl todoService;
  UserServiceImpl userService;
  private static long activeListId;

  @Autowired
  public TodoController(TodoServiceImpl todoService, UserServiceImpl userService) {
    this.todoService = todoService;
    this.userService = userService;
  }

  @GetMapping("/")
  public String loadApp() {
    if (userService.getLoggedInUser() == null) {
      return "nolistsview";
    } else {
      return "redirect:/getlist";
    }
  }

  @GetMapping("getlist")
  public String getLists(Model model) {
    model.addAttribute("todolistlist", userService.getUsersTodolists(userService.getLoggedInUser()));
    return "getlistsview";
  }

  @GetMapping("getlist/{todolist.id}")
  public String getList(@PathVariable(value = "todolist.id") int id, Model model) {
    activeListId = id;
    model.addAttribute("todolistlist", userService.getUsersTodolists(userService.getLoggedInUser()));
    model.addAttribute("todolistobject", todoService.getListById(activeListId));
    model.addAttribute("todolist", todoService.getSortedTodosByListId(activeListId));
    return "index";
  }

  @PostMapping("/addlist")
  public String addList(@ModelAttribute(value = "name") String name) {
    userService.addListToUser(todoService.createList(name));
    return "redirect:/";
  }

  @RequestMapping("deletelist/{todolist.id}")
  public String deleteList(@PathVariable(value = "todolist.id") long id) {
    todoService.removeList(id);
    return "redirect:/";
  }

  @PostMapping("/addtodo")
  public String addTodo(@ModelAttribute(value = "task") String task) {
    todoService.addTodo(activeListId, new Todo(task));
    return "redirect:/getlist/" + activeListId;
  }

  @GetMapping("/delete/{todo.id}")
  public String deleteTodo(@PathVariable(value = "todo.id") long todoid) {
    todoService.removeTodo(activeListId, todoid);
    return "redirect:/getlist/" + activeListId;
  }

  @GetMapping("/check/{todo.id}")
  public String checkTodo(@PathVariable(value = "todo.id") long todoid) {
    todoService.checkTodo(todoid);
    return "redirect:/getlist/" + activeListId;
  }

  @GetMapping("/setprio/{todo.id}")
  public String prioritizeTodo(@PathVariable(value = "todo.id") long todoid) {
    todoService.raiseTodoPrio(todoid);
    return "redirect:/getlist/" + activeListId;
  }

  @PostMapping("/edit/{todo.id}")
  public String editTodo(@PathVariable(value = "todo.id") long todoid, @ModelAttribute(value = "task") String task) {
    todoService.editTodo(task, todoid);
    return "redirect:/getlist/" + activeListId;
  }

  @PostMapping("/searchtodos")
  public String searchTodos(Model model, @ModelAttribute(value="search") String task) {
    model.addAttribute("todolistlist", userService.getUsersTodolists(userService.getLoggedInUser()));
    model.addAttribute("todolist", todoService.searchTodoByTask(task));
    return "customsearchview";
  }

  @GetMapping("/getcompleted")
  public String getCompleted(Model model) {
    model.addAttribute("todolistlist", userService.getUsersTodolists(userService.getLoggedInUser()));
    model.addAttribute("todolist", todoService.getCompletedTodos());
    return "customsearchview";
  }

  @GetMapping("/getpriority")
  public String getPriority(Model model) {
    model.addAttribute("todolistlist", userService.getUsersTodolists(userService.getLoggedInUser()));
    model.addAttribute("todolist", todoService.getPriorityTodos());
    return "customsearchview";
  }
}
