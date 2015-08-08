package com.brazhenko.dao.daoInterface;

import com.brazhenko.entity.Schedule;

import java.util.List;

/**
 * Created by Admin on 07.07.2015.
 */
public interface ScheduleDAO {

    //Method to write new Schedule in the DB
    Long addSchedule(Schedule schedule);

    //Method to read all Schedule
    List<Schedule> getSchedule();

    Schedule getScheduleById(Long id);

    //Method to update Schedule
    void updateSchedule(Schedule schedule);

    //Method to delete Schedule
    void deleteSchedule (Schedule schedule);
}
