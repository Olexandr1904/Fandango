package com.brazhenko.controller;

import com.brazhenko.entity.Cinemas;
import com.brazhenko.entity.Movie;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 26.07.2015.
 */
@Controller
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    CinemasService cinemasService;

    @Autowired
    MovieService movieDAO;

    @Autowired
    Movie movie;

    @Autowired
    SchdeuleService scheduleService; ;

    @RequestMapping(value = "/getAllCinemas", method = RequestMethod.GET)
    public String getAllCinemas (Model model){
        model.addAttribute("cinemas", cinemasService.getCinema());
        return "cinemaDisplay";
    }

    @RequestMapping(value = "/chooseCinema", method = RequestMethod.POST)
    public String chooseCinemas (HttpServletRequest request, Model model){
        Long movieId = Long.valueOf(request.getParameter("movieId"));
        movie = movieDAO.getMovieById(movieId);
        model.addAttribute("choosemovie", movie);
//        model.addAttribute("cinemas", cinemasService.getCinema());
        List<Schedule> allSchedule = scheduleService.getSchdeule();
        model.addAttribute("schedule", allSchedule);

        return "chooseCinema";
    }

    @RequestMapping(value = "/addCinemaForm", method = RequestMethod.GET)
    public String addCinemaForm (){
        return "addCinemaForm";
    }

    @RequestMapping(value = "/addCinema", method = RequestMethod.POST)
    public String addCinema (HttpServletRequest request,Model model){
        Cinemas cinema = new Cinemas();
        cinema.setAdresses(request.getParameter("adress"));
        cinema.setName(request.getParameter("name"));
        cinema.setNumberOfSeats(Integer.parseInt(request.getParameter("numberOfSeats")));
        cinemasService.addCinema(cinema);
        return "cinemaDisplay";
    }
}
