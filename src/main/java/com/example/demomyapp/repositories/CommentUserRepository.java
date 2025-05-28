package com.example.demomyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomyapp.models.CommentUser;

public interface CommentUserRepository extends JpaRepository<CommentUser, Integer> {
}
