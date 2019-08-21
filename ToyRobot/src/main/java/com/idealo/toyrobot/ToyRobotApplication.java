package com.idealo.toyrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.idealo.toyrobot")
public class ToyRobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyRobotApplication.class, args);
	}

}
