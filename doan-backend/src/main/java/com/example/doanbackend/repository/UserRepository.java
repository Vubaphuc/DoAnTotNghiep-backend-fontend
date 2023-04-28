package com.example.doanbackend.repository;

import com.example.doanbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUsersByEmail(String email);
    Optional<User> findUsersById(Integer id);
}