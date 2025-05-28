package com.example.demomyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomyapp.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
