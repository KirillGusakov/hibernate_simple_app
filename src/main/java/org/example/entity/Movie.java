package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "movie")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int year;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    public Movie(String name, int year, Director director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }
}
