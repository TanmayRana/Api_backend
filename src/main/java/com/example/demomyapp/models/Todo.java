package com.example.demomyapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String todo;

    private Boolean completed = false;

    @Column(name = "userId")
    private Integer userId;
}
