package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.NewTaskEntityDTO;
import com.mindhub.todolist.dtos.TaskEntityDTO;
import com.mindhub.todolist.exceptions.TaskNotFoundException;
import com.mindhub.todolist.models.TaskEntity;

import java.util.List;

public interface TaskEntityService {
    TaskEntityDTO getTaskDTOById(Long id) throws TaskNotFoundException;
    TaskEntity getTaskById(Long id) throws TaskNotFoundException;
    List<TaskEntity> getAllTasks();
    TaskEntity updateTask(Long id, TaskEntity taskEntity) throws TaskNotFoundException; // PUT
    void saveTask(TaskEntity taskEntity);
    void deleteTask(Long id); // DELETE
    void createNewTaskEntity (NewTaskEntityDTO newTaskEntityDTO);
}
