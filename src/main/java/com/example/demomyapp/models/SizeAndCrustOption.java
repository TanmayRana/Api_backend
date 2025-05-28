package com.example.demomyapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "size_and_crust_options")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SizeAndCrustOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;
}
