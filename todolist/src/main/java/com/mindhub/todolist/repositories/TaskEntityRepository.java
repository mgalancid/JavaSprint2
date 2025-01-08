package com.mindhub.todolist.repositories;

import com.mindhub.todolist.models.TaskEntity;
import com.mindhub.todolist.models.UserEntity;

public interface TaskEntityRepository {
    TaskEntity getTaskStatus(TaskEntity.TaskStatus status);
}
