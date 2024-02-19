package com.example.incidentmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.incidentmanager.User.domain.UserEntity;
import com.example.incidentmanager.User.service.UserService;

@SpringBootApplication
public class IncidentManagerApplication implements CommandLineRunner{
	private final UserService service;

	public IncidentManagerApplication(UserService service){
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(IncidentManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserEntity admin = new UserEntity(0, "Daniel", "Luga", "daniel@gmail.com", "2ºDam", "ADMIN", "123456");
		try {
			this.service.create(admin);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
