package com.example.demomyapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "desserts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dessert {

    @Id
    private Integer id;

    private String name;

    private BigDecimal price;

    private String description;

    private String img;

    private Integer quantity;
}
