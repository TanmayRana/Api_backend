package com.example.demomyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomyapp.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
