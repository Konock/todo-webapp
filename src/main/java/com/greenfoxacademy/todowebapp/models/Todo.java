package com.greenfoxacademy.todowebapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String task;
  private boolean completed;
  private boolean priority;

  public Todo(String task) {
    this.task = task;
    completed = false;
    priority = false;
  }
}
