package com.mindhub.todolist.repositories;

import com.mindhub.todolist.models.TaskEntity;
import com.mindhub.todolist.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskEntityRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByStatus(TaskEntity.TaskStatus status);
}
