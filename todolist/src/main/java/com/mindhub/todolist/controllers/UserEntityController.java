package com.mindhub.todolist.controllers;

import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserEntityController {
    @Autowired
    private UserEntityRepository userEntityRepository;

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userEntityRepository.findById(id).orElse(null);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Boolean> checkIfUsernameExist(@PathVariable String username) {
        boolean usernameExists = userEntityRepository.existsByUser(username);
        return ResponseEntity.ok(usernameExists);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Boolean> checkIfEmailExist(@PathVariable String email) {
        boolean emailExists = userEntityRepository.existByEmail(email);
        return ResponseEntity.ok(emailExists);
    }
}
