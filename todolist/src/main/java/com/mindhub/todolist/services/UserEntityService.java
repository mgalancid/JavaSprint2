package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.UserEntityDTO;
import com.mindhub.todolist.exceptions.UserNotFoundException;

import java.util.List;

public interface UserEntityService {
    UserEntityDTO getUserDTOById(Long id) throws UserNotFoundException;
    List<UserEntityDTO> getAllUsersDTO();
    UserEntityDTO updateUser(Long id, UserEntityDTO userDetailsDTO) throws UserNotFoundException;
    UserEntityDTO createNewUser(UserEntityDTO newUserDTO);
    void deleteUser(Long id);
}
