package com.example.demomyapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String quote;

    @Column(nullable = false)
    private String author;
}
