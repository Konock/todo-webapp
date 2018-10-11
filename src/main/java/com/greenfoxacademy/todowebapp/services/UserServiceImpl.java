package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.dtos.UserDTO;
import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.models.TodoUser;
import com.greenfoxacademy.todowebapp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  private final HttpSession session;
  private static final String sessionKey = "user";

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  public UserServiceImpl(UserRepository userRepository, HttpSession session) {
    this.userRepository = userRepository;
    this.session = session;
  }

  @Override
  public boolean validateUser(TodoUser todoUserToValidate) {
    boolean validate = false;
    List<TodoUser> todoUserList = userRepository.findAll();
    for (TodoUser todoUser : todoUserList)
      if (todoUser.getUsername().equals(todoUserToValidate.getUsername()) && todoUser.getPassword().equals(todoUserToValidate.getPassword()))
        validate = true;
    return validate;
  }

  public void addListToUser(TodoList list) {
    getLoggedInUser().getTodoLists().add(list);
    saveUser();
  }

  public void saveUser() {
    userRepository.save(getLoggedInUser());
  }

  @Override
  public TodoUser createUser(UserDTO userDTO) {
    TodoUser todoUser = modelMapper().map(userDTO, TodoUser.class);
    userRepository.save(todoUser);
    return todoUser;
  }

  @Override
  public void loginUser(TodoUser todoUser) {
    session.setAttribute(sessionKey, todoUser);
  }

  @Override
  public TodoUser getLoggedInUser() {
    return (TodoUser)session.getAttribute(sessionKey);
  }

  @Override
  public List<TodoList> getUsersTodolists(TodoUser todoUser) {
    return todoUser.getTodoLists();
  }
}
