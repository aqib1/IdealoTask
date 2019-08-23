package com.idealo.toyrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Aqib_Javed
 * @version 1.0
 * @since 8/19/2019
 */
@SpringBootApplication
@ComponentScan("com.idealo.toyrobot")
public class RobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotApplication.class, args);
	}

}
