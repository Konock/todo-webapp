package com.greenfoxacademy.todowebapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "todoUser")
@Getter
@Setter
@NoArgsConstructor
public class TodoUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;
  private String username;
  private String password;
  @OneToMany(cascade = CascadeType.ALL)
  private List<TodoList> todoLists;
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "users_roles",
      joinColumns = {@JoinColumn(name = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id")}
  )
  private Set<Role> roles = new HashSet<Role>();

  public TodoUser(String username, String password) {
    todoLists = new ArrayList<>();
    this.username = username;
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public void addRole(String role) {
    roles.add(new Role(role, this));
  }
}
