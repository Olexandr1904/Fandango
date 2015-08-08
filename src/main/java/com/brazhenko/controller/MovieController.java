package com.brazhenko.controller;

import com.brazhenko.dao.CinemasDAOImpl;
import com.brazhenko.dao.daoInterface.CinemasDao;
import com.brazhenko.entity.Cinemas;
import com.brazhenko.entity.Schedule;
import com.brazhenko.service.CinemasService;
import com.brazhenko.service.MovieService;
import com.brazhenko.service.SchdeuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Admin on 26.07.2015.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    CinemasDao cinemasDao = new CinemasDAOImpl();

    @Autowired
    MovieService movieService;

    Cinemas cinemas;

    @Autowired
    SchdeuleService scheduleService;

    @RequestMapping(value = "/getAllMovies", method = RequestMethod.GET)
    public String getAllCinemas (Model model){
        model.addAttribute("movie", movieService.getMovie());
        return "movieDisplay";
    }

    @RequestMapping(value = "/chooseMovie", method = RequestMethod.POST)
    public String chooseCinemas (HttpServletRequest request, Model model){
        Long cinemaId = Long.valueOf(request.getParameter("cinemaId"));
        cinemas = cinemasDao.getCinemaById(cinemaId);
        model.addAttribute("choosecinema", cinemas);
        List<Schedule> allSchedule = scheduleService.getSchdeule();
        model.addAttribute("schedule", allSchedule);
        return "chooseMovie";
    }

}
