package com.example.demomyapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "commentusers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentUser {

    @Id
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "full_name", nullable = false)
    private String fullName;
}
