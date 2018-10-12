package com.greenfoxacademy.todowebapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class Role {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String role;
  @ManyToMany( mappedBy = "roles")
  private Set<TodoUser> users = new HashSet<TodoUser>();

  public Role(String role, TodoUser user) {
    this.role = role;
    users.add(user);
  }
}
