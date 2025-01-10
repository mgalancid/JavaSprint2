package com.mindhub.todolist.controllers;

import com.mindhub.todolist.dtos.TaskEntityDTO;
import com.mindhub.todolist.exceptions.TaskNotFoundException;
import com.mindhub.todolist.services.impl.TaskEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskEntityController {
    @Autowired
    private TaskEntityServiceImpl taskService;

    public TaskEntityController(TaskEntityServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public TaskEntityDTO getTaskById(@PathVariable Long id) throws TaskNotFoundException {
        return taskService.getTaskDTOById(id);
    }

    @GetMapping
    public List<TaskEntityDTO> getAllTasksDTO() {
        return taskService.getAllTasksDTO();
    }

    @PutMapping("/{id}")
    public TaskEntityDTO updateTaskDTO(@PathVariable Long id,
                                       @RequestBody TaskEntityDTO taskDetailsDTO) throws TaskNotFoundException{
        return taskService.updateTask(id, taskDetailsDTO);
    }

    @PostMapping
    public TaskEntityDTO createNewTask(@RequestBody TaskEntityDTO taskDTO) {
        return taskService.createNewTask(taskDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


}
