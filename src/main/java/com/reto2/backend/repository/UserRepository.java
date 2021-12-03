package com.reto2.backend.repository;

import com.reto2.backend.model.User;
import com.reto2.backend.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){
        return userCrudRepository.findAll();
    }

    public Optional<User> getUser(Integer id){
        return userCrudRepository.findById(id);
    }

    public User create(User user){
        return userCrudRepository.save(user);
    }

    public void update(User user){
        userCrudRepository.save(user);
    }

    public void delete(User user){
        userCrudRepository.delete(user);
    }

    public Optional<User> emailExists(String email){
        return userCrudRepository.findByEmail(email);
    }

    public Optional<User> authUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
