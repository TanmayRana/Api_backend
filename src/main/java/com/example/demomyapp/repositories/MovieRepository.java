package com.example.demomyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomyapp.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
    // You can add custom query methods if needed
}
