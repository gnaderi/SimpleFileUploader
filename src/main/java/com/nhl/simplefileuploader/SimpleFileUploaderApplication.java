package com.nhl.simplefileuploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SimpleFileUploaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleFileUploaderApplication.class, args);
	}
}
