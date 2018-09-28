package com.greenfoxacademy.todowebapp.services;

import com.greenfoxacademy.todowebapp.models.TodoList;
import com.greenfoxacademy.todowebapp.models.User;
import com.greenfoxacademy.todowebapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  private final HttpSession session;
  private static final String sessionKey = "user";

  public UserServiceImpl(UserRepository userRepository, HttpSession session) {
    this.userRepository = userRepository;
    this.session = session;
  }

  @Override
  public boolean validateUser(User userToValidate) {
    boolean validate = false;
    List<User> userList = userRepository.findAll();
    for (User user : userList)
      if (user.getUsername().equals(userToValidate.getUsername()) && user.getPassword().equals(userToValidate.getPassword()))
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
  public User createUser(User user) {
    userRepository.save(user);
    return user;
  }

  @Override
  public void loginUser(User user) {
    session.setAttribute(sessionKey, user);
  }

  @Override
  public User getLoggedInUser() {
    return (User)session.getAttribute(sessionKey);
  }

  @Override
  public List<TodoList> getUsersTodolists(User user) {
    return user.getTodoLists();
  }
}
