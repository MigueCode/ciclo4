package com.reto2.backend.service;

import com.reto2.backend.model.User;
import com.reto2.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(Integer id){
        return userRepository.getUser(id);
    }

    public User create(User user){
        if (user.getId() == null) {
            return user;
        }

        Optional<User> e = userRepository.getUser(user.getId());

        if (e.isPresent()) {
            return user;
        }
        if (emailExists(user.getEmail())==true){
                return user;
        }

        return userRepository.create(user);



    }

    public User update(User user){
        if (user.getId() == null) {
            return user;
        }
        Optional<User> userDb = userRepository.getUser(user.getId());

            if (!userDb.isPresent()) {
                return user;
            }
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                userRepository.update(userDb.get());
                return userDb.get();


    }

    public boolean delete(Integer id){
        Boolean aBoolean = getUser(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public boolean emailExists(String email){
        Optional<User> emailUser = userRepository.emailExists(email);
        if (emailUser.isPresent()){
            return true;
        }
        return false;
    }

}
