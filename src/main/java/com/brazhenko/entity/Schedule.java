package com.brazhenko.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 07.07.2015.
 * Id
 * Movie
 * Cinema
 * Calendar
 * Time
 * FreePlace
 * SheduleId
 * 6+1
 */
@Entity
@Component
@Table (name = "schedule")
public class Schedule implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Schedule_Id", unique = true, nullable = false)
    private Long scheduleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CinemaId", nullable = true)
    private Cinemas cinemas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MovieId", nullable = true)
    private Movie movie;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schedule",cascade=CascadeType.ALL)
    public Set<Tickets> tickets = new HashSet<>(0);

    public Set<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Tickets> tickets) {
        this.tickets = tickets;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinemas getCinema() {
        return cinemas;
    }

    public void setCinema(Cinemas cinemas) {
        this.cinemas = cinemas;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column (name = "Calendar",nullable = false)
    private Calendar time;

    @Column (name = "freePlace")
    private int freePlace;


    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public int getFreePlace() {
        return freePlace;
    }

    public void setFreePlace(int freePlace) {
        this.freePlace = freePlace;
    }

}
