package com.mindhub.todolist;

import com.mindhub.todolist.dtos.UserEntityDTO;
import com.mindhub.todolist.models.TaskEntity;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskEntityRepository;
import com.mindhub.todolist.repositories.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.config.Task;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UserEntityRepository userEntityRepository) {
		return args -> {
			UserEntity userEntity = new UserEntity("John Doe",
													"12345678",
													"johndoe@example.com");
			userEntityRepository.save(userEntity);
			System.out.println(userEntity);

			UserEntity userEntity1 = new UserEntity("Jane Doe",
													"87654321",
													"janedoe@example.com");
			userEntityRepository.save(userEntity1);
			UserEntity userEntity2 = new UserEntity("Bill Smith",
													"24680135",
													"billsmith@example.com");
			userEntityRepository.save(userEntity1);

			TaskEntity taskEntity = new TaskEntity("Task 1",
													"description",
													TaskEntity.TaskStatus.IN_PROCESS);
			userEntityRepository.save(userEntity1);
			TaskEntity taskEntity1 = new TaskEntity("Task 2",
					"description",
					TaskEntity.TaskStatus.PENDING);

			TaskEntity taskEntity2 = new TaskEntity("Task 3",
					"description",
					TaskEntity.TaskStatus.COMPLETED);
			userEntityRepository.save(userEntity2);
		};
	}
}
