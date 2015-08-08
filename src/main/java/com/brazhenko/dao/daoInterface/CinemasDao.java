package com.brazhenko.dao.daoInterface;

import com.brazhenko.entity.Cinemas;
import java.util.List;

/**
 * Created by Admin on 07.07.2015.
 */
public interface CinemasDao {
    //Method to write new Cinema in the DB
    Long addCinema(Cinemas cinema);

    //Method to read all Cinema
    List<Cinemas> getCinema();

    Cinemas getCinemaById(Long id);

    //Method to update Cinema
    void updateCinema(Cinemas cinema);

    //Method to delete Cinema
    void deleteCinema (Cinemas cinema);
}
