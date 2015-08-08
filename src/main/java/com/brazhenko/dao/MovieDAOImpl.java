package com.brazhenko.dao;

import com.brazhenko.dao.daoInterface.MovieDAO;
import com.brazhenko.entity.Movie;
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
public class MovieDAOImpl implements MovieDAO {

    public Long addMovie(Movie movie) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        Long movieId = null;
        try{
            tx = session.beginTransaction();
            movieId = (Long) session.save(movie);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return movieId;
    }

    public List<Movie> getMovie() {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        List<Movie> movieList = new ArrayList<Movie>();
        try{
            tx = session.beginTransaction();
            List movieR = session.createQuery("FROM Movie").list();

            for (Iterator iterator = movieR.iterator(); iterator.hasNext(); ){
                Movie movie = (Movie) iterator.next();
                movieList.add(movie);
            }
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return movieList;
    }

    public Movie getMovieById(Long id) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        Movie movier = new Movie();
        Long idMovie;
        try{
            tx = session.beginTransaction();
            List movieList= session.createQuery("FROM Movie").list();
            for (Iterator iterator =movieList.iterator(); iterator.hasNext(); ){
                Movie movieC = (Movie) iterator.next();
                idMovie = movieC.getMovieId();
                if (id == idMovie){
                    movier = movieC;
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
        return movier;
    }


    public void updateMovie(Movie movie) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(movie);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void deleteMovie(Movie movie) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        try {
            tx = session.beginTransaction();
            session.delete(movie);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

    }
}
