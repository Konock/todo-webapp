package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.dtos.UserDTO;
import com.greenfoxacademy.todowebapp.models.Role;
import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.models.TodoUser;
import com.greenfoxacademy.todowebapp.repositories.RoleRepository;
import com.greenfoxacademy.todowebapp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private UserDetailsServiceImpl userDetailsService;

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserDetailsServiceImpl userDetailsService) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.userDetailsService = userDetailsService;
  }

  public void addListToUser(TodoUser user, TodoList list) {
    user.getTodoLists().add(list);
    saveUser(user);
  }

  public TodoUser getUserByName(String username) {
    return userRepository.findByUsername(username);
  }

  public void saveUser(TodoUser user) {
    userRepository.save(user);
  }

  @Override
  public TodoUser createUser(UserDTO userDTO) {
    TodoUser newUser = modelMapper().map(userDTO, TodoUser.class);
    Role userRole = roleRepository.findByRole("USER");
    if (userRole != null) {
      newUser.getRoles().add(userRole);
    } else {
      newUser.addRole("USER");
    }
    userRepository.save(newUser);
    return newUser;
  }

  @Override
  public List<TodoList> getUsersTodolists(TodoUser todoUser) {
    return todoUser.getTodoLists();
  }
}
