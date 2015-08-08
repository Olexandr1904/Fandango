package com.brazhenko.dao.daoInterface;

import com.brazhenko.entity.Tickets;

import java.util.List;

/**
 * Created by Admin on 07.07.2015.
 */
public interface TicketsDAO {

    //Method to write new Tickets in the DB
    Long addTickets(Tickets tickets);

    //Method to read all Tickets
    List<Tickets> getTickets();

    Tickets getTicketsById(Long id);

    //Method to update Tickets
    void updateTickets(Tickets tickets);

    //Method to delete Tickets
    void deleteTickets (Tickets tickets);
}
