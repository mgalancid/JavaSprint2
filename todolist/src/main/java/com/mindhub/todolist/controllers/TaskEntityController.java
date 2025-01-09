package com.mindhub.todolist.controllers;

import com.mindhub.todolist.models.TaskEntity;
import com.mindhub.todolist.repositories.TaskEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskEntityController {
    @Autowired
    private TaskEntityRepository taskEntityRepository;

}
