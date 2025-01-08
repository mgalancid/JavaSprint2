package com.mindhub.todolist.repositories;

import com.mindhub.todolist.models.UserEntity;

public interface TaskEntityRepository {
    UserEntity findbyID(Long id);
    UserEntity existsbyId(Long id);
    UserEntity countBy(Long Id);
}
