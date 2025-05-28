package com.example.demomyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomyapp.models.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
}
