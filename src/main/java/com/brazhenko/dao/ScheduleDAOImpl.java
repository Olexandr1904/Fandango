package com.brazhenko.dao;

import com.brazhenko.dao.daoInterface.ScheduleDAO;
import com.brazhenko.entity.Schedule;
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
public class ScheduleDAOImpl implements ScheduleDAO {

    public Long addSchedule(Schedule schedule) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        Long scheduleId =null;
        try{
            tx = session.beginTransaction();
            scheduleId = (Long) session.save(schedule);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return scheduleId;
    }

    public List<Schedule> getSchedule() {

        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        List<Schedule> scheduleList = new ArrayList<Schedule>();
        try{
            tx = session.beginTransaction();
            List scheduleR = session.createQuery("FROM Schedule").list();
            for (Iterator iterator = scheduleR.iterator(); iterator.hasNext();){
                Schedule schedule = (Schedule) iterator.next();
                scheduleList.add(schedule);
            }
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return scheduleList;
    }

    public Schedule getScheduleById(Long id) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        Schedule schedule = new Schedule();
        Long idSchedule;
        try{
            tx = session.beginTransaction();
            List scheduleList= session.createQuery("FROM Schedule").list();
            for (Iterator iterator =scheduleList.iterator(); iterator.hasNext(); ){
                Schedule scheduleC = (Schedule) iterator.next();
                idSchedule = scheduleC.getScheduleId();
                if (id == idSchedule){
                    schedule = scheduleC;
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
        return schedule;
    }



    public void updateSchedule(Schedule schedule) {
        Session session = FandangoUtils.getSessionFacory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(schedule);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteSchedule(Schedule schedule) {
        Session session= FandangoUtils.getSessionFacory().openSession();
        Transaction tx =null;
        try{
            tx = session.beginTransaction();
            session.delete(schedule);
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null)tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
