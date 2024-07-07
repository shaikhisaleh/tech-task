package com.salshaikhi.task;

import com.salshaikhi.task.model.User;
import com.salshaikhi.task.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}


	@Bean
	public CommandLineRunner addUser(UserRepository userRepository) {
		return (args) -> {
			User user = new User();
			user.setFullName("Saleh Alshaikhi");
			user.setEmail("admin@email.com");
			user.setPassword("$2a$12$DgxxAxMFWZnUvC5mF/.jGOgI0dHxnRpqCK7MAZacWpwmIiPz8XL4a"); //use 'password'
			userRepository.save(user);
		};
	}
}
