package com.readyMadeProjects.projectTrackerTool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ProjectTrackerToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTrackerToolApplication.class, args);
	}

}
