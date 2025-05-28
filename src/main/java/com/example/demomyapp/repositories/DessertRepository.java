package com.example.demomyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomyapp.models.Dessert;

public interface DessertRepository extends JpaRepository<Dessert, Integer> {
}
