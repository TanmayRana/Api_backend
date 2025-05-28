package com.example.demomyapp.models;

// import com.example.demo.utils.JsonToMapConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

import com.example.demomyapp.utils.JsonToMapConverter;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "maiden_name")
    private String maidenName;

    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;

    @Column(name = "birth_date")
    private String birthDate;

    private String image;

    @Column(name = "blood_group")
    private String bloodGroup;

    private Double height;
    private Double weight;

    @Column(name = "eye_color")
    private String eyeColor;

    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> hair;

    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> address;

    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> company;

    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> bank;

    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> crypto;

    private String ip;

    @Column(name = "mac_address")
    private String macAddress;

    private String university;
    private String ein;
    private String ssn;

    @Column(name = "user_agent")
    private String userAgent;

    private String role;
}
