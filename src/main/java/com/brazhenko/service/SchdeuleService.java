package com.brazhenko.service;

import com.brazhenko.dao.ScheduleDAOImpl;
import com.brazhenko.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Admin on 24.07.2015.
 */
@Service
public class SchdeuleService {

    @Autowired
    private ScheduleDAOImpl scheduleDAO;

    public Long addSchdeule (Schedule schedule){
        Long id = scheduleDAO.addSchedule(schedule);
        return id;
    }

    public List<Schedule> getSchdeule(){
        List scheduleId= scheduleDAO.getSchedule();
        return scheduleId;
    }

    public Schedule getSchdeuleById(Long id){
        Schedule scheduler = scheduleDAO.getScheduleById(id);
        return scheduler;
    }

    public void updateSchdeule(Schedule schedules){
        scheduleDAO.updateSchedule(schedules);
    }

    public void deleteSchdeule(Schedule schedules){
        scheduleDAO.deleteSchedule(schedules);
    }
}
