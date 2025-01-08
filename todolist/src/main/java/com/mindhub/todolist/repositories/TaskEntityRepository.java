package com.mindhub.todolist.repositories;

import com.mindhub.todolist.models.TaskEntity;
import com.mindhub.todolist.models.UserEntity;

import java.util.List;

public interface TaskEntityRepository {
    List<TaskEntity> findByStatus(TaskEntity.TaskStatus status);
}
