package com.brazhenko.dao;

import com.brazhenko.dao.daoInterface.CinemasDao;
import com.brazhenko.entity.Cinemas;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.brazhenko.fandangoUtils.FandangoUtils;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 07.07.2015.
 */
@Repository
public class CinemasDAOImpl implements CinemasDao {

    public Long addCinema(Cinemas cinema) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx=null;
        Long cinemaId =null;
        try {
            tx = session.beginTransaction();
            cinemaId = (Long) session.save(cinema);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null)tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return cinemaId;
    }

    public List<Cinemas> getCinema() {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        List <Cinemas> cinemaList = new ArrayList<Cinemas>();
        try{
            tx = session.beginTransaction();
            List cinemaR = session.createQuery("FROM Cinemas").list();

            for (Iterator iterator =cinemaR.iterator(); iterator.hasNext(); ){
                Cinemas cinemaC = (Cinemas) iterator.next();
                cinemaList.add(cinemaC);
            }
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return cinemaList;
    }

    public Cinemas getCinemaById(Long id) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        Cinemas cinemar = new Cinemas();
        Long idCinema;
        try{
            tx = session.beginTransaction();
            List cinemaResult = session.createQuery("FROM Cinemas").list();
            for (Iterator iterator =cinemaResult.iterator(); iterator.hasNext(); ){
                Cinemas cinemaC = (Cinemas) iterator.next();
                idCinema = cinemaC.getCinemaId();
                if (id == idCinema){
                    cinemar = cinemaC;
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
        return cinemar;
    }




    public void updateCinema(Cinemas cinema) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(cinema);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void deleteCinema(Cinemas cinema) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(cinema);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
