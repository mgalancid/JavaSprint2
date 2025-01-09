package com.mindhub.todolist.services.impl;

import com.mindhub.todolist.dtos.NewUserEntityDTO;
import com.mindhub.todolist.dtos.UserEntityDTO;
import com.mindhub.todolist.exceptions.UserNotFoundException;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.UserEntityRepository;
import com.mindhub.todolist.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserEntityDTO getUserDTOById(Long id) throws UserNotFoundException {
        return new UserEntityDTO(getUserById(id));
    }

    @Override
    public UserEntity getUserById(Long id) throws UserNotFoundException {
        return userEntityRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity userEntity) throws UserNotFoundException {
        UserEntity existingUser = userEntityRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );
        existingUser.setUsername(userEntity.getUsername());
        existingUser.setEmail(userEntity.getEmail());

        return userEntityRepository.save(existingUser);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userEntityRepository.save(userEntity);
    }

    @Override
    public void deleteUser(long id) {
        userEntityRepository.deleteById(id);
    }

    @Override
    public void createNewUserEntity(NewUserEntityDTO newUserEntityDTO) {
        validatePerson(newUserEntityDTO);
        UserEntity userEntity = new UserEntity(newUserEntityDTO.name(),
                                                newUserEntityDTO.password(),
                                                newUserEntityDTO.email());
        saveUser(userEntity);
    }

    public void validatePerson(NewUserEntityDTO newUserEntityDTO){

    }
}
