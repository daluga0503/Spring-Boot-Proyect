package com.example.incidentmanager.User.service;


import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.incidentmanager.User.domain.UserEntity;



public interface UserService {

    public Iterable<UserEntity> getAll();

    public UserEntity create(UserEntity user);

    public UserEntity update(int id, UserEntity user);

    public void delete(int id);

    public void register(UserEntity user);

    public UserEntity login(String email, String password, PasswordEncoder encoder);

    public boolean userExists(String email);

    public UserEntity me();

}
