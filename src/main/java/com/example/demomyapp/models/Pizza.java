package com.example.demomyapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pizzas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pizza {

    @Id
    private Integer id;

    private String name;

    private Boolean veg;

    private BigDecimal price;

    private String description;

    private Integer quantity;

    private String img;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SizeAndCrustOption> sizeAndCrustOptions;
}
