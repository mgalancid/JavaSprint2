package com.mindhub.todolist.services.impl;

import com.mindhub.todolist.dtos.NewTaskEntityDTO;
import com.mindhub.todolist.dtos.TaskEntityDTO;
import com.mindhub.todolist.exceptions.TaskNotFoundException;
import com.mindhub.todolist.models.TaskEntity;
import com.mindhub.todolist.repositories.TaskEntityRepository;
import com.mindhub.todolist.services.TaskEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskEntityServiceImpl implements TaskEntityService {

    @Autowired
    private TaskEntityRepository taskEntityRepository;

    @Override
    public TaskEntityDTO getTaskDTOById(Long id) throws TaskNotFoundException {
        return new TaskEntityDTO(getTaskById(id));
    }

    @Override
    public TaskEntity getTaskById(Long id) throws TaskNotFoundException {
        return taskEntityRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException("Task not found")
        );
    }

    @Override
    public List<TaskEntity> getAllTasks() {
        return taskEntityRepository.findAll();
    }

    @Override
    public TaskEntity updateTask(Long id, TaskEntity taskEntity) throws TaskNotFoundException {
        TaskEntity existingTask = taskEntityRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException("Task not found")
        );
        existingTask.setTitle(taskEntity.getTitle());
        existingTask.setDescription(taskEntity.getDescription());
        existingTask.setStatus(taskEntity.getStatus());
        return taskEntityRepository.save(existingTask);
    }

    @Override
    public void saveTask(TaskEntity taskEntity) {
        taskEntityRepository.save(taskEntity);
    }

    @Override
    public void deleteTask(Long id) {
        taskEntityRepository.deleteById(id);
    }

    @Override
    public void createNewTaskEntity(NewTaskEntityDTO newTaskEntityDTO) {
        validateTask(newTaskEntityDTO);
        TaskEntity taskEntity = new TaskEntity(newTaskEntityDTO.title(),
                                                newTaskEntityDTO.description(),
                                                newTaskEntityDTO.status());
        saveTask(taskEntity);
    }

    public void validateTask(NewTaskEntityDTO newTaskEntityDTO) {

    }
}
