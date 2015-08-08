package com.brazhenko.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Admin on 05.08.2015.
 */
@Entity
@Component
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "User_Id",unique =true, nullable = false)
    private Long userId;

    @Column (name="AdminRole",nullable = false)
    private Boolean admin;

    @Column (name="Password", nullable = false)
    private String password;

    @Column (name = "Email", unique =true, nullable = false)
    private String email;

    @Column (name = "TicketQuantity")
    private Integer ticketQuantity;

    public Integer getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(Integer ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
