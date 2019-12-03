package com.example.cashtest.services;

import java.util.List;
import java.util.Optional;

import com.example.cashtest.entities.User;
import com.example.cashtest.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UsuarioService
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(User u) {
        userRepository.save(u);
    }

    public void createUser(String firstName, String lastName, String email) {
        User u = new User();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        save(u);
    }

    public List<User> getUsers() {

        return userRepository.findAll();
    }

    public User getById(int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent())
            return user.get();

        return null;
    }

    public void delete(User u) {

        this.userRepository.delete(u);

    }

    public enum UserValidationType {
        USER_OK, 
        USER_DUPLICATED, 
        USER_INVALID_DATA
    }

    public UserValidationType verifyUser(User user) {
        if (user.getFirstName() == null)
            return UserValidationType.USER_INVALID_DATA;

        if (user.getLastName() == null)
            return UserValidationType.USER_INVALID_DATA;

        if (user.getEmail() == null)
            return UserValidationType.USER_INVALID_DATA;

        User u = userRepository.findByEmail(user.getEmail());
        if (u != null) {
            if (user.getUserId() != null) {
                if ((user.getUserId().toString()).equals(u.getUserId().toString())) {
                    return UserValidationType.USER_OK;
                } else {
                    return UserValidationType.USER_DUPLICATED;
                }
            } else
                return UserValidationType.USER_DUPLICATED;
        }
        return UserValidationType.USER_OK;
    }
}