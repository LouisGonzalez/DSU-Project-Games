package com.ProjectGames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class ProjectGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGamesApplication.class, args);
	}

}
