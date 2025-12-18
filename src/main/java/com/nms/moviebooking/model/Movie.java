package com.nms.moviebooking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;

    @Column(nullable = false)
    private String title;

    private String genre;

    private String language;

    private Integer duration;

    private Boolean isUpcoming;
}
