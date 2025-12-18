package com.nms.moviebooking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theatres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatre_id")
    private Long theatreId;

    @Column(nullable = false)
    private String name;

    private String location;
}
