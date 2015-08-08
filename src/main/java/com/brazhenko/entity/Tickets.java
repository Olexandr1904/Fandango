package com.brazhenko.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Admin on 07.07.2015.
 * Id
 * Name
 * Last name
 * Movie_Id
 * Date
 * Time
 * Cinema_Id
 *
 * 7
 */
@Entity
@Component
@Table (name = "Tickets")
public class Tickets implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "Ticket_Id",unique =true, nullable = false)
    private Long ticketId;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Integer getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(Integer ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scheduleId", nullable = true)
    private Schedule schedule;

    @Column (name = "TicketQuantity")
    private Integer ticketQuantity;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long id) {
        this.ticketId = id;
    }


}
