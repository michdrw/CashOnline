package com.example.cashtest.repositories;


import com.example.cashtest.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UsuarioRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //Optional<User> findById(Integer userId);

}