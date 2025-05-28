package com.example.demomyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomyapp.models.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
