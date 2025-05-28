package com.example.demomyapp.models;

import com.example.demomyapp.utils.JsonToListConverter;
import com.example.demomyapp.utils.JsonToMapConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String body;

    @Convert(converter = JsonToListConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> tags;

    @Convert(converter = JsonToMapConverter.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> reactions;

    private Integer views;

    @Column(name = "userId")
    private Integer userId;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", tags=" + tags +
                ", reactions=" + reactions +
                ", views=" + views +
                ", userId=" + userId +
                '}';
    }
}
