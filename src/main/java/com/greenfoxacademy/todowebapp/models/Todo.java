package com.greenfoxacademy.todowebapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String task;
  private boolean completed;

  public Todo() {}

  public Todo(String task) {
    this.task = task;
    completed = false;
  }

  public void complete() {
    completed = true;
  }

  public String getTask() {
    return task;
  }

  public long getId() {
    return id;
  }

  public void setTask(String description) {
    task = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}
