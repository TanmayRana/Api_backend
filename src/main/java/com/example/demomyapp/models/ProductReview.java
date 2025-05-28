package com.example.demomyapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "product_reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private Integer rating;
    private String comment;
    private ZonedDateTime date;

    @Column(name = "reviewer_name")
    private String reviewerName;

    @Column(name = "reviewer_email")
    private String reviewerEmail;
}
