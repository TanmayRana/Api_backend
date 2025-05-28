package com.example.demomyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomyapp.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
