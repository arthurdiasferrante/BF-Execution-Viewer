package com.bfvisualizer.interpreter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class InterpreterApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterpreterApplication.class, args);
	}

}
