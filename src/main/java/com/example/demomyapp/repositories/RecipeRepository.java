package com.example.demomyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomyapp.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
