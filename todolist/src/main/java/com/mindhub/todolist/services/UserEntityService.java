package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.NewUserEntityDTO;
import com.mindhub.todolist.dtos.UserEntityDTO;
import com.mindhub.todolist.exceptions.UserNotFoundException;
import com.mindhub.todolist.models.UserEntity;

public interface UserEntityService {
    UserEntityDTO getUserDTOById(Long id) throws UserNotFoundException;
    UserEntity getUserById(Long id) throws UserNotFoundException;
    UserEntity updateUser(Long id, UserEntity userEntity) throws UserNotFoundException;
    void saveUser(UserEntity userEntity);
    void deleteUser(long id); // DELETE
    void createNewUserEntity(NewUserEntityDTO newUserEntityDTO); //POST
}
