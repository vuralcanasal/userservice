package com.catdog.userservice;

import com.catdog.userservice.service.InitialData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

	private final InitialData initialData;

	public UserServiceApplication(InitialData initialData) {
		this.initialData = initialData;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Start the user service app!!");
		//initialData.createInitialData();
	}
}
