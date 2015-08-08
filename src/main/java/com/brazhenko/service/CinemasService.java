package com.brazhenko.service;

import com.brazhenko.dao.CinemasDAOImpl;
import com.brazhenko.entity.Cinemas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Admin on 24.07.2015.
 */
@Service
public class CinemasService {

    @Autowired
    public CinemasDAOImpl cinemasDAOl;

    public Long addCinema (Cinemas cinema){
        Long id = cinemasDAOl.addCinema(cinema);
        return id;
    }

    public List<Cinemas> getCinema(){
        List cinemaId= cinemasDAOl.getCinema();
        return cinemaId;
    }

    public Cinemas getCinemaById(Long id){
        Cinemas cinemar = cinemasDAOl.getCinemaById(id);
        return cinemar;
    }

    public void updateCinema(Cinemas cinemas){
        cinemasDAOl.updateCinema(cinemas);
    }


    public void deleteCinema(Cinemas cinemas){
        cinemasDAOl.deleteCinema(cinemas);
    }
}
