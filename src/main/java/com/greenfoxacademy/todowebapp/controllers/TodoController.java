package com.greenfoxacademy.todowebapp.controllers;

import com.greenfoxacademy.todowebapp.models.Todo;
import com.greenfoxacademy.todowebapp.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {
  TodoServiceImpl todoService;

  @Autowired
  public TodoController(TodoServiceImpl todoService) {
    this.todoService = todoService;
  }

  @GetMapping(value={"/", "todoapp"})
  public String loadApp(Model model) {
    model.addAttribute("todolistlist", todoService.getLists());
    model.addAttribute("todolistobject", todoService.getListById(0));
    model.addAttribute("todolist", todoService.getListById(0).getTodolist());
    return "index";
  }

  @GetMapping("getlist/{todolist.id}")
  public String getList(@PathVariable(value = "todolist.id") int id, Model model) {
    model.addAttribute("todolists", todoService.getLists());
    model.addAttribute("todolistobject", todoService.getListById(id));
    model.addAttribute("todos", todoService.getListById(id).getTodolist());
    return "index";
  }

  @PostMapping("/addlist")
  public String addList(@ModelAttribute(value="name") String name) {
    todoService.addList(todoService.createList(name));
    return "redirect:";
  }

  @GetMapping("deletelist/{todolist.id}")
  public String deleteList(@PathVariable(value = "todolist.id") int id) {
    todoService.removeList(id);
    return "redirect:";
  }

  @PostMapping("/getlist/{todolistobject.id}/addtodo/")
  public String addTodo(@PathVariable(value = "todolistobject.id") int listid, @ModelAttribute(value="task") String task) {
    todoService.getListById(listid).add(new Todo(task));
    return "redirect:";
  }

  @GetMapping("getlist/{todolistobject.id}/delete/{todo.id}")
  public String deleteTodo(@PathVariable(value = "todolistobject.id") int listid,@PathVariable(value = "todo.id") int id) {
    todoService.getListById(listid).remove(id);
    return "redirect:";
  }
}
