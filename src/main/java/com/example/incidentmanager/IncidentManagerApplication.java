package com.example.incidentmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.incidentmanager.User.domain.UserEntity;
import com.example.incidentmanager.User.security.adapter.SecurityController;

@SpringBootApplication
public class IncidentManagerApplication implements CommandLineRunner{
	private final SecurityController controller;

	public IncidentManagerApplication(SecurityController controller){
		this.controller = controller;
	}

	public static void main(String[] args) {
		SpringApplication.run(IncidentManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserEntity admin = new UserEntity(0, "Daniel", "Luga", "daniel@gmail.com", "2ºDam", "ADMIN", "123456");
		try {
			this.controller.registerUser(admin);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
