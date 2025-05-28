package com.example.demomyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomyapp.models.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
}
