package com.example.incidentmanager.User.domain;



import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository <UserEntity, Integer> {
    //public Iterable<UserEntity> findByEmail(String email);
    public UserEntity findByEmailIgnoreCase(String email);
    public boolean existsByEmailIgnoreCase(String email);
}
