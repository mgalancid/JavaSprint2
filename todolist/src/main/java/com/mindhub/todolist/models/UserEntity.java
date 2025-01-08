package com.mindhub.todolist.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public UserEntity() { // Hibernate

    }

    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    private String email;

    @OneToMany(mappedBy = "user")
    private Set<TaskEntity> task = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<TaskEntity> getTask() {
        return task;
    }

    public void setTask(Set<TaskEntity> task) {
        this.task = task;
    }

}
