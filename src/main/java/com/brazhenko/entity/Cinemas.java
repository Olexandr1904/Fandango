package com.brazhenko.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 07.07.2015.
 *
 *
 */
@Entity
@Component
@Table(name= "Cinemas")
public class Cinemas implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "CinemaId",unique =true, nullable = false)
    private Long cinemaId;

    @Column (name = "Name",nullable = false)
    private String name;

    @Column (name = "Adresses",nullable = false)
    private String adresses;

    @Column (name = "Numberofseats", nullable = false)
    private int numberOfSeats;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cinemas",cascade=CascadeType.ALL)
    public Set<Schedule> schedule= new HashSet<Schedule>(0);

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
    }

    public  Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresses() {
        return adresses;
    }

    public void setAdresses(String adresses) {
        this.adresses = adresses;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
