package com.mindhub.todolist.dtos;

import com.mindhub.todolist.models.UserEntity;

public class UserEntityDTO {
    private final Long id;
    private final String name;
    private final String email;

    public UserEntityDTO (UserEntity user) {
        id = user.getId();
        name = user.getUsername();
        email = user.getEmail();
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
}
