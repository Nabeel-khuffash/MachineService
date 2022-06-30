package com.example.MachineService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MachineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MachineServiceApplication.class, args);
		System.out.println("Server is up!");
	}

}
