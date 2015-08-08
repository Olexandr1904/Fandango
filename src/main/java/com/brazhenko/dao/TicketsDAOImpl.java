package com.brazhenko.dao;

import com.brazhenko.entity.Tickets;
import com.brazhenko.dao.daoInterface.TicketsDAO;
import com.brazhenko.fandangoUtils.FandangoUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 07.07.2015.
 */
@Repository
public class TicketsDAOImpl implements TicketsDAO {

    public Long addTickets(Tickets tickets) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        Long ticketId = null;
        try{
            tx = session.beginTransaction();
            ticketId = (Long) session.save(tickets);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return ticketId;
    }

    public List<Tickets> getTickets() {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        List<Tickets> ticketsList = new ArrayList<Tickets>();
        try{
            tx = session.beginTransaction();
            List ticketR = session.createQuery("from Tickets").list();

            for (Iterator iterator = ticketR.iterator(); iterator.hasNext(); ){
                Tickets tickets = (Tickets) iterator.next();
                ticketsList.add(tickets);
            }
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return ticketsList;
    }

    public Tickets getTicketsById(Long id) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        Tickets ticket = new Tickets();
        Long idTickets;
        try{
            tx = session.beginTransaction();
            List ticketList= session.createQuery("FROM Tickets").list();
            for (Iterator iterator =ticketList.iterator(); iterator.hasNext(); ){
                Tickets ticketC = (Tickets) iterator.next();
                idTickets = ticketC.getTicketId();
                if (id == idTickets){
                    ticket = ticketC;
                    break;
                }
            }
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return ticket;
    }



    public void updateTickets(Tickets tickets) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(tickets);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteTickets(Tickets tickets) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        try{
            tx = session.beginTransaction();
            session.delete(tickets);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
