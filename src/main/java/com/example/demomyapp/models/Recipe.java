package com.example.demomyapp.models;

import jakarta.persistence.*;
import lombok.*;

// import java.util.List;
import java.util.Map;

import com.example.demomyapp.utils.JsonToMapConverter;

@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> ingredients;

    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> instructions;

    @Column(name = "prep_time_minutes")
    private Integer prepTimeMinutes;

    @Column(name = "cook_time_minutes")
    private Integer cookTimeMinutes;

    private Integer servings;
    private String difficulty;
    private String cuisine;

    @Column(name = "calories_per_serving")
    private Integer caloriesPerServing;

    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> tags;

    @Column(name = "user_id")
    private Integer userId;

    private String image;
    private Float rating;

    @Column(name = "review_count")
    private Integer reviewCount;

    @Convert(converter = JsonToMapConverter.class)
    @Column(name = "meal_type")
    private Map<String, Object> mealType;
}
