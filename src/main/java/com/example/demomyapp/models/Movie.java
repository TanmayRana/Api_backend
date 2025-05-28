package com.example.demomyapp.models;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.demomyapp.utils.JsonToMapConverter;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    private String id;

    @Column(name = "original_title", nullable = false)
    private String originalTitle;

    @Column(name = "primary_title", nullable = false)
    private String primaryTitle;

    private String description;
    private String type;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "runtime_minutes")
    private Integer runtimeMinutes;

    private Long budget;

    @Column(name = "gross_worldwide")
    private Long grossWorldwide;

    @Column(name = "content_rating")
    private String contentRating;

    @Column(name = "is_adult")
    private Boolean isAdult;

    @Column(name = "average_rating", precision = 3, scale = 1)
    private BigDecimal averageRating;

    private Integer metascore;

    @Column(name = "num_votes")
    private Integer numVotes;

    @ElementCollection
    @CollectionTable(name = "movie_countries", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "country")
    private List<String> countriesOfOrigin;

    @ElementCollection
    @CollectionTable(name = "movie_locations", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "location")
    private List<String> filmingLocations;

    @ElementCollection
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private List<String> genres;

    @ElementCollection
    @CollectionTable(name = "movie_interests", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "interest")
    private List<String> interests;

    @ElementCollection
    @CollectionTable(name = "movie_languages", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "language")
    private List<String> spokenLanguages;

    @ElementCollection
    @CollectionTable(name = "movie_links", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "link")
    private List<String> externalLinks;

    @Convert(converter = JsonToMapConverter.class)
    @Column(name = "production_companies", columnDefinition = "json")
    private Map<String, Object> productionCompanies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "primary_image")
    private String primaryImage;

    private String trailer;
    private String url;
}
