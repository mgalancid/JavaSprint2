package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.NewTaskEntityDTO;
import com.mindhub.todolist.dtos.TaskEntityDTO;
import com.mindhub.todolist.exceptions.TaskNotFoundException;
import com.mindhub.todolist.models.TaskEntity;

public interface TaskEntityService {
    TaskEntityDTO getTaskDTOById(Long id) throws TaskNotFoundException;
    TaskEntity getTaskById(Long id) throws TaskNotFoundException;
    TaskEntity updateTask(Long id, TaskEntity taskEntity) throws TaskNotFoundException; // PUT
    void saveTask(TaskEntity taskEntity);
    void deleteTask(Long id); // DELETE
    void createNewTaskEntity (NewTaskEntityDTO newTaskEntityDTO);
}
