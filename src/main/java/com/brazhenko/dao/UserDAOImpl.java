package com.brazhenko.dao;

import com.brazhenko.dao.daoInterface.UserDAO;
import com.brazhenko.entity.User;
import com.brazhenko.fandangoUtils.FandangoUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 05.08.2015.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public Long addUser(User user) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        Long userId = null;
        try{
            tx = session.beginTransaction();
            userId = (Long) session.save(user);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return userId;
    }

    @Override
    public List<User> getUser() {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        List<User> userList = new ArrayList<>();
        try{
            tx = session.beginTransaction();
            List userR = session.createQuery("from User").list();

            for (Iterator iterator = userR.iterator(); iterator.hasNext(); ){
                User users = (User) iterator.next();
                userList.add(users);
            }
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return userList;



    }

    @Override
    public User getUserById(Long id) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        User user = new User();
        Long idUser;
        try{
            tx = session.beginTransaction();
            List userList= session.createQuery("FROM User").list();
            for (Iterator iterator =userList.iterator(); iterator.hasNext(); ){
                User userC = (User) iterator.next();
                idUser = userC.getUserId();
                if (id == idUser){
                    user = userC;
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
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        User userE = new User();
        Long idUser;
        List<User> userList = new ArrayList<User>();

        try{
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("email", email));
            userList= criteria.list();
            for (User user:userList){
                userE = user;
            }
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return userE;
    }



    @Override
    public void updateUser(User user) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(User user) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        try{
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
