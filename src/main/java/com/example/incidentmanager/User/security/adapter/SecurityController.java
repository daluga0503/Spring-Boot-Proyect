package com.example.incidentmanager.User.security.adapter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;

import com.example.incidentmanager.User.domain.UserEntity;
import com.example.incidentmanager.User.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class SecurityController {

    private final UserService service;
    private final PasswordEncoder encoder;

    public SecurityController(UserService service, PasswordEncoder encoder){
        this.service = service;
        this.encoder = encoder;
    }
    
    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserEntity entity) {
        String encodedPassword = this.encoder.encode(entity.getPassword());
        entity.setPassword(encodedPassword);
        return service.create(entity);
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(CsrfToken token){
        return token;
    }

    @GetMapping("/login")
    public UserEntity loginUser(@RequestParam String email, String password) {
        return service.login(email, password, encoder);
    }
    
    
}
