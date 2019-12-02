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
}