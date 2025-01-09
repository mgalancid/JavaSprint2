package com.mindhub.todolist.models;

import jakarta.persistence.*;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title, description;
    private TaskStatus status;

    public TaskEntity() {

    }

    public TaskEntity(String title,  String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    @ManyToOne
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public enum TaskStatus {
        PENDING,
        IN_PROCESS,
        COMPLETED,
    }
}
