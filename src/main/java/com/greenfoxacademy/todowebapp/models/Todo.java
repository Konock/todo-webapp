package com.greenfoxacademy.todowebapp.models;

import java.time.LocalDateTime;

public class Todo {
  private static int idCounter = 0;
  private int id;
  private LocalDateTime createdAt;
  private LocalDateTime completedAt;
  private String task;

  public Todo(String task) {
    id = idCounter++;
    createdAt = LocalDateTime.now();
    this.task = task;
  }

  public Todo(int id, String task, LocalDateTime createdAt, LocalDateTime completedAt) {
    this.id = id;
    this.task = task;
    this.createdAt = createdAt;
    this.completedAt = completedAt;
  }

  public boolean isCompleted() {
    boolean isCompleted = false;
    if (completedAt != null && completedAt.compareTo(LocalDateTime.now()) < 0)
      isCompleted = true;
    return isCompleted;
  }

  public void complete() {
    completedAt = LocalDateTime.now();
  }

  public String getTask() {
    return task;
  }

  public int getId() {
    return id;
  }

  public void setTask(String description) {
    task = description;
  }

  public static void setIdCounter(int count) {
    idCounter = count;
  }
}
