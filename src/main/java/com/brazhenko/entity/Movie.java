package com.brazhenko.entity;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.lang.Integer;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Admin on 07.07.2015.
 * Id
 * Name
 * Description
 * Rating
 *
 * 4
 */
@Entity
@Component
@Table (name = "movie")
public class Movie implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MovieId", unique = true, nullable = false)
    private Long movieId;

    @Column (name = "Name",nullable = false)
    private String name;

    @Column (name = "Description")
    private String description;

    @Column (name = "Rating",nullable = false)
    private Double rating;

    @Column (name = "Genre")
    private String genre;

    @Column (name = "Duration",nullable = true)
    private Integer duration;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "movie",cascade=CascadeType.ALL)
    public Set <Schedule> schedule= new HashSet<>(0);

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public  Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
